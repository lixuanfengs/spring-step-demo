package bean;

import com.cactusli.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cactusli on 2022/12/23 16:51
 */
@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "仙人球，北京，海淀");
        hashMap.put("10002", "野猫，云南，收拾");
        hashMap.put("10003", "测字，河南，周口");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
