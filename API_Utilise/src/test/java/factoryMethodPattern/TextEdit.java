package factoryMethodPattern;

public abstract class TextEdit implements Component{

}

class WindowTextEdit extends TextEdit{

	@Override
	public void render() {
		System.out.println("윈도우 텍스트 에디터 생성 완료");		
	}
	
}

class MacTextEdit extends TextEdit{

	@Override
	public void render() {
		System.out.println("MAC 텍스트 에디터 생성 완료");		
	}
	
}
