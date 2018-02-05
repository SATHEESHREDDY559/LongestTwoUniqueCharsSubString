import java.util.HashSet;
import java.util.Set;

public class LongestTwoUniqueCharsSubString {
    public static void main(String[] args) {
        String inputStr = "aaabcddddddeeeeehhhh";
        Set<Character> characterSet = new HashSet<Character>();
        String longestStr = "";
        for (int i = 0; i < inputStr.length(); i++) {
            characterSet.add(inputStr.charAt(i));
        }
        for (int i = 0; i < inputStr.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String substring = inputStr.substring(j, i);
                longestStr = getLongestTwoCharsSubStr(characterSet, longestStr, substring);
            }
        }
        System.out.println("Longest two unique chars sub string: " + longestStr);
    }

    private static String getLongestTwoCharsSubStr(Set<Character> characterSet, String longestStr, String substring) {
        Set<Character> twoUniqueCharsSet = new HashSet<Character>();
        for (Character aCharacterSet : characterSet) {
            if (substring.contains(aCharacterSet.toString()))
                twoUniqueCharsSet.add(aCharacterSet);
            if (twoUniqueCharsSet.size() > 2)
                break;
        }
        if (twoUniqueCharsSet.size() == 2)
            if (substring.length() >= longestStr.length())
                longestStr = substring;
        return longestStr;
    }
}
