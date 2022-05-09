package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 아무것도 안되어있을떼 index.html이 나와야 하지만 안나오는 이유는 스프링 컨테이너 검색할때 이미 아무것도 없는 get / 요청이 있어서 home.html이 반환된다
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
