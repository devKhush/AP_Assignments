import java.util.Scanner;

public class IdentityMatrix extends ScalarMatrix{
    double scalarElement=1;

    @Override
    public void getAllTypes(){
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getSuperclass().getName());
        System.out.println("DiagonalMatrix");
        System.out.println("SquareMatrix");
    }

    @Override
    double getScalarElement(){
        return this.scalarElement;
    }

    @Override
    public boolean inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter dimension of Identity matrix (one number): ");
        int dimension = Integer.parseInt(sc.nextLine().trim());
        this.setMatrix(new double[dimension][dimension]);
        this.setRows(dimension);
        this.setColumns(dimension);
        this.scalarElement=1;
        for (int i=0; i<dimension; i++){
            for (int j=0; j<dimension; j++){
                if (i==j) {
                    this.changeElementOfMatrix(i, j, 1);
                }
                else{
                    this.changeElementOfMatrix(i, j, 0);
                }
            }
        }
        //this.id = this.staticID;
        this.setID();
        return true;
    }

    public static void main(String[] args) {
        Matrix im = new IdentityMatrix();
        im.inputMatrix();
        System.out.println(im.getScalarElement());
        System.out.println(im.getId());
        im.printMatrix();
        im.printMatrix(im.getTransposeMatrix());
        System.out.println(im.isSymmetric());
    }
}
