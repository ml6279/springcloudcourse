package zuul.service;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomZuulFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomZuulFilter.class);


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE; //PRE:
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() { //返回一个boolean类型进行判断过滤器是否要执行,通过此方法来指定过滤器的有效范围
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        LOGGER.info("进入到拦截器里面");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        LOGGER.info("传递的参数是: " + request.getAttribute("param1"));
        if (request.getSession().getAttribute("user") == null){
            //表示不将请求转发到目标服务器上
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
            HttpServletResponse response = context.getResponse();
            try {
                response.getWriter().append("please login......");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
