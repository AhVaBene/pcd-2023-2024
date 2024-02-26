package pcd.lab01.ex01;

import java.util.Arrays;

public class MyThread extends Thread {

	long[] v;
	int start;
	int stop;

	public MyThread(long[] v, int start, int stop){
		this.v = v;
		this.start = start;
		this.stop = stop;
	}
	
	public void run(){
		Arrays.sort(v, start, stop);
	}
}
