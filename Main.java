// Name: Deziallia Morris

package com.dezji;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// the reference maze for this program is attached as "numbered maze"!
		// make 110 nodes
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 110; i++)
            nodes.add(new Node(i+1));
        
        // nodes 51, 91, 100, 60, and 30 are the exits
        nodes.get(50).isExit = true;
        nodes.get(90).isExit = true;
        nodes.get(99).isExit = true;
        nodes.get(59).isExit = true;
        nodes.get(29).isExit = true;
        
        
        // connect the nodes to represent the maze
        
        // 1 - 10
        connect(nodes, 1, 2);
        connect(nodes, 1, 11);
        connect(nodes, 2, 3);
        connect(nodes, 3, 4);
        connect(nodes, 4, 14);
        connect(nodes, 4, 5);
        connect(nodes, 5, 15);
        connect(nodes, 5, 6);
        connect(nodes, 7, 17);
        connect(nodes, 7, 8);
        connect(nodes, 8, 9);
        connect(nodes, 9, 19);
        connect(nodes, 10, 20);
        
        // 11 - 20
        connect(nodes, 11, 21);
        connect(nodes, 12, 13);
        connect(nodes, 13, 23);
        connect(nodes, 13, 14);
        connect(nodes, 14, 24);
        connect(nodes, 15, 25);
        connect(nodes, 15, 16);
        connect(nodes, 16, 26);
        connect(nodes, 16, 17);
        connect(nodes, 17, 27);
        connect(nodes, 18, 28);
        connect(nodes, 19, 20);
        
        // 21 -30
        connect(nodes, 21, 22);
        connect(nodes, 22, 23);
        connect(nodes, 23, 33);
        connect(nodes, 24, 34);
        connect(nodes, 26, 36);
        connect(nodes, 27, 28);
        connect(nodes, 28, 29);
        connect(nodes, 29, 39);
        connect(nodes, 29, 30);
        connect(nodes, 30, 40);
        
        // 31 - 40
        connect(nodes, 31, 41);
        connect(nodes, 31, 32);
        connect(nodes, 32, 33);
        connect(nodes, 33, 43);
        connect(nodes, 33, 34);
        connect(nodes, 34, 44);
        connect(nodes, 34, 35);
        connect(nodes, 35, 36);
        connect(nodes, 36, 46);
        connect(nodes, 36, 37);
        connect(nodes, 37, 38);
        connect(nodes, 38, 48);
        connect(nodes, 39, 49);
        connect(nodes, 40, 50);
        
        // 41 - 50
        connect(nodes, 41, 51);
        connect(nodes, 42, 52);
        connect(nodes, 42, 43);
        connect(nodes, 45, 55);
        connect(nodes, 45, 46);
        connect(nodes, 46, 47);
        connect(nodes, 47, 57);
        connect(nodes, 48, 58);
        connect(nodes, 49, 59);
        
        // 51 - 60
        connect(nodes, 51, 61);
        connect(nodes, 52, 53);
        connect(nodes, 53, 54);
        connect(nodes, 54, 64);
        connect(nodes, 55, 56);
        connect(nodes, 56, 66);
        connect(nodes, 57, 67);
        connect(nodes, 58, 68);
        connect(nodes, 58, 59);
        connect(nodes, 59, 60);
        connect(nodes, 60, 70);
        
        // 61 - 70
        connect(nodes, 61, 62);
        connect(nodes, 61, 71);
        connect(nodes, 63, 73);
        connect(nodes, 63, 64);
        connect(nodes, 64, 65);
        connect(nodes, 66, 76);
        connect(nodes, 67, 68);
        connect(nodes, 69, 70);
        connect(nodes, 70, 80);
        
        // 71 - 79
        connect(nodes, 71, 81);
        connect(nodes, 72, 82);
        connect(nodes, 72, 73);
        connect(nodes, 74, 84);
        connect(nodes, 74, 75);
        connect(nodes, 75, 85);
        connect(nodes, 76, 77);
        connect(nodes, 78, 79);
        connect(nodes, 79, 89);
        
        // 82 - 90
        connect(nodes, 82, 92);
        connect(nodes, 83, 93);
        connect(nodes, 83, 84);
        connect(nodes, 85, 95);
        connect(nodes, 85, 86);
        connect(nodes, 86, 96);
        connect(nodes, 87, 97);
        connect(nodes, 87, 88);
        connect(nodes, 88, 89);
        connect(nodes, 89, 90);
        connect(nodes, 90, 100);
        
        // 91 - 100
        connect(nodes, 91, 92);
        connect(nodes, 92, 93);
        connect(nodes, 94, 95);
        connect(nodes, 96, 97);
        connect(nodes, 98, 99);
        connect(nodes, 99, 100);
        
        
        
        List<Node> visited = new ArrayList<>();
        List<Node> path = new ArrayList<>();
        solve(nodes.get(0), visited, path);
    }
    
    private static void connect(List<Node> nodes, int nodeId1, int nodeId2) {
        // point the first node to the second node, and the second to the first
        nodes.get(nodeId1 - 1).children.add(nodes.get(nodeId2 - 1));
        nodes.get(nodeId2 - 1).children.add(nodes.get(nodeId1 - 1));
    }

    private static boolean solve(Node node, List<Node> visited, List<Node> path) {
        
        visited.add(node);
        path.add(node);
        
        List<Node> listOfPaths = new ArrayList<>();
        
        if (node.isExit) {
            for (Node pathNode : path) {
                listOfPaths.add(pathNode);
            }
            
            // gets the length of each path
            int length = listOfPaths.size();
            
            out.print("\n" + listOfPaths + "\nThe number of nodes used to achieve this path is: " + length + "\n\n");
            
            
        }
        
        for (Node child : node.children)
            if (!visited.contains(child))
                if (solve(child, visited, path))
                    return true;
        
        path.remove(path.size() - 1);
        return false;
    }
}

class Node {
    int nodeNumber;
    List<Node> children = new ArrayList<>();
    boolean isExit = false;
    
    public Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }
    
    @Override
    public String toString() {
        return ((Integer) nodeNumber).toString();
    }
}
