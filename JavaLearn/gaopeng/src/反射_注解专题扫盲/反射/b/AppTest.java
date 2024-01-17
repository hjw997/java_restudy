package 反射_注解专题扫盲.反射.b;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.*;
import java.util.Arrays;

public class AppTest {
    public static void main(String[] args) {
    }

    /**
     * 1.1 反射 构造器:
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {


//        这样从文件中读取就可以配置
//        Reader in = new FileReader("/User/whj/Desktop/io_test/1.txt");
//        BufferedReader br = new BufferedReader(in);
//        String className = br.readLine();


        //假设是从文件中读取的. 就很灵活,不会 像 new Person 这样造成对类的依赖.
        String className = "反射_注解专题扫盲.反射.b.Person";

        Class clazz = Class.forName(className);

        //运行时通过字节码对象去分析类信息.
        // 以下的 c 是一个对象, 该对象的类型是Construct,
        // public Person() 的构造
        Constructor c  =  clazz.getDeclaredConstructor();
        //利用构造器对象类构造一个对象
        Object instance = c.newInstance();

        //因为无参构造器使用的频率很高,所以提供了一个语法糖方法  clazz.newInstance() 方法
        Object o = clazz.newInstance(); //无参构造器的快捷方法.
        System.out.println(instance);

        //获取某一个指定的构造器:
        //public Person(String name)
        Constructor c2 = clazz.getDeclaredConstructor(String.class);
        Object instance1 = c2.newInstance("apple");
        System.out.println(instance1);

        //public Person(int age)
        Constructor c3 = clazz.getDeclaredConstructor(int.class);
        Object instance2 = c3.newInstance(10);
        System.out.println(instance2);

        // public Person(String name, int age)
        Constructor c4 = clazz.getDeclaredConstructor(String.class, int.class);
        Object instance4 = c4.newInstance("Google", 25);
        System.out.println(instance4);


        //获取所有的构造方法 - 数组
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        /**
         * 缺点: 反射会把编译时的异常 推迟到 运行时异常.
         */

    }

    /**
     * 1.2 获取构造方法的一些访问修饰,参数,名字等.
     * @throws Exception
     */
    @Test
    public void test01_1() throws Exception {


//        这样从文件中读取就可以配置
//        Reader in = new FileReader("/User/whj/Desktop/io_test/1.txt");
//        BufferedReader br = new BufferedReader(in);
//        String className = br.readLine();


        //假设是从文件中读取的. 就很灵活,不会 像 new Person 这样造成对类的依赖.
        String className = "反射_注解专题扫盲.反射.b.Person";

        Class clazz = Class.forName(className);

        //获取所有的构造方法 - 数组
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("=====================");
            System.out.println("构造方法修饰符:" + constructor.getModifiers() + " 对应:" + Modifier.toString(constructor.getModifiers()));
            System.out.println(constructor.getName()); //构造方法的名字
            System.out.println("构造方法参数:" + Arrays.toString(constructor.getParameters())); //构造方法参数

        }
    }

    /**
     * 2.反射字段:
     */
    @Test
    public void test02() throws Exception {
        String className = "反射_注解专题扫盲.反射.b.Person";

        Class clazz = Class.forName(className);
        Object obj1 = clazz.newInstance();
        Object obj2 = clazz.newInstance();

        // private String  name;
        Field field = clazz.getDeclaredField("name");//孤零零的字段. 就好比一人的名字 飘进教师
        Field field_age = clazz.getDeclaredField("age");
        field_age.setAccessible(true);

        field.setAccessible(true); //让私有的也能访问

        //✅把field的字段 , 当做 obj 对象的字段,赋值为 "张三"  apply 应用,翻译为当做.
        field.set(obj1,"张三"); //p.setName("张三")
        field_age.set(obj1,20);

        // 把field字段应用给obj2对象上. //person.setName("李四")
        field.set(obj2, "李四");
        field_age.set(obj2,25);
        System.out.println(obj1);
        System.out.println(obj2);
    }


    /**
     * 3. 反射--实例方法:
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {

        String className = "反射_注解专题扫盲.反射.b.Person";
        Class clazz = Class.forName(className);

        Object obj = clazz.newInstance();

        //public void eat()
        Method method = clazz.getDeclaredMethod("eat");

        //把method 当做obj对象的方法来 调用,此时method 的 this 就是obj.  前端中叫 apply .
        method.invoke(obj); //invoke 调用的意思 这种方式调用就决定了方法中的this是谁.

        Person p1 = new Person("a", 12);
        Person p2 = new Person("b", 22);

        //把method当做 p1 的方法调用.
        method.invoke(p1);  //其实就是决定了里面的this是谁
        method.invoke(p2);

        System.out.println("============ public void eat(String food) ============");
        //public void eat(String food)
        Method m2 = clazz.getDeclaredMethod("eat", String.class);
        m2.invoke(obj, "凉皮");
        m2.invoke(p1, "酸辣粉");
        m2.invoke(p2, "拉面");

        // 有返回值 怎么获取返回值  public int  add(int a, int b)
        Method addMethod = clazz.getDeclaredMethod("add", int.class, int.class);
        // 返回值用 Object 接收
        Object result =  addMethod.invoke(p1, 2, 3); //此时 Method 方法中的this


    }


    /**
     * 4.反射-获取静态方法
     * @throws Exception
     */
    @Test
    public void test04() throws Exception {

        String className = "反射_注解专题扫盲.反射.b.Person";
        Class clazz = Class.forName(className);

        //public static int times(int a, int b)
        Method timesMethod = clazz.getDeclaredMethod("times", int.class, int.class);

        //静态方法中 不需要 this ,所以第一个参数 , 可以为null建议✅
        Object result = timesMethod.invoke(null, 2, 3);
        System.out.println(result);


    }


    /**
     * 5.反射-复杂方法
     * @throws Exception
     */
    @Test
    public void test05() throws Exception {
        String className = "反射_注解专题扫盲.反射.b.Person";
        Class clazz = Class.forName(className);

        //反射一个实例对象
        Object obj = clazz.newInstance();

        // public Date f1(String[] strings, Class[][][][] c, Integer a)
        Method f1 = clazz.getDeclaredMethod("f1", String[].class, Class[][][][].class, Integer.class);

        Object result = f1.invoke(obj, new String[]{}, new Class[][][][]{}, 20);
        System.out.println(result);
    }




}
