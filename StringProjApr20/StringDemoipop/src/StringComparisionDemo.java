
public class StringComparisionDemo {
   public static void main(String[] args) {
	String str1="LAILA";
	String str2="laila";
	String s3="Laila";
	System.out.println(str1.equals(str2));//f
	System.out.println(str1.equals(s3));//f
	System.out.println(str1.equalsIgnoreCase(str2));//t
	System.out.println(str1.equalsIgnoreCase(s3));//t
}
}
