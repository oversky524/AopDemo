package oversky.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareError;
import org.aspectj.lang.annotation.DeclareWarning;

@Aspect
public class AspectSundry {

	@DeclareWarning("execution(* *.get*(..))")
	public static final String declareWarning = "declareWarning"; 
	
//	@DeclareError("execution(* *.show(..))")
	public static final String declareError = "declareError"; 
}
