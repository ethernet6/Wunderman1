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
	      
	      
	      // begin network read
	      
   String csvFile2 = "src\\test\\resources\\relationships.csv";
   
   Queue<Node> PrimaryQueue = new LinkedList<Node>();
   Node child = new Node();
   Node n = new Node(new Person());
	      //List<List<String>> records = new ArrayList<>();
	      List<Person> rel = new ArrayList<>();
	      try (BufferedReader br = new BufferedReader(new FileReader(csvFile2))) {
	          String line;
	          while ((line = br.readLine()) != null) {
	              String[] values = line.split(",");
	              
	              // only non blank
	              
	              if(values.length > 2) {
	            	  // blank lines has value of 1
	            	  System.out.println("rm " + values.length);
	            	  System.out.println(Arrays.toString(values));
	            	  
	            	  
	            	  //create node
	            	  // HOLDER -> <email, PERSON>
	            	  n = new Node(holder.get(values[0]));
	            	  //System.out.println("jrx "+ holder.get(values[0]).email);
	            	  //System.out.println(n.data.getDetails());
	            	  
	            	  
	            	  
	            	  if(values[1].equals("FAMILY")) {
	            		  child = new Node(holder.get(values[2]));
	            		  n.family.add(child);
	            		  child.setParent(n);
	            		  
		            	  System.out.println("fam");
		            	  System.out.println();
		            	  
		            	  
		            	  // backwards pass
		            	  child.family.add(n);
		            	  
		            	  }
	            	  
	            	  if(values[1].equals("FRIEND")) {
	            		  child = new Node(holder.get(values[2]));
	            		  n.family.add(child);
	            		  child.setParent(n);
		            	  System.out.println("frd");
		            	  System.out.println();
		            	  
		            	  // backwards pass
		            	  child.friends.add(n);
		            	  
		            	  }
	            	  
	            	 PrimaryQueue.add(child); 
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
	      
	      
	      
	      // backwards pass
	      
	      
	      
	      
	      
	      
	      // the cont ???
	      System.out.println("CONT 1234 ");
	      System.out.println();
	     n = PrimaryQueue.poll();
	      for (Node x : n.family) {
	    	  System.out.println(n.data.name);
	      }
	      
	   } // end of MAIN	
	   
	   

}
