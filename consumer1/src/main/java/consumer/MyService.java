package consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    IUserService service;

    public String service(){    //没有调用远程微服务的本地服务方法
        return "myservice";
    }

    //一般来说,如果你调用了其他微服务,又需要开启事务管理
    //那么spring 提供的本地事务已经没有用,需要使用补偿式分布式事务
    //seata 阿里

    public String service1(){
        String s = service.port("consumer");
        s += "自己本地业务";
        return s;
    }

}
