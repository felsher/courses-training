package programming;

public class Matrix {

    private final int rows;
    private final int columns;
    private int[][] matrix;

    public Matrix(int rows, int columns) {
        System.out.println("Creating matrix object!");
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[this.rows][this.columns];
        System.out.println();
    }

    public void fill() {
        System.out.println("Filling the matrix in process");
        int value = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.matrix[i][j] = value;
                value += 1;
            }
        }
        System.out.println();
    }

    public void printToConsole() {
        System.out.println("Here is the matrix:");
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                System.out.print(this.matrix[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printReversedRows() {
        System.out.println("Here is your matrix with each second row reversed:");
        for (int row = 0; row < this.rows; row++) {
            if (row % 2 == 0) {
                for (int column = 0; column < this.columns; column++) {
                    System.out.print(this.matrix[row][column] + " ");
                }
            } else {
                for (int column = columns - 1; column >= 0; column--) {
                    System.out.print(this.matrix[row][column] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
