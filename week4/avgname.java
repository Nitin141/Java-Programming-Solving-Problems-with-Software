
/**
 * Write a description of avgname here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class avgname {
    public int getRank(int year, String name, String gender, FileResource fr)
    {
        int rank = 0;
        int count = 0;
        //FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false))
        {
            //String gen = rec.get(1);
            //System.out.println(gen);
            if(rec.get(1).equals(gender))
            {
                count = count + 1;
                if(rec.get(0).equals(name))
                {
                    rank = count;
                }
            }
        }
        return rank;
    }
    
    public double getAverageRank(String name, String gender)
    {
        int count = 0;
        int sum = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            int year = 0000;
            int rank = getRank(year, name, gender, fr);
            count += 1;
            sum = sum + rank;
        }
        double avg = (double)sum/count;
        return avg;
    }
    
    public String yearOfHigestRank(String name, String gender)
    {
        int highestrank =0;
        String fname = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            int year = 0000;
            int rank = getRank(year, name, gender, fr);
            if(highestrank == 0)
            {
                highestrank = rank;
                fname =f.getName();
            }
            //System.out.println(rank);
            //System.out.println(highestrank);
            //System.out.println(f.getName());
            if(highestrank != 0 && highestrank > rank)
            {
                fname = f.getName();
            }
        }
        //System.out.println(fname);
        return fname;
    }
    
    public void testgetAverageRank()
    {
        String name = "Robert";
        String gender = "M";
        double avg = getAverageRank(name,gender);
        System.out.println(avg);
    }
    
    public void testyearOfHigestRank()
    {
        String name ="Genevieve";
        String gender = "F";
        String fname = yearOfHigestRank(name,gender);
        System.out.println(fname.substring(3 , 7));
    }
}
