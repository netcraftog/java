package CoreJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    public void stringTest(){
        System.out.println("Hello Git 1 World!");
        String s1 = "1234";
        String s2 = "12";
        String s3 = "34";
        //1 This kind of string appending will be optimized by JVM, will not create a new String.
        String s4 = "1"+"234";
        String s5 = "12"+ "34";

        //2 This will use StringBuilder, and create a new String for appending.
        String s6 = s2 +s3;
        Assertions.assertTrue(s1 == s4, "s1 != s4");

        //Because 1 & 2 s1 != s6
        Assertions.assertTrue(s1 != s6, "s1 == s6");
        Assertions.assertEquals(s1 , s4);
        Assertions.assertEquals(s1 , s6);
    }
}
