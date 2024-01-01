package mj_java_01.a14_正则表达式.c_量词_Quantifier;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 量词: Quantifier: 英: [ˈkwɒntɪˌfaɪə(r)]
 * 英文示意:
 * a word or phrase that is used before a noun to show the amount of it that is being considered
 * （数）量词
 * "Some", "many", "a lot of", and "a few" are examples of quantifiers.
 * some, many, a lot of 和 a few 这几个都是量词。
 */
public class AppTest {
    @Test
    public void test01() {

        String input = "123_444_555_666_789";

        //任意数字出现3次.
        String regex = "\\d{3}";
        //matches : 是完全匹配.
        System.out.println(input.matches(regex));

        //如果看里面有没有一个子串是匹配 regex
        Pattern p = Pattern.compile(regex); // 编译正则.
        Matcher matcher = p.matcher(input); // 生成一个匹配器
        //matcher.matches(); //完全匹配.
        //在 input 中如果有一个子串,能和正则匹配.那么就返回 true
        boolean b = matcher.find();
        /**
         * 想把找到的东西拿出来.
         */
        if (b) {
            //获取匹配成功的子串
            System.out.println(matcher.group());
            //匹配的开始位置到结束位置(也就是子串的范围 [m.start(),m.end()) )
            //左闭右开如:[1,4) .那么长度就是 4-1 就是3
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }

    }

    /**
     *  String input = "123_444_555_666_789";
     *   String regex = "\\d{3}";
     * 如果把所有匹配的都搞出来.
     */
    @Test
    public void test02() {
        String input = "123_444_555_666_789";

        //任意数字出现3次.
        String regex = "\\d{3}";

        //如果看里面有没有一个子串是匹配 regex
        Pattern p = Pattern.compile(regex); // 编译正则.
        Matcher matcher = p.matcher(input); // 生成一个匹配器

        //find每调用一次就往下找一次,找到就 返回true.找不到就false.
        while (matcher.find()) {
            System.out.println("-------");
            System.out.println(matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }
    }

    @Test
    public void test03() {
        /**
         * [abc]{3} 对于这个的理解
         * [abc] 表示[abc] a,b,c 中的任意一个,x{3} ,表示x出现3次. 不要以为是 aaa bbb ccc . ❌
         * 正确理解✅: X{3} 表示X出现三次,所以 [abc]{3} 表示:[abc][abc][abc] 这样子出现3次.
         * 所以以后看到 [abc]{3} 右边有量词 [abc]{3} 的.记得 如:X{3} X整体 就出现3次.
         *
         * [abc] 是单字符.
         */
        String regex = "[abc]{3}"; //[abc][abc][abc]--每一处地方都是 a,b,c 的任意一个.
        String input = "abccabaaaccbbbc";
        findAll(regex,input);
    }

    @Test
    public void test04() {
        /**
         * X? 表示 x出现0次或者1次.
         */
        String input = "";
        findAll("a?",input); //a出现了0次 ,就是没有a,就是 "" 没有a
        /**
         * x* x出现任意次, 0次,1次2次,...
         */
        findAll("a*",input);

        /**
          x+  x至少出现一次.
         */
        findAll("a+",input); //a至少匹配一次."" 没有a 就不匹配.

    }


    @Test
    public void test05() {
        String input = "a";
        findAll("a?",input); //a匹配,然后去掉a 剩下的字符"" 匹配. 出现0次a 所以也匹配.
        /**
         "a": [0,1)
         "": [1,1)
         */

        findAll("a*", input);
        /**
         * x* x出现任意次,0次 1次. 2次.
         "a": [0,1)
         "": [1,1)
         */

        findAll("a+",input); // 至少出现一次
        /**
         "a": [0,1)
         */

    }








    public static void findAll(String regex, String input) {
        //如果看里面有没有一个子串是匹配 regex
        Pattern p = Pattern.compile(regex); // 编译正则.
        Matcher matcher = p.matcher(input); // 生成一个匹配器

        boolean isFound = false;
        //find 每调用一次就往下找一次,找到就 返回true.找不到就false.
        while (matcher.find()) {
            isFound = true;
            System.out.format("\"%s\": [%d,%d)%n", matcher.group(), matcher.start(), matcher.end());
        }
        if (!isFound) {
            System.out.println("没有匹配");
        }
    }
}
