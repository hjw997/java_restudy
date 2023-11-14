package tujie_sheji_moshi.a09_Bridge桥接设计模式;

/**
 * CountDisplay 在 Display 功能上增加了一个新功能.
 * 属于类的功能层次结构
 */
public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    /**
     * Display 类只具有 "显示功能"
     * CountDisplay则具有"只显示规定的次数"的功能.也就是 multiDisplay 方法.
     * @param times
     */
    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
