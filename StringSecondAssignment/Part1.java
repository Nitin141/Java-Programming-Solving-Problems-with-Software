
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
    
    //public void testFindGene()
    /*{
        String dna = "TAACTAATCTGATAG";
        System.out.println(dna);
        System.out.println(findGene(dna));
        
        String dna1 = "TATGACCTAATCTGTATAAG";
        System.out.println(dna1);
        System.out.println(findGene(dna1));
        
        String dna2 = "TATGACCTATATCTGATAAG";
        System.out.println(dna2);
        System.out.println(findGene(dna2));
        
        String dna3 = "TATGACCTACATCTAGTATAAG";
        System.out.println(dna3);
        System.out.println(findGene(dna3));
        
        String dna4 = "TATGACCTATATCTGTATAAG";
        System.out.println(dna4);
        System.out.println(findGene(dna4));
        
        String dna5 = "TATGACCTAGTAATGATAAG";
        System.out.println(dna5);
        System.out.println(findGene(dna5));
    }*/
}
