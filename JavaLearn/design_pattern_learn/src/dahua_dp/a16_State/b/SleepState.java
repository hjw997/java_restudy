package dahua_dp.a16_State.b;

public class SleepState implements WorkState{
    @Override
    public void writePrograms(Work work) {
        if (work.getHours() >= 22) {
            System.out.println("当前时间:" + work.getHours() + " " + "回家睡觉 😴");
        }
    }
}
