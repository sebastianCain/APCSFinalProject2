import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;

public class Compression {
  
    public static final String PUNCTUATION = "'-/:;()$&@.,?!/ []{}~<>â\"\\ ";
    
    public static byte[] encrypt(String txt){
        String t = txt + " STOP";
        int ctr = 1;
        HashMap<Integer, String> dict = new HashMap<Integer, String>();
        List<Integer> words = new ArrayList<Integer>();
        String word = "";
        for (int i = 0; i < t.length()-1; i++){  
            if (PUNCTUATION.indexOf(t.substring(i,i+1)) == -1) {
                word += t.substring(i,i+1);
                System.out.println(word);
            }    
            else {
                System.out.println(word);
                if (!dict.containsValue(word)) {
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
        //Object[] x = {words, dict};
        //return x; 
        int[] w = new int[words.size()];
        w = toIntArray(words);
        return integersToBytes(w);
    }

    public static int[] toIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
        //http://www.java2s.com/Code/Java/File-Input-Output/Convertobjecttobytearrayandconvertbytearraytoobject.htm
    }

    public static byte[] integersToBytes(int[] values){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        for(int i=0; i < values.length; ++i) {
            dos.writeInt(values[i]);
        }
        return baos.toByteArray();
    }

    public static String decrypt(List<Integer> keys, HashMap<Integer,String> dict){
        String ans = "";
        for (int i = 0; i < keys.size(); i++){
            if (PUNCTUATION.indexOf(keys.get(i)) != -1)
                ans += " " + dict.get(keys.get(i)); 
            else 
                ans += dict.get(keys.get(i));
        }
        return ans.substring(1);
    }

}