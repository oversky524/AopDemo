package oversky.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectAdviceJoinPointInfo {

	@Before("call(* oversky.JoinPointDemo.show(..))")
	public void showMethodCallJpInfo(JoinPoint jp){
		System.out.println(JoinPoint.METHOD_CALL + ", this=" + jp.getThis() +
				", target=" + jp.getTarget());
	}
	
	@Before("call(oversky.JoinPointDemo.new(..))")
	public void showConstructorCallJpInfo(JoinPoint jp){
		System.out.println(JoinPoint.CONSTRUCTOR_CALL + ", this=" + jp.getThis() +
				", target=" + jp.getTarget());
	}
	
	@Before("execution(* oversky.JoinPointDemo.show(..))")
	public void showMethodExecutionJpInfo(JoinPoint jp){
		System.out.println(JoinPoint.METHOD_EXECUTION + ", this=" + jp.getThis() +
				", target=" + jp.getTarget());
	}
	
	@Before("execution(oversky.JoinPointDemo.new(..))")
	public void showConstructorExecutionJpInfo(JoinPoint jp){
		System.out.println(JoinPoint.CONSTRUCTOR_EXECUTION + ", this=" + jp.getThis() +
				", target=" + jp.getTarget());
	}
	
	@Before("set(* oversky.JoinPointDemo.*)")
	public void showFieldSetJpInfo(JoinPoint jp){
		System.out.println(JoinPoint.FIELD_SET + ", this=" + jp.getThis() +
				", target=" + jp.getTarget() + ", args=" + toString(jp.getArgs()));
	}
	
	@Before("get(* oversky.JoinPointDemo.*)")
	public void showFiledGetJpInfo(JoinPoint jp){
		System.out.println(JoinPoint.FIELD_GET + ", this=" + jp.getThis() +
				", target=" + jp.getTarget() + ", args=" + toString(jp.getArgs()));
	}
	
	private static String toString(Object[] args){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<args.length - 1; ++i){
			sb.append(args[i].toString()).append(",");
		}
		sb.append(args[args.length - 1]);
		return sb.toString();
	}
}
