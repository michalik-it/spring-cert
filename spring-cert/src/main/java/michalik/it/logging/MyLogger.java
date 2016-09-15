package michalik.it.logging;

import michalik.it.service.TransactionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;

@Aspect
public class MyLogger {

    @Pointcut(value="execution(* *..TransactionService.transfer(..))")
    public void transferMethodPC() {
        
    }
    
    @Pointcut(value="execution(* *..TransactionService.transfer(..)) && target(ts) && args(p1,p2,p3)")
    public void transferMethodPC2(TransactionService ts, int p1, int p2, int p3) {
        
    }
    
    @Before("transferMethodPC()")
    public void logA(JoinPoint jp) {
        System.out.println("MyLogger.logA(), execution(* transfer(..)) params:");
        for ( Object arg : jp.getArgs()) {
            System.out.print(arg + " ");
      
        }
        System.out.println();
    }
    
    @Before("transferMethodPC() && target(ts) && args(p1,p2,p3)")
    public void logAHandleParams(TransactionService ts, int p1, int p2, int p3) {
        System.out.println("MyLogger.logAHandleParams(), execution(* transfer(..)) input: " + p1 + " " + p2 + " " + p3);
    }
    
    @Before("transferMethodPC2(ts,p1,p2,p3)")
    public void logAHandleParams2(TransactionService ts, int p1, int p2, int p3) {
        System.out.println("MyLogger.logAHandleParams1(), execution(* transfer(..)) input: " + p1 + " " + p2 + " " + p3);
    }
    

    @Before("execution(* *..TransactionService.*(..))")
    public void logB(JoinPoint jp) {
        System.out.println("MyLogger.logB() called before: " + jp.getSignature());
    }

    @AfterReturning(value = "execution(* *..TransactionService.*(..))", returning = "result")
    public void logC(JoinPoint jp, Integer result) {
        System.out.println(
                "MyLogger.logC() called after: " + jp.getSignature() + " result: " + result);
    }

    @AfterThrowing(value = "execution(* *..TransactionService.*(..))", throwing = "e")
    public void logD(JoinPoint jp, IllegalArgumentException e) {
        System.out.println("MyLogger.logD() called after throwing: " + jp.getSignature() + " message: " + e.getLocalizedMessage());
    }
    
    @Around(value = "transferMethodPC() && !execution(* *..TransactionService.transfer2(..))")
    public void logAround(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("MyLogger.logAround() called after throwing: " + jp.getSignature());
        jp.proceed();
    }
}
