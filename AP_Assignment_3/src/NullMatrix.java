import java.util.Scanner;

public class NullMatrix extends RectangularMatrix{
    double nullElement = 0;

    public double getNullElement() {
        return nullElement;
    }

    @Override
    public boolean isSymmetric(){
        return this.getRows() == this.getColumns();
    }

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Dimensions of Null matrix as <rows><space><columns>: ");
        String dimension = sc.nextLine().trim();
        String[] dimMatrix = dimension.split(" ");
        int row = Integer.parseInt(dimMatrix[0]);
        int column = Integer.parseInt(dimMatrix[1]);
        this.setMatrix(new double[row][column]);
        this.setRows(row);
        this.setColumns(column);
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                this.changeElementOfMatrix(i,j,nullElement);
            }
        }
        // this.id = this.staticID++;
        this.setID();
    }

    public static void main(String[] args) {
        Matrix nm = new NullMatrix();
        nm.inputMatrix();
        nm.printMatrix();
        nm.printMatrix(nm.getTransposeMatrix());
        System.out.println(nm.getId());
        System.out.println(nm.getRows());
        System.out.println(nm.getColumns());
        System.out.println(nm.isSymmetric());
    }
}
