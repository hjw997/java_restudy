package dahua_dp.a16_State.b;

public class ForenoonState implements WorkState {
    @Override
    public void writePrograms(Work work) {
        if (work.getHours() < 12) {
            System.out.println("当前时间:" + work.getHours() + " "  +  " 早上精神百倍👌🏻");
        }else{
            work.setWorkState(new NoonState());
            work.writePrograms();
        }

    }
}
