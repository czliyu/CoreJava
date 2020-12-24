package arrayList;

import java.util.ArrayList;
import java.time.LocalDate;


/**
 * 不必指定数组的大小
 * 使用add将任意多的元素添加到数组中
 * 使用size()而不是length统计元素个数
 * 使用a.get(i)而不是a[i]来访问元素
 */
public class ArrayListTest {
    
    public static void main(String[] args) {
        var staff = new ArrayList<Employee>();
        
        staff.add(new Employee("Carl Craker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1998, 3, 15));

        for (Employee e : staff)
            e.raiseSalary(5);
        
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
    }
}

class Employee {

    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee (String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }
    
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
