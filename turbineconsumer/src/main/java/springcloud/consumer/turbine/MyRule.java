package springcloud.consumer.turbine;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//负载均衡算法
@Configuration
public class MyRule {

    @Bean
    public IRule ribbonRule(){
        //return new RoundRobinRule();      //springcloud默认的算法
        return new RandomRule();
    }
}
