import java.util.Scanner;

public class RectangularMatrix extends Matrix{
//    private int rows;
//    private int columns;
//    private double[][] matrix;
//    private int id;

    @Override
    public void changeElement(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the row number to change element :");
        int i = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter the column number to change element :");
        int j = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter the new value :");
        double value = Double.parseDouble(sc.nextLine());
        this.changeElementOfMatrix(i,j,value);
    }

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Dimensions as <rows><space><columns>: ");
        String dimension = sc.nextLine().trim();
        String[] dimMatrix = dimension.split(" ");
        int row = Integer.parseInt(dimMatrix[0]);
        int column = Integer.parseInt(dimMatrix[1]);
        this.setMatrix(new double[row][column]);
        this.setRows(row);
        this.setColumns(column);
        for (int i=0; i<row; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<column; j++){
                double matrixElement = Double.parseDouble(rowInputArray[j]);
                this.changeElementOfMatrix(i,j , matrixElement);
//                this.matrix[i][j] = Double.parseDouble(rowInputArray[j]);
            }
        }
        //this.id = staticID;
        this.setID();
    }

//    @Override
//    public double[][] calculateTranspose(){
//        double[][] transpose = new double[this.rows][this.columns];
//
//        for(int i=0; i<this.rows; i++){
//            for (int j=0; j<this.columns; j++){
//                transpose[j][i]=this.matrix[i][j];
//            }
//        }
//        return transpose;
//    }
//
//    @Override
//    public double[][] getTransposeMatrix(){
//        return this.calculateTranspose();
//    }

    public static void main(String[] args) {
        Matrix rm = new RectangularMatrix();
        rm.inputMatrix();
        rm.printMatrix();
        System.out.println(rm.getRows());
        System.out.println(rm.getColumns());
        System.out.println(rm.getClass().getName());
        System.out.println(rm.getId());

        System.out.println();
        Matrix rm1 = new RectangularMatrix();
        rm1.inputMatrix();
        rm1.printMatrix();
        rm1.printMatrix(rm1.getTransposeMatrix());
        System.out.println(rm1.getRows());
        System.out.println(rm1.getColumns());
        System.out.println(rm1.getClass().getName());
        System.out.println(rm1.getId());
    }

}
