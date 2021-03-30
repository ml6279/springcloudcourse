package gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono; //响应式编程的一个核心类,解决高并发

//局部过滤器
//对我们关系型数据库支持, postgre  redis  mongodb
public class RequestFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("timebegin",System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() ->{
                    Long startTime = exchange.getAttribute("timebegin");
                    if(startTime != null){
                        System.out.println(exchange.getRequest().getURI().getRawPath() + ": " +
                                (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
