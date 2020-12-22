package com.bk.team.service;


import com.bk.team.domain.*;

import java.util.Arrays;

/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 */
public class NameListService {
    private Employee[] employees;

    public static void main(String[] args) {
        String[] objs = {"1","2","3"};
        objs = Arrays.copyOf(objs,2);
        System.out.println("objs = " + Arrays.toString(objs));
        //NameListService nameListService = new NameListService();
        //System.out.println("nameListService = " + nameListService);
    }

    @Override
    public String toString() {
        return "NameListService{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }

    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            String[] employeeData = Data.EMPLOYEES[i];
            int type = Integer.parseInt(employeeData[0]);
            int id = Integer.parseInt(employeeData[1]);
            String name = employeeData[2];
            int age = Integer.parseInt(employeeData[3]);
            double salary = Double.parseDouble(employeeData[4]);
            Employee newEmployee = null;
            switch (type) {
                case Data.EMPLOYEE:
                    newEmployee = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    newEmployee = new Programmer(id, name, age, salary, getEquipmentByIndex(i));
                    break;
                case Data.DESIGNER:
                    newEmployee = new Designer(id, name, age, salary, getEquipmentByIndex(i), Double.parseDouble(employeeData[5]));
                    break;
                case Data.ARCHITECT:
                    newEmployee = new Architect(id, name, age, salary, getEquipmentByIndex(i), Double.parseDouble(employeeData[5]), Integer.parseInt(employeeData[6]));
                    break;
                default:
                    break;
            }
            employees[i] = newEmployee;
        }

    }

    private Equipment getEquipmentByIndex(int index) {
        String[] equipment = Data.EQUIPMENTS[index];
        if (equipment.length > 0) {
            Equipment newEquiment = null;
            int type = Integer.parseInt(equipment[0]);
            String model = equipment[1];
            switch (type) {
                case Data.PC:
                    newEquiment = new PC(model, equipment[2]);
                    break;
                case Data.NOTEBOOK:
                    newEquiment = new NoteBook(model, Double.parseDouble(equipment[2]));
                    break;
                case Data.PRINTER:
                    newEquiment = new Printer(model, equipment[2]);
                    break;
                default:
                    break;
            }
            return newEquiment;
        } else {
            return null;
        }

    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }
}
