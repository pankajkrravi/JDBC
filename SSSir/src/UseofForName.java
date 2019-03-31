public class UseofForName {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Class.forName("Myclass");
		//creates object
		Class.forName("Myclass").newInstance();
	}
}
class Myclass
{
	//static block
	static
	{
		System.out.println("in static ");
	}
	//non static block
	{
		System.out.println("in instance");
	}
}
