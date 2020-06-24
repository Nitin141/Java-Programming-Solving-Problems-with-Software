
/**
 * Write a description of Part1 here.
 * 
 * @author (Nitin) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String result="";
        int start= dna.indexOf("ATG");
        if(start == -1)
        {
            return "";
        }
        int end = dna.indexOf("TAA",start+3);
        if(end== -1){
            return "";
        }
        result = dna.substring(start,end+3);
        if(result.length()%3 == 0)
        {
            return result;
        }
        return "";
    }
    
    public void testSimpleGene(){
        String dna = "ACCTGATGCCTATAA";
        System.out.println("the dna is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("the gene found is " + gene);
        
        String dna1 = "ACTAATCGGATGAATCCT";
        System.out.println("the dna is " + dna1);
        String gene1 = findSimpleGene(dna1);
        System.out.println("the gene found is " + gene1);
        
        String dna2 = "ACCTGATACCTATAA";
        System.out.println("the dna is " + dna2);
        String gene2 = findSimpleGene(dna2);
        System.out.println("the gene found is " + gene2);
        
        String dna3 = "ACCTGATGCCTTAA";
        System.out.println("the dna is " + dna3);
        String gene3 = findSimpleGene(dna3);
        System.out.println("the gene found is " + gene3);
    }
}

