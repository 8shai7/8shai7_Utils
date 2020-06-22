package com.Shai.Utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public abstract class In{

	private static Map<String,String> mapS = new HashMap<String,String>();
	private static Map<String,Character> mapC = new HashMap<String,Character>();
	private static Map<String,Integer> mapI = new HashMap<String,Integer>();
	private static Map<String,Long> mapL = new HashMap<String,Long>();
	private static Map<String,Float> mapF= new HashMap<String,Float>();
	private static Map<String,Double> mapD = new HashMap<String,Double>();
	private static Map<String,Short> mapSH = new HashMap<String,Short>();
	private static Map<String,Byte> mapB = new HashMap<String,Byte>();
	private static Map<String,Boolean> mapBo = new HashMap<String,Boolean>();
	private static List<String> vals = new LinkedList<String>();

	private static int indexOf(String name) {
		return vals.indexOf(name);
	}
	private static String nameOf(int index) {
		return vals.get(index);
	}
	private static void add(String name,int index) {
		vals.add(index,name);
	}
	private static void add(String name) {
		vals.add(name);
	}
	private static int numOfCopies(String Name) {
		int copies = 0;
		if(mapB.containsKey(Name))
			copies++;
		if(mapBo.containsKey(Name))
			copies++;
		if(mapC.containsKey(Name))
			copies++;
		if(mapD.containsKey(Name))
			copies++;
		if(mapF.containsKey(Name))
			copies++;
		if(mapI.containsKey(Name))
			copies++;
		if(mapL.containsKey(Name))
			copies++;
		if(mapS.containsKey(Name))
			copies++;
		if(mapSH.containsKey(Name))
			copies++;
		return copies;
	}
	private static void deleteCopiesOf(String Name) {
		if(mapB.containsKey(Name))
			mapB.remove(Name);
		if(mapBo.containsKey(Name))
			mapBo.remove(Name);
		if(mapC.containsKey(Name))
			mapC.remove(Name);
		if(mapD.containsKey(Name))
			mapD.remove(Name);
		if(mapF.containsKey(Name))
			mapF.remove(Name);
		if(mapI.containsKey(Name))
			mapI.remove(Name);
		if(mapL.containsKey(Name))
			mapL.remove(Name);
		if(mapS.containsKey(Name))
			mapS.remove(Name);
		if(mapSH.containsKey(Name))
			mapSH.remove(Name);
	}
	public static void printAllNames() {
		System.out.print("[");
		int counter = 0;
		for(String i : vals) {
			System.out.print("( ("+counter+") "+i+" )");
			counter++;
		}
		System.out.print("]");
		System.out.println();
	}
	public static void printAll() {
		String str = "Byte: "+mapB.toString()+" Boolean: "+mapBo.toString()+" Character: "+mapC.toString()+" Double: "+mapD.toString()+" Float: "+mapF.toString()+" Integer: "+mapI.toString()+" Long: "+mapL.toString()+" Short: "+mapSH.toString()+" String: "+mapS.toString()+" Names: "+vals.toString();
		System.out.println(str);
	}
	public static <T> void printAll(Class<?> T) {
		Class<?> cl = T.getClass();
		if(cl.equals(Boolean.class)) {
			System.out.println(mapBo.toString());
		}else if(cl.equals(Byte.class)) {
			System.out.println(mapB.toString());
		}else if(cl.equals(Long.class)) {
			System.out.println(mapL.toString());
		}else if(cl.equals(Float.class)) {
			System.out.println(mapF.toString());
		}else if(cl.equals(Short.class)) {
			System.out.println(mapSH.toString());
		}else if(cl.equals(Character.class)) {
			System.out.println(mapC.toString());
		}else if(cl.equals(String.class)) {
			System.out.println(mapS.toString());
		}else if(cl.equals(Integer.class)) {
			System.out.println(mapI.toString());
		}else if(cl.equals(Double.class)) {
			System.out.println(mapD.toString());
		}
	}
	public static void set(String name){
		set(name, null);
	}
	public static <T> void set(String name, T value) {
		if(numOfCopies(name)>0)
			deleteCopiesOf(name);
		if(vals.indexOf(name)==-1) {
			vals.add(name);
		}
		if(value==null)
			mapS.put(name, null);
		else {
			Class<? extends Object> val = value.getClass();
			if(val==Integer.class) {
				mapI.put(name, (Integer) value);
			}
			else if(val==String.class)
				mapS.put(name, (String)value);
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
	public static String search4Type(String name) {
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
	public static Number plusAll(String type){

		if(type=="int"||type=="Integer") {
			Long i = 0L;
			for (Map.Entry<String, Integer> entry : mapI.entrySet()) {
				i+=entry.getValue();
			}
			return i;
		}

		if(type=="char"||type=="Character") {
			Long i = 0L;
			for (Map.Entry<String, Character> entry : mapC.entrySet()) {
				i+=entry.getValue();
			}
			return i;
		}		
		if(type=="long"||type=="Long") {
			Long i = 0L;
			for (Map.Entry<String, Long> entry : mapL.entrySet()) {
				i+=entry.getValue();
			}
		}
		if(type=="float"||type=="Float") {
			Double i = 0D;
			for (Map.Entry<String, Float> entry : mapF.entrySet()) {
				i+=entry.getValue();
			}
			return i;
		}
		if(type=="short"||type=="Short") {
			Long i = 0L;
			for (Map.Entry<String, Short> entry : mapSH.entrySet()) {
				i+=entry.getValue();
			}
			return i;
		}
		if(type=="byte"||type=="Byte") {
			Long i = 0L;
			for (Map.Entry<String, Byte> entry : mapB.entrySet()) {
				i+=entry.getValue();
			}
			return i;
		}
		if(type=="double"||type=="Double") {
			Double i = 0D;
			for (Map.Entry<String, Double> entry : mapD.entrySet()) {
				i+=entry.getValue();
			}
			return i;
		}
		if(type=="boolean"||type=="Boolean") {
			int i = 0;
			for (Map.Entry<String, Boolean> entry : mapBo.entrySet()) {
				i+=entry.getValue() ? 1 : 0;
			}
			return i;
		}
		System.err.println("Not Found!");
		return null;
	}

	public static Number minusAll(String type){
		Boolean first = true;
		if(type=="int"||type=="Integer") {
			Integer i = 0;
			for (Map.Entry<String, Integer> entry : mapI.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i-=entry.getValue();
			}
			return i;
		}

		if(type=="char"||type=="Character") {
			int i = 0;
			for (Map.Entry<String, Character> entry : mapC.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i-=entry.getValue();
			}
			return i;
		}		
		if(type=="long"||type=="Long") {
			Long i = 0L;
			for (Map.Entry<String, Long> entry : mapL.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i-=entry.getValue();
			}
			return i;
		}
		if(type=="float"||type=="Float") {
			Float i = 0F;
			for (Map.Entry<String, Float> entry : mapF.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i-=entry.getValue();			
			}
			return i;
		}
		if(type=="short"||type=="Short") {
			short i = 0;
			for (Map.Entry<String, Short> entry : mapSH.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i-=entry.getValue();
			}
			return i;
		}
		if(type=="byte"||type=="Byte") {
			byte i = 0;
			for (Map.Entry<String, Byte> entry : mapB.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i-=entry.getValue();
				}
			return i;
		}
		if(type=="double"||type=="Double") {
			Double i = 0D;
			for (Map.Entry<String, Double> entry : mapD.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i-=entry.getValue();
			}
			return i;
		}
		System.err.println("Not Found!");
		return null;
	}

	public static Number multiplyAll(String type){

		if(type=="int"||type=="Integer") {
			Long i = 1L;
			for (Map.Entry<String, Integer> entry : mapI.entrySet()) {
				i*=entry.getValue();
			}
			return i;
		}

		if(type=="char"||type=="Character") {
			Long i = 1L;
			for (Map.Entry<String, Character> entry : mapC.entrySet()) {
				i*=entry.getValue();
			}
			return i;
		}		
		if(type=="long"||type=="Long") {
			Long i = 1L;
			for (Map.Entry<String, Long> entry : mapL.entrySet()) {
				i*=entry.getValue();
			}
			return i;
		}
		if(type=="float"||type=="Float") {
			Double i = 1D;
			for (Map.Entry<String, Float> entry : mapF.entrySet()) {
				i*=entry.getValue();
			}
			return i;
		}
		if(type=="short"||type=="Short") {
			Long i = 1L;
			for (Map.Entry<String, Short> entry : mapSH.entrySet()) {
				i*=entry.getValue();
			}
			return i;
		}
		if(type=="byte"||type=="Byte") {
			Long i = 1L;
			for (Map.Entry<String, Byte> entry : mapB.entrySet()) {
				i*=entry.getValue();
			}
			return i;
		}
		if(type=="double"||type=="Double") {
			Double i = 1D;
			for (Map.Entry<String, Double> entry : mapD.entrySet()) {
				i*=entry.getValue();
			}
			return i;
		}
		if(type=="boolean"||type=="Boolean") {
			int i = 1;
			for (Map.Entry<String, Boolean> entry : mapBo.entrySet()) {
				i*=entry.getValue() ? 1 : 0;
			}
			return i;
		}
		System.err.println("Not Found!");
		return null;
	}
	public static Number divideAll(String type){
		Boolean first = true;
		if(type=="int"||type=="Integer") {
			Integer i = 0;
			for (Map.Entry<String, Integer> entry : mapI.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i/=entry.getValue();
			}
			return i;
		}

		if(type=="char"||type=="Character") {
			int i = 0;
			for (Map.Entry<String, Character> entry : mapC.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i/=entry.getValue();
			}
			return i;
		}		
		if(type=="long"||type=="Long") {
			Long i = 0L;
			for (Map.Entry<String, Long> entry : mapL.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i/=entry.getValue();
			}
			return i;
		}
		if(type=="float"||type=="Float") {
			Float i = 0F;
			for (Map.Entry<String, Float> entry : mapF.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i/=entry.getValue();			
			}
			return i;
		}
		if(type=="short"||type=="Short") {
			short i = 0;
			for (Map.Entry<String, Short> entry : mapSH.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i/=entry.getValue();
			}
			return i;
		}
		if(type=="byte"||type=="Byte") {
			byte i = 0;
			for (Map.Entry<String, Byte> entry : mapB.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i/=entry.getValue();
				}
			return i;
		}
		if(type=="double"||type=="Double") {
			Double i = 0D;
			for (Map.Entry<String, Double> entry : mapD.entrySet()) {
				if (first) {
					first = false;
					i=entry.getValue();
				}else
					i/=entry.getValue();
			}
			return i;
		}
		System.err.println("Not Found!");
		return null;
	}
}

