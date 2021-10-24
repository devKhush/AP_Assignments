import java.util.Arrays;
import java.util.Scanner;

public class Practise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter numbers of rows: ");
        int row = Integer.parseInt(sc.nextLine().trim());
        System.out.printf("Enter numbers of columns: ");
        int column = Integer.parseInt(sc.nextLine().trim());
        double[][] matrix = new double[row][column];
        for (int i=0; i<row; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<column; j++){
                matrix[i][j] = Double.parseDouble(rowInputArray[j]);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }


}
