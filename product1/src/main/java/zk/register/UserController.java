package zk.register;

import common.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    @Value("${server.port}")
    private int port;
    @GetMapping("/list")
    public List<String> getList(){
        Random random = new Random();
        return new ArrayList<String>(){{
           add("product" + random.nextInt(100) + "_" + port);
            add("product" + random.nextInt(100) + "_" + port);
            add("product" + random.nextInt(100) + "_" + port);
        }};
    }

    @GetMapping("/port")
    public String getPort(@RequestParam(value = "name") String name){
        return name + port;
    }

    @PostMapping("/user")
    public User getUser(@RequestBody User user){
        user.setId(10);
        user.setName(user.getName() + "-product");
        user.setPassword(user.getPassword() + "-product");
        return user;
    }

    @GetMapping("/restful/{id}")
    public String getRestful(@PathVariable Integer id){
        return "product" + id;
    }

}
