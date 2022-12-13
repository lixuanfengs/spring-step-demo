package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cactusli on 2022/12/1 16:42
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "仙人球1");
        hashMap.put("10002", "仙人球2");
        hashMap.put("10003", "仙人球3");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
