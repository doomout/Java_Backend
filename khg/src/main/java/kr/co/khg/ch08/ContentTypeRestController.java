package kr.co.khg.ch08;

import kr.co.khg.ch07.Bookmark;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentTypeRestController {
    @RequestMapping("/returnString")
    public String returnString() {
        return "<strong>문자열</strong>을 리턴";
    }
    @RequestMapping("/returnBookmark")
    public Bookmark returnBookmark() {
        return new Bookmark();
    }
}
