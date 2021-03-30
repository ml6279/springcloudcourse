package springcloud.consumer.turbine;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name =ConsumerService.SERVICE_PROYOIDER ,configuration = MyRule.class)
public class RibbonBalance {
}
