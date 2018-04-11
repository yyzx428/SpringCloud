package com.example.zuul.Filter;

import com.example.zuul.FilterType;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.util.HTTPRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {
    private static Logger log= LoggerFactory.getLogger(MyFilter.class);
  /**
    *  pre：路由之前
    * routing：路由之时
    * post： 路由之后
    * error：发送错误调用
    **/
    @Override
    public String filterType() {
        return FilterType.Pre.getValue();
    }

    //过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }
    //这里可以写逻辑判断，是否要过滤
    @Override
    public boolean shouldFilter() {
        return false;
    }
    //过滤器的具体逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        log.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURI().toString()));
        Object accessToken=request.getParameter("token");
        if(accessToken==null){
            log.warn("token is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
