import java.util.Random;


/**
 * 重载构造器
 * 用this(...)调用另一个构造器
 * 无参数构造器
 * 对象初始化块
 * 静态初始化块
 * 实例字段初始化
 */
public class ConstructorTest {
    
    public static void main(String[] args) {

        var staff = new Employee[3];
        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
        }
    }
}

 
class Employee {
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;

    // static initialization block
    // 初始化块
    static
    {
        var generator = new Random();
        nextId = generator.nextInt(10000);
    }

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    // three overload constructors
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee(double s) {
        this("Employee #" + nextId, s);
    }

    // default Employee
    public Employee() {
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

}