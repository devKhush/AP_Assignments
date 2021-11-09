import java.util.Scanner;

public class IdentityMatrix extends ScalarMatrix{
    double scalarElement=1;

    @Override
    public void getAllTypes(){
        System.out.println(this.getClass().getName());
        System.out.println(this.getClass().getSuperclass().getName());
        if (this.getRows()==1)
            System.out.println("SingletonMatrix");
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

}
