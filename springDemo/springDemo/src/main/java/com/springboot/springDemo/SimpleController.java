package com.springboot.springDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

    @Controller
    public class IndexController {
        @RequestMapping("/")
        @ResponseBody
        public String index() {
            return "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<meta charset=\"ISO-8859-1\">\n"
                    + "<title>Spring Boot Demo</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + " <h1>Learning Spring Boot</h1>\n"
                    + "<hr/>\n"
                    + "<h2>Hello World,</h2>\n"
                    + "<h2>This is my first Spring Boot boot web application</h2>\n"
                    + "</body>\n"
                    + "</html>";
        }
    }
}