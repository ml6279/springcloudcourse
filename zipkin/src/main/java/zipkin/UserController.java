package zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/list")
    public List<String> getList(){
       // String result = myService.service();
        List<String> list = userService.getList();
        return list;
    }


}
