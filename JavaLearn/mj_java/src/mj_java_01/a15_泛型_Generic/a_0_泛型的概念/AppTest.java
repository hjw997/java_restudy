package mj_java_01.a15_泛型_Generic.a_0_泛型的概念;

public class AppTest {
    public static void main(String[] args) {
        Student student = new Student(99.0);
        System.out.println(student);
    }
}
class Student {
    double score;
    // 如果分数是 A+ 优 等字符串 太死板.

    public Student(double score) {
        this.score = score;
    }
}
