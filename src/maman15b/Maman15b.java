package maman15b;

public class Maman15b {

    public static void main(String[] args) {
        int[][] a = {{2, 2},{3,3}};
        int[][] b = {{1,3},{6,7}};
        
        MatrixMultiplier multiplier = new MatrixMultiplier(new Matrix(a), new Matrix(b));
        multiplier.execute();
    }
    
}
