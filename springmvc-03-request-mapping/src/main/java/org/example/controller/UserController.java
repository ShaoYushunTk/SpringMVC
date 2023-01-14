package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Controller springmvc 开发专用声明bean注解
 * @RequestMapping("/user") 类上方的访问路径为请求路径的前缀
 */
@Controller
@RequestMapping("/user")
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
        return "{'module':'user save'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        System.out.println("user delete ...");
        return "{'module':'user delete'}";
    }
}
