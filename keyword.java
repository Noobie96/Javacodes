package keyword;

public  class keyword {
	
	static int b;
	
	int display(int a ) {
		System.out.println("a"+a);
		return a;
		
	}
	void show() {
		this.b=200;
		System.out.println("b:"+ b);
		
	}
	
	public static void main(String args[]) {
		keyword k =new keyword();
		k.display(10);
		new keyword().show();
		
	}

}
