package baemin.controller;

import baemin.dto.MemberAuthDto;
import baemin.exception.ErrorResult;
import baemin.exception.MemberException;
import baemin.service.MemberService;
import baemin.dto.MemberDto;
import jakarta.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ExceptionHandler
    private ResponseEntity<ErrorResult> handleMemberException(MemberException e) {
        ErrorResult errorResult = ErrorResult.builder()
            .code(e.getCode().value())
            .message(e.getMessage())
            .timeStamp(new Date())
            .build();
        return new ResponseEntity<>(errorResult, e.getCode());
    }

    @PostMapping("/email-confirm")
    public ResponseEntity<Boolean> emailConfirm(@Valid @RequestBody MemberAuthDto memberAuthDto) {
        Boolean confirmResult = memberService.emailConfirm(memberAuthDto);
        return ResponseEntity.ok(confirmResult);
    }

    @GetMapping("/send-email/{email}")
    public ResponseEntity sendEmail(@PathVariable("email") String email) throws UnsupportedEncodingException, MessagingException {
        memberService.sendEmail(email);
        return ResponseEntity.ok("ok");
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
