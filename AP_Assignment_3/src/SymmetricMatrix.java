import java.util.Scanner;

public class SymmetricMatrix extends SquareMatrix{

    @Override
    public void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter dimension of symmetric square matrix (one number): ");
        int dimension = Integer.parseInt(sc.nextLine().trim());
        this.matrix = new double[dimension][dimension];
        this.rows=dimension;
        this.columns=dimension;
        for (int i=0; i<dimension; i++){
            System.out.printf("Enter %dth row input (Space separated): ",i);
            String rowInput = sc.nextLine().trim();
            String[] rowInputArray = rowInput.split(" ");
            for (int j=0; j<dimension; j++){
                this.matrix[i][j] = Double.parseDouble(rowInputArray[j]);
            }
        }
        this.id = this.staticID;
    }

    public static void main(String[] args) {
        Matrix sm = new SquareMatrix();
        sm.inputMatrix();
        System.out.println(sm.getId());
        sm.printMatrix();
        sm.printMatrix(sm.getTransposeMatrix());
        //System.out.println(Arrays.deepToString(sm.getTransposeMatrix()));
        System.out.println(sm.isSymmetric());
        System.out.println();

        Matrix ssm = new SymmetricMatrix();
        ssm.inputMatrix();
        ssm.printMatrix();
        ssm.printMatrix(ssm.getTransposeMatrix());
        //System.out.println(Arrays.deepToString(ssm.getTransposeMatrix()));
        System.out.println(ssm.isSymmetric());
    }

}
