package com.kosta._0808;

class MyThread1 extends Thread{
	//스레드 특성 메소드를 오버라이딩
	@Override
	public void run(){
		try {
			for (int i = 1; i < 11; i++) {
				Thread.sleep(500);
				//System.out.println("자바스레드[1]: "+i);
				System.out.println(getName()+":"+i);
			}
		}catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
}

class MyThread2 implements Runnable{

	@Override
	public void run() {
		try {
			for (int i = 1; i < 11; i++) {
				Thread.sleep(500);
				//System.out.println("자바스레드[2]: "+i);
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+":"+i);
			}
		}catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
	
}

public class ThreadTest {
	public static void main(String[] args) {
		//자바스레드 객체 생성
		MyThread1 t1 = new MyThread1(); //Thread 객체
		//t1.start();
		//t1.run(); //run으로 실행시 Thread동작 x
		t1.setName("길동스레드");
		
		//Thread(Runnable target)
		//: run메소드가 구현된 위치를 지정해서 스레드 객체 생성
		MyThread2 runnableTarget = new MyThread2(); //Runnable 객체 runnableTarget
		//Thread t2 = new Thread(runnableTarget);
		//Thread(Runnable target, String name)
		Thread t2 = new Thread(runnableTarget,"라임스레드");
		//참고) new Thread(new MyThread2()).start();
		//t2.start();
		//runnableTarget.run(); //run으로 실행시 Thread동작 x
		
		MyThread1 t3 = new MyThread1();
		t3.setName("주원스레드");
		
		//스레드에 우선순위(1~10)를 부여    1:우선순위 낮음    10:우선순위 높음
		//MAX_PRIORITY : 10, MIN_PRIORITY : 1, NORM_PRIORITY : 5
		t1.setPriority(Thread.MAX_PRIORITY); //10
		t2.setPriority(8);
		t3.setPriority(Thread.MIN_PRIORITY);//1
		
		t1.start();
		t2.start();
		t3.start();
	}
}
