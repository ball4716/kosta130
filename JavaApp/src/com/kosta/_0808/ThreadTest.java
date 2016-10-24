package com.kosta._0808;

class MyThread1 extends Thread{
	//������ Ư�� �޼ҵ带 �������̵�
	@Override
	public void run(){
		try {
			for (int i = 1; i < 11; i++) {
				Thread.sleep(500);
				//System.out.println("�ڹٽ�����[1]: "+i);
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
				//System.out.println("�ڹٽ�����[2]: "+i);
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
		//�ڹٽ����� ��ü ����
		MyThread1 t1 = new MyThread1(); //Thread ��ü
		//t1.start();
		//t1.run(); //run���� ����� Thread���� x
		t1.setName("�浿������");
		
		//Thread(Runnable target)
		//: run�޼ҵ尡 ������ ��ġ�� �����ؼ� ������ ��ü ����
		MyThread2 runnableTarget = new MyThread2(); //Runnable ��ü runnableTarget
		//Thread t2 = new Thread(runnableTarget);
		//Thread(Runnable target, String name)
		Thread t2 = new Thread(runnableTarget,"���ӽ�����");
		//����) new Thread(new MyThread2()).start();
		//t2.start();
		//runnableTarget.run(); //run���� ����� Thread���� x
		
		MyThread1 t3 = new MyThread1();
		t3.setName("�ֿ�������");
		
		//�����忡 �켱����(1~10)�� �ο�    1:�켱���� ����    10:�켱���� ����
		//MAX_PRIORITY : 10, MIN_PRIORITY : 1, NORM_PRIORITY : 5
		t1.setPriority(Thread.MAX_PRIORITY); //10
		t2.setPriority(8);
		t3.setPriority(Thread.MIN_PRIORITY);//1
		
		t1.start();
		t2.start();
		t3.start();
	}
}
