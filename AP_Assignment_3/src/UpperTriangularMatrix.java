import java.util.Arrays;
import java.util.Scanner;

public class UpperTriangularMatrix extends SquareMatrix{
//    @Override
//    public void inputMatrix(){
//        Scanner sc = new Scanner(System.in);
//        System.out.printf("Enter dimension of Upper-Traingular square matrix (one number): ");
//        int dimension = Integer.parseInt(sc.nextLine().trim());
//        this.setMatrix(new double[dimension][dimension]);
//        this.setRows(dimension);
//        this.setColumns(dimension);
//        for (int i=0; i<dimension; i++){
//            System.out.printf("Enter %dth row input (Space separated): ",i);
//            String rowInput = sc.nextLine().trim();
//            String[] rowInputArray = rowInput.split(" ");
//            for (int j=0; j<dimension; j++){
//                double matrixElement = Double.parseDouble(rowInputArray[j]);
//                this.changeElementOfMatrix(i,j , matrixElement);
//            }
//        }
//        this.id = this.staticID;
//    }
    @Override
    public void changeElement(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the row number to change element :");
        int i = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter the column number to change element :");
        int j = Integer.parseInt(sc.nextLine());
        if (i>j){
            System.out.println("Can't change the value of an element of upper triangular matrix with rowNumber > columnNumber");
            return;
        }
        System.out.printf("Enter the new value :");
        double value = Double.parseDouble(sc.nextLine());
        this.changeElementOfMatrix(i,j,value);
    }

    public static void main(String[] args) {
        Matrix utm = new UpperTriangularMatrix();
        utm.inputMatrix();
        System.out.println(utm.getRows());
        System.out.println(utm.getClass());
        utm.printMatrix();
        utm.printMatrix(utm.getTransposeMatrix());
        System.out.println(utm.getId());
    }
}
