package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // TODO:先执行拦截代码
    @Before("execution(public * org.example.service.UserService.*(..))")
    public void doAccessCheck() {
        System.err.println("[Before 先] 权限验证：do access check...");
    }

    // TODO:完全控制目标代码是否执行
    @Around("execution(public * org.example.service.MailService.*(..))")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        System.err.println("[Around 全] 开始：start " + pjp.getSignature());
        Object retVal = pjp.proceed();
        System.err.println("[Around 全] 结束：done " + pjp.getSignature());
        return retVal;
    }
}
