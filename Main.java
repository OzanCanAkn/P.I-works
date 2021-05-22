import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*I have 2 different solutions one of them is dynamic and the other is depth first search
* you can compile both of them by using console In dfs solution we can see also the path we can use (dfsSolution.maxPath)*/
class Main {
    public static void main(String[] args) {
        String pyramid = "";
        //txt file reading and converting to string
        try {
            File file = new File("pyramid.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                pyramid=pyramid+data+"\n";
            }
            scanner.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred when file is reading.");
            e.printStackTrace();
        }
        //I have two different solution for this question
        System.out.println("press 1 for dfs solution");
        System.out.println("press 2 for dynamic solution");
        Scanner scanner=new Scanner(System.in);
        int chooser=scanner.nextInt();
        StringToNode stringToNode=new StringToNode();
        if (chooser==1) {
            DFSsolution dfSsolution = new DFSsolution(stringToNode.PrepareNodes(pyramid));
            if (dfSsolution.max!=0) {
                System.out.println(dfSsolution.max);
            }
        }else if(chooser==2) {
            //printer of dynamic solution is inside of the constructor
            DynamicSolution dynamicSolution = new DynamicSolution(stringToNode.PrepareNodes(pyramid));
        }
    }
}