package oversky.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import oversky.MyAnotation;

@Aspect
public class AspectCollectingContext {
	
	@Around(value="execution(* *.show(..)) && args(p1,p2)", argNames="p1, p2")
	public void collectingContext(ProceedingJoinPoint pjp, String p1, MyAnotation p2){
		System.out.println("CollectingContext: " + p1 + ", " + p2);
		
	}
}
