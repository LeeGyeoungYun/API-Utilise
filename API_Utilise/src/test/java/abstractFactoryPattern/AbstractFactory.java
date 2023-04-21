package abstractFactoryPattern;

/* 공장(Factory) 클래스 */
public interface AbstractFactory {
	AbstractProductA createProductA();
	AbstractProductB createProductB();
}

//Product A1과 B1 제품군을 생산하는 공장군 1
class ConcreteFactory1 implements AbstractFactory{
	
	public AbstractProductA createProductA() {
		return new ConcreteProductA1();
	}
	
	public AbstractProductB createProductB() {
		return new ConcreteProductB1();
	}
}

//Product A2와 B2 제품군을 생산하는 공장군 2
class ConcreteFactory2 implements AbstractFactory {
	
	 public AbstractProductA createProductA() {
	     return new ConcreteProductA2();
	 }
	 
	 public AbstractProductB createProductB() {
	     return new ConcreteProductB2();
	 }
}
