package kr.co.khg.ch05;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/article")
    public String createArticle(@RequestParam("title") String title,
                                @RequestParam("content") String content) {
        return String.format("title=%s / content=%s", title, content);
    }

}
