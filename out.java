package com;

import java.lang.reflect.Field;

public class out {
	

	public static <T>  void println() {
		System.out.println();
	}
	@SuppressWarnings("unchecked")
	public static <T> void print(Object obj) {
		if(obj==null) {
			System.out.print("null");
		}
		else {
			Class<? extends T> var = (Class<? extends T>) obj.getClass();
			if(obj.getClass().isPrimitive())  {
				System.out.print(obj);
			}
			else if(var==Byte.class || var==Character.class || var==String.class || var==Integer.class || var==Double.class || var==Long.class || var==Float.class || var==Short.class){
				System.out.print(obj);
			}
			else if(obj instanceof Object[]){
				for(int i=0;i<((Object[])obj).length;i++) {
					System.out.print(((Object[])obj)[i]+",");
				}
			}
			else if(var.getDeclaredFields().length==0){
				System.err.println("ERROR: Not Printable! - Object With No Fields To Print - "+var.getName());
			}
			else if(var.getDeclaredFields().length>0){
				println(obj);
			}
			else {
				System.out.print("ERROR: Not Printable! - Unknown Error"+var.getName());
			}
		}
	}
	public static <T> void println(String obj) {
		if(obj.contains("+")) {
			System.out.println(obj.split("\\+").length);
			String[] obj1 = obj.split("\\+");
			for(String str : obj1) {
				if(str.contains("\\+"+"\"")){
					str.replace("\"", "");
				}
				com.out.print(str);;
			}
			System.out.println();
		}
		else {
			println((Object)(obj));
		}
	}
	@SuppressWarnings("unchecked")
	public static <T> void println(Object obj) {
		if(obj==null) {
			System.out.println("null");
		}
		else {
			Class<? extends T> var = (Class<? extends T>) obj.getClass();
			if(var.isPrimitive())  {
				System.out.println(obj);
			}
			else if(var==Byte.class || var==Character.class || var==String.class || var==Integer.class || var==Double.class || var==Long.class || var==Float.class || var==Short.class){
				System.out.println(obj);
			}
			else if(obj instanceof Object[] || var.isArray()){
				for(int i=0;i<((Object[])obj).length;i++) {
					System.out.println(((Object[])obj)[i]);
				}
			}
			else if(var.getDeclaredFields().length==0){
				System.err.println("ERROR: Not Printable! - Object With No Fields To Print - "+var.getName());
			}
			else if(var.getDeclaredFields().length>0){
				System.out.println(var.getSimpleName()+": \n-----------------");
				for(Field f : var.getDeclaredFields()) {
					f.setAccessible(true);
					try {
						com.out.print(f.getName()+": ");
						com.out.println(f.get(obj));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						System.err.println("ERROR: Not Printable! - Unknown Class Type - "+var.getName());
					}
				}
				System.out.println("-----------------");
			}
			else {
				System.out.println("ERROR: Not Printable! - Unknown Error"+var.getName());
			}
		}
	}
}
