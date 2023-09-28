import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpStr = br.readLine().split(" ");

        int[] array = new int[inpStr.length];
        int index = 0;
        for(String str: inpStr) {
            array[index] = Integer.parseInt(str);
            index++;
        }

        // Reverse an array
        int i = 0;
        int j = array.length-1;
        while (i<j){
            int x = array[i];
            array[i] =array[j];
            array[j] = x;
            i++;
            j--;
        }
        System.out.println("Reversed Array" + Arrays.toString(array));

        // Sort an array
        Arrays.sort(array);
        System.out.println("Sorted Array" + Arrays.toString(array));

        // Max and minimum in array
        int min = array[0];
        int max = array[0];
        for(int element =1; element< array.length; element++){
            if(array[element]>max) max = array[element];
            if(array[element]<min) min = array[element];
        }
        System.out.println("Min element " + min);
        System.out.println("Max element " + max);
    }
}
