import java.util.Scanner;


public class Practise{
    public static void main(String[] args) {

        double[][] matrix = new double[][]{{0,2,4},{-2,0,3},{-4,-3,0}};
        Matrix m = new SquareMatrix();
        m.setRows(3);
        m.setColumns(3);
        m.setMatrix(matrix);
        System.out.println(m.isSkewSymmetric());

        double[][] matrix1 = new double[][]{{1,1,-1},{1,2,0},{-1,0,5}};
        Matrix m1 = new SquareMatrix();
        m1.setRows(3);
        m1.setColumns(3);
        m1.setMatrix(matrix1);
        System.out.println(m1.isSymmetric());


        int i, j;
        float det = 0;
        float mat[][] = new float[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements of matrix row wise:");
        for(i = 0; i < 3; ++i)
            for(j = 0; j < 3; ++j)
                mat[i][j] = sc.nextFloat();


        for(i = 0; i < 3; i++)
            det = det + (mat[0][i] * (mat[1][(i+1)%3] * mat[2][(i+2)%3] - mat[1][(i+2)%3] * mat[2][(i+1)%3]));
        System.out.println("\ndeterminant = " + det);

        System.out.println("\nInverse of matrix is:");
        for(i = 0; i < 3; ++i) {
            for(j = 0; j < 3; ++j)
                System.out.print((( (mat[(j+1)%3][(i+1)%3] * mat[(j+2)%3][(i+2)%3]) - (mat[(j+1)%3][(i+2)%3] * mat[(j+2)%3][(i+1)%3])) / det) + " ");
            System.out.print("\n");
        }
    }
}
