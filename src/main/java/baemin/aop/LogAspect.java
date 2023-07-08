package baemin.aop;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Around("execution(* baemin.controller..*(..))")
    public Object requestLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

        Map <String, String[]> paramMap = request.getParameterMap();
        String params = "";
        if (!paramMap.isEmpty()) {
            params = "[" + paramMapToString(paramMap) + "]";
        }

        long start = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            log.info("Request: {} {}{} < {} ({}ms)", request.getMethod(), request.getRequestURI(), params, request.getRemoteHost(), end - start);
        }

    }

    private String paramMapToString(Map<String, String[]> paramMap) {
        return paramMap.entrySet().stream().map(
            entry -> String.format("%s : %s", entry.getKey(), Arrays.toString(entry.getValue())))
            .collect(Collectors.joining(", "));
    }
}
