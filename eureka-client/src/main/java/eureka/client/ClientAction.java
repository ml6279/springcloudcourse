package eureka.client;



import common.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ClientAction {

    @RequestMapping("/test/test")
    public User test(){
        User user = new User();
        user.setId(1);
        user.setName("liwei");
        user.setPassword("123455");
        return user;
    }

    @RequestMapping("/queryparam/test")
    public String test3(HttpServletRequest request){
        System.out.println("request paramter--->{}"+request.getParameter("paraml"));
        return "test3{}";
    }

    @RequestMapping("/lbtest/test")
    public String test1(HttpServletRequest request){
        request.getHeaderNames();
        System.out.println("myParameter ---> {} " + request.getAttribute("myParamter"));
        System.out.println("myParameter ---> {} " + request.getParameter("myParamter"));
        return "test1 {}";
    }

    @RequestMapping("/header/test")
    public String test2(HttpServletResponse response,HttpServletRequest request){
        System.out.println("X-AnotherHeader ---> {} " + response.getHeader("X-AnotherHeader"));
        System.out.println("X-AnotherHeader ---> {} " + request.getParameter("X-AnotherHeader"));
        System.out.println("X-AnotherHeader ---> {} " + request.getAttribute("X-AnotherHeader"));
        return "test2 {}";
    }
}
