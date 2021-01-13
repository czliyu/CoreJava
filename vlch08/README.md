# 泛型程序设计

## 泛型类型

通配符类型非常抽象，不过，利用通配符类型，构建类库的程序员可以编写尽可能灵活的方法。

> 常见的做法是类型变量使用大写字母，而且很简短。Java库使用变量E表示集合的元素类型，K和V分别表示表的健和值的类型。T（必要时可以用U和S）表示“任意类型”。

## 类型檫除

无论何时定义一个泛型类型，都会自动提供一个相应的*原始类型*。这个原始类型的名字就是去掉类型参数后的泛型类型名。类型变量会被*檫除*，并替换为其限定类型(或者，对于无限定的变量则替换为Object)。

例如：`Pair<T>`的原始类型：

```
public class Pair
{
    private Object first;
    private Object second;
    public Pair(Object first, Object second) 
    {
        this.first = first;
        this.second = second;
    }
    public Object getFirst() 
    {
        return first;
    }

    public Object getSecond()
    {
        return second;
    }

    public void setFirst(Object newValue)
    {
        first = newValue;
    }

    public void setSecond(Object newValue)
    {
        second = newValue;
    }

}
```

因为T是无限定的变量，所有直接用`Object`替换。

T有限定类型：

```
public class Interval<T extends Comparable & Serializable> implements Serializable
{
    private T lower;
    private T upper;
    ...
    public Interval(T first, T second)
    {
        if (first.compareTo(second) <= 0) { lower = first; upper = second; }
        else {lower = second; upper = first }
    }
}
```

原始类型`Interval`：
```
public class Interval implements Serializable
{
    private Comparable lower;
    private Comparable upper;
}
```

原始类型（Interval）用第一个限定来替换类型变量（Comparable）。

对于Java泛型转换，需要记住以下几点：

* 虚拟机中没有泛型，只有普通的类和方法
* 所有的类型参数都会替换为它们的限定类型
* 会合成桥方法来保持多态
* 为保持类型安全性，必要时会插入强制类型转换


## 通配符类型

在通配符类型中，允许类型参数发生变化。例如，通配符类型`Pair<? extends Employee>`

类型`Pair<Manager>`是`Pair<? extends Employee>`的子类型。

### 通配符超类型限定

`? super Manager` 这个通配符限制为`Manager`的所有超类型。

