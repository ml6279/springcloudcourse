package gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;//响应式编程
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
//GlobalFilter: 全局过滤器
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("GlobalFilter ----> {} start");
        ServerHttpRequest request = exchange.getRequest();
        List<String> list = new ArrayList<>();
        list.add("myParameter");
        //request.getBody();
        //request.getQueryParams().add("myParameter1","1122222");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
