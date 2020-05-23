package application;

import javafx.scene.control.TextArea;

public class CountingThread extends Thread{
	private int ThreadNumberReal, ThreadNumberComplex, Degree;
	private TextArea field;
	
	CountingThread(String name, TextArea f, int a, int b, int d)
	{
		super(name);
		field = f;
		ThreadNumberReal = a;
		ThreadNumberComplex = b;
		Degree = d;
		field.setText(field.getText()+"Поток " + name + " создан для рассчета!\n");
		this.start();
	}
	public void run()
	{
		try {
			Thread.sleep(3000);	
		} catch (InterruptedException e) {
		}
		Calculate();
		
		try {
			Thread.sleep(3000);	
		} catch (InterruptedException e) {
		}
		field.setText(field.getText()+"Поток "+this.getName()+" завершил работу!\n");
	}
	public void Calculate()
	{
		double mod, cos, sin, arg;
		mod = Math.sqrt(ThreadNumberReal*ThreadNumberReal + ThreadNumberComplex*ThreadNumberComplex);
		mod = Math.pow(mod, 1.0/Degree);
		for(int i = 0; i < Degree ; i++)
		{
			arg = Math.atan(1.0*ThreadNumberComplex/ThreadNumberReal);
			arg = (arg + (2*Math.PI*i))/Degree;
			cos = Math.cos(arg);
			sin = Math.sin(arg);
			cos *= mod;
			sin *= mod;
			if(sin<0)
				field.setText(field.getText()+"Поток " + this.getName() +": Результат = "+ cos + sin +"i\n");
			else
				field.setText(field.getText()+"Поток " + this.getName() +": Результат = "+ cos +"+"+sin +"i\n");
		}
	}

}
