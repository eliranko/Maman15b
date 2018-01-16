package maman15b;

public class MatrixMultiplierPrinter {
    private final int PRINTED_RESULT = 1;
    private int[] printTracking;
    private int[][] resultMatrix;
    
    public MatrixMultiplierPrinter(int rows, int columns) {
        this.resultMatrix = new int[rows][columns];
        this.printTracking = new int[rows*columns];
        
        // Set the first item as valid for printing
        this.printTracking[0] = PRINTED_RESULT;
    }
    
    public synchronized void printResult(int result, int rowIndex, int columnIndex) {
        if(!validIndices(rowIndex, columnIndex)) return; // Ignore invalid input
        
        this.resultMatrix[rowIndex][columnIndex] = result;
        if(canPrint(rowIndex, columnIndex)) { // Progressive print if possible
            progressivePrint(rowIndex, columnIndex);
        }
    }
    
    private boolean validIndices(int rowIndex, int columnIndex) {
        return rowIndex >= 0 && rowIndex < this.resultMatrix.length &&
                columnIndex >= 0 && columnIndex < this.resultMatrix[0].length;
    }
    
    private int getTrackArrayIndex(int rowIndex, int columnIndex) {
        return rowIndex * this.resultMatrix[0].length + columnIndex; // 2d array mapped as 1d array
    }
    
    /**
     * Checks if the previous item in the matrix printed its result
     * @param rowIndex row index
     * @param columnIndex column index
     * @return true if print is approved, false otherwise
     */
    private boolean canPrint(int rowIndex, int columnIndex) {
        if(rowIndex != 0 && columnIndex == 0) { // Get the last item in the previous row
            rowIndex--;
            columnIndex = this.resultMatrix[0].length - 1;
        }
        else if(rowIndex != 0 && columnIndex != 0) {
            columnIndex--;
        }
        return this.printTracking[getTrackArrayIndex(rowIndex, columnIndex)] == PRINTED_RESULT;
    }
    
    private void progressivePrint(int rowIndex, int columnIndex) {
        boolean stopFlag = false;
        for(int i = rowIndex; !stopFlag && i < this.resultMatrix.length; i++) { 
            for(int j = columnIndex; !stopFlag && j < this.resultMatrix[0].length; j++) {
                if(canPrint(i, j)) {
                    print(this.resultMatrix[i][j], i, j);
                }
                else {
                    stopFlag = true;
                }
            }
        }
    }
    
    private void print(int result, int rowIndex, int columnIndex) {
        if(columnIndex == 0) {
            System.out.println("\n" + result);
        }
        else {
            System.out.println(" " + result);
        }
        
        this.printTracking[getTrackArrayIndex(rowIndex, columnIndex)] = PRINTED_RESULT;
    }
}
