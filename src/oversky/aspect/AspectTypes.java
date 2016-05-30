package oversky.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import oversky.MyAnotation;

@Aspect
public class AspectTypes {
	@Pointcut("!within(oversky.AspectTest)")
	public void exclude(){}

	@Before(value="execution(* *.*(..)) && args(*, second)", argNames="second")
	public void before(MyAnotation second){
		System.out.println("@Before advice, 2nd parameter is:" + second);
	}
	
	@After("execution(* *.show(..))")
	public void after(JoinPoint pjp){
		System.out.println("@After advice: " + "\t" + pjp.toShortString());
	}
	
	@AfterReturning(value="execution(* *.get(..))", returning="result", argNames="result")
	public void afterReturning(JoinPoint pjp, Object result){
		System.out.println("@AfterReturning advice: " + "\t" + pjp.toShortString() +
				", result=" + result);
	}
	
	@AfterThrowing(value="execution(* *.afterThrowing(..))", throwing="e", argNames="e")
	public void afterThrowing(JoinPoint pjp, Throwable e){
		System.out.println("@AfterThrowing advice: " + "\t" + pjp.toShortString() + 
				", throwable=" + e);
	}
	
	@Around(value="execution(* *.geti(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("@Around advice: before" + pjp);
		Object rst = pjp.proceed(pjp.getArgs());
		System.out.println("@Around advice: after" + pjp);
		return rst;
	}
}
