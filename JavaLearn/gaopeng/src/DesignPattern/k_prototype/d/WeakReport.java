package DesignPattern.k_prototype.d;

import java.io.*;
import java.util.Date;

/**
 * 周报:
 * 为了解决 d 包中克隆深度 比较深的 复杂问题 修改代码如下:
 * Serializable 接口: 序列化 写入的是 二进制, 反序列化: 读出来是个对象.
 * 序列化 就是 深拷贝.
 */
class WeekReport implements Cloneable, Serializable { //标记接口

    public WeekReport() {
        System.out.println("AAAAA");
    }
    private int id;
    private String emp; //员工
    private String summary; //总结
    private String plain; //计划
    private String suggestion; //建议
    private Date time; //提交日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPlain() {
        return plain;
    }

    public void setPlain(String plain) {
        this.plain = plain;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeekReport{" +
                "id=" + id +
                ", emp='" + emp + '\'' +
                ", summary='" + summary + '\'' +
                ", plain='" + plain + '\'' +
                ", suggestion='" + suggestion + '\'' +
                ", time=" + time +
                '}';
    }

    //修饰符可以比父类的大 改为public
    @Override
    public Object clone() throws CloneNotSupportedException {

        //因为对象复杂时候 这里的拷贝 就 麻烦了,改用 序列化来进行深拷贝.
        try {
            /// 程序中永远不要写 盘符: 跨平台 , 不要砸牌子.
            String tempFile = "/Users/whj/Desktop/io_test/temp.txt";
            OutputStream out = new FileOutputStream(tempFile);
            //对象流 才能写对象
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this); /** 序列化时,对象的所有属性层级关系都会被序列化自动处理.!!!! */
            oos.close();

            /// 写出去以后 再读进来
            InputStream in = new  FileInputStream(tempFile);
            ObjectInputStream ois = new ObjectInputStream(in);
            Object clone = ois.readObject(); // 读对象
            System.out.println("clone--ing-----");
            System.out.println(this);
            System.out.println(clone);
            System.out.println((this == clone) + "!!!!!!");
            return clone;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}