package engine.aspects;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import engine.annotations.Timeout;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.concurrent.Callable;

/**
 * Created by wojciech on 22.04.17.
 */

@Aspect
public class TimeoutAspect {

    @Pointcut("@annotation(timeout)")
    public void timeoutPointcut(Timeout timeout) {}

    @Pointcut("execution(* *(..))")
    public void atExecution() {}

    //@Around(("@annotation(Timeout) && execution(* *(..))"))
    @Around("timeoutPointcut(timeout) && atExecution()")
    public Object methodWithTimeout(ProceedingJoinPoint joinPoint, Timeout timeout) throws Throwable {

        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                try {
                    return joinPoint.proceed();
                } catch (Throwable throwable) {
                    throw new RuntimeException(throwable);
                }
            }
        };

        return new SimpleTimeLimiter().callWithTimeout(
                callable,
                timeout.value(),
                timeout.unit(),
                true
        );
    }
}
