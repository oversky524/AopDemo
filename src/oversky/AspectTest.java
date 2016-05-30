/**
 * 
 */
package oversky;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Aspect;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import oversky.aspect.AspectPointcutKind;

/**
 * @author gaochao
 *
 */
@Aspect
public class AspectTest {

	@Test
	public void testJoinPointHandler() {
		try{
			throw new RuntimeException("");
		}catch(Exception e){
//			e.printStackTrace();
		}
	}
	
	@Test
	public void testPointcutThis() {
		JoinPointDemo jpd = new JoinPointDemo(1);
		jpd.show("abc", JoinPointDemo.class.getAnnotation(MyAnotation.class));
		jpd.show("abc");

		AspectDemo ad = new AspectDemo();
		ad.methodExecution();
	}
	
	@Test
	public void testAspectTypes() {
		AspectTestDemo atd = new AspectTestDemo();
		atd.show("abc", JoinPointDemo.class.getAnnotation(MyAnotation.class));
		atd.get(2);
		atd.geti(3);
		atd.afterThrowing();
	}
	
	@Test
	public void testAspectCollectingContext() {
		AspectTestDemo atd = new AspectTestDemo();
		atd.show("abc", JoinPointDemo.class.getAnnotation(MyAnotation.class));
	}
	
	@Test
	public void testJoinPointInfomation() {
		JoinPointDemo jpd = new JoinPointDemo(1);
		jpd.show("abc");
		jpd.a = 1;
		System.out.println(jpd.a);
	}
	
	@Test
	public void testJoinPointKind() {
		AspectDemo ad = new AspectDemo();
		ad.methodExecution();
		ad.methodCall();
		ad.a = 1;
		System.out.println(ad.a);
		
		AspectPointcutKind ak = new AspectPointcutKind();
		ak.a = 1;
		System.out.println(ak.a);
	}

}
