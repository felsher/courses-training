package siaod.lab2;

public class Lab2 {

    public static void main(String[] args) {

        DijkstraAlgorithm da = new DijkstraAlgorithm();

        int graphData[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int[] result = da.calculate(graphData, 0);

        printResult(result, da.points, da.sourcePoint);
    }

    static void printResult(int[] distanceArray, int points, int sourcePoint) {
        System.out.println("Selected source point is: " + sourcePoint);

        System.out.println("Destination point | Distance");

        for (int i = 0; i < points; i++) {
            System.out.println(i + "    |   " + distanceArray[i]);
        }
    }
}
