
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

import java.nio.ByteBuffer;

public class ImgCompress{

	private static BufferedImage _img;

	public static void setupImg(){
		try
	    	{
	      	// the line that reads the image file
	     	 BufferedImage img = ImageIO.read(new File("clue.bmp"));
	     	 _img = img;
	     	 } 
    	catch (IOException e)
	    {
	      System.out.println("error");
    	}
	}

	private static int _width;
	private static int _height;

	byte[][] pixels;

	byte[] palette;

	public static void encrypt(){
		setupImg();

		int _width = _img.getWidth();
		int _height = _img.getHeight();
		System.out.println("width: " + _width + "height: " + _height);

		byte[][] pixels = new byte[_height][_width];
		ArrayList<int> preclrs = new ArrayList<>();//holds palette while image is being processed
		byte[] clrs;//holds palette

		//colors have values of 0-255. bytes have values of -128-127. overflow must be utilized
		for (int i = 0; i < _width; i++){
			for (int j = 0; j < _height; j++){
				int color = _img.getRGB(i, j);
		    	if (!clrs.contains(color)) preclrs.add(color);
		    }
		}

		for (int i = 0; i < preclrs.size()-1; i++){
			if (preclrs.get(i) <= 127) 
				clrs.add((byte)preclrs.get(i));
			else 
				clrs.add((byte)(preclrs.get(i)-256));
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
	}

	
	public static void main(String[] args){
		encrypt();
	}
}