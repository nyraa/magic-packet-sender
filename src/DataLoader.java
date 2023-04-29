import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Vector;

class DataLoader
{
    private static Vector<Computer> computers = null;
    private static final String filename = "config.csv";
    // read csv (name, mac) from csv file and return vector<Computer>
    private static Vector<Computer> readCSV(String path)
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
    public static Vector<Computer> getComputers()
    {
        if (computers == null)
        {
            computers = readCSV(filename);
        }
        return computers;
    }
    public static boolean addComputer(Computer computer)
    {
        return computers.add(computer);
    }
    public static boolean removeComputer(Computer computer)
    {
        return computers.remove(computer);
    }
    public static void saveData()
    {
        try
        {
            java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileOutputStream(filename));
            for (Computer computer : computers)
            {
                pw.println(computer.getName() + "," + computer.getMacStr());
            }
            pw.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}