package maman15b;

public class Matrix {
    private final int DEFAULT_MATRIX_X = 0;
    private final int DEFAULT_MATRIX_Y = 0;
    
    private int[][] matrix;
    private int[][] transpose;

    public Matrix(int[][] matrix) {
        setMatrix(matrix);
    }

    public Matrix() {
        setMatrix(new int[DEFAULT_MATRIX_X][DEFAULT_MATRIX_Y]);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
        setTranspose();
    }
    
    public int[] getRowVector(int index) {
        return this.matrix[index];
    }
    
    public int[] getColumnVector(int index) {
        return this.transpose[index];
    }
    
    public int getRowsCount() {
        return this.matrix.length;
    }
    
    public int getColumnsCount() {
        return this.matrix[0].length;
    }
    
    private void setTranspose() {
        this.transpose = new int[this.matrix[0].length][this.matrix.length]; // Assuming input is valid
        for(int i = 0; i < this.matrix.length; i++) {
            for(int j = 0; j < this.matrix[0].length; j++) {
                this.transpose[j][i] = this.matrix[i][j];
            }
        }
    }
}
