package oversky.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectPointcutKind {
	public int a;

	@Pointcut("!within(oversky.JoinPointDemo) && !within(oversky.aspect.*) && !within(oversky.Base)"
			+ " && !within(oversky.AspectTest) && !@within(org.aspectj.lang.annotation.Aspect)")
	public void exclude(){}
	
	@Pointcut("execution(* !@Aspect *.*(..)) && !execution(* *.methodCall(..)) && exclude()")
	public void methodExecution(){}
	
	@Before("methodExecution() && !execution(* java.lang.StringBuilder.*(..))")
	public void showMethodExecution(JoinPoint jp){
		a = 2;
		int b = a;
		System.out.println(JoinPoint.METHOD_EXECUTION + "\t" + jp.toShortString());
	}
	
	@Before("call(* !@Aspect *.methodCall(..)) && !call(* java.lang.StringBuilder.*(..)) && exclude()")
	public void showMethodCall(JoinPoint jp){
		System.out.println(JoinPoint.METHOD_CALL + "\t" + jp.toShortString());
	}
	
	@Pointcut("!execution(AspectPointcutKind.new(..))")
	public void containsNoSelf(){}
	
	@Before("execution(*.new(..)) && containsNoSelf() && !execution(java.lang.StringBuilder.new(..)) && exclude()")
	public void showConstructorExecution(JoinPoint jp){
		System.out.println(JoinPoint.CONSTRUCTOR_EXECUTION + "\t" + jp.toShortString());
	}

	@Before("call(*.new(..)) && !call(AspectPointcutKind.new(..)) && !call(java.lang.StringBuilder.new(..))"
			+ " && exclude()")
	public void showConstructorCall(JoinPoint jp){
		System.out.println(JoinPoint.CONSTRUCTOR_CALL + "\t" + jp.toShortString());
	}

	@Before("initialization(*.new(..)) && !initialization(AspectPointcutKind.new(..))"
			+ " && exclude()")
	public void showObjectInitialization(JoinPoint jp){
		System.out.println(JoinPoint.INITIALIZATION + "\t" + jp.toShortString());
	}

	@Before("preinitialization(*.new(..)) && !preinitialization(AspectPointcutKind.new(..))"
			+ " && exclude()")
	public void showObjectPreinitialization(JoinPoint jp){
		System.out.println(JoinPoint.PREINITIALIZATION + "\t" + jp.toShortString());
	}

	@Before("staticinitialization(!@Aspect *) && exclude()")
	public void showClassInitialization(JoinPoint jp){
		System.out.println(JoinPoint.STATICINITIALIZATION + "\t" + jp.toShortString());
	}

	@Before("set(* !@Aspect *.*) && exclude()")
	public void showFieldSetter(JoinPoint jp){
		System.out.println(JoinPoint.FIELD_SET + "\t" + jp.toShortString());
	}

	@Before("get(* oversky.AspectDemo.*) && exclude()")
	public void showFieldGetter(JoinPoint jp){
		System.out.println(JoinPoint.FIELD_GET + "\t" + jp.toShortString());
	}

	@Before("handler(*)")
	public void showExceptionHandler(JoinPoint jp){
		System.out.println(JoinPoint.EXCEPTION_HANDLER + "\t" + jp.toShortString());
	}

	@Before("adviceexecution() && within(AspectPointcutAdvice)")
	public void showAdviceExecution(JoinPoint jp){
		System.out.println(JoinPoint.ADVICE_EXECUTION + "\t" + jp.toShortString());
	}

}
