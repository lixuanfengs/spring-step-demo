package bean;

/**
 * Created by cactusli on 2022/11/30 9:48
 */
public class UserService {

    private String name;

    public void queryUserInfo(){
        System.out.println("查询用户信息: " + name);
    }

    public UserService() {
        this.name = "111";
    }

    public UserService(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
