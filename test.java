package ct4j;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

class test 
{

    Map<String,String> check;

    test()
    {
        check = new LinkedHashMap<String,String>();
    }

    public static void main(String[] args) throws ElementSizeException, MultipleHeaderException,DuplicateHeaderException{

        ct4j table = new ct4j();

        String[] header = {"loool","second","andrepeat","last","lol","aekfugbryubt","lurhtsi","fiuahyrs","aj","akj","jhrb","ruhri","aleuhai","yrua"};
        String[] row = {"gta san andreas","joood","brooo","loool","lol","jhfbjhb",";aiehurnf","lsol","aj","akj","jhrb","ruhri","aleuhai","yrua"};
        
        table.setHeader(header);
        table.addRow(row);
        table.addRow(row);
        table.addRow(row);
        table.addRow(row);
        
        table.printTable();
        
    }


   
}

