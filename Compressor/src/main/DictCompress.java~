import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.lang.Byte;
public class DictCompress {
  
    public static final String PUNCTUATION = "'-/:;()$&@.,?!/ []{}~<>â\"\\ ";
    public static final String LETTERS = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'-/:;()$&@.,?!/ []{}~<>â\"\\";
    
    public static Byte[] encrypt(String txt){
        String t = txt + " STOP";
        int ctr = 1;
        HashMap<Integer, String> dict = new HashMap<Integer, String>();
        List<Byte> words = new ArrayList<Byte>();
        String word = "";
        for (int i = 0; i < t.length()-1; i++){  
          if (!t.substring(i,i+1).equals(" ")){//PUNCTUATION.indexOf(t.substring(i,i+1)) == -1) {
                word += t.substring(i,i+1);
            }    
            else {
                if (!dict.containsValue(word)) {
                    dict.put(ctr,word);
                    int temp = ctr;
                    while (temp >= 128){
                      words.add(Byte.parseByte("127"));
                      temp -= 127;
                    }
                    words.add(Byte.parseByte(temp+""));
                    words.add(Byte.parseByte("0"));
                    ctr++;
                }
                else {
                  for (Integer ref : dict.keySet()){
                    if (dict.get(ref).equals(word)){
                      int loc = ref;
                      while (loc >= 128){
                        words.add(Byte.parseByte("127"));
                        loc -= 127; 
                      }
                      if (loc > 0) words.add(Byte.parseByte(loc+""));
                      words.add(Byte.parseByte("0"));
                    }
                     
                  }     
                }
                
                word = "";
            }
        }
        
        words.add(Byte.parseByte("-1"));
      List<Byte> L = new ArrayList<Byte>();
      for (Integer i : dict.keySet()){
        int temp = i;
        while (temp >= 128){
          L.add(Byte.parseByte("127"));
          temp -= 127;
        }
        if (temp != 0) L.add(Byte.parseByte(temp+""));
        L.add(Byte.parseByte("0"));
       for (int j = 0; j < dict.get(i).length(); j++)
         L.add(Byte.parseByte(LETTERS.indexOf(dict.get(i).substring(j,j+1)) + "")); //add references to each char
       L.add(Byte.parseByte("0"));
      }
      
      for (int i = 0; i < L.size(); i++)
        words.add(L.get(i));
      Byte[] arr = new Byte[words.size()];
      for (int i = 0; i < words.size(); i++)
        arr[i] = words.get(i);
      return arr;
    }

    public static int[] toIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }

    public static byte[] integersToBytes(int[] values){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        for(int i=0; i < values.length; ++i) {
          try {dos.writeInt(values[i]);}
          catch(Exception e){
           e.printStackTrace(); 
          }
        }
        return baos.toByteArray();
    }
    
    public static int[] convertToIntArray(byte[] bytearr){
    int[] ans = new int[bytearr.length/4];
    for (int i = 0; i < ans.length; i++)
    {
        ans[i] = toInt(bytearr[4*i]) + toInt(bytearr[4*i+1]) + toInt(bytearr[4*i+2]) + toInt(bytearr[4*i+3]); 
    }
    return ans;
}
    
    public static int toInt(Byte b){
     if (b >= 0) return b.intValue();
     return 128 + Math.abs(128+b.intValue());
    }

    public static String decrypt(Byte[] arr){
     int i = 0;
     List<Integer> keys = new ArrayList<Integer>();
     while (arr[i] != -1){
       int ref = 0;
       while (arr[i] != 0){
         ref += Integer.parseInt(arr[i] + "");
         i++;
       }
       keys.add(ref);
       i++;
     }

     i++;
     HashMap<Integer, String> dict = new HashMap<Integer, String>();
     while (i < arr.length){
       String s = "";
       int ref = 0;
       while (arr[i] != 0 && i < arr.length){
         ref += Integer.parseInt(arr[i]+"");
         i++;
       }
       i++;
       System.out.println(dict);
       while  (arr[i] > 0 && i < arr.length){
         s += LETTERS.substring(arr[i], arr[i]+1);
         i++;
       }
       i++;
       dict.put(ref, s);
      //System.out.println(dict);
    }
     return decryptHelp(keys,dict);
    }
      
    
    public static String decryptHelp(List<Integer> keys, HashMap<Integer,String> dict){
        String ans = "";
        for (int i = 0; i < keys.size(); i++){
                ans += " " + dict.get(keys.get(i));
        }
        return ans.substring(1);
    }
    
    public static void main(String[] args){
      String s = "
    }

}