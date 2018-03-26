package com.javapoint;

/**************************
 * 
 *         PATTERN: CREATIONAL
 *
 *
 *           --------------------------------
 *           |                              |
 *           |        FileLogger            |----------
 *           |                              |         |
 *           --------------------------------         |     instances 
 *                                  |                 |      0...1
 *                                  |                 |  
 *                                  |------------------
 */

class FileLogger {
	
	private static FileLogger filelogger;
	
	private FileLogger() {
		System.out.println("Private constructor to disallow no one to call it");
	}
	
	public static FileLogger getLogger() {
			
		if (filelogger == null) {
			System.out.println("initialized only once");
	
			//this will call the private constructor
			filelogger = new FileLogger();
		}
		return filelogger;
	}

	public synchronized void log(String msg) {
		System.out.println("printing log message:" + msg);
	}
}

public class SingleTonCreationalPattern {

	public static void main(String args[]) {

		FileLogger fl = FileLogger.getLogger();
		fl.log("hashcode:" + fl.hashCode() + " logging gopal");

		FileLogger fl1 = FileLogger.getLogger();
		fl1.log("hashcode:" + fl1.hashCode() + " logging gopal tech");

	}
}


/**************** OUTPUT *******************

initialized only once
Private constructor to disallow no one to call it
printing log message:hashcode:118352462 logging gopal
printing log message:hashcode:118352462 logging gopal tech

*********************************************/