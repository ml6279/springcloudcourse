package springcloud.producer.turbine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//测试 turbine 聚合监控功能的接口
@RestController
public class CustomController {



    @Autowired
    private CustomerService customController;

    @GetMapping("consumers")
    public String queryCustome(){
        return customController.queryCustoms();
    }


}
