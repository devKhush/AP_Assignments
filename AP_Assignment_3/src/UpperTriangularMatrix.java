import java.util.Arrays;

public class UpperTriangularMatrix extends SquareMatrix{
//    @Override
//    public void inputMatrix(){
//        Scanner sc = new Scanner(System.in);
//        System.out.printf("Enter dimension of Upper-Traingular square matrix (one number): ");
//        int dimension = Integer.parseInt(sc.nextLine().trim());
//        this.setMatrix(new double[dimension][dimension]);
//        this.setRows(dimension);
//        this.setColumns(dimension);
//        for (int i=0; i<dimension; i++){
//            System.out.printf("Enter %dth row input (Space separated): ",i);
//            String rowInput = sc.nextLine().trim();
//            String[] rowInputArray = rowInput.split(" ");
//            for (int j=0; j<dimension; j++){
//                double matrixElement = Double.parseDouble(rowInputArray[j]);
//                this.changeElementOfMatrix(i,j , matrixElement);
//            }
//        }
//        this.id = this.staticID;
//    }

    public static void main(String[] args) {
        Matrix utm = new UpperTriangularMatrix();
        utm.inputMatrix();
        System.out.println(utm.getRows());
        System.out.println(utm.getClass());
        utm.printMatrix();
        utm.printMatrix(utm.getTransposeMatrix());
        System.out.println(utm.getId());
    }
}
