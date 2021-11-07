import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment3_Main {

    static double scalar;
    static boolean scalarAvailable = false;

    static void showMean(){
        System.out.println("""
                9.1 Compute Row wise mean
                9.2 Compute Column wise mean
                9.3 Compute Mean of all the Elements
                """);
    }

    static void showAllLabelTypesOfMatricesAvailable(){
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

    static void printAllOperationOnMatrices(){
        System.out.println("""
                5.1 Addition of two Matrices
                5.2 Subtraction of two Matrices
                5.3 Multiplication of two Matrices
                5.4 Division of two Matrices""");
    }

    static void printAllElementWiseOperationOnMatrix(){
        System.out.println("6.1 Matrix Element wise Addition");
        System.out.println("6.2 Matrix Element wise Addition by a scalar");
        System.out.println("6.3 Matrix Element wise Subtraction");
        System.out.println("6.4 Matrix Element wise Subtraction by a scalar");
        System.out.println("6.5 Matrix Element wise Multiplication with another Matrix");
        System.out.println("6.6 Matrix Element wise Multiplication with a scalar");
        System.out.println("6.7 Matrix Element wise Division with another Matrix");
        System.out.println("6.8 Matrix Element wise Division with a scalar");
    }

    static void printInstructions(){
        System.out.println("""
                1. Take matrices as input and label them with appropriate matrix-types.
                2. Create matrices of requested matrix-types and label them with appropriate matrix-types.
                3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.
                4. Display all the matrix-type labels of a requested matrix.
                5. Perform addition, subtraction, multiplication & division.
                6. Perform element-wise operations.
                7. Transpose matrices.
                8. Inverse matrices.
                9. Compute means: row-wise mean, column-wise mean, mean of all the elements.
                10. Compute determinants.
                11. Use singleton matrices as scalars.
                12. Compute A + A' for a matrix A (matrix plus its transpose)
                13. Compute Eigen vectors and values.
                14. Solve sets of linear equations using matrices.
                15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.
                16. To exit the program""");
    }

    static void printAllMatricesAvailable(){
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Matrix> allMatricesMade = new LinkedHashMap<>();
        int option;
        printInstructions();

        System.out.println();
        while(true){
            System.out.println();

            System.out.printf("Enter option number (else Enter '0' for repeating all available options)\n> ");
            option = Integer.parseInt(sc.nextLine().trim());

            if (option==0) {
                printInstructions();
            }

            else if (option==1){
                // To be done. To be done later. Not done yet
            }

            else if (option==2){
                printAllMatricesAvailable();
                System.out.println();
                System.out.printf("Enter ID of the Matrix to be made from above :");
                double decimalIdOfMatrix = Double.parseDouble(sc.nextLine().trim());
                if (decimalIdOfMatrix==2.1){
                    Matrix mat = new RectangularMatrix();
                    mat.inputMatrix();
                    System.out.println();
                    System.out.println("Matrix = ");
                    mat.printMatrix();
                    System.out.println("ID = "+mat.getId());
                    allMatricesMade.put(mat.getId(), mat);
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
                printAllOperationOnMatrices();
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
                    A.matrixDivisionWithMatrix(B);
                }
                else{
                    System.out.println("Invalid option");
                }
            }

            else if (option==6){
                printAllElementWiseOperationOnMatrix();
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
                            A.matrixAdditionWithScalar(scalar);
                        }
                        else if (answer.equalsIgnoreCase("no")){
                            double newScalar = Double.parseDouble(sc.nextLine().trim());
                            A.matrixAdditionWithScalar(newScalar);
                        }
                    }
                    else{
                        double newScalar = Double.parseDouble(sc.nextLine().trim());
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
                            A.matrixSubtractionWithScalar(scalar);
                        }
                        else if (answer.equalsIgnoreCase("no")){
                            double newScalar = Double.parseDouble(sc.nextLine().trim());
                            A.matrixSubtractionWithScalar(newScalar);
                        }
                    }
                    else{
                        double newScalar = Double.parseDouble(sc.nextLine().trim());
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
                            A.matrixMultiplicationWithScalar(scalar);
                        }
                        else if (answer.equalsIgnoreCase("no")){
                            double newScalar = Double.parseDouble(sc.nextLine().trim());
                            A.matrixMultiplicationWithScalar(newScalar);
                        }
                    }
                    else{
                        double newScalar = Double.parseDouble(sc.nextLine().trim());
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
                            A.matrixDivisionWithScalar(scalar);
                        }
                        else if (answer.equalsIgnoreCase("no")){
                            double newScalar = Double.parseDouble(sc.nextLine().trim());
                            A.matrixDivisionWithScalar(newScalar);
                        }
                    }
                    else{
                        double newScalar = Double.parseDouble(sc.nextLine().trim());
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
                showMean();
                System.out.println();
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
                    System.out.println("This matrix must be Square Matrix\nTry again");
                }
                else {
                    System.out.println("A = ");
                    computeMatrixPlusItsTranspose.printMatrix();
                    System.out.println("A' (Transpose) = ");
                    computeMatrixPlusItsTranspose.printMatrix(computeMatrixPlusItsTranspose.getTransposeMatrix());
                    System.out.println("\nA + A' (Matrix plus its Transpose) = ");
                    computeMatrixPlusItsTranspose.matrixPlusItsTranspose();
                }
            }

            else if (option==13){
                // Compute Eigen Vectors and values. To be done later. Not done yet
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
                showAllLabelTypesOfMatricesAvailable();
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
                            else {
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
