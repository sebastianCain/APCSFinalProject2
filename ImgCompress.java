
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

import java.nio.ByteBuffer;

public class ImgCompress{

	private static BufferedImage _img;
//file = clue.bmp
	public static void setupImg(String file){
		try
	    	{
	      	// the line that reads the image file
	     	 BufferedImage img = ImageIO.read(new File(file));
	     	 _img = img;
	     	 } 
    	catch (IOException e)
	    {
	      System.out.println("error");
    	}
	}

	private static int _width;
	private static int _height;

	private static byte[][] pixels;

	private static ArrayList<Integer> preclrs;

	private static byte[] clrs;

	private static ArrayList<Integer> vals;

	private static ArrayList<Byte> prefin; 


	private static byte[] fin;


	public static byte[] encrypt(String file){
		setupImg(file);

		int _width = _img.getWidth();
		int _height = _img.getHeight();
		System.out.println("width: " + _width + "height: " + _height);

		byte[][] pixels = new byte[_width][_height];
		preclrs = new ArrayList<>();//holds palette while image is being processed
		//byte[] clrs;//holds palette

		//colors have values of 0-255. bytes have values of -128-127. overflow must be utilized
		for (int i = 0; i < _width; i++){
			for (int j = 0; j < _height; j++){
				int color = _img.getRGB(i, j);
		    	if (!preclrs.contains(color)) 
		    		preclrs.add(color);
		    }
		}


		clrs = new byte[preclrs.size()];

		for (int i = 0; i < preclrs.size()-1; i++){
			if (preclrs.get(i) <= 127) 
				clrs[i]=((byte)((preclrs.get(i)).intValue()));
			else 
				clrs[i]=((byte)((preclrs.get(i)).intValue()-256));
		}

		for (int i = 0; i < pixels.length; i++){
			for (int k = 0; k < pixels[i].length; k++){
				int pix = _img.getRGB(i, k);
				for (int l = 0; l < preclrs.size(); l++)
					if(pix == preclrs.get(l)){
						pixels[i][k] = (byte)(l);
					}
			}
		}

		prefin = new ArrayList<>();

		vals = new ArrayList<>();
		vals.add(clrs.length);
		vals.add(_width);
		vals.add(_height);

		
		byte[] clrlen = ByteBuffer.allocate(4).putInt(clrs.length).array();
		byte[] wid = ByteBuffer.allocate(4).putInt(_width).array();
		byte[] hi = ByteBuffer.allocate(4).putInt(_height).array();

		
		for (int y = 0; y < 4; y++) {
   			prefin.add(clrlen[y]);
		}

		for (int z = 0; z < 4; z++) {
   			prefin.add(wid[z]);
		}

		for (int x = 0; x < 4; x++) {
			prefin.add(hi[x]);
		}

		for (int m = 0; m < clrs.length; m++){
			prefin.add(clrs[m]);
		}

		for (int i = 0; i < pixels.length; i++){
			for (int k = 0; k < pixels[i].length; k++){
				prefin.add(pixels[i][k]);
			}
		}

		fin = new byte[prefin.size()];

		for (int i = 0; i < fin.length; i++)
			fin[i]=prefin.get(i);

		for (int i = 0; i < _width; i++){
			for (int j = 0; j < _height; j++){
				System.out.print(pixels[i][j]);
				System.out.print("       ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Palette!:");

		for (int i = 0; i < clrs.length; i++){
			System.out.println((int)clrs[i]);
		}
		return fin;

		



	}
		
/*
		byte[] palette = new byte[clrs.size()];
		for (int k = 0; k < palette.length; k++){
			//convert the clrs (Integers) into palette (bytes) by
			palette[k] = clrs.get(k);
		}
		System.out.println();
		for (int l = 0; l < palette.length; l++){
			System.out.print(palette[l] + "		");
		}
		System.out.println();
*/
	

	public static void decrypt(byte[] x){//BufferedImage
		System.out.println("length of the byte array:");
		System.out.println(x.length);

		byte[] lenArr = new byte[4];
		byte[] widArr = new byte[4];
		byte[] hiArr = new byte[4];

		for (int i = 0; i < 4; i++)
			lenArr[i]=x[i];

		for (int i = 4; i < 8; i++)
			widArr[i-4]=x[i];

		for (int i = 8; i < 12; i++)
			hiArr[i-8]=x[i];

		int colorLen = ByteBuffer.wrap(lenArr).getInt();
		int widEn = ByteBuffer.wrap(widArr).getInt();
		int hiEn = ByteBuffer.wrap(hiArr).getInt();

		System.out.println(colorLen);
		System.out.println(widEn);
		System.out.println(hiEn);

		BufferedImage finImage = new BufferedImage(widEn,hiEn, BufferedImage.TYPE_INT_RGB);

		byte[] palette = new byte[colorLen];

		for (int i = 0; i < colorLen ; i++)
			palette[i] = x[i+12];

		byte[][] img = new byte[widEn][hiEn];

		int r = 12 + colorLen;
		//System.out.println("rs:");
		//CoSystem.out.println(r);

		for (int i = 0; i < hiEn; i++){//hien
			//System.out.println("imgi.len:"+img[i].length);
			for (int j = 0; j < widEn; j++){//widen
				img[i][j] = x[r];
				
				if ((i==hiEn-1)&&(j==widEn-1)) 
					break;
				//System.out.println(r);
				r++;
			}
			if (i==hiEn-1) 
					break;
		}

		for (int i = 0; i < hiEn; i++){
			for (int j = 0; j < widEn; j++){
				if ((i==hiEn-1)&&(j==widEn-1)) 
					break;
				finImage.setRGB(i, j, palette[(img[i][j])]);
				System.out.print(palette[(img[i][j])]);
				//System.out.println("i:"+i+"j:"+j);
				//System.out.println("hien:"+hiEn+"widEn"+widEn);
				

			}
			if (i==hiEn-1) 
					break;
			System.out.println();
		}

		//ImageIO.write(finImage,"BMP",new File("MyImage.bmp"));

	}

	
	public static void main(String[] args){
		encrypt("splitter.bmp");
		decrypt(encrypt("splitter.bmp"));

		

	}
}




