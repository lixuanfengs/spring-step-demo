package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cactusli on 2022/12/1 16:42
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "仙人球");
        hashMap.put("10002", "测试");
        hashMap.put("10003", "1232");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
