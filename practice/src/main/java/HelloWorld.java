public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello Git 1 World!");
        String s1 = "1234";
        String s2 = "12";
        String s3 = "34";
        String s4 = "1"+"234";
        String s5 = "12"+ "34";
        String s6 = s2 +s3;
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
        System.out.println(s1.equals(s5));
        System.out.println(s1.equals(s6));
        System.out.println(s1 == s6);
    }
}
