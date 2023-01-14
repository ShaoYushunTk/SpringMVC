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
public class ProjectInterceptor implements HandlerInterceptor {
    /**
     * 前置处理方法 原始被拦截的操作执行前调用
     *
     * 返回值为true 放行 false 终止原始操作
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 被调用的处理器对象 本质上是一个方法对象 使用handler参数，可以获取方法的相关信息
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contentType = request.getHeader("Content-Type");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        System.out.println(method);
        System.out.println("preHandle..." + contentType);

        return true;
    }

    /**
     * 后置处理方法 原始被拦截的操作执行后调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 如果处理器执行完成具有返回结果，可以读取到对应数据与页面信息，并进行调整
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
    }

    /**
     * 完成处理方法 拦截器最后执行的方法，无论原始方法是否执行 在postHandle后面
     * @param request
     * @param response
     * @param handler
     * @param ex 如果处理器执行过程中出现异常对象，可以针对异常情况进行单独处理
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion ...");
    }
}
