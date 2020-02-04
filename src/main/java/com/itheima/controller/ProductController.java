package com.itheima.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/product")
public class ProductController {

//    @Secured({"ROLE_PRODUCT","ROLE_ADMIN"})  // spring-security 内部指定的注解
//    @RolesAllowed({"ROLE_PRODUCT","ROLE_ADMIN"})  // jsr250 注解
    @PreAuthorize("hasAnyRole('ROLE_PRODUCT','ROLE_ADMIN')")  // spring 的el表达式注解
    @RequestMapping("/findAll")
    public String findAll(){
        return "product-list";
    }
}
