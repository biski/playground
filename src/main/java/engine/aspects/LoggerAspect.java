package engine.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;


/**
 * Created by wojciech on 21.04.17.
 */

@Aspect
public class LoggerAspect {

    @Before("execution(* engine.Page+.*(..))")
    public void beforePageMethod(JoinPoint jointPoint) {
        // yours log function ..
        System.out.println(getFunctionName(jointPoint) + getArguments(jointPoint));
    }

    private String getFunctionName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }

    private String getArguments(JoinPoint joinPoint) {
        Object[] signatureArgs = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        StringBuilder arguments = new StringBuilder("(");
        joinArguments(signatureArgs, signature, arguments);
        return arguments.append(")").toString();
    }

    private void joinArguments(Object[] signatureArgs, MethodSignature signature, StringBuilder arguments) {
        for (int i = 0; i < signatureArgs.length; i++) {
            arguments.append(signature.getParameterNames()[i])
                    .append(" = ")
                    .append(signatureArgs[i]);
            if(i!=signatureArgs.length-1) arguments.append(", ");
        }
    }
}
