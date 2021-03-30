package zuul.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
public class ZuulAction {

    @RequestMapping("/zuul0")
    public String test(HttpServletRequest request){
        request.getSession().setAttribute("user","user");
        request.setAttribute("param1","param1");
        return "forward:/client/test/test";     //处理业务微服务地址
    }
    @RequestMapping("/zuul2")
    public String test(){
        return "redirect:/client/test/test";
    }

}
