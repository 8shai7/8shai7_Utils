package com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class arr {

	public static Map<String,String[]> mapS = new HashMap<String,String[]>();
	public static Map<String,Character[]> mapC = new HashMap<String,Character[]>();
	public static Map<String,Integer[]> mapI = new HashMap<String,Integer[]>();
	public static Map<String,Long[]> mapL = new HashMap<String,Long[]>();
	public static Map<String,Float[]> mapF= new HashMap<String,Float[]>();
	public static Map<String,Double[]> mapD = new HashMap<String,Double[]>();
	public static Map<String,Short[]> mapSH = new HashMap<String,Short[]>();
	public static Map<String,Byte[]> mapB = new HashMap<String,Byte[]>();
	public static Map<String,Boolean[]> mapBo = new HashMap<String,Boolean[]>();
	public static List<String> arrtypes = new LinkedList<String>();

	public static int indexOf(String name) {
		return arrtypes.indexOf(name);
	}
	public static String nameOf(int index) {
		return arrtypes.get(index);
	}
	public static void add(String name,int index) {
		arrtypes.add(index,name);
	}
	public static void add(String name) {
		arrtypes.add(name);
	}
	public static void printAlltypes() {
		System.out.print("Saved Array typeues(0,1...): ");
		for(String i : arrtypes) {
			System.out.print(i+", ");
		}
		System.out.println();
	}
	public static void set(String name, int length, Class<?> type) {
		if(arrtypes.indexOf(name)==-1) {
			arrtypes.add(name);
		}
		if(type==null)
			System.err.println("Set Error: Cannot Find Given Type!");
		else {
			if(type==Integer.class)
				mapI.put(name, new Integer[length]);
			else if(type==String.class)
				mapS.put(name, new String[length]);
			else if(type==Character.class)
				mapC.put(name, new Character[length]);
			else if(type==Long.class)
				mapL.put(name, new Long[length]);
			else if(type==Float.class)
				mapF.put(name, new Float[length]);
			else if(type==Short.class)
				mapSH.put(name, new Short[length]);
			else if(type==Byte.class)
				mapB.put(name, new Byte[length]);
			else if(type==Double.class)
				mapD.put(name, new Double[length]);
			else if(type==Boolean.class)
				mapBo.put(name, new Boolean[length]);
			else
				System.err.println("Set Error: Cannot Find Given Type!");
		}
	}
	public static void set(String name, Object[] arr) {
		Class<? extends Object> type = arr.getClass();
		if(arrtypes.indexOf(name)==-1) {
			arrtypes.add(name);
		}
		if(type==null)
			System.err.println("Set Error: Cannot Find Given Type!");
		else {
			if(type==Integer[].class)
				mapI.put(name, (Integer[]) arr);
			else if(type==String[].class)
				mapS.put(name, (String[]) arr);
			else if(type==Character[].class)
				mapC.put(name, (Character[]) arr);
			else if(type==Long[].class)
				mapL.put(name, (Long[]) arr);
			else if(type==Float[].class)
				mapF.put(name, (Float[]) arr);
			else if(type==Short[].class)
				mapSH.put(name, (Short[]) arr);
			else if(type==Byte[].class)
				mapB.put(name, (Byte[]) arr);
			else if(type==Double[].class)
				mapD.put(name, (Double[]) arr);
			else if(type==Boolean[].class)
				mapBo.put(name, (Boolean[]) arr);
			else
				System.err.println("Set Error: Cannot Find Given Type!");
		}
	}
	public static void set(String name, String arr) {
		arr = arr.replaceAll("\\s","");
		set(name, arr.split(","));
	}
	public static Object[] get(String name) {
		String type = search4Type(name);
		if(type=="int"||type=="Integer")
			return mapI.get(name);
		if(type=="String")
			return	mapS.get(name);
		if(type=="char"||type=="Character")
			return mapC.get(name);
		if(type=="long"||type=="Long")
			return mapL.get(name);
		if(type=="float"||type=="Float")
			return mapF.get(name);
		if(type=="short"||type=="Short")
			return mapSH.get(name);
		if(type=="byte"||type=="Byte")
			return mapB.get(name);
		if(type=="double"||type=="Double")
			return mapD.get(name);
		if(type=="boolean"||type=="Boolean")
			return mapBo.get(name);
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
