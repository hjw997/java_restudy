package tujie_sheji_moshi.a09_Bridge桥接设计模式;

/**
 * 类的 实现层次结构:
 */
public class StringDisplayImpl extends DisplayImpl{

    /**
     * 要显示的字符串
     */
    private String string;

    /**
     * 以字节单位计算出字符串的宽度
     */
    private int width;

    public StringDisplayImpl(String string) { //构造函数接受要显示的字符串 string .
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|"); //前后加上 "|" 并显示 : |Hello,World!|
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        /** 打印这个效果:
         * +---------------+
         */
        System.out.print("+"); //显示用来表示方框的角的 "+"
        for (int i = 0; i < width; i++) { // 显示width 个 "-"
            System.out.print("-"); // 将其用作方框的 边框.
        }
        System.out.println("+"); // 显示用来表示方框的角的"+"
    }
}
