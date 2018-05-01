package com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class In{
	
	public static Map<String,String> mapS = new HashMap<String,String>();
	public static Map<String,Character> mapC = new HashMap<String,Character>();
	public static Map<String,Integer> mapI = new HashMap<String,Integer>();
	public static Map<String,Long> mapL = new HashMap<String,Long>();
	public static Map<String,Float> mapF= new HashMap<String,Float>();
	public static Map<String,Double> mapD = new HashMap<String,Double>();
	public static Map<String,Short> mapSH = new HashMap<String,Short>();
	public static Map<String,Byte> mapB = new HashMap<String,Byte>();
	public static Map<String,Boolean> mapBo = new HashMap<String,Boolean>();
	public static List<String> vals = new LinkedList<String>();

	public static int indexOf(String name) {
		return vals.indexOf(name);
	}
	public static String nameOf(int index) {
		return vals.get(index);
	}
	public static void add(String name,int index) {
		vals.add(index,name);
	}
	public static void add(String name) {
		vals.add(name);
	}
	public static void printAllVals() {
		System.out.print("Saved Values(0,1...): ");
		for(String i : vals) {
			System.out.print(i+", ");
		}
		System.out.println();
	}
	public static void set(String name){
		set(name, null);
	}
	public static <T> void set(String name, T value) {
		if(vals.indexOf(name)==-1) {
			vals.add(name);
		}
		if(value==null)
			mapS.put(name, null);
		else {
			Class<? extends Object> val =  value.getClass();
			if(val==Integer.class)
				mapI.put(name, (Integer) value);
			else if(val==String.class)
				mapS.put(name, value+"");
			else if(val==Character.class)
				mapC.put(name, (Character) value);
			else if(val==Long.class)
				mapL.put(name, (Long) value);
			else if(val==Float.class)
				mapF.put(name, (Float) value);
			else if(val==Short.class)
				mapSH.put(name, (Short) value);
			else if(val==Byte.class)
				mapB.put(name, (Byte) value);
			else if(val==Double.class)
				mapD.put(name, (Double) value);
			else if(val==Boolean.class)
				mapBo.put(name, (Boolean) value);
			else
			System.err.println("Set Error: Cannot Find Given Type!");
		}
	}
	public static Object get(String name) {
		String type = search4Type(name);
		if(type=="int"||type=="Integer")
			return mapI.get(name).toString();
		if(type=="String")
			return	mapS.get(name).toString();
		if(type=="char"||type=="Character")
			return mapC.get(name).toString();
		if(type=="long"||type=="Long")
			return mapL.get(name).toString();
		if(type=="float"||type=="Float")
			return mapF.get(name).toString();
		if(type=="short"||type=="Short")
			return mapSH.get(name).toString();
		if(type=="byte"||type=="Byte")
			return mapB.get(name).toString();
		if(type=="double"||type=="Double")
			return mapD.get(name).toString();
		if(type=="boolean"||type=="Boolean")
			return mapBo.get(name).toString();
		if(type==null) {
			return null;
		}
		System.err.println("Not Found!");
		return null;
	}
	private static String search4Type(String name) {
		if(!getByType(name, "String").equals("null"))
			return "String";
		else if(!getByType(name, "Integer").equals("null"))
			return "Integer";
		else if(!getByType(name, "Character").equals("null"))
			return "Character";
		else if(!getByType(name, "Long").equals("null"))
			return "Long";
		else if(!getByType(name, "Short").equals("null"))
			return "Short";
		else if(!getByType(name, "Float").equals("null"))
			return "Float";
		else if(!getByType(name, "Double").equals("null"))
			return "Double";
		else if(!getByType(name, "Byte").equals("null"))
			return "Byte";
		else if(!getByType(name, "Boolean").equals("null"))
			return "Boolean";
		return null;
	}
	private static String getByType(String name, String type) {
		if(type=="int"||type=="Integer")
			return mapI.get(name)+"";
		if(type=="String")
			return	mapS.get(name)+"";
		if(type=="char"||type=="Character")
			return mapC.get(name)+"";
		if(type=="long"||type=="Long")
			return mapL.get(name)+"";
		if(type=="float"||type=="Float")
			return mapF.get(name)+"";
		if(type=="short"||type=="Short")
			return mapSH.get(name)+"";
		if(type=="byte"||type=="Byte")
			return mapB.get(name)+"";
		if(type=="double"||type=="Double")
			return mapD.get(name)+"";
		if(type=="boolean"||type=="Boolean")
			return mapBo.get(name)+"";
		System.err.println("Not Found!");
		return null;
	}
}
