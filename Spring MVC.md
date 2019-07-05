# Spring MVC

## 1.MVC设计模式

是一种软件的设计范畴，系统分为模型层，视图层，控制层

模型层：javaBean、Service、Dao

视图层：jsp

控制层：处理客户端请求，调用后台模型层，并返回数据到视图层：servlet、SpringMVC

## 2.优缺点

优点：

1.松耦合

2.高重用性

3.高可扩展性

4.职责清晰，易于管理、维护

缺点：

1.降低了视图层访问模型层效率

## 3.SpringMVC

SpringMVC是当前最流行的mvc框架，本质是servlet

如何使用

### 1.导入所需的驱动包

### 2.在web.xml配置文件中，配置springmvc核心控制器（前端控制器），用来拦截请求，加载Spring MVC配置文件

```xml
 <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--加载spring mvc配置文件-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>WEB-INF/springmvc-servlet.xml</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <!--拦截所有请求，并且将请求特殊处理-->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```

实际上springmvc配置文件可使用自动配置，即其文件名为springmvc-servlet.xml 本文采取的方式就是这样如下所示

```xml
 <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--&lt;!&ndash;加载spring mvc配置文件&ndash;&gt;
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>WEB-INF/springmvc-servlet.xml</param-value>
        </init-param>-->
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <!--拦截所有请求，并且将请求特殊处理-->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```



### 3.创建Controlller 处理请求的控制器

```java
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
```

### 4.配置springmv.xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <!--配置自动扫描的包-->
    <context:component-scan base-package="com"/>

    <!--配置视图解析器：如何把handler 方法返回值解析为实际的物理视图-->
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>
```

