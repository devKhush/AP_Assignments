import java.util.Arrays;
import java.util.Scanner;

public class DiagonalMatrix extends SquareMatrix{
    double[] diagonalElements;

    double[] getDiagonalElements(){
        return this.diagonalElements;
    }

    void setDiagonalElements(double[] diagonalElements){
        this.diagonalElements = diagonalElements;
    }

    void changeDiagonalElement(int i, double value){
        this.diagonalElements[i] = value;
    }

    public double calculateDeterminant(){
        double determinant = 1;
        for (int i=0; i<this.getRows(); i++)
            determinant *= this.getElementOfMatrix(i,i);
        return determinant;
    }

    @Override
    public void inputMatrix(){
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
    }

    public static void main(String[] args) {
        Matrix dm = new DiagonalMatrix();
        dm.inputMatrix();
        dm.printMatrix();
        System.out.println(Arrays.toString(((DiagonalMatrix)dm).getDiagonalElements()));
        dm.printMatrix(dm.getTransposeMatrix());
        System.out.println(dm.getId());
        System.out.println(dm.getRows());
        System.out.println(dm.getColumns());
        System.out.println(dm.isSymmetric());
    }
}
