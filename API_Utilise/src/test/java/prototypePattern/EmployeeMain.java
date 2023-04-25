package prototypePattern;

import java.util.List;

public class EmployeeMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);

        
        
        /* 프로토 타입 패턴(Prototype Pattern)이란? 
         * 
         * 프로토타입은 주로 실제 제품을 만들기에 앞서 대략적인 샘플 정도의 의미로 사용되는 단어이다.
         * 생성할 객체들의 타입이 프로토타입인 인스턴스로부터 결정되도록 하며 인스턴스는 새 객체를 만들기 위해 자신을 복제(clone)하게 된다.
         * 패턴을 구현하려면 우선 clone() 메소드를 선언하는 추상 클래스를 하나 만든다.
         * 그 후 , 다형적 생성자(polymorphic constructor) 기능이 필요한 클래스가 있다면 위의 추상 클래스를 상속받게 한 후, clone()메소드
         * 내의 코드를 구현한다.
         *
         * 1. 프로토타입 패턴 특징
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         * */
        
	}

}
