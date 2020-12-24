# 对象与类

### 类

封装是处理对象的一个重要概念。

> 实现封装的关键在于，绝对不能让类中的方法直接访问其他类中的实例字段。程序只能通过对象的方法与对象的数据进行交互。

### 对象

使用oop，一定要清楚对象的三个主要特征

* 对象的行为 --- 可以对对象完成哪些操作，或者可以对对象应用哪些方法?
* 对象的状态 --- 当调用那些方法时，对象会如何相应？
* 对象的标识 --- 如何区分具有相同行为与状态的不同对象？

> 对象状态的改变必须通过调用方法实现（如果不经过方法调用就可以改变对象状态，只能说明破坏了封装性）

### 类之间的关系

* 依赖（"uses-a"）
* 聚合（"has-a"）
* 继承 ("is-a")

依赖（dependence）,即“uses-a”关系，是一种最明显的、最常见的关系。

应该尽可能地将相互依赖的类减少至最少。

聚合（aggregation）,即“has-a”关系。

继承（inheritance）,即“is-a”关系，表示一个更特殊的类与一个更一般的类之间的关系。

### 更改器方法与访问器方法

只访问对象而不修改对象的方法有时称为访问器方法。例如，`LocalDate.getYear`和`GregorianCalendar.get`就是访问器方法。

## 静态字段与静态方法

### 静态字段

如果将一个字段定义为`static`，每个类只有一个这样的字段。

```
class Employee {
    private static int nextId = 1;
    private int id;
}
```

### 静态常量

```
class Math {
    public static final double PI = 3.1415;
}
```

可以使用`Math.PI`来访问这个变量。

### 静态方法

```
Math.pow(x, a);
```

## 方法参数

`按值调用` 表示方法接收的是调用者提供的值。
`按引用调用` 表示方法接收的是调用者提供的地址变量。

## 对象构造

### 调用另一个构造器

关键词`this`指示一个方法的隐式参数。

如果构造器的第一个语句形如this(...),这个构造器将调用同一个类的另一个构造器。

```
public Employee(double s) {
    this("Employee #" + nextId, s);
    nextId++;
}
```

### 使用null引用

在Java，`Objects`类对此提供了一个便利方法：

```
public Employee(String n, double s, int year, int month, int day) {
    // 宽容型
    name = Objects.requireNonNullElse(n, "unknow");
}
```

"严格型"方法则是干脆拒绝null参数
```
public Employee(String n, double s, int year, int month, in day) {
    Objects.requireNonNull(n, "The name cannot be null");
    name = n;
    ...
}
```

### 显式字段初始化

通过重载类的构造器方法，可以采用多种形式设置类的实例字段的初始状态。

```
class Employee {
    private String name = "";
}
```

初始值不一定是常量值。

```
class Employee 
{
    private static int nextId;
    private int id = assignId();

    private static int assignId() {
        int r = nextId;
        nextId++;
        return r;
    }
}
```

### 初始化块

第三种初始化机制，被称为初始化块。

```
// object initialization block
// 初始化块
{
    id = nextId;
    nextId++;
}
```

如果类的静态字段需要很复杂的初始化代码，那么可以使用静态的初始化块。

```
static
{
    var generator = new Random();
    nextId = generator.nextInt(10000);
}
```

在类第一次加载的时候，将会进行静态字段的初始化。


## 包

### 设置类路径

```
java -classpath /home/user/classdir:.:/home/user/archives/archive.jar MyProg
```

## JAR文件

### 创建JAR文件

```
jar cvf CalculatorClasses.jar *.class icon.gif
```

### 清单文件

除了类文件、图像和其他资源外，每个JAR文件还包含了一个清单文件(manifest),用于描述归档文件的特殊特性。

清单文件被命名为：`MANIFEST.MF`, 它位于JAR文件的一个特殊的META-INF子目录中，

创建一个包含清单文件的JAR文件，

```
jar cfm MyArchive.jar manifest.mf com/mycompany/mypkg/*.class
```

更新一个已有的JAR文件的清单。

```
jar ufm MyArchive.jar manifest-additions.mf
```
