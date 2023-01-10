package com.example.jwtdemo.config;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class BaseInterceptor implements HandlerInterceptor {
    private Logger log = LoggerFactory.getLogger(BaseInterceptor.class);
    //不拦截集合
    public static final List<String> list = Arrays.asList("getToken","getAdvertisementList",
            "getCompanyInfoList","getHelp");

    /**
     * 请求处理前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求头中的 单位编号 信息
        String token = request.getHeader("token");
        log.info("-----preHandle----userCltNo---{}", token);
        String requestURI = request.getRequestURI();

        // 如果不是映射到方法不拦截 直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        requestURI = requestURI.replace("/jeecg-boot/miniApp/", "");
        if (!list.contains(requestURI) && StrUtil.isBlank(token)) throw new RuntimeException("token为空");
        // TODO: 2023/1/10 0010  toke效验逻辑




        MyThreadLocal.set(token);
        return true;
    }

    /**
     * 请求处理后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 请求完后，需要清空 MyThreadLocal 集合数据
        // 避免 OOM
        MyThreadLocal.remove();
        log.info("-----afterCompletion----MyThreadLocal.remove()");
    }
}

