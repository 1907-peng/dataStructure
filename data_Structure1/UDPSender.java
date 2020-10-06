package data_Structure1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.math.*;
public class UDPSender {

	public static void main(String[] args) {
		int reversedNum=0;
		int theNumberOfX=0;
		int temp;
		int x = 1230;
		int y = x;
		/*int i=189;
		System.out.println(i/10000);
		System.out.println(i%10);*/
		
		do{
            x=x/10;
            theNumberOfX++;
        }while(x!=0);
		
		temp = theNumberOfX;
		
		for(int i=0;i<theNumberOfX;i++){
            reversedNum+=(y/10)*(int)(Math.pow(10,temp));
            y=y/10;
            temp--;
    }
		System.out.println(reversedNum);
	}

}
