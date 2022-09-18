

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.*;




public class connection{  
 public static void conn(){  
  try{  
	   
  
	  MongoClient mongoClient = new MongoClient("localhost",27017);
	  DB db = mongoClient.getDB("Ecommerce");
	  
  }catch(Exception e){ 
   System.out.println(e);
  }  
  
 }  
}