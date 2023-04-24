package factoryMethodPattern;

public interface ComponentFactoryMethod {
	Component createOperation(String type); //탬플릿
	Component createComponent(String type); //팩토리 메서드
}

class ButtonFactory implements ComponentFactoryMethod{

	public Button createOperation(String type) {
		Button button = createComponent(type);
		//button.추가설정();
		return button;
	}
	
	public Button createComponent(String type) {
		Button button = null;
		
		switch(type.toLowerCase()) {
		
		case "window":
			button = new WindowButton();
			break;
		
		case "mac":
			button = new MacButton();
			break;
		
		}
		
		return button;
	}
	
}

class CheckBoxFactory implements ComponentFactoryMethod{

	public CheckBox createOperation(String type) {
		CheckBox checkBox = createComponent(type);
		//checkBox.추가설정();
		return checkBox;
	}
	
	public CheckBox createComponent(String type) {
		CheckBox checkBox = null;
		
		switch(type.toLowerCase()) {
		
		case "window":
			checkBox = new WindowCheckBox();
			break;
		
		case "mac":
			checkBox = new MacCheckBox();
			break;
		
		}
		
		return checkBox;
	}
	
}

class TextEditFactory implements ComponentFactoryMethod {
    public TextEdit createOperation(String type) {
        TextEdit txtedit = createComponent(type);
        //txtedit.추가설정();
        return txtedit;
    }

    public TextEdit createComponent(String type) {

        TextEdit txtedit = null;

        switch (type.toLowerCase()) {
            case "window":
                txtedit = new WindowTextEdit();
                break;

            case "mac":
                txtedit = new MacTextEdit();
                break;
        }

        return txtedit;
    }
}
