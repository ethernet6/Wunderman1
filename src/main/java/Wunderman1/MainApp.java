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
	      
	      
	      // PRINT ALL RECORDS
	      
	      //System.out.println(records.get(1));
	      //System.out.println(csr.get(1).getDetails());
	      
	      for(Person x : csr) {
	    	  
	    	  //System.out.println(x.getDetails());
	      }
	      System.out.println();
	      System.out.println();
	      
	      // begin network read
	      
   String csvFile2 = "src\\test\\resources\\relationships.csv";
   
   Queue<Node> PrimaryQueue = new LinkedList<Node>();
   Node child = new Node();
   Node n = new Node(new Person());
   HashMap<String, Node> nodeHolder = new HashMap<String, Node>();
   
   
   HashMap<String, Person> cohort = new HashMap<String, Person>();
   
   
   
   
	      //List<List<String>> records = new ArrayList<>();
	      List<Person> rel = new ArrayList<>();
	      try (BufferedReader br = new BufferedReader(new FileReader(csvFile2))) {
	          String line;
	          while ((line = br.readLine()) != null) {
	              String[] values = line.split(",");
	              
	              // only non blank
	              
	              if(values.length > 2) {
	            	  //System.out.println(Arrays.asList(values));
	            	  //System.out.println(values[2]);
	            	  
	            	  if(values[1].equals("FAMILY")) {
	            		  
	            		// forward pass
		            	  Person p = holder.get(values[0]);
		            	  //System.out.println(p.name);
		            	  p.family.add(values[2]);
		            	  holder.put(values[0], p);
		            	  
		            	  //backwards pass
		            	  
		            	  p = holder.get(values[2]);
		            	  p.family.add(values[0]);
		            	  holder.put(values[2], p);
	            		  
	            	  }
	            	  
	            	  if(values[1].equals("FRIEND")) {
	            		// forward pass
		            	  Person p = holder.get(values[0]);
		            	  //System.out.println(p.name);
		            	  p.friends.add(values[2]);
		            	  holder.put(values[0], p);
		            	  
		            	  //backwards pass
		            	  
		            	  p = holder.get(values[2]);
		            	  p.friends.add(values[0]);
		            	  holder.put(values[2], p);
	            	  }
	            	  
	            	  
	            	  
	              }
	          
	          }
	      }
	      catch(FileNotFoundException e ) {
	    	  System.out.println(e.getMessage());
	      }
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	      
	      
	      
	      System.out.println();
	      System.out.println();
	      System.out.println("KEY ->");
	      Person a = holder.get("dave@dentists.com");
	      
	    for(String s : a.family) {
	    	
	    	System.out.println(s);
	    }  
	      
	      
	      // check nodes with no relationships
	    System.out.println();
	      System.out.println();
	      //Iterator<Map.Entry<String, Person> > iterator = map.entrySet().iterator(); 
	      System.out.println("WATERVILLE");
	      for(Person x : csr) {
	    	  
	    	  //System.out.println(x.getEmail());
	    	  
	    	  if(!holder.containsKey(x.getEmail())) {
		    		// create node with PERSON data
	    		  System.out.println("NOT FOUND -> ADD KEY TO NODE");
	        		 Person p = x;
	        		// save to node HOLDER
            		  holder.put(x.getEmail(), p);
		    	  }
	      }
	      System.out.println();
	      System.out.println();
	      
	      
	      
	      // ESTABLISH ALL RELATIONSHIPS
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      // the cont ???
	      System.out.println("CONT 1234 ");
	      System.out.println();
	     //n = PrimaryQueue.poll();
	      holder.forEach((k, v) -> {
	            //System.out.format("key: %s," + System.lineSeparator() + "value: "+ System.lineSeparator() , k, v);
	    	  System.out.format("key: %s," + System.lineSeparator()  , k, v);
	            
	    	  System.out.println("Family >>");
	    	  System.out.println();
	    	  
	    	  
	    	  
	    	  
	  	      /*int res = countFamily( v );
	  	      System.out.println("Family Count <FE>");
	  	      System.out.println(v.data.name + "        " + res );*/
	    	  
	    	  
	    	  for (String x : v.family) {
	    		  //System.out.println(x);
	  	    	  
	  	    	
	  	      }
	    	  	
	    	  
	    	  
	            /*for (Node x : v.family) {
	            	
	  	    	  System.out.println(x.data.name);
	  	    	  
	  	    	  if(x.data.name.equals("Pete")) {
	  	    		Node er = nodeHolder.get("pete@timber.com");
	  	    		  for( Node g : er.family) {
	  	    			System.out.println("P " +g.data.name);
	  	    		  } 
	  	    	  }
	  	    	
	  	      }*/
	            System.out.println();
	            System.out.println("Friends >>");
	            /*for (Node x : v.friends) {
	            	
	  	    	  System.out.println(x.data.name);
	  	      }*/
	           System.out.println();
	            
	        });
	      
	      System.out.println();
	      System.out.println();
	      System.out.println();
	      List<String> store = new ArrayList<String>();
	      String sample =  "nigel@marketing.com"; 
	      int res = countFamily( holder.get(sample),holder, 0, store );
	      System.out.println("Family Count");
	      System.out.println(sample + "        " + res);
	   } // end of MAIN	
	   
	
	   
	  static int countFamily(Person p, HashMap<String, Person> holder, int count, List<String>  store) {
		  
		  //count = p.family.size();
		  
		  p.visited = true;
		  holder.put(p.getEmail(), p);
		  
		  if(count == 0) {
			  store.add(p.getEmail());
			  count = 1;
		  }
		  
		  
		  for(String s: p.family) {
		  
			  Person x = holder.get(s);
			  if(!x.visited){
				  //count++;
				  System.out.println("nd -> "+ x.getEmail());
				  store.add(x.getEmail());
				  x.visited = true;
				  holder.put(x.getEmail(), x);
				  count = countFamily(x, holder, count, store);
				  
			  }
			  
		  }
		  
		  //count++;
		  
		  return store.size();
	  } 
	 
}
