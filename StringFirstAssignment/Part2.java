
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String Dna,int start , int end){
        String result="";
        String dna = Dna.toUpperCase();
        start= dna.indexOf("ATG");
        if(start == -1)
        {
            return "";
        }
        end = dna.indexOf("TAA",start+3);
        if(end== -1){
            return "";
        }
        result = dna.substring(start,end+3);
        if(result.length()%3 == 0)
        {
            if(dna.equals(Dna))
            {
                return result;
            }
            else{
                return result.toLowerCase();
            }
        }
        return "";
    }
    
    public void testSimpleGene(){
        int start = -1,stop=-1;
        String dna = "ACCTGATGCCTTAA";
        System.out.println("the dna is " + dna);
        String gene = findSimpleGene(dna,start,stop);
        System.out.println("the gene found is " + gene);
        
        String dna1 = "ACTAATCGGATGAATCCT";
        System.out.println("the dna is " + dna1);
        String gene1 = findSimpleGene(dna1,start,stop);
        System.out.println("the gene found is " + gene1);
        
        String dna2 = "ACCTGATACCTATAA";
        System.out.println("the dna is " + dna2);
        String gene2 = findSimpleGene(dna2,start,stop);
        System.out.println("the gene found is " + gene2);
        
        String dna3 ="acctgatgccttaa";
        System.out.println("the dna is " + dna3);
        String gene3 = findSimpleGene(dna3,start,stop);
        System.out.println("the gene found is " + gene3);
    }
}
