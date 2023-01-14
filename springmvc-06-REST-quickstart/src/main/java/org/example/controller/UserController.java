package org.example.controller;

import org.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST（Representational State Transfer），表现形式状态转换,它是一种软件架构风格
 * 当我们想表示一个网络资源的时候，可以使用两种方式:
 * 传统风格资源描述形式
 *      http://localhost/user/getById?id=1 查询id为1的用户信息
 *      http://localhost/user/saveUser 保存用户信息
 * REST风格描述形式
 *      http://localhost/user/1
 *      http://localhost/user
 *
 * 按照REST风格访问资源时使用行为动作区分对资源进行了何种操作
 *      http://localhost/users 查询全部用户信息 GET（查询）
 *      http://localhost/users/1 查询指定用户信息 GET（查询）
 *      http://localhost/users 添加用户信息 POST（新增/保存）
 *      http://localhost/users 修改用户信息 PUT（修改/更新）
 *      http://localhost/users/1 删除用户信息 DELETE（删除）
 *
 *
 *
 * 修改请求方法和访问路径 形参设置@PathVariable注解
 */
@Controller
public class UserController {

    /**
     * 设置当前请求方法为POST，表示REST风格中的添加操作
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public String save(){
        System.out.println("user save ...");
        return "{'module':'user save'}";
    }

    /**
     * 设置当前请求方法为DELETE，表示REST风格中的删除操作
     * @PathVariable 注解用于设置路径变量（路径参数），要求路径上设置对应的占位符，并且占位符名称与方法形参名称相同
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Integer id){
        System.out.println("user delete ..." + id);
        return "{'module':'user delete'}";
    }

    /**
     * 设置当前请求方法为PUT，表示REST风格中的修改操作
     * @param user
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println("user update..."+user);
        return "{'module':'user update'}";
    }

    /**
     * 设置当前请求方法为GET，表示REST风格中的查询操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id){
        System.out.println("user getById..."+id);
        return "{'module':'user getById'}";
    }

    /**
     * 设置当前请求方法为GET，表示REST风格中的查询操作
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
        System.out.println("user getAll...");
        return "{'module':'user getAll'}";
    }

}
