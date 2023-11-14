package dahua_dp.a16_State.b;

import dahua.a16_State.b.Work;

public class AppTest {
    public static void main(String[] args) {
        Work work = new Work();
        work.setHours(9);
        work.writePrograms();
        work.setHours(10);
        work.writePrograms();

        work.setHours(12);
        work.writePrograms();

        work.setHours(13);
        work.writePrograms();

        work.setHours(15);
        work.writePrograms();


        //下午6点工作没完成是否
//        work.setWorkFinished(true);
        work.setWorkFinished(false);
        work.setHours(18);
        work.writePrograms();

        work.setHours(20);
        work.writePrograms();

        work.setHours(22);
        work.writePrograms();

        work.setHours(23);
        work.writePrograms();

    }
}
