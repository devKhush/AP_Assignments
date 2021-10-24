public class Matrix {
    protected int rows;
    protected int columns;
    protected double[][] matrix;
    protected int id;
    protected static int staticID=0;

    public Matrix(){
        staticID++;
    }

    public void inputMatrix(){}

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

    public boolean isSymmetric(){return false;}
    double getScalarElement(){
        return 0;
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

}
