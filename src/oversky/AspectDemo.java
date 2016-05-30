package oversky;

@MyAnotation
public class AspectDemo extends AspectDemoBase{
	public int a;
	
	

	/*public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}*/

	public void methodExecution(){
		new AspectDemo();
	}

	public void methodCall(){}
}
