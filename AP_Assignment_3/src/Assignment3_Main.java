import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment3_Main {

    static double scalar;
    static boolean scalarAvailable = false;

    void showMean(){
        System.out.println("""
                9.1 Compute Row wise mean
                9.2 Compute Column wise mean
                9.3 Compute Mean of all the Elements
                """);
    }

    void showAllLabelTypesOfMatricesAvailable(){
            System.out.println("""
                15.1 Rectangular Matrix
                15.2 Row Matrix
                15.3 Column Matrix
                15.4 Square Matrix
                15.5 Symmetric Matrix
                15.6 Skew-symmetric Matrix
                15.7 Upper-triangular Matrix
                15.8 Lower-triangular Matrix
                15.9 Singular Matrix
                15.11 Diagonal Matrix
                15.12 Scalar Matrix
                15.13 Identity Matrix
                15.14 Singleton Matrix
                15.15 Ones Matrix
                15.16 Null Matrix""");
    }

    void printAllOperationOnMatrices(){
        System.out.println("""
                5.1 Addition of two Matrices
                5.2 Subtraction of two Matrices
                5.3 Multiplication of two Matrices
                5.4 Division of two Matrices""");
    }

    void printAllElementWiseOperationOnMatrix(){
        System.out.println("6.1 Matrix Element wise Addition");
        System.out.println("6.2 Matrix Element wise Addition by a scalar");
        System.out.println("6.3 Matrix Element wise Subtraction");
        System.out.println("6.4 Matrix Element wise Subtraction by a scalar");
        System.out.println("6.5 Matrix Element wise Multiplication with another Matrix");
        System.out.println("6.6 Matrix Element wise Multiplication with a scalar");
        System.out.println("6.7 Matrix Element wise Division with another Matrix");
        System.out.println("6.8 Matrix Element wise Division with a scalar");
    }

    void printInstructions(){
        System.out.println("""
                All options available in the Main thread are :
                
                1. Take Any Matrices as input and label them with appropriate matrix-types.
                2. Create matrices of requested matrix-types and label them with appropriate matrix-types.
                3. Change the elements of a Matrix.
                4. Display all the Matrix-type labels of a Requested matrix.
                5. Perform addition, subtraction, multiplication & division on Matrices.
                6. Perform element-wise operations on Matrices.
                7. Transpose matrices.
                8. Inverse matrices.
                9. Compute means: row-wise mean, column-wise mean, mean of all the elements in Matrices.
                10. Compute determinants of Matrices.
                11. Use singleton matrices as scalars in Operations 6.
                12. Compute A + A' for a matrix A (Matrix plus its Transpose)
                13. Compute Eigen Vectors and Values.
                14. Solve sets of linear equations using Matrices.
                15. Retrieve all the existing Matrices having requested matrix-type labels.
                16. To exit the program""");
    }

    void printAllMatricesAvailable(){
        System.out.println("""
                2.1 Rectangular Matrix
                2.2 Row Matrix
                2.3 Column Matrix
                2.4 Square Matrix
                2.5 Symmetric Matrix
                2.6 Skew-symmetric Matrix
                2.7 Upper-triangular Matrix
                2.8 Lower-triangular Matrix
                2.9 Singular Matrix
                2.11 Diagonal Matrix
                2.12 Scalar Matrix
                2.13 Identity Matrix
                2.14 Singleton Matrix
                2.15 Ones Matrix
                2.16 Null Matrix""");
    }

    boolean checkSingletonMatrix(int row, int column){
        return (row==1) && (column==1);
    }

    boolean checkRowMatrix(int row, int column, double[][] matrix){
        return (row==1) && (column!=1);
    }

    boolean checkColumnMatrix(int row, int column, double[][] matrix){
        return (row!=1) && (column==1);
    }

    boolean checkOnesMatrix(int row, int column, double[][] matrix){
        boolean isOnesMatrix = true;
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                if (matrix[i][j] != 1) {
                    isOnesMatrix = false;
                    break;
                }
            }
        }
        return isOnesMatrix;
    }

    boolean checkNullMatrix(int row, int column, double[][] matrix){
        boolean isNullMatrix = true;
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                if (matrix[i][j] != 0) {
                    isNullMatrix = false;
                    break;
                }
            }
        }
        return isNullMatrix;
    }

    boolean checkRectangularMatrix(int row, int column, double[][] matrix){
        return (row!=column);
    }

    boolean checkSquareMatrix(int row, int column, double[][] matrix){
        return (row==column);
    }

    boolean checkDiagonalMatrix(int row, int column, double[][] matrix){
        boolean isDiagonal = true;
        for (int i=0; i<row; i++){
            for (int j=0; j< column; j++){
                if ((i != j) && (matrix[i][j] != 0)) {
                    isDiagonal = false;
                    break;
                }
            }
        }
        return isDiagonal;
    }

    boolean checkIdentityMatrix(int row, int column, double[][] matrix){
        boolean isIdentity = true;
        for (int i=0; i<row; i++){
            for (int j=0; j< column; j++){
                if ((i != j) && (matrix[i][j] != 0)) {
                    isIdentity = false;
                    break;
                }
                if ((i==j) && (matrix[i][j]!=1)){
                    isIdentity = false;
                    break;
                }
            }
        }
        return isIdentity;
    }

    boolean checkScalarMatrix(int row, int column, double[][] matrix){
        boolean isScalar = true;
        double scalarElement = matrix[0][0];
        for (int i=0; i<row; i++){
            for (int j=0; j< column; j++){
                if ((i!=j) && (matrix[i][j]!=0))
                    isScalar=false;
                if ((i==j) && (matrix[i][j]!=scalarElement))
                    isScalar= false;
            }
        }
        return isScalar;
    }

    boolean checkUpperTraingularMatrix(int row, int column, double[][] matrix){
        boolean isUpperTriangularMatrix = true;
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                if ((i > j) && (matrix[i][j] != 0)) {
                    isUpperTriangularMatrix = false;
                    break;
                }
            }
        }
        return isUpperTriangularMatrix;
    }

    boolean checkLowerTraingularMatrix(int row, int column, double[][] matrix){
        boolean isLowerTraingularMatrix = true;
        for (int i=0; i<row; i++){
            for (int j=0; j<column; j++){
                if ((i < j) && (matrix[i][j] != 0)) {
                    isLowerTraingularMatrix = false;
                    break;
                }
            }
        }
        return isLowerTraingularMatrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Assignment3_Main a3 = new Assignment3_Main();

        Map<Integer, Matrix> allMatricesMade = new LinkedHashMap<>();
        int option;
        a3.printInstructions();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        while(true){
            System.out.println();
            System.out.println("You're Currently in Main thread");
            System.out.printf("Enter option number (else Enter '0' for repeating all available options)\n> ");
            option = Integer.parseInt(sc.nextLine().trim());

            if (option==0) {
                a3.printInstructions();
            }

            else if (option==1){
                System.out.printf("Enter the number of rows in the matrix :");
                int row = Integer.parseInt(sc.nextLine().trim());
                System.out.printf("Enter the number of column in the matrix :");
                int column = Integer.parseInt(sc.nextLine().trim());
                double[][] matrix = new double[row][column];
                for (int i=0; i<row; i++){
                    System.out.printf("Enter %dth row input (Space separated): ",i);
                    String rowInput = sc.nextLine().trim();
                    String[] rowInputArray = rowInput.split(" ");
                    for (int j=0; j<column; j++){
                        double matrixElement = Double.parseDouble(rowInputArray[j]);
                        matrix[i][j] = matrixElement;
                    }
                }

                if (a3.checkSingletonMatrix(row, column)){
                    Matrix madeAsSingletonMatrix = new SingletonMatrix();
                    madeAsSingletonMatrix.setRows(1);
                    madeAsSingletonMatrix.setColumns(1);
                    madeAsSingletonMatrix.setMatrix(matrix);
                    madeAsSingletonMatrix.setElementInSingletonMatrix(madeAsSingletonMatrix.getElementOfMatrix(0,0));
                    madeAsSingletonMatrix.setID();
                    System.out.println("\nThis Matrix is made Singleton Matrix in Memory = ");
                    madeAsSingletonMatrix.printMatrix();
                    System.out.println("ID = "+madeAsSingletonMatrix.getId());
                    allMatricesMade.put(madeAsSingletonMatrix.getId(), madeAsSingletonMatrix);
                }

                else if (a3.checkRowMatrix(row,column,matrix)){
                    if (a3.checkOnesMatrix(row,column,matrix)){
                        Matrix madeAsOnesMatrix = new OnesMatrix();
                        madeAsOnesMatrix.setRows(row);
                        madeAsOnesMatrix.setColumns(column);
                        madeAsOnesMatrix.setMatrix(matrix);
                        madeAsOnesMatrix.setID();
                        System.out.println("\nThis Matrix is made Ones Matrix in Memory = ");
                        madeAsOnesMatrix.printMatrix();
                        System.out.println("ID = "+madeAsOnesMatrix.getId());
                        allMatricesMade.put(madeAsOnesMatrix.getId(), madeAsOnesMatrix);
                    }
                    else if (a3.checkNullMatrix(row,column,matrix)){
                        Matrix madeAsNullMatrix = new NullMatrix();
                        madeAsNullMatrix.setRows(row);
                        madeAsNullMatrix.setColumns(column);
                        madeAsNullMatrix.setMatrix(matrix);
                        madeAsNullMatrix.setID();
                        System.out.println("\nThis Matrix is made Null Matrix in Memory = ");
                        madeAsNullMatrix.printMatrix();
                        System.out.println("ID = "+madeAsNullMatrix.getId());
                        allMatricesMade.put(madeAsNullMatrix.getId(), madeAsNullMatrix);
                    }
                    else{
                        Matrix madeAsRowMatrix = new RowMatrix();
                        madeAsRowMatrix.setRows(row);
                        madeAsRowMatrix.setColumns(column);
                        madeAsRowMatrix.setMatrix(matrix);
                        madeAsRowMatrix.setID();
                        System.out.println("\nThis Matrix is made Row Matrix in Memory = ");
                        madeAsRowMatrix.printMatrix();
                        System.out.println("ID = "+madeAsRowMatrix.getId());
                        allMatricesMade.put(madeAsRowMatrix.getId(), madeAsRowMatrix);
                    }
                }

                else if (a3.checkColumnMatrix(row,column,matrix)){
                    if (a3.checkOnesMatrix(row,column,matrix)){
                        Matrix madeAsOnesMatrix = new OnesMatrix();
                        madeAsOnesMatrix.setRows(row);
                        madeAsOnesMatrix.setColumns(column);
                        madeAsOnesMatrix.setMatrix(matrix);
                        madeAsOnesMatrix.setID();
                        System.out.println("\nThis Matrix is made Ones Matrix in Memory = ");
                        madeAsOnesMatrix.printMatrix();
                        System.out.println("ID = "+madeAsOnesMatrix.getId());
                        allMatricesMade.put(madeAsOnesMatrix.getId(), madeAsOnesMatrix);
                    }
                    else if (a3.checkNullMatrix(row,column,matrix)){
                        Matrix madeAsNullMatrix = new NullMatrix();
                        madeAsNullMatrix.setRows(row);
                        madeAsNullMatrix.setColumns(column);
                        madeAsNullMatrix.setMatrix(matrix);
                        madeAsNullMatrix.setID();
                        System.out.println("\nThis Matrix is made Null Matrix in Memory = ");
                        madeAsNullMatrix.printMatrix();
                        System.out.println("ID = "+madeAsNullMatrix.getId());
                        allMatricesMade.put(madeAsNullMatrix.getId(), madeAsNullMatrix);
                    }
                    else{
                        Matrix madeAsColumnMatrix = new ColumnMatrix();
                        madeAsColumnMatrix.setRows(row);
                        madeAsColumnMatrix.setColumns(column);
                        madeAsColumnMatrix.setMatrix(matrix);
                        madeAsColumnMatrix.setID();
                        System.out.println("\nThis Matrix is made Column Matrix in Memory = ");
                        madeAsColumnMatrix.printMatrix();
                        System.out.println("ID = "+madeAsColumnMatrix.getId());
                        allMatricesMade.put(madeAsColumnMatrix.getId(), madeAsColumnMatrix);
                    }
                }

                else if(a3.checkOnesMatrix(row,column,matrix)){
                    Matrix madeAsOnesMatrix = new OnesMatrix();
                    madeAsOnesMatrix.setRows(row);
                    madeAsOnesMatrix.setColumns(column);
                    madeAsOnesMatrix.setMatrix(matrix);
                    madeAsOnesMatrix.setID();
                    System.out.println("\nThis Matrix is made Ones Matrix in Memory = ");
                    madeAsOnesMatrix.printMatrix();
                    System.out.println("ID = "+madeAsOnesMatrix.getId());
                    allMatricesMade.put(madeAsOnesMatrix.getId(), madeAsOnesMatrix);
                }

                else if (a3.checkNullMatrix(row,column,matrix)){
                    Matrix madeAsNullMatrix = new NullMatrix();
                    madeAsNullMatrix.setRows(row);
                    madeAsNullMatrix.setColumns(column);
                    madeAsNullMatrix.setMatrix(matrix);
                    madeAsNullMatrix.setID();
                    System.out.println("\nThis Matrix is made Null Matrix in Memory = ");
                    madeAsNullMatrix.printMatrix();
                    System.out.println("ID = "+madeAsNullMatrix.getId());
                    allMatricesMade.put(madeAsNullMatrix.getId(), madeAsNullMatrix);
                }

                else if (a3.checkRectangularMatrix(row,column,matrix)){
                    Matrix madeAsRectangularMatrix = new RectangularMatrix();
                    madeAsRectangularMatrix.setRows(row);
                    madeAsRectangularMatrix.setColumns(column);
                    madeAsRectangularMatrix.setMatrix(matrix);
                    madeAsRectangularMatrix.setID();
                    System.out.println("\nThis Matrix is made Rectangular Matrix in Memory = ");
                    madeAsRectangularMatrix.printMatrix();
                    System.out.println("ID = "+madeAsRectangularMatrix.getId());
                    allMatricesMade.put(madeAsRectangularMatrix.getId(),madeAsRectangularMatrix);
                }

                else if (a3.checkSquareMatrix(row,column,matrix)){
                    Matrix squareForTesting = new SquareMatrix();
                    squareForTesting.setRows(row);
                    squareForTesting.setColumns(column);
                    squareForTesting.setMatrix(matrix);

                    if(squareForTesting.isSkewSymmetric()){
                        Matrix madeAsSkewSymmetricMatrix = new SkewSymmetricMatrix();
                        madeAsSkewSymmetricMatrix.setRows(row);
                        madeAsSkewSymmetricMatrix.setColumns(column);
                        madeAsSkewSymmetricMatrix.setMatrix(matrix);
                        madeAsSkewSymmetricMatrix.setID();
                        System.out.println("\nThis Matrix is made Skew Symmetric Matrix in Memory = ");
                        madeAsSkewSymmetricMatrix.printMatrix();
                        System.out.println("ID = "+madeAsSkewSymmetricMatrix.getId());
                        allMatricesMade.put(madeAsSkewSymmetricMatrix.getId(),madeAsSkewSymmetricMatrix);
                    }

                    else if (squareForTesting.getDeterminant()==0){
                        Matrix madeAsSingularMatrix = new SingularMatrix();
                        madeAsSingularMatrix.setRows(row);
                        madeAsSingularMatrix.setColumns(column);
                        madeAsSingularMatrix.setMatrix(matrix);
                        madeAsSingularMatrix.setID();
                        System.out.println("\nThis Matrix is made Singular Matrix in Memory = ");
                        madeAsSingularMatrix.printMatrix();
                        System.out.println("ID = "+madeAsSingularMatrix.getId());
                        allMatricesMade.put(madeAsSingularMatrix.getId(),madeAsSingularMatrix);
                    }

                    else if (a3.checkDiagonalMatrix(row,column,matrix)){
                        if (a3.checkIdentityMatrix(row,column,matrix)){
                            Matrix madeAsIdentityMatrix = new IdentityMatrix();
                            madeAsIdentityMatrix.setRows(row);
                            madeAsIdentityMatrix.setColumns(column);
                            madeAsIdentityMatrix.setMatrix(matrix);
                            madeAsIdentityMatrix.setID();
                            System.out.println("\nThis Matrix is made Identity matrix in memory = ");
                            madeAsIdentityMatrix.printMatrix();
                            System.out.println("ID = "+madeAsIdentityMatrix.getId());
                            allMatricesMade.put(madeAsIdentityMatrix.getId(),madeAsIdentityMatrix);
                        }
                        else if (a3.checkScalarMatrix(row,column,matrix)){
                            Matrix madeAsScalarMatrix = new ScalarMatrix();
                            madeAsScalarMatrix.setRows(row);
                            madeAsScalarMatrix.setColumns(column);
                            madeAsScalarMatrix.setMatrix(matrix);
                            madeAsScalarMatrix.setID();
                            madeAsScalarMatrix.setScalarElement(matrix[0][0]);
                            //System.out.println("scalar = "+ madeAsScalarMatrix.getScalarElement());
                            System.out.println("\nThis Matrix is made Scalar matrix in memory = ");
                            madeAsScalarMatrix.printMatrix();
                            System.out.println("ID = "+madeAsScalarMatrix.getId());
                            allMatricesMade.put(madeAsScalarMatrix.getId(),madeAsScalarMatrix);
                        }
                        else{
                            Matrix madeAsDiagonalMatrix = new DiagonalMatrix();
                            double[] diagonalElements = new double[row];
                            for (int i=0; i<row; i++){
                                diagonalElements[i] = matrix[i][i];
                            }
                            madeAsDiagonalMatrix.setRows(row);
                            madeAsDiagonalMatrix.setColumns(column);
                            madeAsDiagonalMatrix.setMatrix(matrix);
                            madeAsDiagonalMatrix.setID();
                            madeAsDiagonalMatrix.setDiagonalElements(diagonalElements);
                            //System.out.println(Arrays.toString(diagonalElements));
                            System.out.println("\nThis Matrix is made Diagonal matrix in memory = ");
                            madeAsDiagonalMatrix.printMatrix();
                            System.out.println("ID = "+madeAsDiagonalMatrix.getId());
                            allMatricesMade.put(madeAsDiagonalMatrix.getId(),madeAsDiagonalMatrix);
                        }
                    }

                    else if(a3.checkUpperTraingularMatrix(row,column,matrix)){
                        Matrix madeAsUpperTraingularMatrix = new UpperTriangularMatrix();
                        madeAsUpperTraingularMatrix.setRows(row);
                        madeAsUpperTraingularMatrix.setColumns(column);
                        madeAsUpperTraingularMatrix.setMatrix(matrix);
                        madeAsUpperTraingularMatrix.setID();
                        System.out.println("\nThis Matrix is made Upper Triangular Matrix in Memory = ");
                        madeAsUpperTraingularMatrix.printMatrix();
                        System.out.println("ID = "+madeAsUpperTraingularMatrix.getId());
                        allMatricesMade.put(madeAsUpperTraingularMatrix.getId(),madeAsUpperTraingularMatrix);
                    }

                    else if(a3.checkLowerTraingularMatrix(row,column,matrix)){
                        Matrix madeAsLowerTraingularMatrix = new LowerTriangularMatrix();
                        madeAsLowerTraingularMatrix.setRows(row);
                        madeAsLowerTraingularMatrix.setColumns(column);
                        madeAsLowerTraingularMatrix.setMatrix(matrix);
                        madeAsLowerTraingularMatrix.setID();
                        System.out.println("\nThis Matrix is made Lower Triangular Matrix in Memory = ");
                        madeAsLowerTraingularMatrix.printMatrix();
                        System.out.println("ID = "+madeAsLowerTraingularMatrix.getId());
                        allMatricesMade.put(madeAsLowerTraingularMatrix.getId(),madeAsLowerTraingularMatrix);
                    }

                    else if (squareForTesting.isSymmetric()){
                        Matrix madeAsSymmetricMatrix = new SymmetricMatrix();
                        madeAsSymmetricMatrix.setRows(row);
                        madeAsSymmetricMatrix.setColumns(column);
                        madeAsSymmetricMatrix.setMatrix(matrix);
                        madeAsSymmetricMatrix.setID();
                        System.out.println("\nThis Matrix is made Symmetric Matrix in Memory = ");
                        madeAsSymmetricMatrix.printMatrix();
                        System.out.println("ID = "+madeAsSymmetricMatrix.getId());
                        allMatricesMade.put(madeAsSymmetricMatrix.getId(),madeAsSymmetricMatrix);
                    }

                    else{
                        Matrix madeAsSquareMatrix = new SquareMatrix();
                        madeAsSquareMatrix.setRows(row);
                        madeAsSquareMatrix.setColumns(column);
                        madeAsSquareMatrix.setMatrix(matrix);
                        madeAsSquareMatrix.setID();
                        System.out.println("\nThis Matrix is made Square Matrix in Memory = ");
                        madeAsSquareMatrix.printMatrix();
                        System.out.println("ID = "+madeAsSquareMatrix.getId());
                        allMatricesMade.put(madeAsSquareMatrix.getId(),madeAsSquareMatrix);
                    }
                }
            }

            else if (option==2){
                a3.printAllMatricesAvailable();
                System.out.println();
                System.out.printf("Enter ID of the Matrix to be made from above :");
                double decimalIdOfMatrix = Double.parseDouble(sc.nextLine().trim());
                if (decimalIdOfMatrix==2.1){
                    Matrix mat = new RectangularMatrix();
                    boolean isMade = mat.inputMatrix();
                    if (isMade) {
                        System.out.println();
                        System.out.println("Matrix = ");
                        mat.printMatrix();
                        System.out.println("ID = " + mat.getId());
                        allMatricesMade.put(mat.getId(), mat);
                    }
                }
                else if (decimalIdOfMatrix==2.2){
                    Matrix mat = new RowMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.3){
                    Matrix mat = new ColumnMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.4){
                    Matrix mat = new SquareMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.5){
                    Matrix mat = new SymmetricMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.6){
                    Matrix mat = new SkewSymmetricMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.7){
                    Matrix mat = new UpperTriangularMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.8){
                    Matrix mat = new LowerTriangularMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.9){
                    Matrix mat = new SingularMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.11){
                    Matrix mat = new DiagonalMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.12){
                    Matrix mat = new ScalarMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.13){
                    Matrix mat = new IdentityMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.14){
                    Matrix mat = new SingletonMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.15){
                    Matrix mat = new OnesMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else if (decimalIdOfMatrix==2.16){
                    Matrix mat = new NullMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
                }
                else{
                    System.out.println("Invalid option");
                }
            }

            else if (option==3){
                System.out.printf("Enter the ID of the matrix to change its element :");
                int id = Integer.parseInt(sc.nextLine().trim());
                Matrix toBeEdited = allMatricesMade.get(id);
                System.out.println("NOTE : ROW NUMBER AND COLUMN NUMBER STARTS FROM 0 and ENDS WITH M-1 and N-1 FOR A MxN MATRIX");
                toBeEdited.changeElement();
                System.out.println();
                System.out.println("Matrix = ");
                toBeEdited.printMatrix();
                System.out.println("ID = "+toBeEdited.getId());
            }

            else if (option==4){
                System.out.printf("Enter the ID of the matrix to display all its label :");
                int id = Integer.parseInt(sc.nextLine().trim());
                Matrix toDisplayLabel = allMatricesMade.get(id);
                System.out.println("\nAll label of this matrix are: ");
                toDisplayLabel.getAllTypes();
            }

            else if (option==5){
                a3.printAllOperationOnMatrices();
                System.out.println();
                System.out.printf("Enter the ID of the operation to be perform from above :");
                double opID = Double.parseDouble(sc.nextLine().trim());
                if (opID==5.1){
                    System.out.println("Addition of two Matrices A and B is : A + B");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    System.out.printf("Enter ID of matrix B :");
                    int idB = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    Matrix B = allMatricesMade.get(idB);
                    System.out.println("\nResult = ");
                    A.matrixAddition(B,false);
                }
                else if (opID==5.2){
                    System.out.println("Subtraction of two Matrices A and B is : A - B");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    System.out.printf("Enter ID of matrix B :");
                    int idB = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    Matrix B = allMatricesMade.get(idB);
                    System.out.println("\nResult = ");
                    A.matrixSubtraction(B);
                }
                else if (opID==5.3){
                    System.out.println("Multiplication of two Matrices A and B is : A * B");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    System.out.printf("Enter ID of matrix B :");
                    int idB = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    Matrix B = allMatricesMade.get(idB);
                    System.out.println("\nResult = ");
                    A.matrixMultiplicationWithMatrix(B);
                }
                else if (opID==5.4){
                    System.out.println("Division of two Matrices A and B is : A/B = A * inv(B)");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    System.out.printf("Enter ID of matrix B :");
                    int idB = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    Matrix B = allMatricesMade.get(idB);
                    System.out.println("\nResult = ");
                    A.matrixDivisionWithMatrix(B);
                }
                else{
                    System.out.println("Invalid option");
                }
            }

            else if (option==6){
                a3.printAllElementWiseOperationOnMatrix();
                System.out.println();
                System.out.printf("Enter the ID of the operation to be perform from above :");
                double opID = Double.parseDouble(sc.nextLine().trim());

                if (opID==6.1){
                    System.out.println("Element wise Addition of two Matrices A and B is : A + B");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    System.out.printf("Enter ID of matrix B :");
                    int idB = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    Matrix B = allMatricesMade.get(idB);
                    System.out.println("\nResult = ");
                    A.matrixAddition(B,false);
                }
                else if (opID==6.2){
                    System.out.println("Element wise Addition of a matrix, A by a scalar, k is : A[i][j]+k  for every i and j");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    if (scalarAvailable){
                        System.out.printf("Whether to use previous Singleton Matrix as scalar here? (Yes or No) :");
                        String answer = sc.nextLine().trim();
                        if (answer.equalsIgnoreCase("yes")){
                            System.out.println("\nResult = ");
                            A.matrixAdditionWithScalar(scalar);
                        }
                        else if (answer.equalsIgnoreCase("no")){
                            System.out.printf("Enter the scalar :");
                            double newScalar = Double.parseDouble(sc.nextLine().trim());
                            System.out.println("\nResult = ");
                            A.matrixAdditionWithScalar(newScalar);
                        }
                    }
                    else{
                        System.out.printf("Enter the scalar :");
                        double newScalar = Double.parseDouble(sc.nextLine().trim());
                        System.out.println("\nResult = ");
                        A.matrixAdditionWithScalar(newScalar);
                    }
                }
                else if (opID==6.3){
                    System.out.println("Element wise Subtraction of two Matrices A and B is : A - B");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    System.out.printf("Enter ID of matrix B :");
                    int idB = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    Matrix B = allMatricesMade.get(idB);
                    System.out.println("\nResult = ");
                    A.matrixSubtraction(B);
                }
                else if (opID==6.4){
                    System.out.println("Element wise Subtraction of a matrix, A by a scalar, k is : A[i][j]-k  for every i and j");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    if (scalarAvailable){
                        System.out.printf("Whether to use previous Singleton Matrix as scalar here? (Yes or No) :");
                        String answer = sc.nextLine().trim();
                        if (answer.equalsIgnoreCase("yes")){
                            System.out.println("\nResult = ");
                            A.matrixSubtractionWithScalar(scalar);
                        }
                        else if (answer.equalsIgnoreCase("no")){
                            System.out.printf("Enter the scalar :");
                            double newScalar = Double.parseDouble(sc.nextLine().trim());
                            System.out.println("\nResult = ");
                            A.matrixSubtractionWithScalar(newScalar);
                        }
                    }
                    else{
                        System.out.printf("Enter the scalar :");
                        double newScalar = Double.parseDouble(sc.nextLine().trim());
                        System.out.println("\nResult = ");
                        A.matrixSubtractionWithScalar(newScalar);
                    }
                }
                else if (opID==6.5){
                    System.out.println("Element wise Multiplication of two Matrices A and B is : A[i][j] * B[i][j]  for every i and j");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    System.out.printf("Enter ID of matrix B :");
                    int idB = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    Matrix B = allMatricesMade.get(idB);
                    System.out.println("\nResult = ");
                    A.matrixElementWiseMultiplication(B);
                }
                else if (opID==6.6){
                    System.out.println("Element wise Multiplication of a matrix, A by a scalar, k is : A[i][j]*k  for every i and j");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    if (scalarAvailable){
                        System.out.printf("Whether to use previous Singleton Matrix as scalar here? (Yes or No) :");
                        String answer = sc.nextLine().trim();
                        if (answer.equalsIgnoreCase("yes")){
                            System.out.println("\nResult = ");
                            A.matrixMultiplicationWithScalar(scalar);
                        }
                        else if (answer.equalsIgnoreCase("no")){
                            System.out.printf("Enter the scalar :");
                            double newScalar = Double.parseDouble(sc.nextLine().trim());
                            System.out.println("\nResult = ");
                            A.matrixMultiplicationWithScalar(newScalar);
                        }
                    }
                    else{
                        System.out.printf("Enter the scalar :");
                        double newScalar = Double.parseDouble(sc.nextLine().trim());
                        System.out.println("\nResult = ");
                        A.matrixMultiplicationWithScalar(newScalar);
                    }
                }
                else if (opID==6.7){
                    System.out.println("Element wise Division of two Matrices A and B is : A[i][j] / B[i][j]  for every i and j");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    System.out.printf("Enter ID of matrix B :");
                    int idB = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    Matrix B = allMatricesMade.get(idB);
                    System.out.println("\nResult = ");
                    A.matrixElementWiseDivision(B);
                }
                else if (opID==6.8){
                    System.out.println("Element wise Division of a matrix, A by a scalar, k is : A[i][j]/k  for every i and j");
                    System.out.printf("Enter ID of matrix A :");
                    int idA = Integer.parseInt(sc.nextLine().trim());
                    Matrix A = allMatricesMade.get(idA);
                    if (scalarAvailable){
                        System.out.printf("Whether to use previous Singleton Matrix as scalar here? (Yes or No) :");
                        String answer = sc.nextLine().trim();
                        if (answer.equalsIgnoreCase("yes")){
                            System.out.println("\nResult = ");
                            A.matrixDivisionWithScalar(scalar);
                        }
                        else if (answer.equalsIgnoreCase("no")){
                            System.out.printf("Enter the scalar :");
                            double newScalar = Double.parseDouble(sc.nextLine().trim());
                            System.out.println("\nResult = ");
                            A.matrixDivisionWithScalar(newScalar);
                        }
                    }
                    else{
                        System.out.printf("Enter the scalar :");
                        double newScalar = Double.parseDouble(sc.nextLine().trim());
                        System.out.println("\nResult = ");
                        A.matrixDivisionWithScalar(newScalar);
                    }
                }
                else{
                    System.out.println("Invalid option");
                }
            }

            else if (option==7){
                System.out.printf("Enter the ID of the matrix to display its Transpose :");
                int id = Integer.parseInt(sc.nextLine().trim());
                Matrix toDisplayTranspose = allMatricesMade.get(id);
                System.out.println("\nThis Matrix is = ");
                toDisplayTranspose.printMatrix();
                System.out.println("Transpose of this matrix is = ");
                toDisplayTranspose.printMatrix(toDisplayTranspose.getTransposeMatrix());
            }

            else if (option==8){
                System.out.printf("Enter the ID of the matrix to display its Inverse :");
                int id = Integer.parseInt(sc.nextLine().trim());
                Matrix toDisplayInverse = allMatricesMade.get(id);
                System.out.println("\nThis Matrix is = ");
                toDisplayInverse.printMatrix();
                System.out.println("Inverse of this matrix is = ");
                toDisplayInverse.getInverse(false);
            }

            else if (option==9){
                a3.showMean();
                System.out.printf("Enter the ID of the operation to be perform from above :");
                double opID = Double.parseDouble(sc.nextLine().trim());
                if (opID==9.1) {
                    System.out.printf("Enter the ID of the matrix to display its Row-wise Mean :");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    Matrix toDisplayMean = allMatricesMade.get(id);
                    System.out.println("\nThis Matrix is = ");
                    toDisplayMean.printMatrix();
                    toDisplayMean.calculateRowWiseMean();
                }
                else if (opID==9.2) {
                    System.out.printf("Enter the ID of the matrix to display its Column-wise Mean :");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    Matrix toDisplayMean = allMatricesMade.get(id);
                    System.out.println("\nThis Matrix is = ");
                    toDisplayMean.printMatrix();
                    toDisplayMean.calculateColumnWiseMean();
                }
                else if (opID==9.3) {
                    System.out.printf("Enter the ID of the matrix to display its Mean of all the elements :");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    Matrix toDisplayMean = allMatricesMade.get(id);
                    System.out.println("\nThis Matrix is = ");
                    toDisplayMean.printMatrix();
                    toDisplayMean.meanOfAllElements();
                }
                else{
                    System.out.println("Wrong option");
                }
            }

            else if (option==10){
                System.out.printf("Enter the ID of the matrix to compute its Determinant :");
                int id = Integer.parseInt(sc.nextLine().trim());
                Matrix toDisplayDeterminant = allMatricesMade.get(id);
                System.out.println("\nThis Matrix is = ");
                toDisplayDeterminant.printMatrix();
                if (toDisplayDeterminant.getDeterminant()!=Double.MIN_VALUE)
                    System.out.printf("\nDeterminant of this matrix is %.2f\n",toDisplayDeterminant.getDeterminant());
            }

            else if (option==11){
                System.out.printf("Enter the ID of the Singleton matrix to use as scalar :");
                int id = Integer.parseInt(sc.nextLine().trim());
                Matrix toUseAsScalar = allMatricesMade.get(id);
                if ((toUseAsScalar.getRows()!=1) | (toUseAsScalar.getColumns()!=1)){
                    System.out.println("This Matrix must be Scalar matrix\nTry again with Singleton Matrix");
                }
                else{
                    scalarAvailable = true;
                    scalar = toUseAsScalar.getScalarElement();
                    System.out.println("Using Matrix = [ ["+toUseAsScalar.getScalarElement()+"] ] as scalar");
                }
            }

            else if (option==12){
                System.out.printf("Enter the ID of the Matrix, A to compute A + A' (matrix plus its transpose) :");
                int id = Integer.parseInt(sc.nextLine().trim());
                Matrix computeMatrixPlusItsTranspose = allMatricesMade.get(id);
                if (computeMatrixPlusItsTranspose.getRows()!= computeMatrixPlusItsTranspose.getColumns()){
                    System.out.println("Can't perform as this Matrix is not a Square Matrix");
                }
                else {
                    System.out.println("\nA = ");
                    computeMatrixPlusItsTranspose.printMatrix();
                    System.out.println("A' (Transpose) = ");
                    computeMatrixPlusItsTranspose.printMatrix(computeMatrixPlusItsTranspose.getTransposeMatrix());
                    System.out.println("\nA + A' (Matrix plus its Transpose) = ");
                    computeMatrixPlusItsTranspose.matrixPlusItsTranspose();
                }
            }

            else if (option==13){
                // Compute Eigen Vectors and values. To be done later. Not done yet
                System.out.printf("Enter the ID Matrix to find its Eigen value and Eigen Vectors :");
                int id = Integer.parseInt(sc.nextLine().trim());
                Matrix toFindEigenValueAndVector = allMatricesMade.get(id);
                if (toFindEigenValueAndVector.getRows()!=toFindEigenValueAndVector.getColumns()){
                    System.out.println("\nThe Matrix must be square for finding its Eigen values and vectors");
                }
                else{
                    toFindEigenValueAndVector.getEigenValues();
                    toFindEigenValueAndVector.getEigenVectors();
                }
            }

            else if(option==14){
                System.out.println("Solving sets of linear equations using matrices involves solving  \nA.x = B   for x,  where A is a Square matrix and B is a Column matrix");
                System.out.printf("Enter the ID of Matrix A :");
                int idA = Integer.parseInt(sc.nextLine().trim());
                System.out.printf("Enter the ID of Matrix B :");
                int idB = Integer.parseInt(sc.nextLine().trim());
                Matrix A = allMatricesMade.get(idA);
                Matrix B = allMatricesMade.get(idB);
                System.out.println("\nSolution of A.x = B for Matrix x =  ");
                A.solveLinearEquation(B);
            }

            else if (option==15){
                a3.showAllLabelTypesOfMatricesAvailable();
                System.out.println();
                System.out.println("To Retrieve all the existing matrices having requested matrix-type labels");
                System.out.printf("Enter the option ID from above :");
                double optID = Double.parseDouble(sc.nextLine().trim());

                if (optID==15.1){
                    System.out.println("Available Rectangular Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("RectangularMatrix")||currentMatrix.getClass().getName().equals("RowMatrix")||currentMatrix.getClass().getName().equals("ColumnMatrix")||currentMatrix.getClass().getName().equals("NullMatrix")||currentMatrix.getClass().getName().equals("OnesMatrix")){
                            if (currentMatrix.getClass().getName().equals("NullMatrix")||currentMatrix.getClass().getName().equals("OnesMatrix")){
                                if ((currentMatrix.getRows()!=1) || (currentMatrix.getColumns()!=1) ) {
                                    currentMatrix.printMatrix();
                                    System.out.println("ID = "+ currentMatrix.getId());
                                    System.out.println();
                                }
                            }
                            else if (currentMatrix.getRows()!=currentMatrix.getColumns()){
                                currentMatrix.printMatrix();
                                System.out.println("ID = "+ currentMatrix.getId());
                                System.out.println();
                            }

                        }
                    }
                }
                else if (optID==15.2){
                    System.out.println("Available Row Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("RowMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if ((currentMatrix.getRows()==1)&&(currentMatrix.getColumns()!=1)) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                    }
                }
                else if (optID==15.3){
                    System.out.println("Available Column Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("ColumnMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if ((currentMatrix.getColumns()==1)&&(currentMatrix.getRows()!=1)){
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                    }
                }
                else if (optID==15.4){
                    System.out.println("Available Square Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("SquareMatrix")||currentMatrix.getClass().getName().equals("DiagonalMatrix")||currentMatrix.getClass().getName().equals("IdentityMatrix")||currentMatrix.getClass().getName().equals("LowerTriangularMatrix")||
                                currentMatrix.getClass().getName().equals("ScalarMatrix")||currentMatrix.getClass().getName().equals("SingletonMatrix")||currentMatrix.getClass().getName().equals("SingularMatrix")||currentMatrix.getClass().getName().equals("SkewSymmetricMatrix")||
                                currentMatrix.getClass().getName().equals("SymmetricMatrix")||currentMatrix.getClass().getName().equals("UpperTriangularMatrix")){
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if (currentMatrix.getRows()==currentMatrix.getColumns()){
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                    }
                }
                else if (optID==15.5){
                    System.out.println("Available Symmetric Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("SymmetricMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if ((currentMatrix.getRows()==currentMatrix.getColumns())){
                            if (currentMatrix.isSymmetric()) {
                                currentMatrix.printMatrix();
                                System.out.println("ID = "+ currentMatrix.getId());
                                System.out.println();
                            }
                        }
                    }
                }
                else if (optID==15.6){
                    System.out.println("Available Skew Symmetric Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("SkewSymmetricMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if ((currentMatrix.getRows()==currentMatrix.getColumns())){
                            if (currentMatrix.isSkewSymmetric()) {
                                currentMatrix.printMatrix();
                                System.out.println("ID = "+ currentMatrix.getId());
                                System.out.println();
                            }
                        }
                    }
                }
                else if (optID==15.7){
                    System.out.println("Available Upper-triangular Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("UpperTriangularMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if ((currentMatrix.getRows()==currentMatrix.getColumns())){
                            boolean isUpperTriangularMatrix = true;
                            for (int i=0; i<currentMatrix.getRows(); i++){
                                for (int j=0; j<currentMatrix.getColumns(); j++){
                                    if ((i>j) && (currentMatrix.getElementOfMatrix(i,j)!=0))
                                        isUpperTriangularMatrix=false;
                                }
                            }
                            if (isUpperTriangularMatrix) {
                                currentMatrix.printMatrix();
                                System.out.println("ID = " + currentMatrix.getId());
                                System.out.println();
                            }
                        }
                    }
                }
                else if (optID==15.8){
                    System.out.println("Available Lower-triangular Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("LowerTriangularMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if ((currentMatrix.getRows()==currentMatrix.getColumns())){
                            boolean isLowerTriangularMatrix = true;
                            for (int i=0; i<currentMatrix.getRows(); i++){
                                for (int j=0; j<currentMatrix.getColumns(); j++){
                                    if ((i<j) && (currentMatrix.getElementOfMatrix(i,j)!=0))
                                        isLowerTriangularMatrix=false;
                                }
                            }
                            if (isLowerTriangularMatrix) {
                                currentMatrix.printMatrix();
                                System.out.println("ID = " + currentMatrix.getId());
                                System.out.println();
                            }
                        }
                    }
                }
                else if (optID==15.9){
                    System.out.println("Available Singular Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("SingularMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if ((currentMatrix.getRows()==currentMatrix.getColumns()) && (currentMatrix.getDeterminant()==0)){
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                    }
                }
                else if (optID==15.11){
                    System.out.println("Available Diagonal Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("DiagonalMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if (currentMatrix.getRows()==currentMatrix.getColumns()){
                            boolean isDiagonal = true;
                            for (int i=0; i<currentMatrix.getRows(); i++){
                                for (int j=0; j< currentMatrix.getColumns(); j++){
                                    if ((i!=j) && (currentMatrix.getElementOfMatrix(i,j)!=0))
                                        isDiagonal=false;
                                }
                            }
                            if (isDiagonal){
                                currentMatrix.printMatrix();
                                System.out.println("ID = "+ currentMatrix.getId());
                                System.out.println();
                            }
                        }
                    }
                }
                else if (optID==15.12){
                    System.out.println("Available Scalar Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("ScalarMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if (currentMatrix.getRows()==currentMatrix.getColumns()){
                            boolean isScalar = true;
                            double scalarElement = currentMatrix.getElementOfMatrix(0,0);
                            for (int i=0; i<currentMatrix.getRows(); i++){
                                for (int j=0; j< currentMatrix.getColumns(); j++){
                                    if ((i!=j) && (currentMatrix.getElementOfMatrix(i,j)!=0))
                                        isScalar=false;
                                    if ((i==j) && (currentMatrix.getElementOfMatrix(i,j)!=scalarElement))
                                        isScalar= false;
                                }
                            }
                            if (isScalar){
                                currentMatrix.printMatrix();
                                System.out.println("ID = "+ currentMatrix.getId());
                                System.out.println();
                            }
                        }
                    }
                }
                else if (optID==15.13){
                    System.out.println("Available Identity Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("IdentityMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if (currentMatrix.getRows()==currentMatrix.getColumns()){
                            boolean isIdentity = true;
                            for (int i=0; i<currentMatrix.getRows(); i++){
                                for (int j=0; j< currentMatrix.getColumns(); j++){
                                    if ((i!=j) && (currentMatrix.getElementOfMatrix(i,j)!=0))
                                        isIdentity=false;
                                    if ((i==j) && (currentMatrix.getElementOfMatrix(i,j)!=1))
                                        isIdentity= false;
                                }
                            }
                            if (isIdentity){
                                currentMatrix.printMatrix();
                                System.out.println("ID = "+ currentMatrix.getId());
                                System.out.println();
                            }
                        }
                    }
                }
                else if (optID==15.14){
                    System.out.println("Available Singleton Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("SingletonMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else if ((currentMatrix.getRows()==1) && (currentMatrix.getColumns()==1)){
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                    }
                }
                else if (optID==15.15){
                    System.out.println("Available Ones Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("OnesMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else {
                            boolean isOnes = true;
                            for (int i=0; i<currentMatrix.getRows(); i++){
                                for (int j=0; j< currentMatrix.getColumns(); j++){
                                    if (currentMatrix.getElementOfMatrix(i,j)!=1)
                                        isOnes=false;
                                }
                            }
                            if (isOnes){
                                currentMatrix.printMatrix();
                                System.out.println("ID = "+ currentMatrix.getId());
                                System.out.println();
                            }
                        }
                    }
                }
                else if (optID==15.16){
                    System.out.println("Available Null Matrix are :\n");
                    for (Integer matrixID: allMatricesMade.keySet()){
                        Matrix currentMatrix = allMatricesMade.get(matrixID);
                        if (currentMatrix.getClass().getName().equals("NullMatrix")) {
                            currentMatrix.printMatrix();
                            System.out.println("ID = "+ currentMatrix.getId());
                            System.out.println();
                        }
                        else {
                            boolean isNull = true;
                            for (int i=0; i<currentMatrix.getRows(); i++){
                                for (int j=0; j< currentMatrix.getColumns(); j++){
                                    if (currentMatrix.getElementOfMatrix(i,j)!=0)
                                        isNull=false;
                                }
                            }
                            if (isNull){
                                currentMatrix.printMatrix();
                                System.out.println("ID = "+ currentMatrix.getId());
                                System.out.println();
                            }
                        }
                    }
                }
                else{
                    System.out.println("Invalid option");
                }
            }

            else if (option==16) {
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                break;
            }

            else{
                System.out.println("Wrong option");
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }

    }
}
