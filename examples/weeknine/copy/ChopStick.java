package examples.weeknine.copy;

public class ChopStick {
	private final int which;
	public ChopStick(int which){
		this.which = which;
	}
	public int getWhich() {
		return which;
	}
	
	public String toString(){
		return String.format("ChopStick number %d",which);
	}
	
}
