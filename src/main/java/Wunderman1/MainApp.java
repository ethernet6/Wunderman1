/**
 * 
 */
package Wunderman1;

import java.io.*;
import java.util.*;
/**
 * @author James
 *
 */
public class MainApp {

	/**
	 * @param args
	 */
	
	
	public String sayHello() {
	      return "Hello Gradle";
	   }

	   public static void main(String[] args) {
	      MainApp app = new MainApp();
	      System.out.println(app.sayHello());
	      
	      
	      
	      HashMap<String, Person> holder = new HashMap<String, Person>();
	      
	      String csvFile = "src\\test\\resources\\people.csv";
	      
	      //List<List<String>> records = new ArrayList<>();
	      List<Person> csr = new ArrayList<>();
	      try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	          String line;
	          while ((line = br.readLine()) != null) {
	              String[] values = line.split(",");
	              
	              csr.add(new Person(values[0],values[1], Integer.parseInt(values[2])   ));
	              //hash
	              holder.put(values[1], new Person(values[0],values[1], Integer.parseInt(values[2])) );
	              //System.out.println(holder.get(values[1]).name); // bob at 0
	              //System.out.println();
	              //records.add(Arrays.asList(values));
	          }
	      }
	      catch(FileNotFoundException e ) {
	    	  System.out.println(e.getMessage());
	      }
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	      
	      
	      // end of try catch
	      
	      //System.out.println(records.get(1));
	      System.out.println(csr.get(1).getDetails());
	      
	      for(Person x : csr) {
	    	  
	    	  System.out.println(x.getDetails());
	      }
	      System.out.println();
	      System.out.println();
	      
	      // begin network read
	      
   String csvFile2 = "src\\test\\resources\\relationships.csv";
   
   Queue<Node> PrimaryQueue = new LinkedList<Node>();
   Node child = new Node();
   Node n = new Node(new Person());
   HashMap<String, Node> nodeHolder = new HashMap<String, Node>();
   
   
   
   
	      //List<List<String>> records = new ArrayList<>();
	      List<Person> rel = new ArrayList<>();
	      try (BufferedReader br = new BufferedReader(new FileReader(csvFile2))) {
	          String line;
	          while ((line = br.readLine()) != null) {
	              String[] values = line.split(",");
	              
	              // only non blank
	              
	              if(values.length > 2) {
	            	  // blank lines has value of 1
	            	  //System.out.println("rm " + values.length);
	            	  //System.out.println(Arrays.toString(values));
	            	  
	            	  //if contains key do this
	            	  if(!nodeHolder.containsKey(holder.get(values[0]).email))
	            	  {
	            		  // create node with PERSON data
	            		  n = new Node(holder.get(values[0]));
	            		  
	            		  //set family
	            		  
	            		  // set friends
	            		  
	            		  //n = new Node(holder.get(values[0]));
		            	  //System.out.println("jrx "+ holder.get(values[0]).email);
		            	  //System.out.println(n.data.getDetails());
		            	  
		            	  
		            	  
		            	  if(values[1].equals("FAMILY")) {
		            		  child = new Node(holder.get(values[2]));
		            		  n.family.add(child);
		            		  child.setParent(n);
		            		  
			            	  //System.out.println("fam");
			            	  System.out.println();
			            	  
			            	  
			            	  // backwards pass
			            	  child.family.add(n);
			            	  
			            	  }
		            	  
		            	  if(values[1].equals("FRIEND")) {
		            		  child = new Node(holder.get(values[2]));
		            		  n.friends.add(child);
		            		  child.setParent(n);
			            	  //System.out.println("frd");
			            	  System.out.println();
			            	  
			            	  // backwards pass
			            	  child.friends.add(n);
			            	  
			            	  }
		            	  
		            	 //PrimaryQueue.add(child); 
	            		  
	            		  // save to node HOLDER
	            		  nodeHolder.put(values[0], n);
	            		  
	            	  }else {
	            		  
	            		  // fetch the desired node to be modified
	            		  n = nodeHolder.get(values[0]);
	            		  
	            		  // edit the relationship
	            		  
	            		  if(values[1].equals("FAMILY")) {
		            		  child = new Node(holder.get(values[2]));
		            		  n.family.add(child);
		            		  child.setParent(n);
		            		  
			            	  //System.out.println("fam");
			            	  System.out.println();
			            	  
			            	  
			            	  // backwards pass
			            	  child.family.add(n);
			            	  
			            	  }
		            	  
		            	  if(values[1].equals("FRIEND")) {
		            		  child = new Node(holder.get(values[2]));
		            		  n.friends.add(child);
		            		  child.setParent(n);
			            	  //System.out.println("frd");
			            	  System.out.println();
			            	  
			            	  // backwards pass
			            	  child.friends.add(n);
			            	  
			            	  }
		            	  
		            	// save to node HOLDER
	            		  nodeHolder.put(values[0], n);
	            	  }
	            	  
	            	  
	            	  
	            	  // R1 @ R2
	            	  // Backwards pass
	            	  
	            	//if contains key do this
	            	  if(!nodeHolder.containsKey(holder.get(values[2]).email))
	            	  {
	            		  // create node with PERSON data
	            		  n = new Node(holder.get(values[2]));
	            		  
	            		  //set family
	            		  
	            		  // set friends
	            		  
	            		  //n = new Node(holder.get(values[0]));
		            	  //System.out.println("jrx "+ holder.get(values[0]).email);
		            	  //System.out.println(n.data.getDetails());
		            	  
		            	  
		            	  
		            	  if(values[1].equals("FAMILY")) {
		            		  child = new Node(holder.get(values[0]));
		            		  n.family.add(child);
		            		  child.setParent(n);
		            		  
			            	  //System.out.println("fam");
			            	  System.out.println();
			            	  
			            	  
			            	  // backwards pass
			            	  child.family.add(n);
			            	  
			            	  }
		            	  
		            	  if(values[1].equals("FRIEND")) {
		            		  child = new Node(holder.get(values[0]));
		            		  n.friends.add(child);
		            		  child.setParent(n);
			            	  //System.out.println("frd");
			            	  System.out.println();
			            	  
			            	  // backwards pass
			            	  child.friends.add(n);
			            	  
			            	  }
		            	  
		            	 //PrimaryQueue.add(child); 
	            		  
	            		  // save to node HOLDER
	            		  nodeHolder.put(values[2], n);
	            		  
	            	  }else {
	            		  
	            		  // fetch the desired node to be modified
	            		  n = nodeHolder.get(values[2]);
	            		  
	            		  // edit the relationship
	            		  
	            		  // error here
	            		  System.out.println("F2F  " + values.length);
		            	  System.out.println(Arrays.toString(values));
	            		  
	            		  if(values[1].equals("FAMILY")) {
		            		  child = new Node(holder.get(values[0]));
		            		  n.family.add(child);
		            		  child.setParent(n);
		            		  
			            	  //System.out.println("fam");
			            	  System.out.println();
			            	  
			            	  
			            	  // backwards pass
			            	  child.family.add(n);
			            	  
			            	  }
		            	  
		            	  if(values[1].equals("FRIEND")) {
		            		  child = new Node(holder.get(values[0]));
		            		  n.friends.add(child);
		            		  child.setParent(n);
			            	  //System.out.println("frd");
			            	  System.out.println();
			            	  
			            	  // backwards pass
			            	  child.friends.add(n);
			            	  
			            	  }
		            	  
		            	// save to node HOLDER
	            		  nodeHolder.put(values[2], n);
	            	  }
	            	  
	            	  
	            	  
	            	  
		            	  
		            	
	            	  
	            	 //PrimaryQueue.add(child); 
	              }
	              /*if(values[1].equals("FAMILY")) {
	            	  System.out.println("fm");
	              }*/
	              
	              
	              System.out.println();
	              
	              
	              
	              
	              // OUTER
	              
	              
	              //records.add(Arrays.asList(values));
	          }
	      }
	      catch(FileNotFoundException e ) {
	    	  System.out.println(e.getMessage());
	      }
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	      
	      
	      
	      // check nodes with no relationships
	      
	      //Iterator<Map.Entry<String, Person> > iterator = map.entrySet().iterator(); 
	      System.out.println("WATERVILLE");
	      for(Person x : csr) {
	    	  
	    	  System.out.println(x.getEmail());
	    	  
	    	  if(!nodeHolder.containsKey(x.getEmail())) {
		    		// create node with PERSON data
	    		  System.out.println("NOT FOUND -> ADD KEY TO NODE");
	        		  n = new Node(x);
	        		// save to node HOLDER
            		  nodeHolder.put(x.getEmail(), n);
		    	  }
	      }
	      System.out.println();
	      System.out.println();
	      
	      
	      
	      
	      
	      
	      
	      
	      // the cont ???
	      System.out.println("CONT 1234 ");
	      System.out.println();
	     //n = PrimaryQueue.poll();
	      nodeHolder.forEach((k, v) -> {
	            //System.out.format("key: %s," + System.lineSeparator() + "value: "+ System.lineSeparator() , k, v);
	    	  System.out.format("key: %s," + System.lineSeparator()  , k, v);
	            
	    	  System.out.println("Family >>");
	    	  System.out.println();
	            for (Node x : v.family) {
	            	
	  	    	  System.out.println(x.data.name);
	  	      }
	            System.out.println();
	            System.out.println("Friends >>");
	            for (Node x : v.friends) {
	            	
	  	    	  System.out.println(x.data.name);
	  	      }
	           System.out.println();
	            
	        });
	      
	      
	   } // end of MAIN	
	   
	   

}
