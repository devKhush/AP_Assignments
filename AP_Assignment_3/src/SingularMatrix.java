
public class SingularMatrix extends SquareMatrix {
    @Override
    public void changeElement(){
        System.out.println("Can't change the value of this matrix as determinant may becomes non-zero");
    }

    @Override
    public double getDeterminant(){
        return 0;
    }

    @Override
    public double[][] getInverse(boolean toBeReturned){
        System.out.println("Can't perform as the first matrix is singular");
        return new double[][]{{Double.MIN_VALUE}};
    }

    @Override
    public void solveLinearEquation(Matrix B){
        System.out.println("Can't solve equations as the first matrix is singular");
    }


}
