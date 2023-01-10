package bean.event;

import com.cactusli.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * Created by cactusli on 2022/12/20 11:25
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
