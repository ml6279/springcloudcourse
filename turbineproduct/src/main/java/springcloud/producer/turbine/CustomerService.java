package springcloud.producer.turbine;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//为了验证微服务聚合,添加这个调用,这样可以在一张(仪表盘)图标上两个微服务的调用情况
//调用的时候,消费者和生产者都调用一下,仪表盘才能把图标合并在一起显示

public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "queryCustomsFail")
    public String queryCustoms(){
        return restTemplate.getForObject("http://consumer/consumers",String.class);
    }


    public String queryCustomsFail(){
        return "获取用户列表失败";
    }

}
