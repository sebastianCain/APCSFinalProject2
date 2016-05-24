import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Compression {
  
  public static final String PUNCTUATION = "'-/:;()$&@.,?!/ []{}~<>â\"\\ ";
  public static Object[] encrypt(String txt){
   
   String t = txt + " STOP";
   int ctr = 1;
   HashMap<Integer, String> dict = new HashMap<Integer, String>();
   List<Integer> words = new ArrayList<Integer>();
   String word = "";
   for (int i = 0; i < t.length()-1; i++){
    if (PUNCTUATION.indexOf(t.substring(i,i+1)) == -1){
      word += t.substring(i,i+1);
      System.out.println(word);
    }
    else{
      System.out.println(word);
    if (!dict.containsValue(word)){
      dict.put(ctr,word);
      words.add(ctr);
      ctr++;
    }
    else {
     Integer loc = -1;
     //find the index corresponding to the word
     Object[] a = dict.entrySet().toArray(); //create an array from the dictionary
     for (int j = 0; j < a.length; j++) { //iterate through the dictionary
       a[j] = a[j].toString(); 
       if (((String)a[j]).indexOf(word) != -1) //if that entry has the word we are looking for
         loc = Integer.parseInt(((String)a[j]).substring(0,((String)a[j]).indexOf("="))); //extract the index that accompanies it
     }
     words.add(loc);
    }
    System.out.println(dict);
    word = "";
    }
   }
   Object[] x = {words, dict};
   return x;
   
   }
  
  public static String decrypt(List<Integer> keys, HashMap<Integer,String> dict){
    String ans = "";
    for (int i = 0; i < keys.size(); i++){
     if (PUNCTUATION.indexOf(keys.get(i)) != -1)
       ans += " " + dict.get(keys.get(i)); 
     else ans += dict.get(keys.get(i));
    }
    return ans.substring(1);
  }
   
    
    
  }