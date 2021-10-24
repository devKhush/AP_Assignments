import java.util.Arrays;
import java.util.Scanner;

public class Practise {
    public static void printMatrix(int rows, int columns, double[][] matrix){
        System.out.printf("[");
        int j;
        for (int i=0; i<rows;i++){
            if (i==0)
                System.out.printf(" [");
            else
                System.out.printf("  [");
            for (j=0; j<columns-1; j++){
                System.out.printf("%f, ",matrix[i][j]);
            }
            if (i==rows-1)
                System.out.printf("%f ] ]\n",matrix[i][columns-1]);
            else
                System.out.printf("%f ]\n",matrix[i][columns-1]);
        }
        System.out.println();
    }
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

        double[][] mat = {{1,1,1},{3,3,3},{2,2,2}};
        printMatrix(3,3,mat);
    }


}
