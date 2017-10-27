class Node {
    int data;
    Node left, right;
    String colour;
    int count;
    Node(int value) {
        data = value;
        left = right = null;
        colour= "white";
        count=0;
    }
    private void setColour(String c){
    	colour=c;
    }
    private String getColour(){
    	return colour;
    }
    private void setCount(int c){
    	count=c;
    }
    private int getCount(){
    	return count;
    }
}