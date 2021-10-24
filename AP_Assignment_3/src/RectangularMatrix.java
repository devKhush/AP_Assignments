import java.util.Arrays;
import java.util.Scanner;

public class RectangularMatrix extends Matrix{
//    private int rows;
//    private int columns;
//    private double[][] matrix;
//    private int id;

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Dimensions as <rows> <columns>: ");
        String dimension = sc.nextLine().trim();
        String[] dimMatrix = dimension.split(" ");
        int row = Integer.parseInt(dimMatrix[0]);
        int column = Integer.parseInt(dimMatrix[1]);
        this.matrix = new double[row][column];
        this.rows=row;
        this.columns=column;
        for (int i=0; i<row; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<column; j++){
                this.matrix[i][j] = Double.parseDouble(rowInputArray[j]);
            }
        }
        this.id = staticID;
        System.out.println(Arrays.deepToString(this.matrix));
        System.out.println(this.staticID);
    }

}
