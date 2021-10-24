import java.util.Arrays;
import java.util.Scanner;

public class RowMatrix extends Matrix{
//    private int rows=1;
//    private int columns;
//    private double[][] matrix;
//    private int id;

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter numbers of columns: ");
        int column = Integer.parseInt(sc.nextLine().trim());
        matrix = new double[1][column];
        this.rows=1;
        this.columns=column;
        for (int i=0; i<1; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<column; j++){
                this.matrix[i][j] = Double.parseDouble(rowInputArray[j]);
            }
        }
        this.id = staticID;
        System.out.println(Arrays.deepToString(this.matrix));
    }

//    @Override
//    public int getRows(){
//        return this.rows;
//    }
//    @Override
//    public int getColumns(){
//        return this.columns;
//    }
//    @Override
//    public double[][] getMatrix(){
//        return this.matrix;
//    }
//    @Override
//    public int getId(){
//        return this.id;
//    }

    public static void main(String[] args) {
        Matrix rm = new RowMatrix();
        rm.inputMatrix();
        System.out.println(rm.getId());
        System.out.println(rm.getRows());
        System.out.println(rm.getColumns());

        Matrix cm = new ColumnMatrix();
        cm.inputMatrix();
        System.out.println(cm.getId());
        System.out.println(cm.getRows());
        System.out.println(cm.getColumns());

        Matrix rm1 = new RowMatrix();
        rm1.inputMatrix();
        System.out.println(rm1.getId());
        System.out.println(rm1.getRows());
        System.out.println(rm1.getColumns());
    }
}
