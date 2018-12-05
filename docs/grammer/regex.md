# 正则表达式

正则表达式不是Java 独有的，而是一种通用的字符串匹配规则，许多语言都可以使用。正则表达式定义了字符串的模式，可以用来搜索、编辑或处理文本。
Java 中使用正则表达式`\\ `表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义。
而其他语言中`\\` 表示：我想要在正则表达式中插入一个普通的（字面上的）反斜杠，请不要给它任何特殊的意义。
也就是说需要给反斜杠转义表示时Java 中表示为`\\\\`。

## 常用语法

+ `\` 表示下一个字符具有特殊含义，用于转义字符

+ `^` 用于匹配字符串的开始位置

+ `$` 用于匹配字符串的结束位置

+ `*` 零次或多次匹配前面的字符或子表达式

+ `+` 一次或多次匹配前面的字符或子表达式

+ `?` 零次或一次匹配前面的字符或子表达式

+ `{n}` n为非负数，正好匹配n次

+ `{n,}` n为非负数，至少匹配n次

+ `{,m}` m为非负数，最多匹配m次

+ `{n, m}` n/m为非负数，其中 n <= m。匹配至少 n 次，至多 m 次

## 主要相关类

java.util.regex 包主要包括以下三个类：

+ **Pattern 类：**

    + pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
    
+ **Matcher 类：**
    
    + Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
    
+ **PatternSyntaxException：**

    + PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
    
## 示例

``` java
public class RegexIntroduction {

    public static void main(String [] args) {

        //java中使用Pattern 类和 Matcher类对字符串进行匹配
        String input = "this is a beautiful world!";

        String pattern = "(\\D*)(is+)(.*)";

        boolean isMatch = Pattern.matches(pattern, input);
        if (isMatch) {
            System.out.println(input + "包含 is");
        }

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(input);

        if (m.find( )) {
            int group = m.groupCount();
            for(int i = 0; i < group + 1; i++) {
                System.out.println("找到第" + (i + 1) + "个匹配：" + m.group(i));
            }
        } else {
            System.out.println("没有匹配值");
        }

        Pattern n = Pattern.compile("beautiful");
        Matcher mn = n.matcher(input);

        //替换字符串
        input = mn.replaceAll("BEAUTIFUL");

        System.out.println(input);

    }
}
```

正则表达式由于作者本身涉及使用的并不多，所以了解尚浅，这里这是大概介绍了下基础语法，更多正则表达式相关具体介绍可以参考
[菜鸟教程-Java 正则表达式](https://www.runoob.com/java/java-regular-expressions.html)。