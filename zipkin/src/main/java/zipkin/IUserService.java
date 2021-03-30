package zipkin;


import common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(value = "product1",configuration = FeignConfig.class,fallback = IUserFeignFailback.class)      //product1 是其他微服务的名称
public interface IUserService {

    @GetMapping("/list")
     List<String> getList();

    /**
     * 如果传递的是普通参数,String和基本类型值,那么这里加RequestParam注解,否则会出现参数错误问题
     * 基本类型最好使用包装类
     * @param name
     * @return
     */

    @GetMapping("/port")
    String port(@RequestParam(value = "name") String name);

    /**
     * 如果传递实体对象,那么使用RequestBody注解,否则也会出现各种参数错误问题
     */

    @PostMapping("/user")
    User getUser(@RequestBody User user);

    /**
     * 如果使用restful风格传递参数,那么使用PathVarilable 注解,并指明名称
     * 否则也会产生各种参数错误问题
     */

    @GetMapping("/restful/{id}")
    public String getRestful(@PathVariable(value = "id") Integer id);


}
