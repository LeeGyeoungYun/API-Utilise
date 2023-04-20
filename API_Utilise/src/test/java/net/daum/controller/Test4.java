package net.daum.controller;

public class Test4 {  //Builder 패턴  연습

	public static void main(String[] args) {
		
		User user1 = new User("abc","qwer123","홍길동");
		System.out.println(user1.toString());
			
		User user2 = new User.Builder()
				     .id("testId")
				     .pwd("testPwd")
				     .name("테스트이름")
				     .build();
		
		System.out.println(user2.toString());
		
		
		User user3 = new User.Builder()  //부분 build
					.id("아이디")
					.name("이름")
					.build();		
		System.out.println(user3.toString());
	}

}


class User{
	
	private String id;
	private String pwd;
	private String name;
	
	public User(String id,String pwd,String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	
	public String toString() {
		
		String answer = "User [ id="+id+", pwd="+pwd+", name="+name+" ]";
		return answer;
	}
	
	public static class Builder{// User클래스안에 Builder클래스 생성
		
		private String id;
		private String pwd;
		private String name;
		
		public Builder() {//생성자
			
		}
		
		public Builder(User user) {
			this.id = user.id;
			this.pwd = user.pwd;
			this.name = user.name;			
		}
		
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		
		public Builder pwd(String pwd) {
			this.pwd = pwd;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public User build() {
			return new User(id,pwd,name);
		}
		
		
	}
}
