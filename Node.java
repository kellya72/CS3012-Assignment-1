import java.util.ArrayList;




class Node {
	int data;
    public ArrayList<Node> edges;
    public String key;
    public int in;
    public int out;
    Node(String key, int data) {
        this.data = data;
        this.key = key;
        edges = new ArrayList<Node>();
        in = 0;
        out = edges.size();
    }
    public void connect(Node child)
    {
        if(child != null)
        {
            this.edges.add(child);
            child.in++;
        }
        
    }

}