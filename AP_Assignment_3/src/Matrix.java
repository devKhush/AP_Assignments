import java.util.Arrays;

public class Matrix {
    protected int rows;
    protected int columns;
    protected double[][] matrix;
    protected int id;
    protected static int staticID=0;

    public Matrix(){
        staticID++;
    }

    public void getAllTypes(){
        System.out.println(this.getClass().getName());
        if (!this.getClass().getSuperclass().getName().equals("Matrix")){
            System.out.println(this.getClass().getSuperclass().getName());
        }
    }

    public double[][] calculateTranspose(){
        double[][] transpose = new double[this.columns][this.rows];

        for(int i=0; i<this.rows; i++){
            for (int j=0; j<this.columns; j++){
                transpose[j][i]=this.matrix[i][j];
            }
        }
        return transpose;
    }

    public double[][] getTransposeMatrix(){
        return this.calculateTranspose();
    }

    public String getType(){
        return this.getClass().getName();
    }

    public void printMatrix(){
        System.out.printf("[");
        int j;
        for (int i=0; i<this.rows;i++){
            if (i==0)
                System.out.printf(" [");
            else
                System.out.printf("  [");
            for (j=0; j<this.columns-1; j++){
                System.out.printf("%.2f, ",this.matrix[i][j]);
            }
            if (i==this.rows-1)
                System.out.printf("%.2f ] ]\n",this.matrix[i][this.columns-1]);
            else
                System.out.printf("%.2f ]\n",this.matrix[i][this.columns-1]);
        }
    }

    public void printMatrix(double[][] matrixInput){
        System.out.printf("[");
        int j;
        int row = matrixInput.length;
        int column = matrixInput[0].length;
        for (int i=0; i<row;i++){
            if (i==0)
                System.out.printf(" [");
            else
                System.out.printf("  [");
            for (j=0; j<column-1; j++){
                System.out.printf("%.2f, ",matrixInput[i][j]);
            }
            if (i==row-1)
                System.out.printf("%.2f ] ]\n",matrixInput[i][column-1]);
            else
                System.out.printf("%.2f ]\n",matrixInput[i][column-1]);
        }
    }

    public void setID(){
        this.id = this.staticID;
    }

    public void matrixAddition(Matrix B){
        if ((this.getRows()!=B.getRows()) | (this.getColumns()!=B.getColumns())){
            System.out.println("Can't perform addition as Dimension of two matrices doesn't match");
            return;
        }
        double[][] addition = new double[this.getRows()][this.getColumns()];

        for(int i = 0; i<this.getRows(); i++){
            for (int j =0; j<this.getColumns(); j++){
                addition[i][j] = this.getElementOfMatrix(i,j)+B.getElementOfMatrix(i,j);
            }
        }
        this.printMatrix(addition);
    }

    public void matrixSubtraction(Matrix B){
        if ((this.getRows()!=B.getRows()) | (this.getColumns()!=B.getColumns())){
            System.out.println("Can't perform subtraction as Dimension of two matrices doesn't match");
            return;
        }
        double[][] subtraction = new double[this.getRows()][this.getColumns()];

        for(int i = 0; i<this.getRows(); i++){
            for (int j =0; j<this.getColumns(); j++){
                subtraction[i][j] = this.getElementOfMatrix(i,j) - B.getElementOfMatrix(i,j);
            }
        }
        this.printMatrix(subtraction);
    }

    public void matrixMultiplication(Matrix B){
        if (this.getColumns()!=B.getRows()){
            System.out.println("Can't perform multiplication as the condition for matrix multiplication doesn't satisfy");
            return;
        }
        double[][] product = new double[this.getRows()][B.getColumns()];
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < B.getColumns(); j++) {
                product[i][j] = 0;
                for (int k = 0; k < this.getColumns(); k++)
                    product[i][j] += (this.getElementOfMatrix(i,k))*B.getElementOfMatrix(k,j);
            }
        }
        this.printMatrix(product);
    }

    public void matrixElementWiseMultiplication(Matrix B){
        if ((this.getRows()!=B.getRows()) | (this.getColumns()!=B.getColumns())){
            System.out.println("Can't perform Element wise multiplication as Dimension of two matrices doesn't match");
            return;
        }
        double[][] product = new double[this.getRows()][this.getColumns()];

        for(int i = 0; i<this.getRows(); i++){
            for (int j =0; j<this.getColumns(); j++){
                product[i][j] = this.getElementOfMatrix(i,j) * B.getElementOfMatrix(i,j);
            }
        }
        this.printMatrix(product);
    }

    public void matrixElementWiseDivision(Matrix B){
        if ((this.getRows()!=B.getRows()) | (this.getColumns()!=B.getColumns())){
            System.out.println("Can't perform Element wise division as Dimension of two matrices doesn't match");
            return;
        }
        double[][] product = new double[this.getRows()][this.getColumns()];

        for(int i = 0; i<this.getRows(); i++){
            for (int j =0; j<this.getColumns(); j++){
                product[i][j] = this.getElementOfMatrix(i,j) / B.getElementOfMatrix(i,j);
            }
        }
        this.printMatrix(product);
    }

    public void calculateRowWiseMean(int rowNumber){
        double sumOfRow=0;
        for (int j=0; j<this.getColumns(); j++){
            sumOfRow += this.getElementOfMatrix(rowNumber-1, j);
        }
        double mean = sumOfRow/this.getColumns();
        System.out.printf("Mean of Row no. %d of this matrix is %.2f\n",rowNumber,mean);
    }

    public void calculateColumnWiseMean(int columnNumber){
        double sumOfColumn =0;
        for (int i=0; i<this.getRows(); i++){
            sumOfColumn += this.getElementOfMatrix(i,columnNumber-1);
        }
        double mean = sumOfColumn/this.getRows();
        System.out.printf("Mean of Column no. %d of this matrix is %.2f\n",columnNumber,mean);
    }

    public void meanOfAllElements(){
        double sum=0;
        for(int i=0; i<this.getRows(); i++){
            for (int j=0; j<this.getColumns(); j++){
                sum+= this.getElementOfMatrix(i,j);
            }
        }
        double mean = sum/(this.getRows()*this.getColumns());
        System.out.printf("Mean of all the elements in this matrix is %.2f\n",mean);
    }


    public void inputMatrix(){}
    double getScalarElement(){
        return Double.MIN_VALUE;
    }
    public boolean isSymmetric(){
        return false;
    }
    double[] getDiagonalElements(){
        return new double[1];
    }
    void setDiagonalElements(double[] diagonalElements){}
    void changeDiagonalElement(int i, double value){ }
    public double getNullElement() {
        return 0;
    }
    public double getOnesElement() {
        return 1;
    }


    public int getColumns(){
        return this.columns;
    }
    public int getRows(){
        return this.rows;
    }
    public double[][] getMatrix(){
        return this.matrix;
    }
    public int getId(){
        return this.id;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
    public void setColumns(int columns){
        this.columns=columns;
    }
    public void changeElementOfMatrix(int i, int j, double element){
        this.matrix[i][j] = element;
    }
    public double getElementOfMatrix(int i, int j){
        return this.getMatrix()[i][j];
    }
}
