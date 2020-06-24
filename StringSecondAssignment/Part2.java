
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb)
    {
        int startindex = stringb.indexOf(stringa);
        int count = 0;
        if(startindex== -1)
        {
            return 0;
        }
        while(true)
        {
            count = count+1;
            startindex = stringb.indexOf(stringa, startindex + stringa.length());
            if(startindex == -1)
            {
                return count;
            }
        }
    }
    
    public void test()
    {
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        System.out.println(howMany(stringa,stringb));
        
        String string1 = "AA";
        String string2 = "ATAAAA";
        System.out.println(howMany(string1,string2));
        
        String stringm = "AA";
        String stringn = "ATATATATA";
        System.out.println(howMany(stringm,stringn));
    }
}
