package com.return3.model;

public class UserModelCup {
	
	public UserModelCup() {
	}
	
	public int[] cupToMachine(int x, int y){
		int xy[]=new int[2];
		if(x>20&&x<100&&y>600&&y<700){//�ݶ�
			xy[0]=41;
			xy[1]=625;
			return xy;
		}else if(x>170&&x<250&&y>600&&y<700){//���̴�
			xy[0]=191;
			xy[1]=625;
			return xy;
		}else if(x>320&&x<400&&y>600&&y<700){//ȯŸ
			xy[0]=321;
			xy[1]=625;
			return xy;
		}else if(x>470&&x<550&&y>600&&y<700){//����ƾ��
			xy[0]=491;
			xy[1]=625;
			return xy;
		}else{//����
			xy[0]=0;
			xy[1]=0;
			return xy;
		}
		
	}//cupToMachine
	
}
