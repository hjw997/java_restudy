package dahua_dp.a16_State.b;

import dahua.a16_State.b.Work;

public interface WorkState {
    /**
     * 不同状态 写程序.
     * 需要一个上下文获取当前的状态等. work 就是context
     */
    public void writePrograms(Work work);
}
