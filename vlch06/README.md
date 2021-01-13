# 接口、lambda表达式与内部类

接口（interface）接口用来描述类应该做什么，而不指定它们具体应该如何做。一个类可以实现（implement）一个或多个接口。
通过使用lambda表达式，可以用一种精巧而简洁的方式表示使用回调或可变行为的代码。

内部类（inner class）机制。内部类定义在另外一个类的内部，它们的方法可以访问包含它们的外部类的字段。

代理（proxy）一种实现任意接口的对象。代理是一种非常专业的构造工具，可以用来构建系统级工具。

## 接口

接口不是类，而是对希望符合这个接口的类的一组需求。

### Comparator接口

对一个对象数组进行排序，前提是这些对象是实现了`Comparable`接口的类的实例。

```
public interface Comparator<T> {
    int compare(T first, T second);
}
```

### 对象克隆

`Clonable`接口，这个接口指示一个类提供一个安全的clone方法，

如果对象中的所有数据字段都是数值或其他基本类型，拷贝这些字段没有任何问题。

如果原对象和浅克隆对象共享的子对象是*不可变的*，那么这种共享就是安全的。如果子对象属于一个不可变的类，如`String`，就是这种情况。或者在对象的生命期中，子对象一直包含不变的常量，没有更改器方法会改变它，也没有方法会生成它的引用，这种情况也是安全的。

通常子对象都是可变的，必须重新定义`clone`方法来建立深拷贝。

> 在Employee类中，hireDay字段是一个Date，这是可变的，所以它也必须克隆。（出于这个原因，这个例子使用Date类型字段而不是LocalDate来展示克隆过程。如果hireDay是不可变的LocalDate类的一个实例，无须做任何处理）。

对于一个类，需要确定：

* 默认的clone方法是否满足要求。
* 是否可以在可变的子对象上调用clone来修补默认的clone方法
* 是否不该使用clone


## lambda 表达式

`lambda`表达式是一个可传递的代码块，可以在以后执行一次或多次。

`lambda`表达式形式：参数

```
(String first, String second) ->
    {
        if (first.length() < second.length()) return -1;
        else if (first.length() > second.length()) return 1;
        else return 0;
    }
```

`lambda`表达式形式： 无参数
```
() -> { for (int i = 100; i >= 0; i--) System.out.println(i); }
```

### 函数式接口

对于只有抽象方法的接口，需要这种接口的对象时，就可以提供一个`lambda`表达式。这种接口称为*函数式接口*

## 内部类

为什么需要使用内部类，主要是两个原因：

* 内部类可以对同一个包中的的其他类隐藏
* 内部类方法可以访问定义这个类的作用域中的数据，包括原本私有数据。