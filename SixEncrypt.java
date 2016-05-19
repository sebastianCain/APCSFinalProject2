import java.nio.ByteBuffer;

public class SixEncrypt {
    
    private static char[] _chars;
    private static String _charString;
    
    public static void setup6() {
        _charString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789. ";
        _chars = _charString.toCharArray();
    }
    
    public static byte[] encrypt(String txt) {
        
        setup6();
        
        //setup input chars and output bytes
        byte[] bytes = new byte[txt.length()+5];
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
	        //System.out.println(b);

        //creates 4 characters, compresses into 3 bytes
        for (int i = 0; i < s.length(); i+=4) {
            String fourChars = "";
            for (int j = 0; j < 4; j++) {
				//System.out.println(i + ", " + j);
                fourChars += charToBinary6(schars[i+j]);
            }
			for (int k = 0; k < 3; k++)
                bytes[5+i+k] = binaryToByte(fourChars.substring(k*8, k*8+8));
        }
        return bytes;
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
        return 0;
    }
    
    public static char charForIndex(byte b) {
        return _chars[(int)b];
    }
    
    public static String byteToBinary(byte b) {
        return String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0');
    }
    
    public static byte binaryToByte(String s) {
        return (byte)(int)Integer.valueOf(s, 2);
    }

	public static void main(String args[]) {
		String s = "abcdefgh";
		//System.out.println(byteToBinary((byte)46));
        byte[] bytes = SixEncrypt.encrypt(s);
		for (byte b : bytes)
	        System.out.println(b);
	}	
}
