import java.util.Scanner;

public class LowerTriangularMatrix extends SquareMatrix{

    @Override
    public void changeElement(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the row number to change element :");
        int i = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter the column number to change element :");
        int j = Integer.parseInt(sc.nextLine());
        if (i<j){
            System.out.println("Can't change the value of an element of lower triangular matrix with rowNumber < columnNumber");
            return;
        }
        System.out.printf("Enter the new value :");
        double value = Double.parseDouble(sc.nextLine());
        this.changeElementOfMatrix(i,j,value);
    }

    @Override
    public void getEigenValues(){
        System.out.printf("\nEigen values  =  ");
        for (int i=0; i<this.getRows(); i++){
            if (i!=this.getRows()-1)
                System.out.printf("%.4f, ",this.getElementOfMatrix(i,i));
            else
                System.out.printf(" %.4f ",this.getElementOfMatrix(i,i));
        }
        System.out.println();
    }

}
