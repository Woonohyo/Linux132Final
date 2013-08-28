import java.awt.Point;
import java.util.Random;

public class Exam3 implements Runnable {
	static final double PI = 3.14159265359;
	final static int NT = 10;
	final static int MAX_DOT = 10000000;
	static int TotalDot = 0;
	static int DotLessThanOne = 0;
	static int id = 0;
	static double result;
	Point dot = new Point();
	Random rand = new Random();

	@Override
	public void run() {
		int i;
		int localTotal = 0;
		int localLessOne = 0;
		int start;
		int end;
		synchronized (this) {
				start = (MAX_DOT / NT) * id + 1;
				end = (MAX_DOT / NT) * (id + 1);
				id++;
		}

		for ( i = start; i <= end; i++ ) { 
			if (dot.distance(rand.nextDouble(), rand.nextDouble()) <= 1) {
				localTotal++;
				localLessOne++;
			} else
				localTotal++;
		}

		synchronized(this) {
			TotalDot += localTotal;
			DotLessThanOne += localLessOne;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Exam3 exam = new Exam3();
		Thread[] at = new Thread[NT];
		
		for (int i = 0; i < NT; i++) {
			at[i] = new Thread(exam);
			at[i].start();
		}
		
		for (Thread thread : at)
			thread.join();

		result = (double) DotLessThanOne / (double) TotalDot;
		System.out.printf("계산되어 나온 값은 %f입니다.\n", result);
		System.out.printf("실제 PI/4의 값은 %f입니다.\n", PI / 4);
		System.out.println("우왕 되게 비슷하당");
	}
}
