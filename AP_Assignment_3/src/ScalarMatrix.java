import java.util.Scanner;

public class ScalarMatrix extends SquareMatrix{
    double scalarElement;

    @Override
    double getScalarElement(){
        return this.scalarElement;
    }

    void setScalarElement(double scalarElement){
        this.scalarElement = scalarElement;
    }

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter dimension of Scalar matrix (one number): ");
        int dimension = Integer.parseInt(sc.nextLine().trim());
        System.out.printf("Enter the element of scalar matrix: ");
        double scalar = Double.parseDouble(sc.nextLine().trim());
        this.setMatrix(new double[dimension][dimension]);
        this.setRows(dimension);
        this.setColumns(dimension);
        this.setScalarElement(scalar);
        for (int i=0; i<dimension; i++){
            for (int j=0; j<dimension; j++){
                if (i==j)
                    this.changeElementOfMatrix(i,j , this.scalarElement);
                else
                    this.changeElementOfMatrix(i,j , 0);
            }
        }
        //this.id = this.staticID;
        this.setID();
    }

    public static void main(String[] args) {
        Matrix sm = new ScalarMatrix();
        sm.inputMatrix();
        System.out.println(sm.getScalarElement());
        System.out.println(sm.getId());
        sm.printMatrix();
        sm.printMatrix(sm.getTransposeMatrix());
        System.out.println(sm.isSymmetric());
    }
}
