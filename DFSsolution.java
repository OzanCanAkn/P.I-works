import java.util.ArrayList;
import java.util.Collections;

public class DFSsolution {
    ArrayList<ArrayList<Node>> nodes;
    int pyramidLength;
    int max=0;
    ArrayList<Node> maxPath;
    //DFS solution constructor
    public DFSsolution(ArrayList<ArrayList<Node>> nodes) {
        this.nodes = nodes;
        pyramidLength=nodes.size();
        if (nodes.get(0).get(0).value!=-1){
            nodeIterator(nodes.get(0),nodes.get(0).get(0).value);
        }else {
            System.out.println("there is no solution");
        }

    }
    //recursive function for dfs search
    void nodeIterator(ArrayList<Node> path,int total){
        Node initialNode=path.get(path.size()-1);
        if (initialNode.edges!=null) {
            for (int i = 0; i < initialNode.edges.size(); i++) {
                ArrayList<Node> copy = new ArrayList<>(path);
                copy.add(initialNode.edges.get(i));
                nodeIterator(copy, total + initialNode.edges.get(i).value);
            }
        }
        //if initial node is the base of triangular and initial paths sum is greater than previous one
        if (path.get(path.size()-1).y==pyramidLength-1 & total>max){
            max=total;
            maxPath=path;
        }
    }
}