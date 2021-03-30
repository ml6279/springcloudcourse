package springcloud.producer.turbine;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService implements ApplicationListener<WebServerInitializedEvent> {

    private static List<String> productList = new ArrayList<>();

    public String queryProductById(int id){
        return productList.get(id);
    }

    public List<String> queryAllProducts(){
        //hystrix 默认超时是2秒, 测试熔断
        int i = new Random().nextInt(2500);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void saveProduct(String product){
        productList.add(product);
    }

    @Override       //
    public void onApplicationEvent(WebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();
        for (long i = 0;i<20;i++){
            productList.add(port+" 产品 "+i);
        }
    }


}
