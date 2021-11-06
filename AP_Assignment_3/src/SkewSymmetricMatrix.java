
public class SkewSymmetricMatrix extends SquareMatrix{
//    @Override
//    public void inputMatrix(){
//        Scanner sc = new Scanner(System.in);
//        System.out.printf("Enter dimension of skew-symmetric square matrix (one number): ");
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

    @Override
    public void changeElement(){
        System.out.println("Can't change value of this Matrix");
    }

    public static void main(String[] args) {
        Matrix ssm = new SkewSymmetricMatrix();
        ssm.inputMatrix();
        ssm.printMatrix();
        ssm.printMatrix(ssm.getTransposeMatrix());
        System.out.println(ssm.getId());
        System.out.println(ssm.getRows());
        System.out.println(ssm.getColumns());
        System.out.println(ssm.isSymmetric());
    }
}
