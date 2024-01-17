import java.util.*;

public class bellmanford {
    static int n, dest;
    static double[] prevDis, disVec;
    static double[][] adjMat;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        n = sc.nextInt();
        adjMat = new double[n][n];
        System.out.println("Enter Adjacency Matrix (Use 'Infinity' for No Link)");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                adjMat[i][j] = sc.nextDouble();
        System.out.println("Enter destinationvertex");
        dest = sc.nextInt();
        disVec = new double[n];
        for (int i = 0; i < n; i++)
            disVec[i] = Double.POSITIVE_INFINITY;
        disVec[dest - 1] = 0;
        bellmanFordAlgorithm();
        System.out.println("Distance Vector");
        for (int i = 0; i < n; i++) {
            if (i == dest - 1) {
                continue;
            }
            System.out.println("Distance from " + (i + 1) + " is " + disVec[i]);
        }
        System.out.println();
    }

    static void bellmanFordAlgorithm() {
        for (int i = 0; i < n - 1; i++) {
            prevDis = disVec.clone();
            for (int j = 0; j < n; j++) {
                double min = Double.POSITIVE_INFINITY;
                for (int k = 0; k < n; k++) {
                    if (min > adjMat[j][k] + prevDis[k]) {
                        min = adjMat[j][k] + prevDis[k];
                    }
                }
                disVec[j] = min;
            }
        }
    }
}