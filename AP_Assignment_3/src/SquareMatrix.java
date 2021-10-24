import java.util.Arrays;
import java.util.Scanner;

public class SquareMatrix extends Matrix{
    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter dimension of square matrix (one number): ");
        int dimension = Integer.parseInt(sc.nextLine().trim());
        this.matrix = new double[dimension][dimension];
        this.rows=dimension;
        this.columns=dimension;
        for (int i=0; i<dimension; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<dimension; j++){
                this.matrix[i][j] = Double.parseDouble(rowInputArray[j]);
            }
        }
        this.id = this.staticID;
        System.out.println(Arrays.deepToString(this.matrix));
        System.out.println(this.staticID);
    }

    public static void main(String[] args) {
        Matrix sm = new SquareMatrix();
        sm.inputMatrix();
        System.out.println(sm.getId());
        System.out.println(sm.getRows());
        System.out.println(sm.getColumns());

        Matrix rm = new RectangularMatrix();
        rm.inputMatrix();
        System.out.println(rm.getId());
        System.out.println(rm.getRows());
        System.out.println(rm.getColumns());

        Matrix sm1 = new SquareMatrix();
        sm1.inputMatrix();
        System.out.println(sm1.getId());
        System.out.println(sm1.getRows());
        System.out.println(sm1.getColumns());
    }
}
