package baemin.controller;

import baemin.service.MemberService;
import baemin.dto.MemberDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity join(@Valid @RequestBody MemberDto memberDto) {
        memberService.join(memberDto);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/my-information")
    public MemberDto findById(@RequestParam Integer id) {
        return memberService.findById(id);
    }

}
