package com.springmvc.controller;

import com.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//@SessionAttributes({"use"})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    /**
     * 1.@RequestMapping 除了修饰方法 还可修饰类
     * 2.相当于web应用的路径
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

    /**
     * 常用
     * 使用Method属性来指定请求方法
     * 页面表单 method = post
     * @return
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**
     * 了解
     * 可以使用params和headers来更加精确的映射请求
     * params和headers支持简单的表达式
     * @return
     */
    @RequestMapping(value = "/testParamsAndHeaders", params = {"username", "age != 10"}, headers = {"Accept-Language = en-US,zhq=0.8"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * @PathVariable 可以映射URL中的占位符到目标方法的参数中
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("testPathVariable : " + id);
        return SUCCESS;
    }

    /**
     * @RequestParam 来映射请求参数
     * value：值即为请求参数的参数名
     * required 该参数是否必须 默认为true
     * defaultValue:请求参数的默认值
     * @param un
     * @param age
     * @return
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String un, @RequestParam(value = "age", required = false, defaultValue = "0") int age){
        System.out.println("testRequestParam, username: " + un + ", age : " + age);
        return SUCCESS;
    }

    /**
     * 了解
     * @CookieValue 映射一个cookie值，属性同@RequestParam
     * @param sessionId
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
        System.out.println("testCookieValue : sessionId : " + sessionId);
        return SUCCESS;
    }

    /**
     * 根据请求参数名和Pojo属性自动匹配 支持级联属性
     * @param user
     * @return
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println("testPojo : user " + user);
        return SUCCESS;
    }

    /**
     * 可以使用原生的servletAPI作为方法的参数
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI : " + request + ", " + response);
        out.write("hello quzhidiao");
    }


    /**
     * 处理model数据 如何和页面交互
     */

    /**
     * 目标方法的返回值可以是modelandview类型，
     * 其中可以包含视图和模型信息
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewname = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewname);
        //添加模型数据到ModelAndView中
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    /**
     * 目标方法可以添加Map类型的参数
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }

    /**
     * 除了可以指定属性名可以放到会话中的属性外
     * 还可以通过模型属性的对象类型指定那些模型属性放到会话中
     *
     * 需要注意的是：注解只能放到类上面而不能放在方法上面
     * @param map
     * @return
     */
    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Map<String, Object> map){
        /*User user = new User("quzhidiao", "123455", "quzhd17@lzu.edu.cn", 24);
        map.put("user", user);
        System.out.println("testSessionAttribute");*/
        return SUCCESS;
    }

    /**
     * 有@ModelAttribute标记的方法会在每个目标方法执行前被SpringMVC调用
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map){
        if (id != null){
            User user = new User(1, "tom", "123456", "tom@lzu.edu.cn",12);
            System.out.println("模拟从数据库中获取一个对象 " + user);
            map.put("user", user);
        }
    }
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute : user " + user);
        return SUCCESS;
    }
}
