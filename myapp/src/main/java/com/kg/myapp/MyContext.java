package com.kg.myapp;

import java.lang.reflect.Field;

public class MyContext {

	private <T> T runAnnotation(T obj) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field : fields) {
			myAnnotation anno = field.getAnnotation(myAnnotation.class);
//			if(anno != null && field.getType() == String.class) {
//				field.setAccessible(true);
//				field.set(obj, anno.name());
//			}
			if(anno != null) {
			field.setAccessible(true);
//			field.set(obj, anno.name());
			field.set(obj, field.getType().newInstance());
		}
		}
		return obj;
	}
	
	public <T> T getInstance(Class c) throws InstantiationException, IllegalAccessException{
		T obj = (T)c.newInstance();
		obj = runAnnotation(obj);
		return obj;
	}
}
