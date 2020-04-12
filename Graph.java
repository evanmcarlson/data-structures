import java.util.List;

public interface Graph {
	
	// this graph is extremely simplified
	// ... but it's somewhere to start!
	public void addEdge(int v1, int v2);
	public List<Integer> topologicalSort();
	public int[] neighbors(int vertex);

}
