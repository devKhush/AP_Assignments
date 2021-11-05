import java.util.Scanner;

public class SingletonMatrix extends SquareMatrix{
    double elementInSingletonMatrix;

    public double getElementInSingletonMatrix() {
        return elementInSingletonMatrix;
    }

    public void setElementInSingletonMatrix(double elementInSingletonMatrix) {
        this.elementInSingletonMatrix = elementInSingletonMatrix;
    }

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        this.setMatrix(new double[1][1]);
        this.setRows(1);
        this.setColumns(1);
        System.out.printf("Enter the value inside Singleton Matrix: ");
        double value = Double.parseDouble(sc.nextLine().trim());
        this.changeElementOfMatrix(0, 0, value);
        this.setElementInSingletonMatrix(value);
        //this.id = this.staticID;
        this.setID();
    }

    public static void main(String[] args) {
        Matrix sm = new SingletonMatrix();
        sm.inputMatrix();
        sm.printMatrix();
        sm.printMatrix(sm.getTransposeMatrix());
        System.out.println(sm.getId());
        System.out.println(sm.getRows());
        System.out.println(sm.getColumns());
        System.out.println(sm.isSymmetric());
        System.out.println();
    }
}
