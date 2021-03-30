package springcloud.trubin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix  //开启熔断保护
@EnableHystrixDashboard  //开启熔断监控的仪表盘
@EnableTurbine
public class TurbinApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurbinApplication.class,args);
    }
}
