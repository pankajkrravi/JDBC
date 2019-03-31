
public class ComusingCompareoperator {
	public static void main(String[] args) {
		String s1="DINGA";
		String s2="dinga";
		String s3="DINGA";
		String s4=new String("DINGA");
		System.out.println(s1==s2);//f
		System.out.println(s1==s4);//f decoz refer to s4 refer to instance created in non pool
		System.out.println(s1==s3);//t decoz refer to same object
	}
}
