package com.test.di01;

import com.test.di02.Hong;

public class Main {

	public static void main(String[] args) {
		
		
		Hong hong = new Hong();
		hong.run();
		
		//DI
		Brush b = new Brush();
		//Lee lee = new Lee(b); //의존 주입
		Lee lee = new Lee();
		lee.setB(b);
		lee.run();
		
	}
}
	