package javaBasics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentDate {
	public static void main(String[] args) {
		
		Date dateObj= new Date();
		//System.out.println(dateObj.toString());
		
		
		SimpleDateFormat sim =new SimpleDateFormat("yyyy-MM-dd");
        String actDate= sim.format(dateObj);
        System.out.println(actDate);
        
                        //using Calender we can access complete calender
    Calendar cal= sim.getCalendar();
    cal.add(Calendar.DAY_OF_MONTH, -30);
    String dataRequires= sim.format(cal.getTime());
        System.out.println(dataRequires);
	}

}
