package com.neusoft.medical.Util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
class Advices {
    private Logger log = Logger.getLogger(Advices.class);

    /**
     * 方法执行前写日志，包括方法名和传入参数
     *
     * @param joinPoint 连接点
     */
    @Before(value = "execution(* com.neusoft.medical.*.*(.))")
    public void before(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + " method starts");
        log.info("Arguments: ");
        for (Object o : joinPoint.getArgs()) {
            log.info(o.toString());
        }
    }

    /**
     * 方法执行后写日志
     *
     * @param joinPoint 连接点
     */
    @After(value = "execution(* com.neusoft.medical.*.*(.))")
    public void after(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + " method ends");

    }

    /**
     * 方法返回值写日志
     *
     * @param resObj 连接点
     * @return 返回值
     */
    @AfterReturning(value = "execution(* com.neusoft.medical.*.*(.))", returning = "resObj")
    public Object afterReturn(Object resObj) {
        log.info("Return value: " + resObj);
        return resObj;
    }

    /**
     * 方法抛出异常写日志
     *
     * @param e 异常
     */
    @AfterThrowing(value = "execution(* com.neusoft.medical.*.*(.))", throwing = "e")
    public void afterThrowing(Exception e) {
        log.info("Exception occurs: " + e.getMessage());
    }
}
