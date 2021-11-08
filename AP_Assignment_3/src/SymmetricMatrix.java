
public class SymmetricMatrix extends SquareMatrix{

    @Override
    public void changeElement(){
        System.out.println("Can't change value of this Matrix");
    }

    public static void main(String[] args) {
        Matrix sm = new SquareMatrix();
        sm.inputMatrix();
        System.out.println(sm.getId());
        sm.printMatrix();
        sm.printMatrix(sm.getTransposeMatrix());
        System.out.println(sm.isSymmetric());
        System.out.println();

        Matrix ssm = new SymmetricMatrix();
        ssm.inputMatrix();
        ssm.printMatrix();
        ssm.printMatrix(ssm.getTransposeMatrix());
        System.out.println(ssm.isSymmetric());
    }

}
