package factoryMethodPattern;

public class Client {

	public static void main(String[] args) {
		
		ComponentFactoryMethod factory = null;
		Button btn = null;
		CheckBox checkBox = null;
		
		//윈도우 버튼생성
		factory = new ButtonFactory();
		btn = (Button) factory.createComponent("Window");
		btn.render();
		
		//Mac 버튼 생성
		btn = (Button) factory.createComponent("Mac");
		btn.render();
		 
		// 윈도우 체크 박스 생성
	    factory = new CheckBoxFactory();
	    checkBox = (CheckBox) factory.createOperation("Window");
	    checkBox.render();

	    // 맥 체크 박스 생성
	    checkBox = (CheckBox) factory.createOperation("Mac");
	    checkBox.render();
		
	}

}
