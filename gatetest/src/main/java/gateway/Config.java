package gateway;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    @LoadBalanced   //开启负载均衡
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory httpRequestFactory =
                new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(5000);
        httpRequestFactory.setConnectTimeout(5000);
        return new RestTemplate(httpRequestFactory);
    }

}
