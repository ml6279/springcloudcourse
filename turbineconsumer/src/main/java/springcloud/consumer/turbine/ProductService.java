package springcloud.consumer.turbine;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private RestTemplate restTemplate;

    //使用http协议,数据格式就是json
    public String queryProductById(int id){
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://producer/product/{"+id+"}",String.class,id);
        return responseEntity.getBody();
    }

    /**
     * 熔断保护
     * @return
     */

    @HystrixCommand(fallbackMethod = "queryProductsFail")
    public List<String> queryAllProducts(){
        ResponseEntity<List> responseEntity =
                restTemplate.getForEntity("http://producer/products",List.class);
        List<String> productList = responseEntity.getBody();
        return productList;
    }

    public List<String> queryProductsFail(){
        List<String> result = new ArrayList<>();
        result.add("当前购买油条的人数太多,请先排号!!");
        return result;
    }

}
