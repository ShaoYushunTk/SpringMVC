package org.example.controller;

import org.example.domain.Book;
import org.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * REST简化开发
 * @RequestMapping("/books") 将@RequestMapping提到类上面，用来定义所有方法共同的访问路径。
 * @ResponseBody 将ResponseBody提到类上面，让所有的方法都有@ResponseBody的功能
 * @RestController 替换@Controller与@ResponseBody注解，简化书写
 * 使用@GetMapping @PostMapping @PutMapping @DeleteMapping代替 每个方法的@RequestMapping注解中method属性定义请求方式
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book){
        System.out.println("book save ...");
        return "{'module':'book save'}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("book delete ..." + id);
        return "{'module':'book delete'}";
    }


    @PutMapping
    public String update(@RequestBody Book book){
        System.out.println("book update..."+book);
        return "{'module':'book update'}";
    }


    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("book getById..."+id);
        return "{'module':'book getById'}";
    }


    @GetMapping
    public String getAll(){
        System.out.println("book getAll...");
        return "{'module':'book getAll'}";
    }
}
