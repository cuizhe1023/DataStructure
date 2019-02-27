package AdjacencyMatrix.UndirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: cuizhe
 * @Date: 2019/2/16 21:08
 */
//邻接矩阵无向图
public class UndirectedGraph {

    private ArrayList<String> vertexList;//存储顶点的链表
    public int[][] adjMat;//邻接矩阵，用来存储边
    private int numOfEdges;//边的数目

    public UndirectedGraph(int n) {
        //初始化矩阵，一维矩阵，和边的数目
        adjMat = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
    }

    public void insertVertex(String v){
        vertexList.add(v);
    }

    /**
     * 增加一条边
     * @param v1 顶点1
     * @param v2 顶点2
     * @param weight 权值
     */
    public void addEdge(String v1,String v2,int weight){
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(v1)){
                index1 = i;
                break;
            }
        }

        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(v2)){
                index2 = i;
                break;
            }
        }

        adjMat[index1][index2] = weight;
        adjMat[index2][index1] = weight;
        numOfEdges++;
    }

    /**
     * 移除一条边
     * @param v1 结点1
     * @param v2 结点2
     */
    public void removeEdge(String v1,String v2){
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(v1)){
                index1 = i;
                break;
            }
        }

        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(v2)){
                index2 = i;
                break;
            }
        }

        adjMat[index1][index1] = 0;
        adjMat[index2][index1] = 0;
        numOfEdges++;
    }

    public String getValueByIndex(int index){
        String value = null;
        for (int i = 0; i < vertexList.size(); i++) {
            if (index == i){
                value = vertexList.get(i);
            }
        }
        return value;
    }

    /**
     * 得到结点数
     * @return 图的结点数
     */
    public int getNumOfVertex(){
        return vertexList.size();
    }

    /**
     * 得到边数
     * @return 图有多少条边
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 获取 v1,v2 的权值
     * @param v1 顶点1
     * @param v2 顶点2
     * @return 权值
     */
    public int getWeight(String v1,String v2){
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(v1)){
                index1 = i;
                break;
            }
        }

        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(v2)){
                index2 = i;
                break;
            }
        }
        return adjMat[index1][index2];
    }


    public void printAdjMat(){
        for (int[] a :
                adjMat) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (adjMat[index][i]>0){
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (adjMat[v1][i]>0){
                return i;
            }
        }
        return -1;
    }

    private void dfs(boolean[] visited,int i){
        System.out.print(getValueByIndex(i)+" ");
        visited[i] = true;
        int w = getFirstNeighbor(i);
        while (w!=-1){
            if (!visited[w]){
                dfs(visited,w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    public void dfs(){
        boolean[] isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
        System.out.println();
    }

    private void bfs(boolean[] isVisited,int i){
        LinkedList<Integer> queue = new LinkedList<>();
        int u,w;
        System.out.print(vertexList.get(i)+" ");
        isVisited[i] = true;
        queue.add(i);
        w = getFirstNeighbor(i);
        while (!queue.isEmpty()){
            u = queue.pop();
            w = getFirstNeighbor(i);
            while (w!=-1){
                if (!isVisited[i]){
                    System.out.print(vertexList.get(i)+" ");
                    isVisited[i] = true;
                    queue.add(i);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }

    public void bfs(){
        boolean[] isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
        System.out.println();
    }


    public boolean judgeLink(String str1,String str2){
        int index1 = 0,index2 = 0;
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (str1.equals(vertexList.get(i))){
                index1 = i;
            }
            if (str2.equals(vertexList.get(i))){
                index2 = i;
            }
        }

        return true;
    }

}
