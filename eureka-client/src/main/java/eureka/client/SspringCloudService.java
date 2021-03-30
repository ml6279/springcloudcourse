package eureka.client;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SspringCloudService {

    @RequestMapping("/prefix")
    public String test4(){
        return "prefix---->{}";
    }
}
