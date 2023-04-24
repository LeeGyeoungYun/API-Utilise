package factoryMethodPattern;

public abstract class CheckBox implements Component{

}

class WindowCheckBox extends CheckBox{

	@Override
	public void render() {
		System.out.println("윈도우 체크박스 생성 완료");
	}
	
}

class MacCheckBox extends CheckBox{

	@Override
	public void render() {
		System.out.println("MAC 체크박스 생성 완료");
	}
	
}
