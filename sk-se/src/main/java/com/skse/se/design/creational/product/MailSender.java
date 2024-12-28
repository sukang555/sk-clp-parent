package com.skse.se.design.creational.product;




/**
 * http://blog.csdn.net/weiwenlongll/article/details/6918164
 * https://my.oschina.net/u/3455207/blog/1588099
 * @author Administrator
 *
 */
public class MailSender implements Sender{
	
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Sender sender = SenderProduce.produceMailSender();
			System.out.println(sender + ":");
			sender.send();
		}
	}

	@Override
	public void send() {
		
		
		System.out.println("发送邮件");
		
	}

}


class SmsSender implements Sender{
	

	@Override
	public void send() {
		
		System.out.println("发送短信");
		
	}
	
}


class SenderProduce {
	
	
	
	public static Sender produceMailSender(){
		return new MailSender();

	}
	
	public static Sender produceSmsSender(){
	
		return new SmsSender();
	
	}
}









