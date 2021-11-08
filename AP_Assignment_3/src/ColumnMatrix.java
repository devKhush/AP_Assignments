import java.util.Scanner;

public class ColumnMatrix extends RectangularMatrix{
    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter numbers of rows: ");
        int row = Integer.parseInt(sc.nextLine().trim());
        this.setMatrix(new double[row][1]);
        this.setRows(row);
        this.setColumns(1);
        for (int i=0; i<row; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<1; j++){
                double matrixElement = Double.parseDouble(rowInputArray[j]);
                this.changeElementOfMatrix(i,j , matrixElement);
                //this.matrix[i][j] = Double.parseDouble(rowInputArray[j]);
            }
        }
        //this.id = staticID;
        this.setID();
    }

    @Override
    public void getAllTypes(){
        System.out.println("Column Matrix");
        if (this.getRows()==this.getColumns()) {
            System.out.println("Square Matrix");
            System.out.println("Singleton Matrix");
            System.out.println("Diagonal Matrix");
            System.out.println("Scalar Matrix");
            if (this.getElementOfMatrix(0,0)==1){
                System.out.println("Ones matrix");
                System.out.println("Identity matrix");
            }
            else if (this.getElementOfMatrix(0,0)==0){
                System.out.println("Null matrix");
            }
        }
        else
            System.out.println("Rectangular Matrix");
    }

    public static void main(String[] args) {
        Matrix cm = new ColumnMatrix();
        cm.inputMatrix();
        System.out.println(cm.getId());
        System.out.println(cm.getRows());
        System.out.println(cm.getColumns());
        cm.printMatrix();

        System.out.println();
        Matrix cm1 = new ColumnMatrix();
        cm1.inputMatrix();
        System.out.println(cm1.getId());
        System.out.println(cm1.getRows());
        System.out.println(cm1.getColumns());
        cm1.printMatrix();
    }
}
