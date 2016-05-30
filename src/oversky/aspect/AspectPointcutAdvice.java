package oversky.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectPointcutAdvice {

	@Before("execution(* *.main(..))")
	public void adviceexecutiion(){}
}
