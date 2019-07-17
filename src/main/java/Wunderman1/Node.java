/**
 * 
 */
package Wunderman1;

/**
 * @author James
 *
 */

import java.util.ArrayList;
import java.util.Comparator;


public class Node implements Comparator<Node>{
    
    Node left;
    Node right;
    
    Person data;
    public Node parent;
    ArrayList<Node> family;
    ArrayList<Node> friends;
    
    ArrayList<String> fam;
    ArrayList<String> fri;
    
    
    int depth;
    boolean visited_site;
    
    int solutionCost;
    int total_cost;

	public Node(Person data) {
		this.data = data;
		left = null;
		right = null;
                parent = null;
                family = new ArrayList<Node>();
                friends = new ArrayList<Node>();
	}
       
        //constructor default
        public Node(){
                this.data = null;
                left = null;
		right = null;
                parent = null;
                family = new ArrayList<Node>();
                friends = new ArrayList<Node>();
        }
     
        
    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public void addFamily(Node child) {
        family.add(child);
    }
    
    public void addFriend(Node child) {
        friends.add(child);
    }
    
    
    
    
    
    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    public int getDepth() {
        return depth;
    }

    public boolean WasVisited() {
        return visited_site;
    }
    
    public void setVisited(boolean visit_true) {
        this.visited_site = visit_true;
    }
    
    public void setSolutionCost(int tc) {
        this.solutionCost = tc;
    }
    
    public void setTotalCost(int cost, int estimate) {
        this.total_cost = cost + estimate;
    }
    
    
    
    @Override
    public int compare(Node x, Node y) {
        if (x.total_cost < y.total_cost) {
            return -1;
        }
        if (x.total_cost > y.total_cost) {
            return 1;
        }
        return 0;
    }
        
}
