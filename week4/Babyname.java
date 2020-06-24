
/**
 * Write a description of Babyname here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Babyname {
    public void TotalBirths(FileResource fr)
    {
        int totalBirth = 0;
        int totalBoys = 0;
        int numboysname = 0;
        int totalGirls = 0;
        int numgirlsname =0;
        for(CSVRecord rec : fr.getCSVParser(false))
        {
            int numBirths = Integer.parseInt(rec.get(2));
            totalBirth += numBirths;
            if(rec.get(1).equals("M"))
            {
                totalBoys += numBirths;
                numboysname += 1;
            }
            else{
                totalGirls += numBirths;
                numgirlsname += 1;
            }
        }
        System.out.println("Total Births " + totalBirth);
        System.out.println("Total boys " + totalBoys);
        System.out.println("Total boys name " + numboysname);
        System.out.println("Total girls " + totalGirls);
        System.out.println("Total girls name " + numgirlsname);
    }
    
    public int getRank(int year, String name, String gender)
    {
        int rank = 0;
        int count = 0;
        FileResource fr = new FileResource();
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
    
    public String getName(int year, int rank, String gender)
    {
        String name = "";
        String num ="";
        int count = 0;
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false))
        {
            //String gen = rec.get(1);
            //System.out.println(gen);
            if(rec.get(1).equals(gender))
            {
                count = count + 1;
                if(count == rank)
                {
                    name = rec.get(0);
                    num = rec.get(2);
                }
            }
        }
        //return name;
        return num;
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender)
    {
        int rank = getRank(year,name,gender);
        String newname =  getName(newYear,rank,gender);
        System.out.println(name + " born in " + year + " would be " + newname + " if he/she was born in " + newYear);
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
            int rank = getRank(year, name, gender);
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
    
    public double getAverageRank(String name, String gender)
    {
        int count = 0;
        int sum = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            int year = 0000;
            int rank = getRank(year, name, gender);
            count += 1;
            sum = sum + rank;
        }
        double avg = (double)sum/count;
        return avg;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender)
    {
        int rank = 0;
        String num = null;
        int sum = 0;
        rank = getRank(year, name, gender);
        //System.out.println(rank);
        while(rank!= 0)
        {
            rank = rank -1;
            if(rank != 0)
            {
                num = getName(year, rank, gender);
                //System.out.println(num);
                sum =sum + Integer.parseInt(num);
            }
        }
        return sum;
    }
    
    public void testTotalBirths()
    {
        FileResource fr = new FileResource();
        TotalBirths(fr);
    }
    
    public void testgetRank()
    {
        int year = 2012;
        String gender = "M";
        String name = "Frank";
        int rank = getRank(year, name, gender);
        if (rank == 0)
        {
            System.out.println("Not Found");
        }
        else{
            System.out.println("The rank of name " + name + " is " + rank);
        }
        
    }
    
    public void testgetName()
    {
        int year = 2012;
        String gender = "M";
        int rank = 450;
        String name = getName(year, rank, gender);
        if(name == "")
        {
            System.out.println("Not found");
        }
        else{
            System.out.println("The name at rank " + rank + " is " + name);
        }
    }
    
    public void testwhatIsNameInYear()
    {
        int year = 2012;
        int newYear = 2014;
        String name = "Owen";
        String gender = "M";
        whatIsNameInYear(name,year,newYear,gender);
    }
    
    public void testyearOfHigestRank()
    {
        String name ="Mich";
        String gender = "M";
        String fname = yearOfHigestRank(name,gender);
        System.out.println(fname.substring(3 , 7));
    }
    
    public void testgetAverageRank()
    {
        String name = "Susan";
        String gender = "F";
        double avg = getAverageRank(name,gender);
        System.out.println(avg);
    }
    
    public void testgetTotalBirthsRankedHigher()
    {
        int year = 2014;
        String name = "Emily";
        String gender = "";
        int birth =  getTotalBirthsRankedHigher(year, name, gender);
        System.out.println(birth);
    }
}
