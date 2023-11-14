package dahua_dp.a16_State.b;

import dahua.a16_State.b.Work;

public class RestState implements WorkState{
    @Override
    public void writePrograms(Work work) {
        System.out.println("当前时间:" + work.getHours() + " "  +  " 下班了开心😄");
    }
}
