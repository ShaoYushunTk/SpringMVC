package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Controller springmvc 开发专用声明bean注解
 */
@Controller
public class UserController {

    /**
     * @RequestMapping 设置当前操作访问路径
     * @ResponseBody 设置当前操作返回值类型
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("user save ...");
        return "{'module':'springmvc'}";
    }
}
