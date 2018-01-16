package maman15b;

public class VectorMultiplier implements Runnable {
    private final int DEFAULT_VECTOR_SIZE = 0;
    
    private int[] rowVector;
    private int[] columnVector;
    private int rowIndex;
    private int columnIndex;
    private MatrixMultiplierPrinter printer;

    /**
     * Constructor
     * @param rowVector row vector
     * @param columnVector column vector
     * @param rowIndex row vector's index
     * @param columnIndex column vector's index
     * @param printer printer object
     */
    public VectorMultiplier(int[] rowVector, int[] columnVector, int rowIndex, int columnIndex, MatrixMultiplierPrinter printer) {
        this.rowVector = rowVector;
        this.columnVector = columnVector;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.printer = printer;
    }

    /**
     * Empty constructor
     */
    public VectorMultiplier() {
        this.rowVector = new int[DEFAULT_VECTOR_SIZE];
        this.columnVector = new int[DEFAULT_VECTOR_SIZE];
    }

    /**
     * Get row vector
     * @return array representing vector
     */
    public int[] getRowVector() {
        return rowVector;
    }

    /**
     * Set row vector
     * @param rowVector array representing vector
     */
    public void setRowVector(int[] rowVector) {
        this.rowVector = rowVector;
    }

    /**
     * Get row vector
     * @return array representing vector
     */
    public int[] getColumnVector() {
        return columnVector;
    }

    /**
     * Set row vector
     * @param rowVector array representing vector
     */
    public void setColumnVector(int[] columnVector) {
        this.columnVector = columnVector;
    }

    /**
     * Get row index
     * @return integer index
     */
    public int getRowIndex() {
        return rowIndex;
    }

    /**
     * Set row index
     * @param rowIndex integer index
     */
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    /**
     * Get column index
     * @return integer index
     */
    public int getColumnIndex() {
        return columnIndex;
    }

    /**
     * Set column index
     * @param rowIndex integer index
     */
    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    /**
     * Get printer
     * @return MatrixMultiplierPrinter object
     */
    public MatrixMultiplierPrinter getPrinter() {
        return printer;
    }

    /**
     * Set printer
     * @param printer MatrixMultiplierPrinter object
     */
    public void setPrinter(MatrixMultiplierPrinter printer) {
        this.printer = printer;
    }
    
    @Override
    public void run() {
        this.printer.printResult(getMultiplicationResult(), this.rowIndex, this.columnIndex);
    }
    
    private int getMultiplicationResult() {
        int result = 0;
        for(int i = 0; i < this.rowVector.length; i++) { // Assuming the input is valid (equal size vector)
            result += this.rowVector[i] * this.columnVector[i];
        }
        
        return result;
    }
}
