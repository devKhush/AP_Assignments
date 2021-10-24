import java.util.Scanner;

public class IdentityMatrix extends ScalarMatrix{
    double scalarElement=1;

    @Override
    double getScalarElement(){
        return this.scalarElement;
    }

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter dimension of Identity matrix (one number): ");
        int dimension = Integer.parseInt(sc.nextLine().trim());
        this.matrix = new double[dimension][dimension];
        this.rows=dimension;
        this.columns=dimension;
        this.scalarElement=1;
        for (int i=0; i<dimension; i++){
            for (int j=0; j<dimension; j++){
                if (i==j) {
                    this.matrix[i][j]=1;
                }
                else{
                    this.matrix[i][j]=0;
                }
            }
        }
        this.id = this.staticID;
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
