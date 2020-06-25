public class Singleton{
	private int data = 0 ;
	private Singleton(){}
	private static class SingletonHelper{
		private static final Singleton uniqueInstance = new Singleton();
	}
	public static Singleton getInstance(){
		return SingletonHelper.uniqueInstance;
	}
	// setters and getters
}

// / / / / // 
public class Client{
	Singleton a = Singleton.getInstance();
	Singleton b = Singleton.getInstance();
}