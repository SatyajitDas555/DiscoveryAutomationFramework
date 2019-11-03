package com.discovery.go.logs;

public class Log {
	public static boolean isPrint = true;
	
	public static void printDebug(String message) {
		if(isPrint) {
			System.out.println(message);
		}
	}
}
