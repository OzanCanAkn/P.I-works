import java.util.ArrayList;

public class Node {
    int x1;
    int x2;
    int y;
    int value;
    ArrayList<Node> edges;
    int maxEdgesVal=-1;

    public Node(int x1, int x2, int y, int value) {
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
        int i=2;
        this.value = -1;
        //prime checker
        if (value==1){
            this.value=1;
        }else if (value==0){
            this.value=0;
        }
        else {
            while (i <= value / 2) {
                if (value % i == 0) {
                    this.value = value;
                }
                ++i;
            }
        }
        //prime checker end
    }
}
