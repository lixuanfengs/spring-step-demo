package bean.event;

import com.cactusli.springframework.context.ApplicationListener;
import com.cactusli.springframework.context.event.ContextClosedEvent;

/**
 * Created by cactusli on 2022/12/20 11:24
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
