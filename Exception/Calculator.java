package Exception;
public abstract class Calculator {
	int result;
	abstract void add();
	protected abstract void sub();
	 void multiply(int num1,int num2) {
		result = num1*num2;
		System.out.println("result:"+ result);			
	}

}
