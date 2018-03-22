package run;

import douBan.BookRunnable;

public class RunBook {

	 
	public static void main(String[] args) {
		
		Runnable bRunn=new BookRunnable();
		Thread r=new Thread(bRunn);
		r.start();
		
		
		
		
	}
	
}
