package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 创建springmvc配置文件 加载bean
 * @EnableWebMvc 开启json数据转化为对象的功能
 */
@Configuration
@ComponentScan({"org.example.controller","org.example.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
