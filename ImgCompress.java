
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

	public static void makePalette(){
		ArrayList<Integer> clrs = new ArrayList<>();

		for (int x = 0; x < pixels.length; x++){
			for (int y = 0; y < pixels[x].length; y++){
				int color = image.getRGB(x, y);
		    	if (!clrs.contains(color)) clrs.add(color);
		    }
		}
		byte[] palette = new byte[clrs.size()];
		for (int i = 0; i < palette.size(); i++{
			palette[i] = palette.get(i);
		}
	}

	
	public static void main(String[] args){
		setupImg();
		int _width = _img.getWidth();
		int _height = _img.getHeight();
		System.out.println("width: " + _width + "height: " + _height);

		byte[][] pixels = new byte[_height][_width];

		
            }
        }
	}
}

