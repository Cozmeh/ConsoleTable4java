# Console Table For Java (ct4j)
The `Java Console Table (ct4j)` is a `Java library` that helps to create adaptive tables inside the console or terminal. This module is designed to create and customize tables for the console in the easiest way possible.

## Features
- Create a table for the console.
- Set the headers of the table.
- Add data/rows to the table.
- Customize the table by setting horizontal separator, vertical separator, and corner joint.
- Set table headers to uppercase.

## Installation
You can use this module by cloning it and specifying the `package ConsoleTable;`
```
git clone https://github.com/Cozmeh/ConsoleTable4java.git
```
> clone it in your desired folder using the above command in terminal(cmd)

Alternatively, you can download the [JcTable.jar](https://github.com/Cozmeh/ConsoleTable4java/releases/download/v1.0.0/jcTable.jar) file from the `Releases`(latest) and add it to your project's classpath.

## Usage
To use the this module, you need to import the `ct4j` class into your project after adding the `jcTable.jar` to your project's classpath. Then, create an object of the `ct4j` class and use its methods to set up the table and add data to it.

Here's an example usage of the ct4j module:
```
import ConsoleTable.ct4j;

public class Example {

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

```

> Output

```
+---------+-----+------------+
| NAME    | AGE | CITY       |
+---------+-----+------------+
| Krishna | 24  | Dwaraka    |
| Arjuna  | 21  | Hastinapur |
+---------+-----+------------+
```
This code will create a table with three columns: `Name, Age, and City`. It will then add two rows of data to the table and print the table to the console.

## Customization
You can customize the appearance of the table by using the following methods:

- `setHorizontalSeparator(char HorizontalSeparator)` 
   - Set the horizontal separator for the table (default is -).
- `setVerticalSeparator(char VerticalSeparator)`
   - Set the vertical separator for the table (default is |).
- `setCornerJoint(char CornerJoint)`
   - Set the corner joint for the table (default is +).
- `setUppercaseHeaders(Boolean uppercaseHeader)` 
   - Set the headers of the table to uppercase (default is false).
   
### Note 
- Incase of any problem, you can create an `Issue`
- If interested , feel free to `Contribute`


