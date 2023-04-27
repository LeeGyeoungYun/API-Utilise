package singletonPattern;

public class Printer {
	
	private static Printer printer = null;
	
	private Printer() {
		
	}
	
	public static Printer getInstance() {
		
		if(printer == null) {
			printer = new Printer();
		}
		
		return printer;
	}
	
	public void print(String input) {
		System.out.println(input);
	}
	
	public static void main(String args[]) {
		Printer.getInstance().print("Singleton Painter print");
	}
	
	
	/*	< 싱글턴 패턴(Singleton Pattern)이란? >
	 * 
	 *	싱글턴 패턴은 인스턴스를 하나만 만들어 사용하기 위한 패턴이다.
	 *	커넥션 풀, 스레드 풀, 디바이스 설정 객체 등의 경우 여러 개 만들게 되면 자원을 낭비하게 되거나 버그를 발생시킬 수 있으므로 오직 하나만 생성하고
	 *	그 인스턴스를 사용하도록 하는 것이 이 패턴의 목적이다. 하나의 인스턴스만을 유지하기위해 인스턴스 생성에 특별한 제약을 걸어둬야 한다.
	 *	new를 실행할 수 없도록 생성자에 private 접근 제어자를 지정하고, 유일한 단일 객체를 반환할 수 있도록 정적 메소드를 지원해야 한다.
	 *	또한 유일한 단일 객체를 참조할 정적 참조변수가 필요하다.
	 *
	 * 	Singleton : 하나의 인스턴스만을 생성하는 책임이 있으며, getInstance() 메서드를 통해, 모든 클라이언트에게 동일한 인스턴스를 
	 *  			반환하는 작업을 수행한다.
	 *  
	 *  
	 *  위 코드의 main 메서드에서 실행시       Singleton Painter print    라는 결과물이 출력이된다.
	 *  기본생성자를 private를 사용하여 생성을 불가능하게 하고 getInstance()를 통해서만 생성할 수 있다.
	 *  getInstance()는 내부적으로 생성되지 않았다면 생성하고, 기존에 생성된 값이 존재한다면 생성된 인스턴스를 리턴하는 형태로 프로그램 전반에
	 *  걸쳐 하나의 인스턴스를 유지한다. 또한 참고할 점은 인스턴스를 제공하는 메서드와 인스턴스 변수 모두 Static으로 선언된 정적 변수 및 메서드이다.
	 *  당연히 기본생성자를 통해 생성할 수 없기 때문에 외부에서 인스턴스에 접근하려면 클래스 변수 및 메서드에 접근을 허용해야하기 때문에 두 메서드는 정적
	 *  타입으로 선언되어 있다.
	 *  
	 *  
	 *  < Singleton Pattern 문제점 >
	 *	
	 *	위와같은 싱글턴 패턴은 Multi-Thread 환경에서 안전하지 않다.
	 *	여러 쓰레드가 공유되고 있는 상황에서는 아래의 블럭에서 조건문이 동시에 두번 돌 수 있기 때문에 하나의 인스턴스가 아닌 여러개의 인스턴스가
	 *	발생할 위험이 있다.
	 *
	 *		public static Printer getInstance() {
	 *			if(printer == null) {
	 *				printer = new Printer();
	 *			}
	 *			return printer;
	 *		}
	 * 
	 * 	뿐만 아니라, 인스턴스가 상태를 유지해야하는 상황에서 싱글톤은 더 고려해야할 점이 많다. 아래의 예제에서 count값은 각기 다른 쓰레드에서 공유
	 *  하고 있고 서로 다른 프로세스에서 처리하고 있기 때문에 일관되지 않을 수 있다.
	 *  
	 *  	public class Printer {
     *			private static Printer printer = null;
     *			private int count = 0;
     *
     *			private Printer(){}
     *
     *			public static Printer getInstance() {
     *				if(printer == null) {
     *					printer = new Printer();
     *				}
     *				return printer;
     *			}
     *
     *			public void print(String input) {
     *				count++;
     *				System.out.println(input + "count : "+ count);
     *			}
     * 		}
     * 
     * 	
     * 	< 위 코드와 같이 멀티쓰레드 환경에서의 싱글톤 사용방법 (해결법) >
     * 
     *  멀티쓰레드 환경에서 싱글톤의 문제를 해결할 수 있는 방법은 두가지가 있다.
     *  
     *  1. 정적 변수에 인스턴스를 만들어 바로 초기화 하는 방법
     *  2. 인스턴스를 만드는 메소드에 동기화하는 방법
     *  
     *  정적 변수는 객체가 생성되기 전 클래스가 메모리에 로딩할 때 만들어져 초기화가 한 번만 실행된다. 또한 정적 변수는 프로그램이 시작될때부터 종료할때까지
     *  없어지지 않고, 메모리에 계속 상주하며 클래스에서 생성된 모든 객체에서 참조할 수 있다. 따라서 기존에 조건문에서 체크하던 부분이 원천적으로 제거된다.
     *  하지만 이경우에도, Count값은 각기 다르게 접근하기 때문에 쓰레드마다 값이 달라진다. 객체 생성 자체는 로드 시점에서 결정되어 하나의 객체만을 사용하지만,
     *  Count 접근하는 것은 동시적으로 접근하기 때문에 그렇다. 이를 해결하기 위해서는 아래와 같이 syncronized라는 키워드를 통해 여러 쓰레드에서
     *  동시에 접근하는 것을 막는 방법으로 이를 해결 할 수 있다.
     *  
     *  	public class Printer {
	 * 			private static Printer printer = new Printer();
	 *  		private static int count = 0;
	 *	
	 * 			private Printer(){}
	 *
	 *			public static Printer getInstance() {
	 *				return printer;
	 * 			}
	 *
	 *			 public synchronized static void print(String input) {
	 *				count++;
	 * 				System.out.println(input + "count : "+ count);
	 *			}
     *		}
     *   
     *  
     *  위와 같이 정적 클래스를 이용하면 객체를 전혀 생성하지 않고 메서드를 사용할 수 있고, 인스턴스 메서드를 사용하는 것보다 성능면에서 우수하다고
     *  볼 수 있다. 
     *  
     *  
     *  
     *  < 싱글톤 패턴의 문제점 정리 >
     *  
     *  1. 싱글톤은 프로그램 전체에서 하나의 객체만을 공통으로 사용하고 있기 때문에 각 객체간의 결합도가 높아지고 변경에 유연하게 대처할 수 없다.
     *     싱글톤 객체가 변경되면, 이를 참조하고 있는 모든 값들이 변경되어야 하기 때문이다.
     *     
     *  2. 멀티쓰레드 환경에서 대처가 어느정도 가능하지만, 고려해야 할 요소가 많아 사용이 어렵고, 프로그램 전반에 걸쳐서 필요한 부분에만 사용한다면,
     *     장점이 있다. 하지만 그 포인트를 잡기가 어렵다.
     *  
	 * 
	 * 
	 * 
	 * */

}
