package gateall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayAllApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayAllApplication.class,args);
    }
}
