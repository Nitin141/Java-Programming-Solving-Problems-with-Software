
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part2 {
    public int noOfLetter(String dna, String letter)
    {
        int Startindex = dna.indexOf(letter);
        int count = 0;
        if(Startindex == -1)
        {
            return 0;
        }
        while(true)
        {
            count=count+1;
            Startindex = dna.indexOf(letter, Startindex+1);
            if(Startindex ==-1)
            {
                return count;
            }
        }
    }
    
    public float cgRatio(String dna)
    {
        int CountofC = noOfLetter(dna , "C");
        int CountofG = noOfLetter(dna , "G");
        int countCG = CountofC + CountofG;
        float ratio = (float)countCG/dna.length();
        return ratio;
    }
    
    public int noOfCTG(String dna, String letter)
    {
        int Startindex = dna.indexOf(letter);
        int count = 0;
        if(Startindex == -1)
        {
            return 0;
        }
        while(true)
        {
            count=count+1;
            Startindex = dna.indexOf(letter, Startindex+3);
            if(Startindex ==-1)
            {
                return count;
            }
        }
    }
    
    public int countCTG(String dna)
    {
        int countofCTG = noOfCTG(dna , "CTG");
        return countofCTG;
    }
    
    public void test()
    {
        String dna = "ATGCCATAG";
        System.out.println(cgRatio(dna));
    }
    
    public void test2()
    {
        URLResource fr = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        String dna1 = fr.asString();
        String dna = dna1.toUpperCase();
        System.out.println(countCTG(dna));
    }
}
