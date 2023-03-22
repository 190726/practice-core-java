package com.sk.io.datastream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamToFile {
	
	static final String dataFile = "data.txt";
	static final int[] units = {1, 2, 3, 4, 5};
	static final double[] prices = {1.1, 2.2, 3.3, 4.4, 5.0};
	static final String[] desc = {
			"leesang",
			"ITs",
			"DF FIS",
			"sss",
			"absoulte"
	};
	
	public static void main(String[] args) throws IOException {
		
		DataOutputStream out = new DataOutputStream( 
									new BufferedOutputStream(
											new FileOutputStream(dataFile)
							   ));
		for(int i = 0; i < units.length; i++) {
			out.writeDouble(prices[i]);
			out.writeInt(units[i]);
			out.writeUTF(desc[i]);
		}
		out.close();
		
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
		try {
			while(true) {
				double price = in.readDouble();
				int unit = in.readInt();
				String desc = in.readUTF();
				System.out.println(price + ":" + unit + ":" + desc);
			}
		}catch(EOFException e) {e.printStackTrace();}
		in.close();
	}
}