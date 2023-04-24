package factoryMethodPattern;

public abstract class Button implements Component{

}

class WindowButton extends Button{

	@Override
	public void render() {
		System.out.println("윈도우 버튼 생성 완료");
	}
	
}

class MacButton extends Button{

	@Override
	public void render() {
		System.out.println("MAC윈도우 버튼 생성 완료");	
	}
}
