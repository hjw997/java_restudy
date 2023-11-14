package dahua_dp.a16_State.b;

public class AfternoonState implements WorkState {
    @Override
    public void writePrograms(Work work) {
        if (work.getHours() < 17) {
            System.out.println("当前时间:" + work.getHours() + " "  +  " 下午状态还好 ☕️ ");
        }else { //18点及以后
            work.setWorkState(new EveningState());
            work.writePrograms();
        }
    }
}
