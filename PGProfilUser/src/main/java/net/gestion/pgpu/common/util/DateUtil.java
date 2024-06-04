package net.gestion.pgpu.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_FRENCH_PATTERN = "dd/MM/YYYY HH:mm";
	public static final String DATE_FRENCH_PATTERN = "dd/MM/YYYY";
	public static final String DATE_TIME_LOCAL_PATTERN = "dd MMMM YYYY à HH:mm:ss ";
	public static final String DATE_LOCAL_PATTERN = "dd MMMM YYYY";

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
	private static final DateTimeFormatter DATE_TIME_FRENCH_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FRENCH_PATTERN);
	private static final DateTimeFormatter DATE_FRENCH_FORMATTER = DateTimeFormatter.ofPattern(DATE_FRENCH_PATTERN);
	private static final DateTimeFormatter DATE_LOCAL_FRENCH_FORMATTER = DateTimeFormatter.ofPattern(DATE_FRENCH_PATTERN);


	public static String format(LocalDate date) { 
		if(date == null)
			return null;
		return DATE_FORMATTER.format(date);
	}
	public static String formatFrench(LocalDate date) {
		if(date == null)
			return null;
		return DATE_FRENCH_FORMATTER.format(date);
	}
	public static String formatLocalFrench(LocalDate date) {
		if(date == null)
			return null;
		return DATE_LOCAL_FRENCH_FORMATTER.format(date);
	}
	public static String format(Date date) {
		if(date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FRENCH_PATTERN);
    
		return sdf.format(date);
	}
	public static String format(Date date,String format) {
		if(date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
    
		return sdf.format(date);
	}
	public static String format(LocalDate date,String format) {
		if(date == null) return null;
		return date.format(DateTimeFormatter.ofPattern(format));
	}
	
	public static String format(String date,String format) {
		if(date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
    
		return sdf.format(Date.from(java.sql.Timestamp.valueOf(date).toInstant()));
	}
	public static String format(LocalDateTime date) {
		if(date == null)
			return null;
		return DATE_TIME_FORMATTER.format(date);
	}
	
	public static String now() {
		return LocalDateTime.now().format(DATE_TIME_FORMATTER);
	}

	public static LocalDate parse(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (Exception e) {
			System.out.println("format error");
			return null;
		}
	}
	public static LocalDate parse2(String dateString) {
		try {
			return DATE_FRENCH_FORMATTER.parse(dateString, LocalDate::from);
		} catch (Exception e) {
			System.out.println("format error");
			return null;
		}
	}
	public static LocalDate parseToFrenchDate2(String dateString) {
		try {
			return DATE_TIME_FORMATTER.parse(dateString, LocalDateTime::from).toLocalDate();
		} catch (Exception e) {
			System.out.println("format error");
			return null;
		}
	}


	public static LocalDateTime parseToDateTime(String dateString) {
		try {
			return DATE_TIME_FORMATTER.parse(dateString, LocalDateTime::from);
		} catch (Exception e) {
			System.out.println("format error");
			return null;
		}
	}

	public static String parseToFrenchDateTime(String dateString) {
		String dateToString = null;
		try {
			if (dateString != null) {
				dateToString = LocalDateTime.parse(dateString, DATE_TIME_FORMATTER).format(DATE_TIME_FRENCH_FORMATTER);
			}
		} catch (Exception e) {
			System.out.println("Echec format de date");
		}
		return dateToString;
	}

	public static String parseToFrenchDate(String dateString) {
		String dateToString = null;
		try {
			if (dateString != null) {
				dateToString = LocalDate.parse(dateString, DATE_FORMATTER).format(DATE_FRENCH_FORMATTER);
			}
		} catch (Exception e) {
			System.out.println("Echec format de date");
		}
		return dateToString;
	}
	public static String parseToFrenchDate3(String dateString) {
		String dateToString = null;
		SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			SimpleDateFormat format = new SimpleDateFormat("d-MM-yyyy");
			Date date6 = formatter6.parse(dateString);

			dateToString = format.format(date6);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateToString;
	}

	public static LocalDate parseToLocalDate(String dateString) {
		try {
			return DATE_TIME_FORMATTER.parse(dateString, LocalDate::from);
		} catch (Exception e) {
			System.out.println("Echec format de date");
			return null;
		}
	}

	//verifie si la date correspond au pattern
	public static boolean validDate(String dateString) {
		return DateUtil.parseToDateTime(dateString) != null;
	}

	public static String parseDate(Date date) {
		return date.getYear()+"-"+date.getMonth()+""+date.getDate();
	}
	public static String parseDateTime(Date date) {
		return  date.getYear()+"-"+date.getMonth()+"-"+date.getDate()+" "
				+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}

	public static Date parseDateTime(String date) {
		if(date ==null) return null;
		return  Date.from(java.sql.Timestamp.valueOf(date).toInstant()) ;
	}
	public static Date parseDate(String date) {
		if(date ==null) return null;
		return   Date.from(java.sql.Timestamp.valueOf(date).toInstant());
	}
	public static String parseDateTimeToLocal(String date) {
		if(date ==null) return null;
		return  Date.from(java.sql.Timestamp.valueOf(date).toInstant()).toLocaleString();
	}
	public static String parseDateToLocal(String date) {
		if(date ==null) return null;
		return  Date.from(java.sql.Timestamp.valueOf(date).toInstant()).toLocaleString();
	}
	public static Date parseDate(LocalDate localDate) {
		if(localDate ==null) return null;
		return   java.sql.Date.valueOf(localDate);
	}
	public static LocalDate  getLastDay(String date) {
		LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		convertedDate = convertedDate.withDayOfMonth(convertedDate.getMonth().length(convertedDate.isLeapYear()));
		convertedDate = convertedDate.withDayOfMonth(convertedDate.lengthOfMonth());
		return convertedDate;		
	}

	public static List<Month> getTroisDerniersMois(){
		LocalDate currentDate = LocalDate.now();
		List<Month> troisDerniersMois = new ArrayList<>();
		for(int i=0; i < 3; i++){
			troisDerniersMois.add(currentDate.minusMonths(i).getMonth());
		}
		return troisDerniersMois;
	}

	public static List<LocalDate> getTroisDernieresSemaines(){
		LocalDate currentDate = LocalDate.now();
		List<LocalDate> troisDernieresSemaines = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			LocalDate startOfWeek = currentDate.minusWeeks(i).with(TemporalAdjusters
					.previousOrSame(java.time.DayOfWeek.MONDAY));
			troisDernieresSemaines.add(startOfWeek);
		}
		return troisDernieresSemaines;
	}

	public static List<LocalDate> getTroisDerniersJours(){
		LocalDate currentDate = LocalDate.now();
		List<LocalDate> troisDerniersJours = new ArrayList<>();
		for (int i = 0; i < 3; i++){
			troisDerniersJours.add(currentDate.minusDays(i));
		}
		return troisDerniersJours;
	}
}
