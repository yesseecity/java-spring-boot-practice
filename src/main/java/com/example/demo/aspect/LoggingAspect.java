package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.LoginServiceDto;
import com.example.demo.util.LoggerUtil;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private LoggerUtil loggerUtil;

    @Pointcut("within(com.example.demo.service..*)")
    public void withinServicePackage() {
        // 這裡的代碼不會在切入點匹配時執行
    }

    @Before("execution(* com.example.demo.service.UserService.login(..))")
    public void loginBeforeMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof LoginServiceDto) {
            LoginServiceDto dto = (LoginServiceDto) args[0]; // 強制轉型
            loggerUtil.debug("==========================");
            loggerUtil.debug("Login attempt: Employee ID = " + dto.getEmployeeId());
        }
    }

    @Before("execution(* com.example.demo.service.UserService.*(..))")
    public void logBeforeMethod() {
        loggerUtil.debug("==========================");
        loggerUtil.debug("Method is about to be called");
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.service.UserService.login(..))", returning = "result")
    public void loginAfterMethod(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof LoginServiceDto) {
            LoginServiceDto dto = (LoginServiceDto) args[0];
            loggerUtil.debug("==========================");
            loggerUtil.debug("Login attempt: Employee ID = " + dto.getEmployeeId());
            loggerUtil.debug("Login result: " + result);
        }
    }

    // 在 com.example.demo.service 包及其子包中的方法拋出異常時執行
    @AfterThrowing(pointcut = "withinServicePackage()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        // 可以把 error 送到 Slack 或是其他地方
        loggerUtil.error("Exception in " + joinPoint.getSignature().getName() + " with cause = " + (error.getCause() != null ? error.getCause() : "NULL") + " and exception = " + error.getMessage(), error);
    }
}