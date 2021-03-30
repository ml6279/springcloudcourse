package zk.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZkProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkProductApplication.class,args);
    }
}
