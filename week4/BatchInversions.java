
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BatchInversions {
    public ImageResource makeInversion(ImageResource inImage)
    {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels())
        {
            Pixel inpixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(225 - inpixel.getRed());
            pixel.setGreen(225 - inpixel.getGreen());
            pixel.setBlue(225 - inpixel.getBlue());
        }
        return outImage;
    }
    
    public void testmakeInversion()
    {
        ImageResource ir = new ImageResource();
        ImageResource Inversion = makeInversion(ir);
        Inversion.draw();
    }
    
    void selectandconvert()
    {
        DirectoryResource dr =new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            ImageResource inImage = new ImageResource(f);
            ImageResource Inversion = makeInversion(inImage);
            String fname = inImage.getFileName();
            String newName = "inverted-" + fname;
            Inversion.setFileName(newName);
            Inversion.draw();
            Inversion.save();
        }
    }
}
