import java.util.ArrayList;

public class Grabh {
    ArrayList<NodeG> nodes;
    int[][] matrix;

    Grabh(int size) {
        matrix = new int[size][size];
        nodes = new ArrayList<>();
    }

    public void addNode(NodeG nodeG) {
        nodes.add(nodeG);
    }

    public void addEdge(int fst, int sec) {
        matrix[fst][sec] = 1;
    }

    public boolean chekEdge(int fst, int sec) {
        return matrix[fst][sec] == 1;
    }

    public void printMy() {
        System.out.print("  ");
        for (NodeG node : nodes) {
            System.out.print(node.data + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }

    }

    public void depthSearch(int src) {
        if (nodes.get(src).visited) {
            return;
        } else {
            nodes.get(src).visited = true;
            System.out.println("visited->: " + nodes.get(src).data);
        }

        for (int i = 0; i < matrix[src].length; i++) {
            if (matrix[src][i] == 1) {
                depthSearch(i);

            }
        }

    }

}
/*
 * A B C D
 * A|0 1 0 0
 * B|0 0 0 0
 * C|1 0 1 0
 * D|
 * 
 */

class NodeG {
    char data;
    boolean visited;

    NodeG(char data) {
        this.data = data;
        this.visited = false;
    }

}