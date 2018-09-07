package com.blackj.leran.java.datetype;

/**
 * Program Name: java-basic
 * <p>
 * Description: java运算符
 * <p>
 * Created by Zhang.Haixin on 2018/9/5
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class Operator {

    /**
     * java运算符分为以下几种
     *  1.算数运算符
     *      算数运算符包括+、-、*、/、%、++、--这七种
     *      +、-还可以用在数字前表示数字的正负，整数默认前面不加+，只有区分负数是使用
     *      +在和字符串使用的时候表示字符串的拼接
     *      运算符优先级：符号 +、- > ++、-- > *、/、% > 加减运算符 +、-
     *      为了不影响计算结果建议使用(),因为()的优先级最高
     *
     *  2.关系运算符
     *      关系运算符包括==、!=、>、<、>=、<=
     *      使用关系运算符是需要两种数据类型一致，byte、short、char会自动转换为int
     *      ==表示左边的变量值等于右边变量的值则返回true，反之返回false
     *      !=表示左边的变量值不等于右边变量的值则返回true，反之返回false
     *      >表示左边的变量值大于右边的变量的值则返回true,反之返回false
     *      <表示左边的变量的值小于右边的变量的值则返回true，反之返回false
     *      >=表示左边的变量的值大于等于右边的变量的值则返回true，反之返回false
     *      <=表示左边的变量的值小于等于右边的变量的值则返回true，返回返回false
     *
     *  3.逻辑运算符
     *      逻辑运算符包括&、|、^、!、&&、||
     *      逻辑运算符对结果是boolean的值进行比较，只能比较一次
     *      &与运算符，左右都为true时返回true,否则返回false,运行两次，依次判断左右是否为true
     *      |或运算符，左右只要有true返回true,否则返回false，运行两次，依次判断左右是否为true
     *      ^异或运算符，有一个true时返回true,否则返回false
     *      ！非运算符，右边为true是返回false,反之返回true
     *      &&与（短路）运算符，只要左边为false直接返回false，都为true是返回true
     *      ||或（短路）运算符，只要左边为true直接返回true,都为false是返回false
     *
     *  4.位运算符
     *      位运算符包括&、|、^、~、<<、>>、>>>
     *      位运算符应用于long、int、short、byte、char类型，作用在所有位上
     *      按位操作整数基本类型中的单个比特bit，也就是二进制，执行布尔运算得出结果
     *      为运算中1表示true,0表示false
     *      &进行二进制位运算   00100100 11010011 01011001 11001000
     *                        & 11001100 10011111 11110001 00111011
     *                        得00000100 10010011 01010001 00001000
     *      |进行二进制位运算 00100100 11010011 01011001 11001000
     *                       | 11001100 10011111 11110001 00111011
     *                       得11101100 11011111 11111001 11111011
     *       ^进行二进制运算   00100100 11010011 01011001 11001000
     *                       ^ 11001100 10011111 11110001 00111011
     *                       得11101000 01001100 10101000 11110011
     *       ~进行二进制运算   ~ 0100100 11010011 01011001 11001000
     *                         得1011011 00101100 10100110 00110111
     *        <<进行二进制运算    0100100 11010011 01011001 11001000 << 2
     *          左移去掉高位2位得 00100 11010011 01011001 11001000
     *             结果低位补零得 00100 11010011 01011001 1100100000
     *                 左移几位就是乘以2的几次幂
     *         >>进行二进制运算    0100100 11010011 01011001 11001000 << 2
     *           右移去掉低位2位得   0100100 11010011 01011001 110010
     *             结果高位补零得  000100100 11010011 01011001 110010
     *                右移几位就是除以2的几次幂，最高位原来是多少补位的时候还是一样
     *          >>>无符号右移与>>右移类似只是不管最高为是0还是1都补位的时候补0
     *
     *
     *  5.赋值运算符
     *      赋值运算符包括=、+=、-=、*=、/=、%=、<<=、>>=、&=、^=、|=
     *      =表示将右边的值赋值给左边的变量，其他包含其他运算符的表示先进行运算在进行赋值
     *      例如：a += b 表示先执行a + b然后在将计算后的结果赋值给a,其他类似
     *
     *  6.其他运算符
     *      三目运算符 variable x = (expression) ? value if true : value if false
     *      若表达式为true则变量x的值为前面的值，否则为后面的值
     *
     *      instanceof 运算符
     *      用于判断对象实例是不是属于某个类型或者某个类型的子类
     *      如果实例兼容某个类型返回true否则返回false
     *
     *      运算符的优先级可以自行查找资料进行了解，不需要记住所有优先级
     *      在不清楚优先级的时候建议使用()，()的优先级最高
     */
    public static void main(String [] args) {

        //正数表示
        int a = +101, c = 3;
        //负数表示
        int b = -87;

        //加法运算
        System.out.println("a + b = " + (a + b));
        //减法运算
        System.out.println("a - b = " + (a - b));
        //乘法运算
        System.out.println("a * c = " + (a * c));
        //除法运算
        System.out.println("a / c = " + (a / c));
        //取余运算（取模的正负取决于被除数）
        System.out.println("a % c = " + (a % c));
        /**
         * 自增运算（表示自己加1，但是有两种用法）
         * ++在前表示先进行加一在对结果进行使用
         * ++在后表示先使用变量的值，再对变量进行加一
         */
        System.out.println("c++ = " + (c++));
        System.out.println("++c = " + (++c));
        //自减运算（同自增运算原理，区别在于减一）
        System.out.println("c-- = " + (c--));
        System.out.println("--c =" + (--c));
        System.out.println("=====================================");

        //==运算符
        System.out.println("a == b 返回" + (a == b));

        //!=运算符
        System.out.println("a != b 返回" + (a != b));

        //>运算符
        System.out.println("a > b 返回" + (a > b));

        //<运算符
        System.out.println("a < b 返回" + (a < b));

        //>=运算符
        System.out.println("a >= b 返回" + (a >= b));

        //<=运算符
        System.out.println("a <= b 返回" + (a <= b));

        System.out.println("=====================================");

        //&与运算符
        System.out.println("true & false返回" + (true & false));

        //|与运算符
        System.out.println("true | false返回" + (true | false));

        //^与运算符
        System.out.println("true ^ false返回" + (true ^ false));

        //!运算符
        System.out.println("!true返回" + (!true));

        //&&运算符
        System.out.println("true && false返回" + (true && false));

        //||运算符
        System.out.println("true || false返回" + (true || false));

        System.out.println("=====================================");

        //赋值运算符
        c = a + b;
        System.out.println("c = a + b赋值后c = " + c);

        //+=运算
        c += a;
        System.out.println("c += a赋值后c = " + c);

        //-=运算
        c -= a;
        System.out.println("c -= a赋值后c = " + c);

        //*=运算
        c *= a;
        System.out.println("c *= a赋值后 c =" + c);

        // /=运算
        c /= a;
        System.out.println("c /= a赋值后 c = " + c);

        //%=运算
        c %= a;
        System.out.println("c %= a赋值后 c = " + c);

        int x = 3;
        //<<=运算
        System.out.println("x <<= 2赋值后 " + (x <<= 2));

        int y = 5;
        //>>=运算
        System.out.println("y >>= 2赋值后 " + (y >>= 2));

        //&=运算
        System.out.println("x &= 2赋值后 " + (x &= 2));

        //^=运算
        System.out.println("x ^= 2赋值后 " + (x ^= 2));

        //|=运算
        System.out.println("x |= 2赋值后 " + (x |= 2));

        System.out.println("=====================================");

        //三目运算符
        int z = x < y ? 12 : 2;
        System.out.println("z的结果为: " + z);

        //instanceof运算符
        String name = "Jordan";
        boolean result = name instanceof String;
        System.out.println("name兼容String类型" + result);

        boolean res = name instanceof Object;
        //所有类型都是Object的子类
        System.out.println("name兼容Object类型" + res);
    }
}
