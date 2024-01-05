package utility;

import org.testng.annotations.DataProvider;

class A{
	void a() {
		System.out.println("A a");
	}
}
class B extends A{
	void a() {
		System.out.println("B a");
	}
}

public class DataProviders {

	public static void main(String[] args) {
//		System.out.println(Utility.getConfigurationProperty("grid_url"));
		B b = new B();
		A a = (A) b;
		
		b.a();
		a.a();
		if(a.equals(b)) {
			System.out.println("Yes");
		}
	}
}
