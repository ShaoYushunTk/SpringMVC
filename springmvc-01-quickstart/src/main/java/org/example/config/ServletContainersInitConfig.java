package org.example.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * 定义一个servlet容器启动配置类，在里面加载spring的配置
 *
 * 启动服务器初始化过程
 * 1. 服务器启动，执行ServletContainersInitConfig类，初始化web容器
 * 2. 执行createServletApplicationContext方法，创建了WebApplicationContext对象
 *      该方法加载SpringMVC的配置类SpringMvcConfig来初始化SpringMVC的容器
 * 3. 加载SpringMvcConfig配置类
 * 4. 执行@ComponentScan加载对应的bean
 *      扫描指定包下所有类上的注解，如Controller类上的@Controller注解
 * 5. 加载UserController，每个@RequestMapping的名称对应一个具体的方法
 *      此时就建立了 /save 和 save方法的对应关系
 * 6. 执行getServletMappings方法，定义所有的请求都通过SpringMVC
 *      / 代表所拦截请求的路径规则，只有被拦截后才能交给SpringMVC来处理请求
 *
 * 单次请求过程
 * 1. 发送请求localhost/save
 * 2. web容器发现所有请求都经过SpringMVC，将请求交给SpringMVC处理
 *      因为符合上面第六步设置的请求路径，所以该请求会交给SpringMVC来处理
 * 3. 解析请求路径/save
 * 4. 由/save匹配执行对应的方法save(）
 *      上面的第五步已经将请求路径和方法建立了对应关系，通过/save就能找到对应的save方法
 * 5. 执行save()
 * 6. 检测到有@ResponseBody直接将save()方法的返回值作为响应求体返回给请求方
 */
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    /**
     * 加载springmvc容器配置
     * @return
     */
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    //设置Tomcat接收的请求哪些归SpringMVC处理
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    //设置spring相关配置
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
