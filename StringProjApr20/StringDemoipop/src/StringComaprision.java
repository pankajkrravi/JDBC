
public class StringComaprision {
	public static void main(String[] args) {
		String s1="Dinga";
		String s2="dinga";
		String s3="Dingi";
		String s4=new String("rama");
		System.out.println(s1.equals(s2));//f
		System.out.println(s1.equals(s3));//f
		System.out.println(s1.equalsIgnoreCase(s2));//T
	}

}
