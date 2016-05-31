
package main;

import java.nio.ByteBuffer;

public class ImgCompress{

	BufferedImage img = Image IO.read(new File("sample.bmp"));

	int _width = img.getWidth();
	int _height = img.getHeight();

	byte[][] pixels = new byte[_height][_width];

	byte[] palette = new byte[];


	public static void main(String[] args){
	}
}

