package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

  // 어디다가 적용을 시킬 것인지 라우팅
  @Around("execution(* hello.hellospring..*(..))")
//  @Around("execution(* hello.hellospring.service..*(..))")
  public Object execute(ProceedingJoinPoint jointPoint) throws Throwable {
    long start = System.currentTimeMillis();
    System.out.println("START: " + jointPoint.toString());
    try {
      return jointPoint.proceed();
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("END: " + jointPoint.toString() + " " + timeMs + "ms");
    }
  }
}
