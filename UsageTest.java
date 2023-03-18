package ct4j;

class UsageTest 
{

    public static void main(String[] args) throws ElementSizeException, MultipleHeaderException,DuplicateHeaderException{

        ct4j table = new ct4j();

        String[] header = {"first","second","third","last"};
        String[] row = {"shortword","superverylongword","normalword","lol"};
        
        table.setHeader(header);
        table.addRow(row);
        table.addRow(row);
        table.addRow(row);
        table.addRow(row);
        
        table.printTable();
        
    }
}
