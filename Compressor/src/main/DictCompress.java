package main;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.lang.Byte;
public class DictCompress {
  
  public static final String PUNCTUATION = "'=+_–-/:;()$&@.,?!/ []{}~<>â\"\\ ";
  public static final String LETTERS = " \'\n\tabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'=+_–-/:;()$&@.,?!/ %[]{}~<>â\"\\";
  
  public static byte[] encrypt(String txt){
    String t = txt + " STOP"; //code doesn't include the last word, so we added a buffer word
    int ctr = 1; //the counter will serve as the Integer reference to the Strings we add into the dictionary
    HashMap<Integer, String> dict = new HashMap<Integer, String>(); //create a dictionary (Integer references to String words)
    List<Byte> words = new ArrayList<Byte>(); //create a List of Bytes (these Bytes reference the Strings in the dictionary)
    String word = ""; //initialize the String that will represent each individual word
    for (int i = 0; i < t.length()-1; i++){  //iterate through the input String
      if (!t.substring(i,i+1).equals(" ")){ //if the current character is not a space, i.e. you are still in the current word
        word += t.substring(i,i+1); //add this char to your String word
      }    
      else { //the word is complete
        int loc = -1; //the value we will add to our List (i.e. the reference to the word)
          for (Integer ref : dict.keySet()){ //iterate through the dictionary
            if (dict.get(ref).equals(word)){ //if ref is the reference to our word
              loc = ref;  //the added value will be equal to this ref
              break; //we can break out to save runtime
            }
          }
           if (loc == -1) { //if the dictionary does not already has a reference to this word
          dict.put(ctr,word); //create a new reference and put it in the dictionary
          loc = ctr++; //our added value is the counter, because it is a newly stored word in the dictionary and increment the counter to avoid reference reduncancy
        }
        
        //The following loop is used to ensure that bytes will work. For example, the integer value 130 would be scaled down into two bytes of value 127 and 3, respectively. This will ensure unique encoding of each reference.
        while (loc >= 128){ //while our reference is greater than or equal to 128
          words.add(Byte.parseByte("127")); //add the value 127 (to continue using bytes)
          loc -= 127; //do this as many times as 127 fits in
        }
        if (loc > 0) words.add(Byte.parseByte(loc+"")); //add our remaining value
        words.add(Byte.parseByte("0")); //The "0" signifies a change to the next word (necessary if there are more than 127 words in the inputted String)
        word = ""; //reinitialize the word to an empty String and reenter the loop
      }
    }
    
    
    words.add(Byte.parseByte("-1")); //Siginifies a change from the references to the dictionary itself
    for (Integer i : dict.keySet()){ //for each key in the dictionary 
      int temp = i; //we want to continue using i, so we initialize a temporary value to scale down (to continue using bytes)
      while (temp >= 128){ 
        words.add(Byte.parseByte("127"));
        temp -= 127;
      }
      if (temp != 0) words.add(Byte.parseByte(temp+""));
      words.add(Byte.parseByte("0")); //signifies a change from reference to the String (word) itself
      for (int j = 0; j < dict.get(i).length(); j++) //for every character in the word
        words.add(Byte.parseByte(LETTERS.indexOf(dict.get(i).substring(j,j+1)) + "")); //add references to each character
      words.add(Byte.parseByte("0")); //signifies a change from the word to the next reference stored in the dictionary
    }
    
    byte[] arr = new byte[words.size()]; //create a new byte[]
    for (int i = 0; i < words.size(); i++) //for every element in the List<Bytes>
      arr[i] = words.get(i).byteValue(); //cast the Byte to a byte and put it into the byte[]
    return arr;
  }
  
  public static String decrypt(byte[] arr){
    int i = 0; 
    List<Integer> keys = new ArrayList<Integer>();
    while (arr[i] != -1){ //access all the elements in the byte[] that comprise the list of references (come before the -1)
      int ref = 0; 
      while (arr[i] != 0){ //go through each complete reference (spaced in between the 0's, may consist of more than one byte if the reference int is greater than 127)
        ref += Integer.parseInt(arr[i] + ""); //convert the series of bytes into an int
        i++;
      }
      keys.add(ref); //add the reference into our list of references
      i++;
    }
    i++;
    HashMap<Integer, String> dict = new HashMap<Integer, String>();
    while (i < arr.length){ //iterate through the rest of the byte[]
      String s = "";
      int ref = 0;
      while (arr[i] != 0 && i < arr.length){ //go through the references that add up to a reference (if greater than 127, will be stored in two separate bytes)
        ref += Integer.parseInt(arr[i]+"");
        i++;
      }
      i++;
      while  (arr[i] > 0 && i < arr.length){ //go through the String that the previously found reference references using our String LETTERS (a=1,b=2,etc). Since there are fewer than 128 characters, we do not need more than one bytes.
        s += LETTERS.substring(arr[i], arr[i]+1); //concatenate the characters individually to form a word
        i++;
      }
      i++;
      dict.put(ref, s); //add the reference and the found String into our dictionary
    }
    return decryptHelp(keys,dict); //converts our List and dict into a String
  }
  
  
  public static String decryptHelp(List<Integer> keys, HashMap<Integer,String> dict){
    String ans = "";
    for (int i = 0; i < keys.size(); i++){ //for every value in the List
      ans += " " + dict.get(keys.get(i)); //add its reference in the dictionary to our return String
    }
    return ans.substring(1);
  }
  
  public static void main(String[] args){
    String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ut imperdiet eros. Nam interdum ornare interdum. Mauris dapibus, orci vitae tincidunt vehicula, leo est mollis ante, sit amet tristique magna eros iaculis est. Duis tempor, purus vel pharetra luctus, sapien odio viverra erat, non semper nunc orci cursus odio. Phasellus consequat dui tortor, id sollicitudin lorem venenatis porta. In vehicula imperdiet vestibulum. Etiam semper tempus malesuada. Quisque efficitur leo enim, id facilisis erat rhoncus vitae. Vivamus mollis odio non lorem commodo, ut sagittis leo vehicula. Nam iaculis interdum augue, non ullamcorper metus fermentum a. Vivamus blandit dictum nibh, quis fringilla nibh pellentesque vitae. Sed at condimentum tortor, vulputate aliquet velit. Nam pretium eget ante sit amet bibendum. Nunc venenatis sem ac eros ornare, ultricies dignissim neque dignissim. Quisque eget hendrerit augue. Quisque ultricies at ante ut gravida. Pellentesque a mi tincidunt nisi tincidunt sollicitudin vel non mi. Fusce accumsan purus eget tellus sagittis rhoncus. Nulla mattis mollis odio sit amet rutrum. Duis ut ipsum eu urna ullamcorper condimentum at sit amet mi. Suspendisse tristique mauris magna, vel fringilla diam mattis et. Mauris tristique posuere nulla, id ornare massa tempor at. Vivamus est nulla, interdum sit amet interdum id, semper pulvinar neque. In nec est erat. Donec interdum tellus quis urna commodo ornare. Donec mollis, dui et rhoncus fermentum, tortor nisl ultrices leo, sit amet porta dolor ante non odio. Pellentesque eget diam egestas, volutpat est a, ullamcorper eros. Mauris sem purus, iaculis non pretium at, sagittis vehicula lectus. Nam consequat leo sed dui luctus semper. Donec eleifend leo at nisi laoreet, eu interdum purus ullamcorper. Mauris sed urna tellus. Vivamus enim dui, consectetur nec nibh non, fringilla aliquet nisi. Suspendisse sit amet nisl scelerisque, fringilla elit in, imperdiet dui. Praesent porta rhoncus congue. Curabitur varius nibh ac ipsum maximus, ac vehicula enim aliquam. Praesent venenatis placerat augue a lobortis. Nam viverra purus molestie luctus feugiat. Maecenas nisi mi, pulvinar vel imperdiet a, vehicula convallis mauris. Phasellus fringilla vitae dui id elementum. Nunc a interdum arcu, et fermentum eros. Pellentesque sit amet leo non orci viverra tincidunt. Curabitur convallis dui sed mi fermentum, eu varius nunc varius. Integer mauris nisl, volutpat accumsan metus non, ullamcorper luctus sapien. Aliquam feugiat enim non varius hendrerit. Mauris pulvinar urna et interdum sagittis. Mauris ac ante eros. Sed viverra finibus diam. Cras placerat interdum efficitur. Etiam vitae molestie risus. Nullam justo neque, ullamcorper id nisi.";
    byte[] arr = encrypt(s);
    String s2 = decrypt(encrypt(s));
    System.out.println(s2.equals(s));
  }
}