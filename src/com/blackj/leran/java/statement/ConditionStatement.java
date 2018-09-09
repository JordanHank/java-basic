package com.blackj.leran.java.statement;

import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Program Name: java-basic
 * <p>
 * Description: java条件语句
 * <p>
 * Created by Zhang.Haixin on 2018/9/9
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class ConditionStatement {

    /**
     * java中条件语句主要分if条件语句和switch条件语句
     * 其中if条件语句又分单if条件语句、if else条件语句、if else if语句几种
     */

    public static void main(String [] args) {

        /**
         * if (表达式） {
         *      //符合条件的执行代码语句。
         * }
         * 如果表示式的结果是true则执行{}里面的语句，否则跳过{}的语句直接执行后面的语句
         */

        //判断今天是不是星期一，如果是打印语句
        Calendar today = Calendar.getInstance();
        int td = today.get(today.DAY_OF_WEEK);
        if ( 2 == td) {
            System.out.println("今天是星期一");
        }

        /**
         * if (表达式）{
         *      //表达式为true执行后面的代码
         *
         * } else {
         *      //表达式为false执行后面的代码
         *
         * }
         * 如果 else 后面只有一条语句可以省略{}，不过不建议这么做
         */
        //判断num是否是数字
        String num = "1002";
        Pattern pattern = Pattern.compile("[0-9]*");
        if (pattern.matcher(num).matches()) {
            System.out.println(num + "是数字");
        } else {
            System.out.println(num + "不是数字");
        }


        /**
         * if (表达式) {
         *      //第一个表达式为true,执行后面的代码
         *
         * } else if (表达式）{
         *      //第一个表达式为false,第二个表达式为true，执行后面的代码
         *
         * } else if (表达式) {
         *      //第一、二个表达式都为false,第三个表达式为true,执行后面的代码
         *
         * } else {
         *      //所有的表达式都为false，执行后面的代码
         *
         * }
         */
        //判断分数75的成绩
        int sore = 75;
        if (sore < 60) {
            System.out.println("你的成绩是E");
        } else if (sore < 70) {
            System.out.println("你的成绩是D");
        } else if (sore < 80) {
            System.out.println("你的成绩是C");
        } else if (sore < 90){
            System.out.println("你的成绩是B");
        } else {
            System.out.println("你的成绩是A");
        }

        /**
         * swith(变量） {
         *      case 取值1：
         *          //执行语句
         *          break;
         *      case 取值2
         *          //执行语句
         *          break;
         *      case 取值3：
         *          //执行语句
         *          break;
         *      ...
         *      default:
         *          //执行语句
         *          break;
         *
         * }
         * 1.switch语句的选择类型只能是byte,short,int,char和枚举（jdk1.7版本之后）
         * 2.case之间与default么有顺序，先判断所有case，没有批判的case则执行default后面的语句
         * 3,.如果匹配的case或者default没有跟break结束，程序会继续执行，知道遇到break或则程序结束
         * 4.case的值必须是相同类型的常量，不能是变量
         */
        //判断今天是星期几
        switch (td) {
            case 1:
                System.out.println("今天是星期天");
                break;
            case 2:
                System.out.println("今天是星期一");
                break;
            case 3:
                System.out.println("今天是星期二");
                break;
            case 4:
                System.out.println("今天是星期三");
                break;
            case 5:
                System.out.println("今天是星期四");
                break;
            case 6:
                System.out.println("今天是星期五");
                break;
            case 7:
                System.out.println("今天是星期六");
                break;
            default:
                System.out.println("今天是个好天气");
                break;
        }
    }
}
