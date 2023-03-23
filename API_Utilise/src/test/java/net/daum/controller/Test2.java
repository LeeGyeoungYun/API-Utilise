package net.daum.controller;

public class Test2 {

	public static void main(String[] args) {
		
		Test3 t = new Test3(11,"zz");
		
		/*
		 * System.out.println(t.aa); 
		 * System.out.println(t.bb);
		 */
		
	}
	
}

class Test3{
	
	private int age;
	private String name;
	public int aa=3;
	protected int bb=4;
	
	public Test3(int age,String name){
		this.age = age;
		this.name = name;
		System.out.println(age+" "+name);
	}
}
