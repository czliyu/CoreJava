# 异常、断言和日志

## 异常

`Exception`层次结构。这个层次结构又分解为两个分支：一个派生于`RuntimeException`;另一个分支包含其他异常。

一般规程： *由编程错误导致的异常属于RuntimeException*

派生于`RuntimeException`的异常包括以下问题：

* 错误的强制类型转换
* 数组访问越界
* 访问null指针

不是派生于`RuntimeException`的异常包括：

* 试图超越文件末尾继续读取数据
* 试图打开一个不存在的文件
* 试图根据给定的字符串查找`Class`对象，而这个字符串表示的类并不存在

Java语言规范将派生于`Error`类或`RuntimeException`类的所有异常称为*非检查型异常*，所有其他的异常称为*检查型异常*。

编译器将检查是否为所有的检查型异常提供了异常处理器


> finally 子句主要用于清理资源，不要把改变控制流的语句（return, throw, break, continue）放在finally子句中。

`try-with-Resources` （带资源的try语句）的简易形式：

```
try (Resource res = ...) {
    work
}
```

## 日志

> 未被任何变量引用的日志记录器可能会被垃圾回收。为了防止这种情况发生，用静态变量存储日志记录器`private static final Logger myLogger = Logger.getLogger("com.mycompany.myapp")`