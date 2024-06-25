package com.sigrh.gestionressourceh.common.util;
public class DecimalUtils {
	
	public static String parseToDecimal(String str) {
		str = str.replace(",", ".").replaceAll(" ", "");
		return str;
	}
	
	public static String parseToString(String str) {
		String[] parts = str.replace(",", ".").split(",");
		parts[0]=new StringBuilder(parts[0]).reverse().toString().replaceAll("(\\d{3})", "$1 ");
		parts[0]=new StringBuilder(parts[0]).reverse().toString();
		if(parts.length>1)
		return parts[0]+","+parts[1];
		return parts[0];
	}
	public static String parseToString(Double d) {
		if(d==null) return "";
		String str = d.toString();
		String[] parts = str.replace(".", ",").split(",");
		parts[0]=new StringBuilder(parts[0]).reverse().toString().replaceAll("(\\d{3})", "$1 ");
		parts[0]=new StringBuilder(parts[0]).reverse().toString();
		return parts[0]+","+parts[1];
	}
	
	public static Float getValue(String str) {
		if(str.isEmpty()) return 0f;
		str = str.replace(",", ".").replaceAll(" ", "");
		return Float.parseFloat(str);
	}
	
	public static String withoutScientificNotation(Double str) {
		return parseToString(String.format("%.0f\n", str));		
	}	
	public static String withoutScientificNotationNotSpace(Double str) {
		return String.format("%.0f\n", str);		
	}
	
	public static String getValueWithBlank(Double d) {
		return parseToString(d);
		/*
		String str = String.valueOf(d);
		if(str.isEmpty()) return null;
		return str;
		*/ 
	}
	
}
