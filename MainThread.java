package application;

import java.util.Vector;
import javafx.scene.control.TextArea;

public class MainThread {
	private int NumberReal, NumberComplex;
	private Vector<CountingThread> Threads = new Vector<CountingThread>();
	
	public void FindRadical(TextArea field, int a, int b, int d)
	{
		NumberReal = a;
		NumberComplex = b;
		CountingThread temp = new CountingThread(String.valueOf(Threads.size()+1), field, NumberReal, NumberComplex, d);
		Threads.add(temp);
	}
}
