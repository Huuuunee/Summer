package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //private final MemberService memberService = new MemberService(); // 하나를 선언하고 가져다 쓰는것이 효율적
    private final MemberService memberService;

    @Autowired // 자동으로 컨테이너에서 가져옴
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
