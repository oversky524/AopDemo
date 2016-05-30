package oversky;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectTestDemo {
	
	public void show(String str, MyAnotation i){}
	
	public int get(int a){ return a; }
	
	public int geti(int a){ return a; }
	
	public void afterThrowing() throws NullPointerException{
		throw new NullPointerException();
	}

}
