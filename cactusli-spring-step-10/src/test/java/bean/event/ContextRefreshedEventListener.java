package bean.event;

import com.cactusli.springframework.context.ApplicationListener;
import com.cactusli.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by cactusli on 2022/12/20 11:23
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
