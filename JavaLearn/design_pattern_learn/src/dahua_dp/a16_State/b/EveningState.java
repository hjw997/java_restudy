package dahua_dp.a16_State.b;

public class EveningState implements WorkState{
    @Override
    public void writePrograms(Work work) {
        if (work.isWorkFinished()) {
            work.setWorkState(new RestState());

        }else {
            work.setWorkState(new FuckingWorkState());
        }
        work.writePrograms();
    }
}
