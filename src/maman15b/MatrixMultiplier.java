package maman15b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMultiplier {
    private Matrix firstMatrix;
    private Matrix secondMatrix;
    private ExecutorService executor;

    public MatrixMultiplier(Matrix firstMatrix, Matrix secondMatrix) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
    }

    public MatrixMultiplier() {
    }

    public Matrix getFirstMatrix() {
        return firstMatrix;
    }

    public void setFirstMatrix(Matrix firstMatrix) {
        this.firstMatrix = firstMatrix;
    }

    public Matrix getSecondMatrix() {
        return secondMatrix;
    }

    public void setSecondMatrix(Matrix secondMatrix) {
        this.secondMatrix = secondMatrix;
    }
    
    public void execute() {
        if(this.executor != null) return; // An executor already running
        
        this.executor = Executors.newCachedThreadPool();
        MatrixMultiplierPrinter printer = new MatrixMultiplierPrinter(this.firstMatrix.getRowsCount(),
                this.secondMatrix.getColumnsCount());
        // Run vector multipliers threads
        for(int i = 0; i < this.firstMatrix.getRowsCount(); i++) {
            for(int j = 0; j < this.secondMatrix.getColumnsCount(); j++) {
                this.executor.execute(new VectorMultiplier(this.firstMatrix.getRowVector(i),
                        this.secondMatrix.getColumnVector(j), i, j, printer)); // Set executor with the relevant row&column vector
            }
        }
        
        this.executor.shutdown();
        this.executor = null;
    }
}
