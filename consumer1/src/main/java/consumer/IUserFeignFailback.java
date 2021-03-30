package consumer;

import common.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//服务降级,它实现远端调用的接口,在发生熔断的时候,由它替代生产者继续发送回应消息
@Component
public class IUserFeignFailback implements IUserService{

    @Override
    public List<String> getList() {
        return new ArrayList<String>(){{add("fallback");}};
    }

    @Override
    public String port(String name) {
        return "fallback";
    }

    @Override
    public User getUser(User user) {
        user.setName("fallback");
        return user;
    }

    @Override
    public String getRestful(Integer id) {
        return "fallback"+id;
    }
}
