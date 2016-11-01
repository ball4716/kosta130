package com.kosta._1031.di;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputer implements Outputer {

	@Override
	public void helloPrint(String str) {
		try {
			FileWriter fw = new FileWriter("hello.txt");
			fw.write(str);
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//helloPrint

}
