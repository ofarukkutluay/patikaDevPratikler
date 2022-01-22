package com.company;

import java.time.LocalDate;

public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    public Employee(String name,double salary,int workHours,int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax(){
        if (salary>1000){
            return salary*0.03;
        }
        return 0;
    }

    public double bonus(){
        if(workHours>40){
            int x = workHours-40;
            return x*30;
        }
        return 0;
    }

    public double raiseSalary(){
        int x = hireYear - LocalDate.now().getYear();
        if (x<10){
            return salary*0.05;
        }else if(x>9 &&  x<20){
            return salary*0.1;
        }else if(x>19){
            return salary*0.15;
        }else{
            return 0;
        }
    }

    public String toString(){

        String s = "Adı : %s\n".formatted(this.name) +
                "Maaşı : %s\n".formatted(this.salary) +
                "Çalışma Saati : %s\n".formatted(this.workHours) +
                "Başlangıç Yılı : %s\n".formatted(this.hireYear) +
                "Vergi : %s\n".formatted(tax()) +
                "Bonus : %s\n".formatted(bonus()) +
                "Maaş Artışı : %s\n".formatted(raiseSalary()) +
                "Vergi ve Bonuslar ile birlikte maaş : %s\n".formatted((this.salary-tax()+bonus())) +
                "Toplam Maaş : %s".formatted((this.salary+raiseSalary()));
        return s;
    }
}
