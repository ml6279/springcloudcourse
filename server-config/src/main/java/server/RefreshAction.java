package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RefreshAction {

    @Autowired
    RestTemplate template;
    //@Scheduled(cron = "0/5  * * * * * ?")
    @RequestMapping("postRefresh")
    public void postRefresh(){
        template.postForObject("http://gitclient/actuator/bus-refresh",null,Void.class);
        //template.postForObject("http://order/actuator/bus-refresh",null,Void.class);
        //template.postForObject("http://stock/actuator/bus-refresh",null,Void.class);
    }
}
