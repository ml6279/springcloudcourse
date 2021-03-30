package gateall;


import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/** 限流的策略*/
@Configuration
public class Config {

    /** 根据请求参数中的 user 字段来限流 */
    @Bean
    //@Primary
    KeyResolver userKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

    /** 根据请求 ip 地址来限流*/
    @Bean
    @Primary
    public KeyResolver ipKeyResolver(){
        System.out.println("-----------------");
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
