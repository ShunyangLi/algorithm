import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i ++) {
            int index = 0;
            for (int j = matrix.length - 1; j >= 0; j --) {
                res[i][index++] = matrix[j][i];
            }
        }

        for (int i = 0; i < res.length; i ++) {
            matrix[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        RotateImage ri = new RotateImage();
        ri.rotate(m);

        for (int[] ints : m) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
