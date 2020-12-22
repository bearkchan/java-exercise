package com.bk.team.service;

import com.bk.team.domain.Architect;
import com.bk.team.domain.Designer;
import com.bk.team.domain.Employee;
import com.bk.team.domain.Programmer;

import java.util.Arrays;

public class TeamService {
    private static int counter = 1;
    private static final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;


    public Programmer[] getTeam() {
        return Arrays.copyOf(team, total);
    }

    /**
     * 开发团队人员组成要求：
     * 最多一名架构师
     * 最多两名设计师
     * 最多三名程序员
     * <p>
     * 失败信息包含以下几种：
     * 成员已满，无法添加
     * 该成员不是开发人员，无法添加
     * 该员工已在本开发团队中
     * 该员工已是某团队成员
     * 该员正在休假，无法添加
     * 团队中至多只能有一名架构师
     * 团队中至多只能有两名设计师
     * 团队中至多只能有三名程序员
     *
     * @param employee
     * @throws TeamException
     */
    public void addMember(Employee employee) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programmer programmer = (Programmer) employee;

        if (isExist(programmer)) {
            throw new TeamException("该员工已在本团队中");
        }
        if (programmer.getStatus().getNAME().equals(Status.BUSY)) {
            throw new TeamException("该员工已是某团队成员");
        } else if (programmer.getStatus().getNAME().equals(Status.VOCATION)) {
            throw new TeamException("该员正在休假，无法添加");

        }


        int numOfArch = 0, numOfDsgn = 0, numOfPrg = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDsgn++;
            } else if (team[i] instanceof Programmer) {
                numOfPrg++;
            }
        }

        if (programmer instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (programmer instanceof Designer) {
            if (numOfDsgn >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (programmer instanceof Programmer) {
            if (numOfPrg >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        programmer.setMemberId(counter++);
        programmer.setStatus(Status.BUSY);
        team[total++] = programmer;
    }

    private boolean isExist(Programmer programmer) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == programmer.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberid) throws TeamException {
        int index = -1;
        for (int i = 0; i < team.length; i++) {
            if (team[i].getMemberId() == memberid) {
                index = i;
            }
        }
        if (index < 0) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        for (int i = index; i < total - 1; i++) {
            team[i] = team[i + 1];
        }
        team[--total] = null;

    }
}
