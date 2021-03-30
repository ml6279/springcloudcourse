package server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
//@EnableScheduling   //定时任务注解
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        RestTemplate rest = new RestTemplate();
        //在模板上增加一个拦截器,为了设置请求头的mime格式为json格式
        rest.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            ClientHttpResponse response = execution.execute(request,body);
            return response;
        }));
        return rest;

    }

}
