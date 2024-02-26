package pcd.lab01.ex01;

import java.util.*;

public class ConcurrentSort {

	static final int VECTOR_SIZE = 200000000;
	static final int THREAD_NUMBER = 5;
	
	public static void main(String[] args) {
	
		log("Generating array...");
		long[] v = genArray(VECTOR_SIZE);
		
		log("Array generated.");
		log("Sorting (" + VECTOR_SIZE + " elements)...");
		MyThread[] threads = new MyThread[THREAD_NUMBER];
		int index = 0;
		long step = VECTOR_SIZE / THREAD_NUMBER;
		for(int i = 0; i < THREAD_NUMBER; i++) {
			threads[i] = new MyThread(v, index, (int) (index + step));
			index += (int) step;
		}
		long t0 = System.nanoTime();
		for (MyThread thread : threads) {
			thread.start();
		}
		try {
			for (MyThread thread : threads) {
				thread.join();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		Arrays.sort(v, 0, v.length);
		long t1 = System.nanoTime();
		log("Done. Time elapsed: " + ((t1 - t0) / 1000000) + " ms");
		
		// dumpArray(v);
	}


	private static long[] genArray(int n) {
		Random gen = new Random(System.currentTimeMillis());
		long v[] = new long[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = gen.nextLong();
		}
		return v;
	}

	private static void dumpArray(long[] v) {
		for (long l:  v) {
			System.out.print(l + " ");
		}
	}

	private static void log(String msg) {
		System.out.println(msg);
	}
}
