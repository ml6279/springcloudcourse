package gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class,args);
    }

    //http://start.spring.io/actuator/info  查看springcloud和boot版本依赖
    //@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes().route(r ->{
           // return r.path("/prefix").uri("http://127.0.0.1:8020/test/test");
            //规则: 路由地址 + 微服务的主机 = 最终要去的真实地址
            return r.path("/prefix").uri("lb://eurekaClient");
        }).route(r ->r.path("/prefix/prefix").filters(f ->f.stripPrefix(1))
                .uri("lb://eurekaClient"))
                .route(r -> r.path("/test").filters(f ->f.prefixPath("/test")).uri("lb://eurekaClient"))
                .route(r->r.path("/rewrite/abc").
                                filters(f->f.rewritePath("/rewrite/abc","/test/test"))
                                .uri("lb://eurekaClient")
                        //filters(f->f.rewritePath("/rewrite/abc","/test/test"))  过滤规则:把前面的地址替换成后面的地址
                ).route(r -> r.path("/queryparam/**").uri("lb://eurekaClient")
                        //  /queryparam/**  前缀分类
                ).route("route1",r -> r.path("/lbtest/**").
                        filters(f -> { //过滤器
                        f.addRequestParameter("myParamter","11"); //向微服务传递参数
                        return f;
                }).uri("lb://eurekaClient")//访问微服务的名称
                ).route(r -> r.path("/header/**")
                .filters(f -> f.filter(new RequestFilter())
                        .addResponseHeader("X-AnotherHerHeader","testheader"))
                        .uri("lb://eurekaClient"))

                .build();
    }
}
