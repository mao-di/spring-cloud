package com.usian.filter;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 限流器
 */
//@Component
public class RateLimitFilter extends ZuulFilter {

    /**
     * 创建令牌桶
     *  RateLimiter.create(1)1: 是每秒生成令牌的数量,数值越大代表处理请求量越多
     */
    private static final RateLimiter RATE_LIMIT = RateLimiter.create(1);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 限流器的优先级应为最高
     * DEBUG_FILTER_ORDER = 1;
     * FORM_BODY_WRAPPER_FILTER_ORDER = -1;
     * PRE_DECORATION_FILTER_ORDER = 5;
     * RIBBON_ROUTING_FILTER_ORDER = 10;
     * SEND_ERROR_FILTER_ORDER = 0;
     * SEND_FORWARD_FILTER_ORDER = 500;
     * SEND_RESPONSE_FILTER_ORDER = 1000;
     * SIMPLE_HOST_ROUTING_FILTER_ORDER = 100;
     * SERVLET_30_WRAPPER_FILTER_ORDER = -2;
     * SERVLET_DETECTION_FILTER_ORDER = -3;
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER;
    }

    /**
     /**
     * 指定需要执行该Filter的规则
     *  返回true则执行run()
     *  返回false则不执行run()
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 是否能从令牌桶中获取到令牌
        if (!RATE_LIMIT.tryAcquire()) {
            // 获取请求上下文
            RequestContext rc = RequestContext.getCurrentContext();
            rc.setSendZuulResponse(false);// 代表请求结束。不在继续向下请求
            rc.setResponseStatusCode(401);// 添加一个响应的状态码
            rc.setResponseBody("限流了，稍后再访问！！！");// 响应内容
            rc.getResponse().setContentType("text/html;charset=utf-8");// 响应类型
        }
        return null;
    }
}
