package org.example.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器（Interceptor）是一种动态拦截方法调用的机制，在SpringMVC中动态拦截控制器方法的执行
 * 作用:
 * 1.在指定的方法调用前后执行预先设定的代码
 * 2.阻止原始方法的执行
 * 3.总结：拦截器就是用来做增强
 *
 * 拦截器和过滤器之间的区别是什么?
 * 1.归属不同：Filter属于Servlet技术，Interceptor属于SpringMVC技术
 * 2.拦截内容不同：Filter对所有访问进行增强，Interceptor仅针对SpringMVC的访问进行增强
 *
 * 流程参考：webapp/interceptor.png
 */

@Component
public class ProjectInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle222...");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 222...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 222...");
    }
}
