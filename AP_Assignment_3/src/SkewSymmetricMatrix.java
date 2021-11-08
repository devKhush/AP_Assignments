
public class SkewSymmetricMatrix extends SquareMatrix{

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
