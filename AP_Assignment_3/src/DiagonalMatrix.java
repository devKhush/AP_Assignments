import java.util.Arrays;
import java.util.Scanner;

public class DiagonalMatrix extends SquareMatrix{
    double[] diagonalElements;

    @Override
    double[] getDiagonalElements(){
        return this.diagonalElements;
    }

    @Override
    void setDiagonalElements(double[] diagonalElements){
        this.diagonalElements = diagonalElements;
    }

    @Override
    void changeDiagonalElement(int i, double value){
        this.diagonalElements[i] = value;
    }

    @Override
    public double calculateDeterminant(){
        double determinant = 1;
        for (int i=0; i<this.getRows(); i++)
            determinant *= this.getElementOfMatrix(i,i);
        return determinant;
    }

    @Override
    public boolean inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the dimension of diagonal matrix (one number): ");
        int dimension = Integer.parseInt(sc.nextLine().trim());
        this.setMatrix(new double[dimension][dimension]);
        this.setDiagonalElements(new double[dimension]);
        this.setRows(dimension);
        this.setColumns(dimension);
        System.out.printf("Enter the %d diagonal elements (space separated): ", dimension);
        String diagonal = sc.nextLine().trim();
        String[] diagonalElements = diagonal.split(" ");
        for (int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                if (i==j){
                    this.changeElementOfMatrix(i,j,Double.parseDouble(diagonalElements[i]));
                }
                else
                    this.changeElementOfMatrix(i,j,0);
            }
            this.changeDiagonalElement(i,Double.parseDouble(diagonalElements[i]));
        }
//        this.id = this.staticID;
        this.setID();
        return true;
    }

    @Override
    public void changeElement(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the row number to change element :");
        int i = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter the column number to change element :");
        int j = Integer.parseInt(sc.nextLine());
        if (i!=j){
            System.out.println("Can't change the value of non-diagonal element");
            return;
        }
        System.out.printf("Enter the new value :");
        double value = Double.parseDouble(sc.nextLine());
        this.changeElementOfMatrix(i,j,value);
        this.changeDiagonalElement(i,value);
    }

    @Override
    public void getEigenValues(){
        System.out.printf("\nEigen Values  =  ");
        for (int i=0; i<this.getRows(); i++){
            if (i!=this.getRows()-1)
                System.out.printf("%.4f, ",this.getElementOfMatrix(i,i));
            else
                System.out.printf(" %.4f ",this.getElementOfMatrix(i,i));
        }
        System.out.println();
    }

}
