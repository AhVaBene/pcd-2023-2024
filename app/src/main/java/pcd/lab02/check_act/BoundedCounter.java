package pcd.lab02.check_act;

public class BoundedCounter {

	private int cont;
	private int min, max;
	
	public BoundedCounter(int min, int max){
		this.cont = this.min = min;
		this.max = max;
	}
	
	synchronized public void inc() throws OverflowException {
		if (cont + 1 > max){
			throw new OverflowException();
		}
		cont++;
	}

	synchronized public void dec() throws UnderflowException {
		if (cont - 1 < min){
			throw new UnderflowException();
		}
		cont--;
	}
	
	synchronized public int getValue(){
		return cont;
	}
}
