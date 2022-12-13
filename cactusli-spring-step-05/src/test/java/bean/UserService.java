package bean;

/**
 * Created by cactusli on 2022/11/30 9:48
 */
public class UserService {

    private String uId;

    private UserDao userDao;
    private String name;

    public String queryUserInfo(){
        String s  = "查询用户信息: " + userDao.queryUserName(uId);
        System.out.println("查询用户信息: " + userDao.queryUserName(uId));
        return s;
    }

    public UserService() {
    }

    public UserService(String uId, UserDao userDao, String name) {
        this.uId = uId;
        this.userDao = userDao;
        this.name = name;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "uId='" + uId + '\'' +
                ", userDao=" + userDao +
                ", name='" + name + '\'' +
                '}';
    }
}
