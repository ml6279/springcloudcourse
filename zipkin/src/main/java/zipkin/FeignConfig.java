package zipkin;


import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 重试机制
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer retryer(){
        //重试间隔为100ms,最大重试时间为1秒,重试次数为五次
        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }
}
