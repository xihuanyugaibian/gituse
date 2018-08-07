package cn.snake.feng;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Logger {
	private static FileWriter fileWriter;
	private static String loggerpath = ResourceBundle.getBundle("logger").getString("loggerpath");
	private static String loggername = ResourceBundle.getBundle("logger").getString("loggername");
	private static String time = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss").format(new Date());
	public static String loggeraddress = loggerpath + time + loggername;

	static {
		try {
//			System.out.println("静态块" + loggeraddress);
			File file = new File(loggeraddress);
			fileWriter = new FileWriter(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void debug(String args) {
		try {
			String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			fileWriter.write("debug:" + time + ":" + args);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//不同级别的错误
	public static void info(String args) {
		try {
			String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			fileWriter.write("info:" + time + ":" + args);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void error(String args) {
		try {
			String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			fileWriter.write("error:" + time + ":" + args);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void warn(String args) {
		try {
			String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			fileWriter.write("warn:" + time + ":" + args);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fatal(String args) {
		try {
			String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			fileWriter.write("fatal:" + time + ":" + args);
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
