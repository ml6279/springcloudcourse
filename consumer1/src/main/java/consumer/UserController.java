package consumer;

import common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private MyService myService;    //本地服务

    @GetMapping("/list")
    public List<String> getList(){
       // String result = myService.service();
        List<String> list = userService.getList();
        return list;
    }

    @GetMapping("/port1")
    public String getPort(@RequestParam(value = "name") String name){
        return userService.port(name);
    }

    @GetMapping("/user")
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("李伟");
        user.setPassword("123456");
        System.out.println("user---------------" + user.getName());
        return userService.getUser(user);
    }

}
