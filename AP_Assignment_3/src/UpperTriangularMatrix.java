import java.util.Scanner;

public class UpperTriangularMatrix extends SquareMatrix{

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
