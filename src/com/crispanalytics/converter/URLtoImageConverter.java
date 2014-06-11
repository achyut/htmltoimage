package com.crispanalytics.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class URLtoImageConverter {
	public static void main(String[] args) {
		createImageFromURL("http://google.com",900,"google.png");
	}
	
	public static String createImageFromURL(String url,Integer delay, String outputFileName){
		executeCommand("/home/achyut/workspace1/test/wkhtmltoimage --javascript-delay "+delay+" "+url+" "+outputFileName);
		return outputFileName;
	}
	public static String executeCommand(String command){
		Runtime rt = Runtime.getRuntime();
		try {
			StringBuffer output = new StringBuffer();
			Process p = rt.exec(command);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));
 
                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}
			return output.toString();
			//System.out.println(output);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
	}
}
