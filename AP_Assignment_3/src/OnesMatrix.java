import java.util.Scanner;

public class OnesMatrix extends Matrix{
    double onesElement = 1;

    public double getOnesElement() {
        return onesElement;
    }

    @Override
    public double getElementOfMatrix(int i,int j){
        return onesElement;
    }

    @Override
    public void getAllTypes(){
        System.out.println("OnesMatrix");
        if (this.getRows()==this.getColumns())
            System.out.println("SquareMatrix");
        else
            System.out.println("RectangularMatrix");
    }

    @Override
    public boolean isSymmetric(){
        return this.getRows() == this.getColumns();
    }

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Dimensions of Ones matrix as <rows><space><columns>: ");
        String dimension = sc.nextLine().trim();
        String[] dimMatrix = dimension.split(" ");
        int row = Integer.parseInt(dimMatrix[0]);
        int column = Integer.parseInt(dimMatrix[1]);
        this.setMatrix(new double[row][column]);
        this.setRows(row);
        this.setColumns(column);
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                this.changeElementOfMatrix(i,j, onesElement);
            }
        }
        //this.id = this.staticID++;
        this.setID();
    }

    @Override
    public void matrixElementWiseMultiplication(Matrix B){
        if ((this.getRows()!=B.getRows()) | (this.getColumns()!=B.getColumns())){
            System.out.println("Can't perform Element wise multiplication as Dimension of two matrices doesn't match");
            return;
        }
        double[][] product = new double[this.getRows()][this.getColumns()];

        for(int i = 0; i<this.getRows(); i++){
            for (int j =0; j<this.getColumns(); j++){
                product[i][j] =  B.getElementOfMatrix(i,j);
            }
        }
        this.printMatrix(product);
    }

    @Override
    public void matrixMultiplicationWithScalar(double scalar){
        double[][] product = new double[this.getRows()][this.getColumns()];

        for(int i = 0; i<this.getRows(); i++){
            for (int j =0; j<this.getColumns(); j++){
                product[i][j] = scalar;
            }
        }
        this.printMatrix(product);
    }

    @Override
    public void changeElement(){
        System.out.println("Can't change element of a ones matrix");
    }

    public static void main(String[] args) {
        Matrix om = new OnesMatrix();
        om.inputMatrix();
        om.printMatrix();
        om.printMatrix(om.getTransposeMatrix());
        System.out.println(om.getId());
        System.out.println(om.getRows());
        System.out.println(om.getColumns());
        System.out.println(om.isSymmetric());
    }
}
