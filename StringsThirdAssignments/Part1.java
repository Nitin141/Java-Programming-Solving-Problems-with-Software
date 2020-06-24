
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon , startIndex);
        while(currIndex != -1)
        {
            int diff = startIndex - currIndex;
            if(diff%3 == 0)
            {
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon ,currIndex+1);
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna , int where)
    {
        int startCodon = dna.indexOf("ATG" , where);
        if(startCodon == -1)
        {
            return "";
        }
        int Indexoftaa = findStopCodon(dna, startCodon, "TAA");
        int Indexoftga = findStopCodon(dna, startCodon, "TGA");
        int Indexoftag = findStopCodon(dna, startCodon, "TAG");
        int stopCodon = Math.min(Indexoftaa , Math.min(Indexoftga, Indexoftag));
        if(stopCodon == dna.length())
        {
            return "";
        }
        return dna.substring(startCodon, stopCodon + 3);
    }
    
    public void printAllGenes(String dna)
    {
        int startIndex = 0;
        while(true)
        {
            String currString = findGene(dna , startIndex);
            if(currString.isEmpty())
            {
                break;
            }
            System.out.println(currString);
            startIndex = dna.indexOf(currString, startIndex) + currString.length();
        }
    }
    
    public StorageResource getAllGenes(String dna)
    {
        StorageResource sr = new StorageResource();
        int startIndex = 0;
        while(true)
        {
            String currString = findGene(dna , startIndex);
            if(currString.isEmpty())
            {
                break;
            }
            sr.add(currString);
            startIndex = dna.indexOf(currString, startIndex) + currString.length();
        }
        return sr;
    }
    
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
    
    public void processGenes(StorageResource sr)
    {
        int count = 0;
        for(String item : sr.data())
        {
            if(item.length()> 60 )
            {
                System.out.println(item);
                count = count+1;
            }
        }
        System.out.println("no of genes having more than 60 char: " + count);
        int countcg = 0; 
        for(String gene : sr.data())
        {
            if(cgRatio(gene) > 0.35)
            {
                System.out.println(gene);
                countcg = countcg+1;
            }
        }
        System.out.println("no of genes having cgratio more than 0.35: " + count);
        int max = 0;
        for(String genes : sr.data())
        {
            if(genes.length() > max)
            {
                max = genes.length();
            }
        }
        System.out.println("gene having longest size: " + max);
    }
    
    public void testprocessGenes()
    {
        //String dna = "AAATCGATGACTTAAATGACTACCTTGGGCTAG";
        URLResource fr = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        String dna1 = fr.asString();
        String dna = dna1.toUpperCase();
        StorageResource s = getAllGenes(dna);
        System.out.println(s.size());
        processGenes(s);
    }
    
    public void testgetAllGenes()
    {
        String dna = "ATGACCTGATAGATGATTGTATAAT";
        StorageResource genes = getAllGenes(dna);
        System.out.println(genes.size());
    }
    
    public void testFindStopCodon()
    {
        String dna = "ATTATGCCTATTTAA";
        int startIndex = dna.indexOf("ATG");
        int stopIndex = findStopCodon(dna, startIndex, "TAA");
        System.out.println(dna.substring(startIndex, stopIndex + 3));
        
        String dna2 = "ATTATGCCTATCTAGTAA";
        int startIndex2 = dna2.indexOf("ATG");
        int stopIndex2 = findStopCodon(dna2, startIndex2, "TAG");
        System.out.println(dna2.substring(startIndex2, stopIndex2 + 3));
        
        String dna3 = "ATTATGCCTATCTGATAA";
        int startIndex3 = dna3.indexOf("ATG");
        int stopIndex3 = findStopCodon(dna3, startIndex3, "TGA");
        System.out.println(dna3.substring(startIndex3, stopIndex3 + 3));
    }
    
    public void test()
    {
        String dna = "TATGACCTAGATGTAAATGTCATGATAAG";
        printAllGenes(dna);
    }
}
