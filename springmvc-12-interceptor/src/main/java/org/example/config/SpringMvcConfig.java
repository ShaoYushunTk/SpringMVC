package org.example.config;

import org.example.controller.interceptor.ProjectInterceptor;
import org.example.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 继承WebMvcConfigurer 简化开发 不需要写springMvcSupport
 */
@Configuration
//@ComponentScan({"org.example.controller", "org.example.config"})
@ComponentScan("org.example.controller")
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ProjectInterceptor projectInterceptor;
    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

    /**
     *  拦截器执行的顺序是和配置顺序有关。就和前面所提到的运维人员进入机房的案例，先进后出。
     *      当配置多个拦截器时，形成拦截器链
     *      拦截器链的运行顺序参照拦截器添加顺序为准
     *      当拦截器中出现对原始处理器的拦截，后面的拦截器均终止运行
     *      当拦截器运行中断，仅运行配置在前面的拦截器的afterCompletion操作
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/books","/books/*");
    }
}
