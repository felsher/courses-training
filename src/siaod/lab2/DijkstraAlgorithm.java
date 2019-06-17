package siaod.lab2;

/**
 * What calculate() method of this class do:
 *
 * 1) Create a set pointsMarkers - set that keeps track of points included in shortest path tree, whose minimum distance from source is calculated and finalized. Initially, this set is empty (at first all points marked as false)
 *
 * 2) Assign a distance value to all points in the input graph. Initialize all distance values as MAX_INTEGER values. Assign distance value as 0 for the source point
 *
 * 3) While pointsMarkers doesn’t include all points
 *
 * a) Pick a point which is not there in pointsMarkers and has minimum distance value.
 *
 * b) Include this point (P) to pointsMarkers.
 *
 * c) Update distance value of all neighbour points of P.
 *      To update the distance values, iterate through all neighbour points.
 *      For every neighbour point (V),
 *      if sum of distance value of (P) (from source) and weight of edge (P to V),
 *      is less than the distance value of (V), then update the distance value of (V)
 * */
class DijkstraAlgorithm {

    int points;
    int sourcePoint;

    int[] calculate(int[][] graph, int sourcePoint) {
        this.sourcePoint = sourcePoint;
        points = graph.length;

        int[] resultDistances = new int[points];

        Boolean[] pointsMarkers = new Boolean[points];

        // initialization by default falses and max distances at first
        for (int i = 0; i < points; i++) {
            resultDistances[i] = Integer.MAX_VALUE;
            pointsMarkers[i] = false;
        }

        // src point distance always 0
        resultDistances[sourcePoint] = 0;

        for (int point = 0; point < points - 1; point++) {
            int minDistance = findCloserPoint(resultDistances, pointsMarkers);
            pointsMarkers[minDistance] = true;
            // update resultDistances value of neighbour points
            for (int _point = 0; _point < points; _point++) {
                // Update resultDistances[_point] if is not in pointsMarkers,
                // there is an edge from findCloserPoint to current _point, and total weight of path from sourcePoint to
                // _point through findCloserPoint is smaller than current value of resultDistances[_point]
                if (!pointsMarkers[_point] && graph[minDistance][_point] != 0 &&
                        resultDistances[minDistance] != Integer.MAX_VALUE &&
                        resultDistances[minDistance] + graph[minDistance][_point] < resultDistances[_point]
                ) {
                    resultDistances[_point] = resultDistances[minDistance] + graph[minDistance][_point];
                }
            }
        }

        return resultDistances;
    }

    private int findCloserPoint(int[] resultDistances, Boolean[] pointsMarkers) {
        int defaultDistance = Integer.MAX_VALUE;
        int closerPointIndex = -1;

        for (int point = 0; point < points; point++) {
            if (!pointsMarkers[point] && resultDistances[point] <= defaultDistance) {
                defaultDistance = resultDistances[point];
                closerPointIndex = point;
            }
        }

        return closerPointIndex;
    }
}
