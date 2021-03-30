package springcloud.consumer.turbine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    //服务提供者
    public static final String SERVICE_PROYOIDER = "producer";

}
