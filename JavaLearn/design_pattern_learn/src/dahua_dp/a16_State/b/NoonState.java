package dahua_dp.a16_State.b;

public class NoonState implements WorkState {

    @Override
    public void writePrograms(Work work) {
        if (work.getHours() < 13) { //中午时间 12点-13点
            System.out.println("当前时间:" + work.getHours() + " "  +  " 中午饿了 犯困.🍚 ");
        }else {
            work.setWorkState(new AfternoonState());
            work.writePrograms();
        }
    }
}
