package bean;

/**
 * Created by cactusli on 2022/11/30 9:48
 */
public class UserService {

    private String uId;

    private UserDao userDao;
    private String name;

    private String company;

    private String location;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + ","  + name + "," + company + "," + location;
    }


    public UserService() {
        super();
    }

    public UserService(String uId, UserDao userDao, String name, String company, String location) {
        this.uId = uId;
        this.userDao = userDao;
        this.name = name;
        this.company = company;
        this.location = location;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
