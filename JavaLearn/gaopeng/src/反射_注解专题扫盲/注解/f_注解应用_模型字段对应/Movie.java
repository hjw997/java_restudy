package 反射_注解专题扫盲.注解.f_注解应用_模型字段对应;

public class Movie {
    @Column("move_id") //JSON 中是 这个字段 使用注解去标记 让json中的 move_id 给模型中的 moveID
    private String moveID; //自定义的和json对不上.
    @Column("move_type")
    private String moveType;

    public Movie(String moveID, String moveType) {
        this.moveID = moveID;
        this.moveType = moveType;
    }
}
