package oversky.aspect;

import java.lang.annotation.Retention;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import oversky.AspectDemo;
import oversky.AspectDemoBase;
import oversky.MyAnotation;

//@withincode没有示例
@Aspect
public class AspectPointcutNonkind {
	@Pointcut("!within(oversky.JoinPointDemo) && !within(oversky.aspect.*) && !within(oversky.Base)"
			+ " && !within(oversky.AspectTest) && !@within(org.aspectj.lang.annotation.Aspect)")
	public void exclude(){}

	@Before("within(oversky.AspectDemo) &&  exclude()")
	public void showWithin(JoinPoint jp){
		System.out.println("within" + "\t" + jp.toShortString());
	}

	@Before("withincode(* oversky.AspectDemo.*(..)) &&  exclude()")
	public void showWithincode(JoinPoint jp){
		System.out.println("withincode" + "\t" + jp.toShortString());
	}
	
	@Before("execution(* !@Aspect *.*(..)) && this(oversky.AspectDemo) &&  exclude()")
	public void showThis(JoinPoint jp){
		System.out.println("this" + "\t" + jp.toShortString());
	}
	
	@Before(value="execution(* !@Aspect *.*(..)) && this(ad)", argNames="ad")
	public void showThisObjectIdentifier(JoinPoint jp, AspectDemoBase ad){
		System.out.println("this identified by oi" + "\t" + jp.toShortString() + ", this=" + ad);
	}
	
	@Before("execution(* !@Aspect *.*(..)) && target(oversky.AspectDemo) &&  exclude()")
	public void showTarget(JoinPoint jp){
		System.out.println("target" + "\t" + jp.toShortString());
	}
	
	@Before(value="execution(* !@Aspect *.*(..)) && target(ad)", argNames="ad")
	public void showTargetObjectIdentifier(JoinPoint jp, AspectDemoBase ad){
		System.out.println("target identified by oi" + "\t" + jp.toShortString() + ", target=" + ad);
	}
	
	@Before("execution(* !@Aspect *.*(..)) && args(String) && exclude() &&  exclude()")
	public void showArgs(JoinPoint jp){
		System.out.println("args" + "\t" + jp.toShortString());
	}
	
	@Before(value="execution(* !@Aspect *.*(..)) && args(str) && exclude()", argNames="str")
	public void showArgsObjectIdentifier(JoinPoint jp, String str){
		System.out.println("args identified by oi" + "\t" + jp.toShortString() + ", args=" + str);
	}
	
	@Before(value="execution(* !@Aspect *.*(..)) && args(*, str) && exclude()", argNames="str")
	public void showArgsObjectIdentifier(JoinPoint jp, Integer str){
		System.out.println("args identified by oi" + "\t" + jp.toShortString() + ", args=" + str);
	}
	
	@Before("cflow(execution(* oversky.AspectDemo.methodExecution(..))) && !cflow(adviceexecution()) &&  exclude()")
	public void showCflow(JoinPoint jp){
		System.out.println("cflow" + "\t" + jp.toShortString());
	}
	
	@Before("cflowbelow(execution(* oversky.AspectDemo.methodExecution(..))) && !cflow(adviceexecution()) &&  exclude()")
	public void showCflowbelow(JoinPoint jp){
		System.out.println("cflowbelow" + "\t" + jp.toShortString());
	}
	
	@Before("execution(*.new(..)) && @this(Aspect) && !this(oversky.AspectTypes) &&  exclude()")
	public void showThisAnotation(JoinPoint jp){
		System.out.println("anotation this" + "\t" + jp.toLongString());
	}
	
	@Before(value="execution(* *.*(..)) && @target(ad)", argNames="ad")
	public void showTargetAnotation(JoinPoint jp, MyAnotation ad){
		System.out.println("anotation target" + "\t" + jp.toLongString() + ", anotation=" + ad);
	}
	
	@Before(value="execution(* *.*(..)) && @args(*, re)", argNames="re")
	public void showArgsAnotation(JoinPoint jp, Retention re){
		System.out.println("anotation args" + "\t" + jp.toLongString());
	}
	
	@Before(value="execution(* *.*(..)) && @within(re)", argNames="re")
	public void showWithinAnotation(JoinPoint jp, MyAnotation re){
		System.out.println("anotation within" + "\t" + jp.toLongString());
	}
	
	//对于注解形式的if只能使用如下形式
	@Pointcut("if() &&  exclude()")
	public static boolean debugTrue(){
		return true;
	}
	
	@Before(value="execution(* *.method*(..)) && debugTrue() && exclude() &&  exclude()")
	public void showIf(JoinPoint jp){
		System.out.println("anotation if true" + "\t" + jp.toLongString());
	}
}
