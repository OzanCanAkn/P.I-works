import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class StringToNode {
    ArrayList<ArrayList<Node>> nodes=new ArrayList<>();
    int lengthOfNumber;
    ArrayList<ArrayList<Node>> PrepareNodes(String triangle){
        String[] lines=triangle.split("\n");
        int x1=0;
        int x2=0;
        //splitting the string and creates node struct for easy to solve
        for(int i=0;i< lines.length;i++){
            int firstIndex=findFirstDigitsIndex(lines[i]);
            String[] numbers=lines[i].substring(firstIndex).split(" ");
            ArrayList<Node> inLineNodes=new ArrayList<>();
            for (String s:numbers){
                Node node=new Node(firstIndex,firstIndex+s.length()-1,i,Integer.parseInt(s));
                inLineNodes.add(node);
                lengthOfNumber=s.length();
                firstIndex += s.length()+1;
            }
            nodes.add(inLineNodes);
        }
        return defineEdges();
    }
    //like space iterator
    int findFirstDigitsIndex(String str){
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)!=' '){
                return i;
            }
        }
        return 0;
    }
    //finding compatible edges for each node
    ArrayList<ArrayList<Node>> defineEdges(){
        for(int i=0;i<nodes.size()-1;i++){
            for (Node n:nodes.get(i)){
                n.edges=SearchEdge(i,n.x1,n.x2);
            }
        }
        return nodes;
    }
    ArrayList<Node> SearchEdge(int i,int x1,int x2){
        ArrayList<Node> compatibles=new ArrayList<>();
        for(Node n: nodes.get(i+1)){
            if(x1-2==n.x2||x1-1==n.x2 || n.x1==x1 || x2+2==n.x1 || x2+1==n.x1){
                if (n.value!=-1) {
                    compatibles.add(n);
                }
            }
        }
        return compatibles;
    }
}
