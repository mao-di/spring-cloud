package com.usian.filter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
/**
 * ClassName:PreFilter
 * Author:maodi
 * CreateTime:2021/03/10/09:49
 */
@Component
public class PreFilter extends ZuulFilter {

    @Override
    public Object run() {
        // 获取请求上下文
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        // 获取表单中的 token
        String token = request.getParameter("token");
        // 对 token 做判断
        if (token == null) {
            System.out.println("token is null............");
            rc.setSendZuulResponse(false);// 代表请求结束。不在继续向下请求
            rc.setResponseStatusCode(401);// 添加一个响应的状态码
            rc.setResponseBody("请登录后再访问！！！");// 响应内容
            rc.getResponse().setContentType("text/html;charset=utf-8");// 响应类型
        } else {
            // 访问 redis 服务 进行验证
            System.out.println("token is OK");
        }
        return null;
    }

    // 是否开启过滤器：默认为 false 不开启
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器的执行顺序：通过整数表示顺序，数值越小，优先级越高
    @Override
    public int filterOrder() {
        return 0;
    }

    // 过滤器类型：通过过滤器类型决定了过滤器执行的时机
    @Override
    public String filterType() {
        return "pre";
    }
}
