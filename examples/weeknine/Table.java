package examples.weeknine;

public class Table {
//	private final ChopStick left;
//	private final ChopStick right;
//	private final int which;
	private final Philosopher[] lock;
	
	public Table(int count){
//		for (int i =0;i<count;i++){
//			
//		}
		lock = new Philosopher[count];
	}
	
//	public Table( int which, ChopStick left, ChopStick right){
//		this.left = left;
//		this.right = right;
//		this.which = which;
//	}
	
	public synchronized ChopStick pickUpChopStick(Philosopher p, int whichChopStick){
		while(lock[whichChopStick] != null){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		lock[whichChopStick] = p;
		return new ChopStick(whichChopStick);
	}
	
	public synchronized void returnChopStick(Philosopher p, int WhichChopStick){
		lock[WhichChopStick] = null;
		notify();
	}
	
	public boolean  takeBite(Philosopher philosopher, ChopStick first,
			ChopStick second) {
		// TODO Auto-generated method stub
		if(lock[first.getWhich()]==philosopher
				&& lock[second.getWhich()] == philosopher){
			return true;
		}
		System.out.println("CORRUPTION");
		return false;
	}
	
	
	
	public void getChopSticks(Philosopher p){
		
	}
//
//	public ChopStick getLeft() {
//		return left;
//	}
//
//	public ChopStick getRight() {
//		return right;
//	}
//
//	public int getWhich() {
//		return which;
//	}

	
}
