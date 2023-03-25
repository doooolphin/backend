package baemin.controller;

import baemin.service.MemberService;
import baemin.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/sign-up")
    public Boolean save(@RequestBody MemberVo memberVo) {
        return memberService.save(memberVo);
    }

    @GetMapping("/my-information")
    public MemberVo findById(@RequestParam Integer id) {
        return memberService.findById(id);
    }

}
