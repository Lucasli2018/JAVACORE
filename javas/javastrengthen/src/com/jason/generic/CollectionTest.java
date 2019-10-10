package com.jason.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * 泛型的集合遍历
 * @author Administrator
 *
 */
public class CollectionTest {
	
	/**
	 * 只有两边有泛型，必须一致。
	 */
	public void run4(){
		List list1 = new ArrayList();
		List<String> list2 = new ArrayList();
		List list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		
	//	List<Object> list5 = new ArrayList<String>();
	//	List<String> list6 = new ArrayList<Object>();
	}
	
	public void demo1(List list){
		
	}
	
	public void demo(){
		demo1(new ArrayList<String>());
	}
	
	/**
	 * Map集合，有序的
	 */
	@Test
	public void demo03(){
		Map<String,Integer> map=new HashMap<>();
		map.put("aa", 11);
		map.put("bb", 22);
		map.put("cc", 33);
		map.put("dd", 44);
		// 遍历两种	获取key
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key+" "+map.get(key));
		}
		System.out.println("==============================");
		
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
	}
	
	/**
	 * Set集合,无序的
	 */
	@Test
	public void demo02(){
		Set<String> set=new HashSet<>();
		set.add("1柯震东");
		set.add("2房祖名");
		set.add("3王全安");
		set.add("5张耀扬");
		
		// 遍历方式		迭代器和增强for循环
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("========================");
		
		// 增强for循环		for(类型	变量 : 集合){}
		for (String str : set) {
			System.out.println(str);
		}
	}
	
	/**
	 * List集合，有序的
	 */
	@Test
	public void demo01(){
		//list集合
		List<String> list=new ArrayList<>();
		list.add("1美美");
		list.add("2旺财");
		list.add("3芙蓉姐姐");
		
		// 循环遍历	三种	普通for	增强for	迭代器
		for(int i=0;i<list.size();i++){
			String str = list.get(i);
			System.out.println(str);
		}
		System.out.println("==============================");
		
		// 增强for循环		for(类型	变量 : 集合){}
		for(String str:list){
			System.out.println(str);
		}
		System.out.println("==============================");
		
		// 迭代器
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
