package anynms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateTest {
	   private static String formatDate(String dateString) {
		      DateFormat srcDf = null;
		      
		     // DateTimeFormatter parserDtf = DateTimeFormatter.ofPattern("YYYYMMdd HH:mm:ss");
		      
		      srcDf = new SimpleDateFormat("yyyyMMddHHmmss");
		      Date date = null;
		      try {
		         date = srcDf.parse(dateString);
		 		System.out.println(date.getDay());
				System.out.println(date.getMonth());
				System.out.println(date.getYear());
		      } catch (ParseException e) {
		         //pluginLogger.error(new CustomEventPluginError("date_format_error", "Error while formatting date for app native flow..", FailureLeague.TXN, e));
		      }
		      DateFormat destDf = null;

		      
		      destDf = new SimpleDateFormat("dd.MM.yyyy");
		     
		 DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		 
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
		
		LocalDate localDate = LocalDate.parse(dateString, formatter);
		System.out.println(localDate.format(dateFormatter));

		System.out.println(date.toString());
		//LocalDate ld = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
		//System.out.println(ld.format(dateFormatter));
		      return destDf.format(date);
		   }
	   
	   public static void main(String[] args) {
		   System.out.println(new Date().getYear());
		System.out.println(formatDate("20200814011313"));
	}
}
