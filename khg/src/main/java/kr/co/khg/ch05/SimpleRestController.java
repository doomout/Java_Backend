package kr.co.khg.ch05;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
    //@RequestMapping("/")
    //@RequestMapping("/bye")
    //public String hello() {
    //    return "Hello";
    //}

    @RequestMapping("/")
    public String hello() {
        return "Hello <strong>Backend</strong>";
    }

    @RequestMapping("/bye")
    public String bye() {
        return "Bye";
    }

}
