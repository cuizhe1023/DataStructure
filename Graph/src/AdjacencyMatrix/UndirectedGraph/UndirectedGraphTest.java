package AdjacencyMatrix.UndirectedGraph;

/**
 * @Author: cuizhe
 * @Date: 2019/2/16 21:09
 */
public class UndirectedGraphTest {

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(9);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        graph.insertVertex("G");
        graph.insertVertex("H");
        graph.insertVertex("I");

        graph.addEdge("A","B",1);
        graph.addEdge("A","C",1);
        graph.addEdge("A","D",1);
        graph.addEdge("B","C",1);
        graph.addEdge("B","E",1);
        graph.addEdge("C","F",1);
        graph.addEdge("D","F",1);
        graph.addEdge("E","G",1);
        graph.addEdge("F","H",1);
        graph.addEdge("I","H",1);

        System.out.println("输出邻接矩阵:");
        graph.printAdjMat();
        System.out.println("图的结点数有:"+graph.getNumOfVertex());
        System.out.println("图的边数:"+graph.getNumOfEdges());
        System.out.println("深度优先遍历:");
        graph.dfs();
        System.out.println("广度优先遍历:");

        }

}
