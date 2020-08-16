/* 1. String - Write a Java program to replace each substring of a given string that matches
 *    the given regular expression with the given replacement.
 **/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFind {

   private static String REGEX = "vdf";
   private static String PAT = "dnifvdfnrfieri435vdfernir7njqw,ojxcp[q89,wcg,vdfreio,gocg";
   private static String REPLACE = "GOOGLE";

   public static void main(String[] args) {
      Pattern p = Pattern.compile(REGEX);
      System.out.println("Before : " + PAT);
      // get a matcher object
      Matcher m = p.matcher(PAT); 
      PAT = m.replaceAll(REPLACE);
      System.out.println("After : " + PAT);
   }
}