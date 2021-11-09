import java.util.Scanner;

public class ScalarMatrix extends DiagonalMatrix{
    double scalarElement;

    @Override
    public void getAllTypes(){
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getSuperclass().getName());
        System.out.println("SquareMatrix");
    }


    @Override
    double getScalarElement(){
        return this.scalarElement;
    }

    @Override
    void setScalarElement(double scalarElement){
        this.scalarElement = scalarElement;
    }

    @Override
    public boolean inputMatrix(){
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
        return true;
    }

    @Override
    public void changeElement(){
        System.out.println("Can't change value of Scalar Matrix");
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
