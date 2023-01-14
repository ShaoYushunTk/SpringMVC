package org.example.controller;

import org.example.domain.Book;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book){
        System.out.println("book save " + book);
        return "{'module':'book save'}";
    }

    @PutMapping
    public String update(@RequestBody Book book){
        System.out.println("book update " + book);
        return "{'module':'book update'}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("book delete " + id);
        return "{'module':'book delete'}";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("book getById " + id);
        return "{'module':'book getById'}";
    }

    @GetMapping
    public String getAll(){
        System.out.println("book getAll ");
        return "{'module':'book getAll'}";
    }


}
