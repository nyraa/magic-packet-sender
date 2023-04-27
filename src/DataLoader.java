import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Vector;

class DataLoader
{
    // read csv (name, mac) from csv file and return vector<Computer>
    public static Vector<Computer> readCSV(String path)
    {
        Vector<Computer> computers = new Vector<Computer>();
        try
        {
            // open file as utf-8
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(",");
                computers.add(new Computer(data[1], data[0]));
            }
            br.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
            // popup a message dialog to show error
            // title: "wake on lan"
            // message: "No config file found\nPlease make sure config.csv is in the same directory as the jar file"
            javax.swing.JOptionPane.showMessageDialog(null, "No config file found\nPlease make sure config.csv is in the same directory as the jar file", "wake on lan", javax.swing.JOptionPane.ERROR_MESSAGE);
            // exit the program
            System.exit(1);
        }
        return computers;
    }
}