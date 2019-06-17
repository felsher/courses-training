package programming;

public class Lab1 {

    public static void main(String[] args) {
//        programming.Matrix matrix = new programming.Matrix(10,10);
        Matrix matrix = new Matrix(5,5);
        matrix.fill();
        matrix.printToConsole();
        matrix.printReversedRows();
    }
}
