
/**
 * Write a description of temprature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class temprature {
    public CSVRecord colestHourInFile(CSVParser parser)
    {
        CSVRecord coldestsofar = null;
        for(CSVRecord record : parser)
        {
            double temp = Double.parseDouble(record.get("TemperatureF")); 
            if(temp != -9999)
            {
                if(coldestsofar == null)
                {
                    coldestsofar = record;
                }
                else{
                double currtemp = Double.parseDouble(coldestsofar.get("TemperatureF"));
                if(temp < currtemp && temp!= -9999)
                {
                    coldestsofar = record;
                }
                }   
            }
        }
        return coldestsofar;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord humidsofar = null;
        for(CSVRecord record : parser)
        {
            String temp = record.get("Humidity"); 
            if(temp != "N/A")
            {
                if(humidsofar == null)
                {
                    humidsofar = record;
                }
                else{
                double temp1 = Double.parseDouble(record.get("Humidity"));
                double currtemp = Double.parseDouble(humidsofar.get("Humidity"));
                if(temp1 < currtemp && temp!= "N/A")
                {
                    humidsofar = record;
                }
                }   
            }
        }
        return humidsofar;
    }
    
    public String fileWithColdestTemperature()
    {
        CSVRecord largestsofar = null;
        String filename = "";
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVRecord current =  colestHourInFile(fr.getCSVParser());
            if(largestsofar == null)
            {
                largestsofar = current;
                filename = f.getName();
            }
            else{
                double temp = Double.parseDouble(largestsofar.get("TemperatureF"));
                double currtemp = Double.parseDouble(current.get("TemperatureF"));
                if(temp > currtemp)
                {
                    largestsofar = current;
                    filename=f.getName();
                }
            }
        }
        return filename;
        //return current;
    }
    
    public CSVRecord lowestHumidityInManyFiles()
    {
        CSVRecord lowestsofar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVRecord current =  lowestHumidityInFile(fr.getCSVParser());
            if(lowestsofar == null)
            {
                lowestsofar = current;
            }
            else{
                double temp = Double.parseDouble(lowestsofar.get("Humidity"));
                double currtemp = Double.parseDouble(current.get("Humidity"));
                if(temp > currtemp)
                {
                    lowestsofar = current;
                }
            }
        }
        return lowestsofar;
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value)
    {
        double sum = 0;
        int count = 0;
        for(CSVRecord record : parser)
        {
            double humid = Double.parseDouble(record.get("Humidity"));
            if(humid >= value)
            {
                double temp = Double.parseDouble(record.get("TemperatureF"));
                sum =sum +temp;
                count = count + 1;
            }
        }
        if(sum == 0)
        {
            return 0;
        }
        double avg = sum/count;
        return avg;
    }
    
    public void testFileWithColdestTemperature()
    {
        String fname = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + fname);
        FileResource fr = new FileResource(fname);
        CSVParser parser = fr.getCSVParser();
        CSVRecord cday = colestHourInFile(parser);
        System.out.println("Coldest temperature on that day was " + cday.get("TemperatureF"));
        System.out.println("All the Temperature on the coldest day were:");
        FileResource f = new FileResource(fname);
        CSVParser par = f.getCSVParser();
        for(CSVRecord record : par)
        {
            System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
        }
    }
    
    public void testColdestHourInFile()
    {
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord record = colestHourInFile(parser);
        System.out.println("The coldest temprature is :" + 
                                 record.get("TemperatureF") + " at " + record.get("TimeEDT"));
        
    }
    
    public void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord record = lowestHumidityInFile(parser);
        System.out.println("The Lowest humidity is :" + 
                                 record.get("Humidity") + " at " + record.get("DateUTC"));
    }
    
    public void testLowestHumidityInManyFiles()
    {
        CSVRecord record = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was : " + record.get("Humidity") + " at " + record.get("DateUTC"));
    }
    
    public void testAverageTemperatureWithHighHumidityInFile()
    {
        int value = 80;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgtemp = averageTemperatureWithHighHumidityInFile(parser,value);
        if(avgtemp == 0)
        {
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average Temp when high Humidity is : " + avgtemp);
        }
    }
}
