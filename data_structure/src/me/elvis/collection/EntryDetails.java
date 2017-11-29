package me.elvis.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Version:v1.0 (description:  ) Date:2017/11/18 0018  Time:13:19
 */
public class EntryDetails {



	public static void main(String[] args){
		Map<String,Object> data = new HashMap<>();
		data.put("key1",new Person("张三",'M',"北京"));
		data.put("key2",new Person("李四",'M',"北京"));
		System.out.println(data);
		System.out.println(data.entrySet());
		System.out.println(data.keySet());
		System.out.println(data.values());
		for (Map.Entry<String,Object> entry:data.entrySet()) {
			System.out.println( entry.getKey() + ":" + entry.getValue() + ";");
		}

	}

	static class Person{
		private String name;
		private char gender;
		private String address;

		public Person(String name, char gender, String address) {
			this.name = name;
			this.gender = gender;
			this.address = address;
		}

		@Override
		public String toString() {
			return "Person{" + "name='" + name + '\'' + ", gender=" + gender + ", address='"
					+ address + '\'' + '}';
		}
	}

}
