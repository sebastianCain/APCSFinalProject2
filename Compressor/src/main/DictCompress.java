package main;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.lang.Byte;
public class DictCompress {
  
    public static final String PUNCTUATION = "'-/:;()$&@.,?!/ []{}~<>â\"\\ ";
    public static final String LETTERS = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'-/:;()$&@.,?!/ %[]{}~<>â\"\\";
    
    public static byte[] encrypt(String txt){
        String t = txt + " STOP";
        int ctr = 1;
        HashMap<Integer, String> dict = new HashMap<Integer, String>();
        List<Byte> words = new ArrayList<Byte>();
        String word = "";
        for (int i = 0; i < t.length()-1; i++){  
          if (!t.substring(i,i+1).equals(" ")){
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
      
      //convert from Byte[] to byte[]
      byte[] finalArr = new byte[arr.length];
      for (int i = 0; i < arr.length; i++)
        finalArr[i] = arr[i].byteValue();
      return finalArr;
    }

    public static String decrypt(byte[] arr){
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
      String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ut imperdiet eros. Nam interdum ornare interdum. Mauris dapibus, orci vitae tincidunt vehicula, leo est mollis ante, sit amet tristique magna eros iaculis est. Duis tempor, purus vel pharetra luctus, sapien odio viverra erat, non semper nunc orci cursus odio. Phasellus consequat dui tortor, id sollicitudin lorem venenatis porta. In vehicula imperdiet vestibulum. Etiam semper tempus malesuada. Quisque efficitur leo enim, id facilisis erat rhoncus vitae. Vivamus mollis odio non lorem commodo, ut sagittis leo vehicula. Nam iaculis interdum augue, non ullamcorper metus fermentum a. Vivamus blandit dictum nibh, quis fringilla nibh pellentesque vitae. Sed at condimentum tortor, vulputate aliquet velit. Nam pretium eget ante sit amet bibendum. Nunc venenatis sem ac eros ornare, ultricies dignissim neque dignissim. Quisque eget hendrerit augue. Quisque ultricies at ante ut gravida. Pellentesque a mi tincidunt nisi tincidunt sollicitudin vel non mi. Fusce accumsan purus eget tellus sagittis rhoncus. Nulla mattis mollis odio sit amet rutrum. Duis ut ipsum eu urna ullamcorper condimentum at sit amet mi. Suspendisse tristique mauris magna, vel fringilla diam mattis et. Mauris tristique posuere nulla, id ornare massa tempor at. Vivamus est nulla, interdum sit amet interdum id, semper pulvinar neque. In nec est erat. Donec interdum tellus quis urna commodo ornare. Donec mollis, dui et rhoncus fermentum, tortor nisl ultrices leo, sit amet porta dolor ante non odio. Pellentesque eget diam egestas, volutpat est a, ullamcorper eros. Mauris sem purus, iaculis non pretium at, sagittis vehicula lectus. Nam consequat leo sed dui luctus semper. Donec eleifend leo at nisi laoreet, eu interdum purus ullamcorper. Mauris sed urna tellus. Vivamus enim dui, consectetur nec nibh non, fringilla aliquet nisi. Suspendisse sit amet nisl scelerisque, fringilla elit in, imperdiet dui. Praesent porta rhoncus congue. Curabitur varius nibh ac ipsum maximus, ac vehicula enim aliquam. Praesent venenatis placerat augue a lobortis. Nam viverra purus molestie luctus feugiat. Maecenas nisi mi, pulvinar vel imperdiet a, vehicula convallis mauris. Phasellus fringilla vitae dui id elementum. Nunc a interdum arcu, et fermentum eros. Pellentesque sit amet leo non orci viverra tincidunt. Curabitur convallis dui sed mi fermentum, eu varius nunc varius. Integer mauris nisl, volutpat accumsan metus non, ullamcorper luctus sapien. Aliquam feugiat enim non varius hendrerit. Mauris pulvinar urna et interdum sagittis. Mauris ac ante eros. Sed viverra finibus diam. Cras placerat interdum efficitur. Etiam vitae molestie risus. Nullam justo neque, ullamcorper id nisi.";
      String s2 = decrypt(encrypt(s));
      System.out.println(s2.equals(s));
    }

}