package examples.weeknine;

public class ChopStick {
	private final int which;
	private Philosopher holder;
	
	public ChopStick(int which){
		this.which = which;
	}
	public int getWhich() {
		return which;
	}
	
	public synchronized void setPhilosopher(Philosopher p){
		while(this.holder != null){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.holder = p;
	}
	
	public synchronized void clearPhilosopher(){
		this.holder = null;
		notify();
	}
	
	public String toString(){
		return String.format("ChopStick number %d",which);
	}
	
}
