package baemin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Test {

    @GetMapping("/test")
    public String test() {
        log.info("Dfdfdfsf");
        return "test입니다";
    }
}
