package ct4j;

class UsageTest 
{

    public static void main(String[] args) throws Exception {
        
        ct4j table = new ct4j();
        
        // Set table headers
        table.setHeader("Name", "Age", "City");
        
        // Add data/rows to the table
        table.addRow("Krishna", "24", "Dwaraka");
        table.addRow("Arjuna", "21", "Hastinapur");
        
        // Customize the table
        table.setHorizontalSeparator('-');
        table.setVerticalSeparator('|');
        table.setCornerJoint('+');
        table.setUppercaseHeaders(true);
        
        // Print the table
        table.printTable();
        
    }
}

