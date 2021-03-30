package gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class GatewayTestApplication {
    @Autowired
    RestTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(GatewayTestApplication.class,args);
    }

    @RequestMapping("/loop")
    public void loop(){
        //spring-cloud-gateway  带限流功能的服务网关的微服务名称
        for(int i = 0; i<200000; i++){
            try {
                ResponseEntity<String> response =
                        template.getForEntity("http://" + "spring-cloud-gateway".toUpperCase() +
                                "/prefix?user=tom",String.class);
                System.out.println(response.getBody());
            } catch (Exception e) {
                System.out.println("访问的频率太高,请休息一下");
            }
        }
    }
}
