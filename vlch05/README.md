# 继承

### 函数覆盖

调用超类中的方法`super.getSalary()`

> 有些人认为super与this引用是类似的概念，实际上，这样比较并不恰当。这是因为super不是一个对象的引用，例如，不能将值super赋值给另一个对象变量，它只是一个指示编译器调用超类方法的特殊关键词。

### 子类构造器

```
public Manager(String name, double salary, int year, int month, int day) {

    /*
    * 调用超类Employee中带参数的构造器的简写
    */
    super(name, salary, year, month, day);
    bonus = 0;
}
```

### 方法调用

1、编译器查看对象的声明类型和方法名。需要注意的是：有可能存在多个名字为f但参数类型不一样的方法。例如，可能存在方法f(String)和方法f(int)。
编译器将会--列举类中的所有名为f的方法和其超类中所有名为f而且可以访问的方法。

2、编译器要确定方法调用中提供的参数类型。如果在所有名为f的方法中存在一个与所提供参数类型完全匹配的方法，这个过程叫做<b>重载解析</b>

## Object: 所有类的超类

### equals方法

Java语言规范要求`equals`方法具有下面的特性：

1、自反性：对于任何非空引用x, `x.equals(x)`应该返回`true`
2、对称性：对于任何引用x和y，当且仅当`y.equals(x)`返回`true`时，`x.equals(y)`返回`true`
3、传递性：对于任何引用x、y和z，如果`x.equals(y)`返回`true`,`y.equals(z)`返回`true`，`x.euqals(z)`也应该返回`true`
4、一致性：如果x和y引用的对象没有发生变化，反复调用`x.equals(y)`应该返回同样的结果。
5、对于任意非空引用x，`x.equals(null)`应该返回`false`

编写一个完美的`equals`方法的建议：

1、显式参数命名为`otherObject`, 稍后需要将它强制转换成另一个名为`other`的变量。
2、检测`this`与`otherObject`是否相等：
`if (this == otherObject) return true;`
3、检测`otherObject`是否为`null`，如果为`null`,返回`false`。这项检测是很必要的。
`if（otherObject == null) return false;`
4、比较`this`与`otherObject`的类。如果`equals`的语义可以在子类中改变，就使用`getClass`检测。
`if (getClass() != otherObject.getClass()) return false;`
如果所有的子类都有相同的相等性语义，可以使用`instanceof`检测：
`if (!(otherObject instanceof ClassName)) return false;`
5、将`otherObject`强制转换为相应类类型的变量：
`ClassName other = (ClassName) otherObject`
6、根据相等性概念要求来比较字段，使用`==`比较基本数据类型字段，使用`Objects.equals`比较对象字段。
如果所有字段都匹配，就返回`true`; 否则返回`false`。
```
return field1 == other.field1
    && Objects.equals(field2, other.field2)
    && ...;
```
如果在子类中重新定义`equals`。就要在其中包含一个`super.equals(other)`调用

### hashCode方法

散列码（hash code）是由对象导出的一个整数值。散列码是没有规律的。

```
public class Employee {
    public int hashCode() {
        return 7 * name.hashCode()
            + 11 * new Double(salary).hashCode()
            + 13 * hireDay.hashCode();
    }
}
```

可以做得更好，首先，最好使用null安全的方法`Objects.hashCode`。如果参数为null，返回0，
否则返回对参数调用`hashCode`的结果。使用静态方法`Double.hashCode`来避免创建`Double`对象：
```
public int hashCode() {
    return 7 * Objects.hashCode()
        + 11 * Double.hashCode(salary)
        + 13 * Objects.hashCode();
}
```

更好的做法是，需要组合多个散列值时，可以调用`objects.hash`并提供所有这些参数。

```
public int hashCode() {
    return Objects.hash(name, salary, hireDay);
}
```

> equals与hashCode的定义必须相容：如果x.equals(y)返回true，那么x.hashCode() 就必须与y.hashCode()返回相同的值。

### toString 方法

返回表示对象值的一个字符串。

```
public String toString() {
    return getClass().getName()
        + “[name=” + name
        + ", salary=" + salary
        + ", hireDay=" + hireDay
        + "]";
}
```

> 随处可见`toString`方法的主要原因是：只要对象与一个字符串通过操作符“+”连接起来，