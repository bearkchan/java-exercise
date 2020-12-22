package com.bk.team.service;

import com.bk.team.domain.Architect;
import com.bk.team.domain.Designer;
import com.bk.team.domain.Employee;
import com.bk.team.domain.Programmer;

import java.lang.reflect.Array;
import java.time.temporal.Temporal;
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
        } else if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programmer programmer = (Programmer) employee;
        if (programmer.getStatus().getNAME().equals(Status.BUSY)) {
            throw new TeamException("该员工已是某团队成员");
        } else if (programmer.getStatus().getNAME().equals(Status.VOCATION)) {
            throw new TeamException("该员正在休假，无法添加");

        }


        int programCount = 0, designerCount = 0, architectCount = 0;
        Programmer[] programmers = Arrays.copyOf(team, team.length);
        programmers[total] = programmer;
        for (int i = 0; i < programmers.length; i++) {
            if (programmers[i].getClass().getName().equals(Programmer.class.getName())) {
                programCount += 1;
            } else if (programmers[i].getClass().getName().equals(Designer.class.getName())) {
                designerCount += 1;
            } else if (programmers[i].getClass().getName().equals(Architect.class.getName())) {
                architectCount += 1;
            }
        }
        if (programCount > 3) {
            throw new TeamException("团队中至多只能有三名程序员");
        } else if (designerCount > 2) {
            throw new TeamException("团队中至多只能有两名设计师");
        } else if (architectCount > 1) {
            throw new TeamException("团队中至多只能有一名架构师");
        }

        programmer.setMemberId(counter++);
        team[total] = programmer;
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
        } else {
            for (int i = index; i < team.length - 1; i++) {
                team[i] = team[i + 1];
            }
            team[team.length - 1] = null;
        }
    }
}
