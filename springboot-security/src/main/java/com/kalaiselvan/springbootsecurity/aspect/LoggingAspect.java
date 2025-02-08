package com.kalaiselvan.springbootsecurity.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//	@Pointcut("execution(public * com.kalaiselvan.springbootsecurity.controller..*(..)) || execution(public * com.kalaiselvan.springbootsecurity.service.impl..*(..))")
//	public void serviceAndControllerPackagePointcut() {
//	};
	
	@Pointcut("execution(* com.kalaiselvan.springbootsecurity.service.impl..*(..))")
	public void serviceLayer() {}

//	@Before("execution(public * com.kalaiselvan.springbootsecurity.controller..*(..))")
	@Before("serviceLayer()")
	public void logControllerAccess(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
		logger.info("<--- Starting Service Name  : {} --->",
				joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "serviceLayer()", returning = "result")
	public void logServiceAccess(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
		logger.info("<--- {} Service Exits here --->", joinPoint.getSignature().getName());
	}
	
	 @AfterThrowing(pointcut = "serviceLayer()", throwing = "exception")
	    public void logServiceError(JoinPoint joinPoint, Throwable exception) {
		 Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringType());
	        logger.error("Error in: {} with message: {}", joinPoint.getSignature().getName(), exception.getMessage());
	    }

//	 @Around("serviceAndControllerPackagePointcut()")
//	    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
//	        long startTime = System.currentTimeMillis();
//
//	        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//	        String className = methodSignature.getDeclaringType().getSimpleName();
//	        String methodName = methodSignature.getName();
//	        Object[] methodArgs = joinPoint.getArgs();
//
//	        // Log method entry
//	        logger.info("Entering method: {}.{} with arguments: {}", className, methodName, Arrays.toString(methodArgs));
//
//	        Object result;
//	        try {
//	            result = joinPoint.proceed();  // Execute the method
//	        } catch (Exception ex) {
//	            logger.error("Exception in {}.{} with message: {}", className, methodName, ex.getMessage());
//	            throw ex;
//	        }
//
//	        long elapsedTime = System.currentTimeMillis() - startTime;
//
//	        // Log method exit
//	        logger.info("Exiting method: {}.{}......;",
//	                    className, methodName);
//
//	        return result;
//	    }

}
