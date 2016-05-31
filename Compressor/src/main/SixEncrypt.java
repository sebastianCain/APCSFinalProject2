
package main;

import java.nio.ByteBuffer;

public class SixEncrypt {
    
    private static char[] _chars;
    private static String _charString;
    private static String _exString

    public static void setup6() {
		_escapeString = "0123456789{}[]@#$%^&*_+-=<>"
        _charString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,:;'()-?/\ ";

        _chars = _charString.toCharArray();
    }
    
    public static byte[] encrypt(String txt) {
        
        SixEncrypt.setup6();
        
        //setup input chars and output bytes
        byte[] bytes = new byte[txt.length()*3/4 +8];
        String s = txt;
        char[] schars = s.toCharArray();
        
        //Set first byte to show type of encryption
        bytes[0] = 1;
        
        //next 4 bytes store length of text
        ByteBuffer buff = ByteBuffer.allocate(4);
        buff.putInt(s.length());
        byte[] result = buff.array();
        for (int i = 1; i < 5; i++)
            bytes[i] = result[i-1];
        
		//for (byte b : bytes)
	    //    System.out.print(b + " ");
        //System.out.println("");

        int currchar = 0;
        int currbyte = 5;
        
        //creates 4 characters, compresses into 3 bytes
        for (int i = 0; i < s.length(); i+=4) {
            String fourChars = "";
            for (int j = 0; j < 4; j++) {
                if (currchar < s.length())
                    fourChars += SixEncrypt.charToBinary6(schars[currchar]);
                else
                    fourChars += "000000";
                currchar++;
            }
            
			for (int k = 0; k < 3; k++) {
                //System.out.println("currbyte: " + currbyte + "  bits: " + binaryToByte(fourChars.substring(k*8, k*8+8)));
                bytes[currbyte] =  SixEncrypt. binaryToByte(fourChars.substring(k*8, k*8+8));
                currbyte++;
            }
        }

        //for (byte b : bytes)
	    //    System.out.print(b + " ");
        //System.out.println("");
        return bytes;
    }
    
    public static String decrypt(byte[] eb) {
        byte[] bytes = eb;
        
        String bytestr = "";
        String finalstr = "";
        
        byte[] size = new byte[4];
        for (int i = 0; i < 4; i++)
            size[i] = bytes[i+1];
        
        int strlength = ByteBuffer.wrap(size).getInt();

        for (byte b : bytes)
            bytestr += byteToBinary(b);
        //System.out.println("bytestr l: " + bytestr.length());
        
        int currbyte = 0;
        while (currbyte < strlength) {
            finalstr += binary6ToChar(bytestr.substring(40+currbyte*6, 40+currbyte*6+6));
            currbyte++;
        }

        return finalstr;
    }
    
    
    
    public static String charToBinary6(char c) {
        byte b = indexForChar(c);
        String s = byteToBinary(b);
		//System.out.println(c);
        return s.substring(2);
    }
    
    public static char binary6ToChar(String s) {
        String binary = "00" + s;
        byte b = binaryToByte(binary);
        return charForIndex(b);
    }
    
    public static byte indexForChar(char c){
        for (byte i = 0; i < 64; i++) {
            if (_chars[(int)i] == c)
                return i;
        }
        //not in utf 6 charset
		for (byte i = 0; i < exString.length(); i++) {
			if ()
    }
    
    public static char charForIndex(byte b) {
        return _chars[(int)b];
    }
    
    public static String byteToBinary(byte b) {
        return Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);
    }
    
    public static byte binaryToByte(String s) {
        return (byte)(int)Integer.valueOf(s, 2);
    }
     
    /*
	public static void main(String args[]) {
        setup6();
        String s = "Asher is a major fucking dick.";
        System.out.println("\nOriginal Text:\n" + s + "\n\nEncrypted Bytes:");
        byte[] bytes = encrypt(s);
        for (byte b : bytes)
            System.out.print(b + ", ");
        System.out.println("\n");
        String output = decrypt(bytes);
        System.out.println(output);
        
	}
    */	
}
