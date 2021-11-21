package com.iei.greenlight.event.controller;

public class Practice {

	public static void main(String[] args) {
		
		
		int eList = 138;
		
		
		int count = (eList > 10) ? (int)((int)Math.round(eList/10.0) * 10 * 0.1) : 1; // 맞힌 사람 중 10% 인원수
		

		int[] a = new int[count];

		for (int i = 0; i < count; i++) {
			a[i] = (int) Math.random() * eList + 1; // 중복이 되면 안됨
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
					break;
				}
			}
		}
		
		System.out.println(a.length);
		
		for(int c : a) {
			System.out.println(c);
		}
		
//		 int b[] = new int[3];
//         for(int i=0; i<3; i++) {
//            b[i]=(int)(Math.random()*10 + 1);
//            for(int j=0; j<i;j++) {
//                if(b[i]==b[j]) {i--; break;}
//            }    
//         }
//         
//         for(int c : b) {
//        	 System.out.println(c);
//         }

	}
}
