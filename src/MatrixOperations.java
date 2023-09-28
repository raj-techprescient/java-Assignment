import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows:: ");
        int rows = scan.nextInt();
        System.out.print("Enter the number of columns:: ");
        int col = scan.nextInt();
        int[][] matrixOne = new int[rows][col];
        System.out.println("Enter metric one values");
        for(int i= 0; i<rows; i++){
            System.out.println("Enter Elements of row " + i);
            for(int j= 0; j<col; j++){
                matrixOne[i][j] = Integer.parseInt(scan.next());
            }
        }
        System.out.println("Enter metric two values");
        int[][] matrixTwo = new int[rows][col];
        for(int i= 0; i<rows; i++){
            System.out.println("Enter Elements of row " + i);
            for(int j= 0; j<col; j++){
                matrixTwo[i][j] = Integer.parseInt(scan.next());
            }
        }
        scan.close();

        // Addition of matrix
        int[][] matrixSum = new int[rows][col];
        for(int i= 0; i<rows; i++){
            for(int j= 0; j<col; j++){
                matrixSum[i][j] = matrixOne[i][j]+matrixTwo[i][j];
            }
        }

        // Sub of matrix
        int[][] matrixSub = new int[rows][col];
        for(int i= 0; i<rows; i++){
            for(int j= 0; j<col; j++){
                matrixSub[i][j] = Math.abs(matrixOne[i][j]-matrixTwo[i][j]);
            }
        }

        // Mul of matrix
        int[][] matrixMul = new int[rows][col];
        for(int i= 0; i<rows; i++){
            for(int j= 0; j<col; j++){
                matrixMul[i][j] = matrixOne[i][j] * matrixTwo[i][j];
            }
        }
        System.out.println("Addition of matrix");
        // System.out.println(Arrays.deepToString(matrixOne));
        // System.out.println(Arrays.deepToString(matrixTwo));
        System.out.println(Arrays.deepToString(matrixSum));
        System.out.println("Subtraction of matrix");
        System.out.println(Arrays.deepToString(matrixSub));
        System.out.println("Multiplication of matrix");
        System.out.println(Arrays.deepToString(matrixMul));
    }
}
