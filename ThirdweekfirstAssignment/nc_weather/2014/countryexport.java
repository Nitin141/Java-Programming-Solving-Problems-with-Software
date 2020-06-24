
/**
 * Write a description of countryexport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
public class countryexport {
    public String countryInfo(CSVParser parser, String country)
    {
        for(CSVRecord record : parser)
        {
            String ctry = record.get("Country");
            if(ctry.contains(country))
            {
                System.out.print(ctry+":");
                System.out.print(record.get("Exports")+":");
                System.out.println(record.get("Value (dollars)"));
            }
        }
        return "";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportitem1, String exportitem2)
    {
        for(CSVRecord record : parser)
        {
            String export = record.get("Exports");
            if(export.contains(exportitem1)&&export.contains(exportitem2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public void numberOfExporters(CSVParser parser, String exportitem)
    {
        int count = 0;
        for(CSVRecord record : parser)
        {
            String export = record.get("Exports");
            if(export.contains(exportitem))
            {
                count = count+1;
            }
        }
        System.out.println(count);
    }
    
    public void bigExporters(CSVParser parser, String amount)
    {
        for(CSVRecord record : parser)
        {
            String value = record.get("Value (dollars)");
            if(value.length() > amount.length())
            {
                System.out.print(record.get("Country") + " ");
                System.out.println(value);
            }
        }
    }
    
    public void tester()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //countryInfo(parser,"Nauru");
        //listExportersTwoProducts(parser,"cotton","flowers");
        //numberOfExporters(parser,"cocoa");
        bigExporters(parser,"$999,999,999,999");
    }
}
