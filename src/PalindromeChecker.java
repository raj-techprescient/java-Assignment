import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PalindromeChecker {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().strip();
        char[] charArray = str.toCharArray();
        int i = 0;
        int j = charArray.length-1;
        int flag = 0;
        while(i<j){
            if (charArray[i]!=charArray[j]){
                flag = 1;
                break;
            }
            i++;
            j--;
        }
        if(flag == 1){
            System.out.println(str + " is not a palindrome");
        }
        else {
            System.out.println(str + " is a palindrome");
        }
    }
}
