
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    
    public int countGenes(String dna)
    {
        int startIndex = 0;
        int count = 0;
        while(true)
        {
            String currString = findGene(dna , startIndex);
            if(currString.isEmpty())
            {
                return count;
            }
            count = count+1;
            startIndex = dna.indexOf(currString, startIndex) + currString.length();
        }
    }
    
    public void testCountGenes()
    {
        String dna1 = "ATGTAAGATGCCCTAGT";
        System.out.println(countGenes(dna1));
        
        String dna2 = "ATTAAGAGCCCTAGT";
        System.out.println(countGenes(dna2));
        
        String dna3 = "ATGCCTTAGATGCCCTAAGATGCTTACCTAGT";
        System.out.println(countGenes(dna3));
        
        String dna4 = "ATGTCGATCGCCCTATGT";
        System.out.println(countGenes(dna4));
    }
}
