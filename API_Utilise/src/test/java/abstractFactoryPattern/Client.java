package abstractFactoryPattern;

// 클라이언트 
public class Client {

	public static void main(String[] args) {
		
		AbstractFactory factory = null;
		
		
		//1. 공장군 1을 가동시킨다.
		factory = new ConcreteFactory1();
		
		//2. 공장군 1을 통해 제품군 A1을 생성하도록 한다. (클라이언트는 구체적인 구현은 모르고 인터페이스에 의존한다.)
		AbstractProductA product_A1 = factory.createProductA();
		System.out.println(product_A1.getClass().getName()); //ConcreteProductA1
		
		//3. 공장군 2를 가동시킨다.
		factory = new ConcreteFactory2();
		
		//4. 공장군 2를 통해 제품군 A2를 생성하도록 한다. (클라이언트는 구체적인 구현은 모르고 인터페이스에 의존한다.)
		AbstractProductA product_A2 = factory.createProductA();
		System.out.println(product_A2.getClass().getName()); //ConcreteProductA2
		
		
		//결과 -> 똑같은 createProductA() 메서드를 호출하지만 어떤 팩토리 객체이냐에 따라 반환되는 제품군이 다르게된다.
		
		/*   <추상 팩토리 패턴 특징>
		 * 
		 *  1. 패턴 사용시기
		 *  
		 *  -> 1-1. 관련제품의 다양한 제품군과 함께 작동해야 할 때, 해당 제품의 구체적인 클래스에 의존하고 싶지 않은 경우
		 *  -> 1-2. 여러 제품군 중 하나를 선택해서 시스템을 설정해야하고 한 번 구성한 제품을 다른 것으로 대체할 수 있을 때
		 *  -> 1-3. 제품에 대한 클래스 라이브러리를 제공하고, 그들의 구현이 아닌 인터페이스를 노출시키고 싶을 때
		 *  
		 *  
		 *  2. 패턴 장점
		 *  
		 *  -> 2-1. 객체를 생성하는 코드를 분리하여 클라이언트 코드와 결합도를 낮출 수 있다.
		 *  -> 2-2. 제품 군을 쉽게 대체 할 수 있다.
		 *  -> 2-3. 단일 책임 원칙 준수
		 *  -> 2-4. 개방/패턴 원칙 준수
		 *  
		 *  
		 *  3. 패턴 단점
		 *  
		 *  -> 3-1. 각 구현체마다 팩토리 객체들을 모두 구현해주어야만 하기 때문에 객체가 늘어날때 마다 클래스가 증가하여 코드가
		 *          증가하여 코드의 복잡성이 증가한다. (팩토리 패턴의 공통적인 문제)
		 *  -> 3-2. 기존 추상 팩토리의 세부사항이 변경되면 모든 팩토리에 대한 수정이 필요해진다. 이는 추상 팩토리와 모든 서브클래스의 수정을 가져온다.
		 *  -> 3-3. 새로운 종류의 제품을 지원하는 것이 어렵다. 새로운 제품이 추가되면 팩토리 구현 로직 자체를 변경해야하한다. 
		 * 
		 * */
	}

}
