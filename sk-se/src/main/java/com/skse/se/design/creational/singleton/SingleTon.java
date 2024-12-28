package com.skse.se.design.creational.singleton;


public class SingleTon {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Single.getInstance());
				}
			}).start();
		}
		
	}

}


class Single{
	
	//private volatile static Single single = null;
	
    private Single(){}
    
    public static Single getInstance(){
    	return SingleProxy.SINGLE;
    }
	
	
	private static class SingleProxy{
		private static final Single SINGLE = new Single();
	}
	
/*	public static Single getSingle(){
		
		if (single == null) {
			synchronized (Single.class) {
				if (single == null) {
					single = new Single();
					
				}
			}
		}
		
		return single;
	}
	*/
/*	public static Single getSingle(){
		
		synchronized (Single.class) {
			if (single == null) {
				single = new Single();
			}
		}
		
		return single;
	}*/
	
	/*public synchronized static Single getSingle(){
		if (single == null) {
			single =  new Single();
		}
		return single;
	}*/
	
}
