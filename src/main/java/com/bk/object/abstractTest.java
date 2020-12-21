package com.bk.object;


import java.util.Calendar;

public class abstractTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        int month = instance.get(Calendar.MONTH)+1;



        Employee[] employees = new Employee[2];
        employees[0] = new SalariedEmployee("张三",100001,new MyDate(1991,2,12),100);
        employees[1] = new HourlyEmployee("里斯",100002,new MyDate(1990,12,20),1,990);
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
            if (month==employees[i].getBirthday().getMonth()){
                System.out.println("恭喜你生日快乐，给你加100块钱工资哦");
            }
        }
    }
}

abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;


    abstract double earnings();

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString() +
                '}';
    }
}

class MyDate {
    private int year, month, day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toDateString() {
        return year+"年"+month+"月"+day+"日";
    }
}

/**
 * 实现按月计算工资的员工处理
 */
class SalariedEmployee extends Employee{
    private double monthlySalary;

    public SalariedEmployee(String name, int number, MyDate birthday,double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "monthlySalary=" + monthlySalary +
                "} " + super.toString();
    }
}

/**
 * 实现按照小时计算工资的员工处理
 */
class HourlyEmployee extends Employee{
    private double wage;
    private int hour;

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    double earnings() {
        return wage*hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "wage=" + wage +
                ", hour=" + hour +
                "} " + super.toString();
    }
}
