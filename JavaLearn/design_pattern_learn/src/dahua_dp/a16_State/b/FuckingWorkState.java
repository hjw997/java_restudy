package dahua_dp.a16_State.b;

/**
 * 加班状态
 */
public class FuckingWorkState implements WorkState{
    @Override
    public void writePrograms(Work work) {
        if (work.getHours() < 22) { // 6到 10点 加班
            System.out.println("当前时间:" + work.getHours() + " " + "开始犯困了");
        }else {
            work.setWorkState(new SleepState());
            work.writePrograms();
        }
    }
}
