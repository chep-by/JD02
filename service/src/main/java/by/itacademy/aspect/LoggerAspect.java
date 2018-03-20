package by.itacademy.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Pointcut("@annotation(SaveOrUpdateLogger)")
    public void saveOrUpdateLogger() {}


    @Before("saveOrUpdateLogger()")
    public void startSaveOrUpdate(JoinPoint joinPoint) {
        logger.info("***** Start save or update: " + joinPoint.getSignature().getName() + "() *****");
    }

    @AfterReturning("saveOrUpdateLogger()")
    public void correctSaveOrUpdate(JoinPoint joinPoint) {
        logger.info("***** Save or update correctly : " + joinPoint.getSignature().getName() + "() *****");
    }

    @AfterThrowing(pointcut = "saveOrUpdateLogger()", throwing = "ex")
    public void incorrectSaveOrUpdate(Exception ex) {
        logger.info("***** Save or update incorrectly : " + ex.getMessage() + " *****");
    }
}
