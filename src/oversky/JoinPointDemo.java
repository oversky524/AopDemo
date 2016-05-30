package oversky;

@MyAnotation
public class JoinPointDemo extends Base{
	public int a;
	
	@MyAnotation
	public void show(String str){}
	
	public void show(String str, MyAnotation i){}
	
	public JoinPointDemo(int b){
		super(b+10);
	}

}

class Base{
	protected Base(int c){}
}
