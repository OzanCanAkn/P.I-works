import java.util.ArrayList;
import java.util.Collections;

public class DynamicSolution {
    ArrayList<ArrayList<Node>> nodes;
    int pyramidLength;
    public DynamicSolution(ArrayList<ArrayList<Node>> nodes) {
        this.nodes = nodes;
        pyramidLength=nodes.size();
        System.out.println(nodeIterator(nodes.get(0).get(0)));
    }

    int nodeIterator(Node initialNode){
        int iteratorMax=-1;
        if (initialNode.value==-1){
            //if this node prime
            initialNode.maxEdgesVal=iteratorMax;
            return -1;
        }
        if (initialNode.maxEdgesVal!=-1){
            //if this node visited already,use the data from memory
            return initialNode.maxEdgesVal;
        }

        if (initialNode.edges!=null) {
            //checking all possible edges for finding maximum sub triangular
            for (int i = 0; i < initialNode.edges.size(); i++) {
                int nextVertices=nodeIterator(initialNode.edges.get(i));
                if (nextVertices!=-1) {
                    iteratorMax = Math.max(nextVertices, iteratorMax);
                }
            }
            iteratorMax+=initialNode.value;
            initialNode.maxEdgesVal=iteratorMax;
            return iteratorMax;
        }
        else {
            initialNode.maxEdgesVal=initialNode.value;
            return initialNode.value;
        }
    }
}
