package DesignPattern.k_prototype.b;

import java.util.Date;

/**
 * 周报:
 * 为了能克隆 实现 接口
 */
class WeekReport implements Cloneable { //标记接口

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
        return super.clone();
    }
}