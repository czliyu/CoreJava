# Java的基本程序设计结构

## 数据类型
Java共有8种基本类型，4种整型、2种浮点型、1种字符型（char）和1种用于表示真假的boolean类型。

整型：`int`、`short`、`long`、`byte`

> 在Java中，整型的范围与运行Java代码的机器无关。

浮点类型：`float`、`double`

char类型： `char`

boolean类型： `boolean`

### 变量和常量

利用关键词`final`指示常量。

```
final double CM_PER_INCH = 2.54; // 常量
```

### 枚举类型

```
enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE }
```

## 运算符

### 算术运算符

算术运算符：+、-、*、/

> 整数被0除将会产生一个异常，而浮点数被0除将会得到无穷大或NaN结果。

```
jshell> 0/1.2
$1 ==> 0.0

jshell> 12/0
|  异常错误 java.lang.ArithmeticException：/ by zero
|        at (#2:1)

jshell> 12.9/0
$3 ==> Infinity
```

### 数据类型转换

用一个二元运算符连接两个值（n+f, n是整数，f是浮点数),先要将两个操作数转换为同一种类型，然后再计算：

* 如果两个操作数中有一个是double类型，另一个操作数就会转换为double类型
* 否则，如果其中一个操作数是float类型，另一个操作数会转换为float类型。
* 否则，如果其中一个操作数是long类型，另一个操作数将会装换为long类型。
* 否则，两个操作数都将被转换为int类型。

### 强制类型转换

```
double x = 9.997；
int nx = (int) x;
```

## 字符串

### 检测字符串是否相等

```
String greting = "Hello";
"Hello".equals(greeting);

// 不区分大小写
“Hello”.equalsIgnoreCase("hello");
```

> 一定不要使用`==`运算符检测两个字符串是否相等！这个运算符只能够确定两个字符串是否放在同一个位置上。

```
jshell> String greeting = "Hello";
greeting ==> "Hello"

jshell> System.out.print(greeting == "Hello");
true
jshell> System.out.print(greeting.substring(0,3) == "Hel");
false
```

### 空串和Null串

空串“”是长度为0的字符串。

> 有时检查一个字符串既不是null也不是空串，这种情况下就需要使用`if (str != null && str.length() != 0)`,首先要检查`str`不为null，如果在一个`null`值上调用方法，会出现错误。

### 构造字符串

```
StringBuilder builder = new StringBuilder();
添加内容
builder.append(ch);
builder.append(str);

String completedString = builder.toString();
```

## 输入与输出

### 读取输入

首先要构造一个与“标准输入流”System.in关联的Scanner对象。
```
Scanner in = new Scanner(System.in);
```

### 格式化输出

```
System.out.printf("%8.2f", 33333.333333);
```

### 文件输入与输出

```
// 读取文件
Scanner in = new Scanner(Path.of("myfile.txt"), StandardCharsets.UTF_8);

// 写入文件
PrintWriter out = new PrintWriter("myfile.txt", StandardCharsets.UTF_8);
```

## 控制流程

### 条件语句

`if (condition) statement`

### 循环

```
while (condition) statement

do statement while (condition);

```

### 确定循环

```
for (int i = 0; i <= 10; i++) {
    System.out.println(i);
}
```

### 多重选择：switch

## 大数

如果基本的整数和浮点数精度不能满足需求，那么可以使用java.math包中两个很有用的类：`BigInteger`和`BigDecimal`

```
BigInteger c = a.add(b); // c = a + b
BigInteger d = c.multiply(b.add(BigInteger.valueOf(2)));// d = c * (b + 2)
```

## 数组

