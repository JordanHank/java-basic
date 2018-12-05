package com.blackj.leran.java.grammer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Program Name: java-basic
 * <p>
 * Description: 正则表达式介绍以及在java中的使用
 * <p>
 * Created by Zhang.Haixin on 2018/9/26
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class RegexIntroduction {

    /**
     * 正则表达式不是java独有的，而是一种通用的字符串匹配规则，许多语言都可以使用
     * java中使用正则表达式\\ 表示：我要插入一个正则表达式的反斜线，所以其后的字符具有特殊的意义
     * 而其他语言中\\ 表示：我想要在正则表达式中插入一个普通的（字面上的）反斜杠，请不要给它任何特殊的意义。
     * 也就是说需要给反斜杠转义表示时java中表示为\\\\
     *
     * 正则表达式的几种基本语法：
     * \表示下一个字符具有特殊含义，用于转义字符
     * ^用于匹配字符串的开始位置
     * $用于匹配字符串的结束位置
     * *零次或多次匹配前面的字符或子表达式
     * +一次或多次匹配前面的字符或子表达式
     * ?零次或一次匹配前面的字符或子表达式
     * {n}n为非负数，正好匹配n次
     * {n,}n为非负数，至少匹配n次
     * {,m}m为非负数，最多匹配m次
     * {n, m}n/m为非负数，其中 n <= m。匹配至少 n 次，至多 m 次
     */
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
