package project;

import java.util.Date;
import java.text.SimpleDateFormat;

public class util {

	public static String getNowDate() {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date time = new Date();

		return format.format(time);
	}

}
