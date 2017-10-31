import java.util.ArrayList;

import dummy.node2;


class Node {
    int data;
    public ArrayList<Node> edges;
    public int key;
    public int in;
    public int out;
    Node(int data, int key) {
        this.data = data;
        this.key = key;
        edges = new ArrayList<Node>();
        in = 0;
        out = edges.size();
    }
}