import java.util.ArrayList;

// Check whether string is palindrome or not
class Solution {
    public static boolean isPalindrome(int x) {
        String myString = Integer.toString(x);
        char[] arr = myString.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            if (arr[i] != arr[j]) {
                return false;
            }
            i+=1;
            j-=1;
        }
        return true;
    }
}

// Reverse Individual words in a String.

// https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/
class Reverse {
    public static String reverseWords(String s) {
        ArrayList<String> result = new ArrayList<String>();
        String[] words = s.split(" ");
        for(String word: words){
            result.add(reverseWord(word));
        }
        return String.join(" ", result);
    }
    public static String reverseWord(String word) {
        char[] charArray = word.toCharArray();
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }
}

class SampleQuestion{
    public static void main(String[] args){
        System.out.println(Solution.isPalindrome(121));
        System.out.println(Reverse.reverseWords("Let's take LeetCode contest"));
    }
}

