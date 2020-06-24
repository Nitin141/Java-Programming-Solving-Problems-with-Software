
/**
 * Write a description of Grayscale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Grayscale {
    public ImageResource makeGray(ImageResource inImage)
    {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels())
        {
            Pixel inpixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int avg = (inpixel.getRed() + inpixel.getGreen() + inpixel.getBlue())/3;
            pixel.setRed(avg);
            pixel.setGreen(avg);
            pixel.setBlue(avg);
        }
        return outImage;
    }
    
    public void testmakeGray()
    {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    
    void selectandconvert()
    {
        DirectoryResource dr =new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            String fname = inImage.getFileName();
            String newName = "gray-" + fname;
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }
    }
}
