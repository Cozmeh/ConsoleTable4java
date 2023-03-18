package ct4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;


class ct4j 
{
    
    private ArrayList<String> headers;
    private Map<Integer,ArrayList<String>> rows ;
    private Map<String,ArrayList<String>> column;

    private ArrayList<String> values;
    private ArrayList<String> columnValues;
    private ArrayList<Integer> spacing;

    private String horSep;
    private String verSep;
    private final String whitespace;
    private String cornerJoint;
    private Boolean BlockMultipleHeaders = false; 
    private Boolean uppercaseHearder = false;

    private int index;



    // constructor 
    ct4j()
    {
        headers = new ArrayList<>();
        rows = new HashMap<>();
        column = new LinkedHashMap();
        spacing = new ArrayList<>();
        horSep = "-";
        verSep = "|";
        whitespace = " ";
        cornerJoint = "+";
        index = 0;

    }


    // ---------------------------------- user useable functiions---------------------------

    protected void setHorizontalSeparator(char HorizontalSeparator){
        horSep = "";
        horSep += HorizontalSeparator;
    }
    protected void setVerticalSeparator(char VerticalSeparator){
        verSep = "";
        verSep += VerticalSeparator;
    }
    protected void setCornerJoint(char CornerJoint){
        cornerJoint = "";
        cornerJoint += CornerJoint;
    }
    protected void setUppercaseHeaders(Boolean uppercaseHeader) {
        this.uppercaseHearder = uppercaseHeader;
    }




    // setting up Headers or column title of the tables 
    protected void setHeader(String ...Header) throws DuplicateHeaderException , MultipleHeaderException 
    {
        HashMap<String,Integer> duplicate = new HashMap<>();
        duplicate.clear();
        int index = 0;
        for (String h : Header) 
        {
            if(duplicate.containsKey(h) == false)
            {
                duplicate.put(h, index);
            }else{
                throw new DuplicateHeaderException("Header cannot contain duplicate values ie : " + h);
            }

            headers.add(index, h);
            index++; 
        }
        if(BlockMultipleHeaders)
        {
            throw new MultipleHeaderException("A table cannot contain multiple column headers");
        }

        BlockMultipleHeaders = true;
    }

    // add
    protected void addRow(String ...Row) throws ElementSizeException
    {
        ArrayList<String> tempRow = new ArrayList<>();
        tempRow.clear();
        for (String str : Row) {
            tempRow.add(str);
        }
        
        if(headers.size() != tempRow.size()){
            throw new ElementSizeException("Number of elements in Header and Row must be equal" + "\nHeader: " + headers.size() + " Row: " + tempRow.size());
        }
        
        rows.put(index, tempRow);
        index++;
        

    }

    protected void printTable() throws ElementSizeException 
    {
        row2column(); // converts row into column 
        getMaxColumnLength(); // gets the maximum length of a value from each column 
        System.out.println("");
        tableLine();
        tableHeader();
        tableLine();
        tableData();
        tableLine();
        
        
    }

    //-------------------------------------- private functions -------------------------


    private void tableData()
    {
        
        for (Map.Entry<Integer, ArrayList<String>> data : rows.entrySet()) 
        {
            values = data.getValue();
            for(int i = 0; i < values.size(); i++)
            {
                System.out.print(verSep + " " + values.get(i) + whitespace.repeat((spacing.get(i) - (values.get(i).length()+1))));  
                
            }
            System.out.print(verSep + "\n");
        }
        
    }


    private void tableHeader()
    {
        int i = 0;
        for (String heading : headers) 
        {
            if(uppercaseHearder){
                System.out.print(verSep + " " + heading.toUpperCase() + whitespace.repeat(spacing.get(i) - (heading.length()+1)));  
            }
            else{
                System.out.print(verSep + " " + heading + whitespace.repeat((spacing.get(i) - (heading.length()+1))));  
            }
            i++;  
        }
        System.out.print(verSep + "\n");
    }


    private void tableLine()
    {
        for (int i = 0; i <= headers.size()-1; i++) 
        {
            System.out.print(cornerJoint + horSep.repeat(spacing.get(i) )); //////// last entry has problem
        }
        System.out.print(cornerJoint + "\n");
    }


    private void getMaxColumnLength()
    {
        int max;

        for (Map.Entry<String, ArrayList<String>> entry : column.entrySet()) 
        {  
            String columnHeading = entry.getKey();
            columnValues = entry.getValue();
            max = 0;

            if(columnHeading.length() > max){
                max = columnHeading.length();
            }

            for (String colval : columnValues)
            {
                if(colval.length() > max)
                {
                    max = colval.length();
                }
                
            }

            spacing.add(max+2); // adds the maximum lengths of values in each column and puts them in a list (columnwise)
            
        }
        
    }


    private void row2column()
    {
        int i = 0;
        column.clear();
        for (String str : headers) 
        {
            ArrayList<String> tempColumn = new ArrayList<>();
            tempColumn.clear();
            for (Map.Entry<Integer, ArrayList<String>> entry : rows.entrySet()) 
            {
                values = entry.getValue();
                tempColumn.add(values.get(i));
            }
            column.put(str, tempColumn);
            i++;
            
        }
        
    }




}

























final class ElementSizeException extends Exception
{
    ElementSizeException(String msg){
        super(msg);
    }
}
final class MultipleHeaderException extends Exception
{
    MultipleHeaderException(String msg){
        super(msg);
    }
}
final class DuplicateHeaderException extends Exception
{
    DuplicateHeaderException(String msg){
        super(msg);
    }
}

