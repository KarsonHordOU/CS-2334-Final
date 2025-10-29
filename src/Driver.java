// DH
public class Driver extends ArrayList {
  public static void main(String[] args) {
	  ArrayList<String> list = new ArrayList<>();
      list.add("a");
      list.add("b");
      list.add("c");

      System.out.println(list);          
      System.out.println(list.get(1));   
      list.remove(0);
      System.out.println(list);         
      System.out.println("Size: " + list.size()); 
	}  
	
  }

