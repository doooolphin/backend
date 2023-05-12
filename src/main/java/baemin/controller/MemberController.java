package baemin.controller;

import baemin.exception.ErrorResult;
import baemin.exception.MemberException;
import baemin.service.MemberService;
import baemin.dto.MemberDto;
import jakarta.validation.Valid;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ExceptionHandler
    private ResponseEntity<ErrorResult> handelMemberException(MemberException e) {

        ErrorResult errorResult = ErrorResult.builder()
            .code(e.getCode().value())
            .message(e.getMessage())
            .timeStamp(new Date())
            .build();

        return new ResponseEntity<>(errorResult, e.getCode());
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
