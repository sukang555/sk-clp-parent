package com.skse.se.design.behavioral.strategy;

/**
 * 
 * 策略设计模式
 * 
 * 
 *            Strategy                   Context
 *          /    |     \        
 *         /     |      \
 * StrategyA  StrategyB  StrategyC
 * 
 * 
 *
 */

public class StrategyTest {
	
	public static void main(String[] args) {
		
		Context.getInstance(new StrategyA()).method();
		Context.getInstance(new StrategyB()).method();
		Context.getInstance(new StrategyC()).method();
		
	}

}


class Context{
	public Strategy strategy;
	
	private Context(Strategy strategy){
		this.strategy = strategy;
	}
	
	public static Context getInstance(Strategy strategy){
		
		return new Context(strategy);
	}
	
	
	public void method(){
		strategy.method();
	}
	
}


abstract class Strategy{
	 
	 public abstract void method();
	
}

class StrategyA extends Strategy {

	@Override
	public void method() {
		System.out.println("A方法执行");
	}
	
}

class StrategyB extends Strategy {
	
	@Override
	public void method() {
		System.out.println("B方法执行");
	}
	
}

class StrategyC extends Strategy {
	
	@Override
	public void method() {
		System.out.println("C方法执行");
	}
	
}




