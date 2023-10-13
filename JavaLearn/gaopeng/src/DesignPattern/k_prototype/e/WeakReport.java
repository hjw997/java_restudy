package DesignPattern.k_prototype.e;

import java.io.*;
import java.util.Date;

/**
 * 周报:
 * 为了解决 d 包中 克隆 写文件地址. 使用操作内存的 流.
 *
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
            /// 操作内存中的流 : ByteArrayOutputStream ,以为不存盘 ,所以不要地址盘符
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            //对象流 才能写对象
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this); /** 序列化时,对象的所有属性层级关系都会被序列化自动处理.!!!! */
            oos.close();

            /// 再从内存中取出数据,怎么取? 内存又没有名字.
            /// 如何再从内存中读出来? 拿出来是字节数组.
            byte[] bytes = out.toByteArray(); //bytes 中放的就是序列化的数据


            System.out.println(bytes);
            // ByteArrayInputStream 从内存中读.
            InputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(in);

            Object clone = ois.readObject(); // 读对象
            System.out.println("读内存!!!!!!!!");
            System.out.println(this);
            System.out.println(clone);
            System.out.println((this == clone) + "内存!!!!!!");
            return clone;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}