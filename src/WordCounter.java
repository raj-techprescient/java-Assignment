import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String input_str = sc.nextLine();
        String[] input_array = input_str.split(" ");
        for(String word : input_array){
           if(map.containsKey(word)){
               map.put(word, map.get(word)+1);
           }
           else {
               map.put(word, 1);
           }
        }
        for(String i : map.keySet()){
            System.out.println(i + " " +map.get(i).toString());
        }
    }
}
