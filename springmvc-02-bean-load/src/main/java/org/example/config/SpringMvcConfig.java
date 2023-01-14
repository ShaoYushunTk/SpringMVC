package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 创建springmvc配置文件 加载bean
 */
@Configuration
@ComponentScan("org.example.controller")
public class SpringMvcConfig {
}
