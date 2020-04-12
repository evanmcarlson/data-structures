import java.util.ArrayList;
import java.util.List;

public class GraphImplementation implements Graph {

    int vertices;
    int[][] adjMatrix;

    public GraphImplementation(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices]; // create square matrix
    }

    public void addEdge(int src, int tar) {
        adjMatrix[src][tar] = 1;
    }

    public List<Integer> neighbors(int vertex) {
        List<Integer> neigh = new ArrayList<Integer>();
        for(int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[vertex][i] > 0) {
                neigh.add(i);
            }
        }
        return neigh;
    }

    public List<Integer> topologicalSort() {

        int[] incident = new int[vertices];
        for(int i = 0; i < vertices; i++) {	// since it's a square matrix
            incident[i] = 0;
        }

        // update incident array with adjMatrix values column-wise
        for(int i = 0; i < vertices; i++) {
            int incidents = 0;
            for(int j = 0; j < vertices; j++) {
                incidents += adjMatrix[j][i];
            }
            incident[i] = incidents;
        }

        // sort, based on quantity of inbound edges
        List<Integer> schedule = new ArrayList<Integer>();
        for(int j = 0; j < vertices; j++) {
            int leastInbound = least_inbound(incident);
            incident[leastInbound] = -1; // flag node so not chosen again
            schedule.add(leastInbound);
        }
        return schedule;
    }

    private int least_inbound(int[] arr) {
        int lowest = vertices;
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(0 <= arr[i] && arr[i] < lowest) {
                lowest = arr[i];
                index = i;
            }
        }
        return index;
    }
}
