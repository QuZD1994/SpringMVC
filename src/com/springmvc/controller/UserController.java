package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    /**
     * 1.使用 @RequestMapping 注解来映射请求的URL
     * 2.返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver 视图解析器会做如下解析：
     *  通过 前缀（prefix）+returnVal+后缀（suffix） 这样的方式得到实际的物理视图，然后做转发操作，直接转到页面
     *  prefix:/WEB-INF/views/
     *  returnVal:success
     *  suffix：.jsp
     *  构成：/WEB-INF/views/success.jsp
     *
     * @return
     */
    @RequestMapping("/helloworld")
   public String Hello(){
       System.out.println("hello world");
       return "success";
   }
}
