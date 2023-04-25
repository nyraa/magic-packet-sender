import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

class DataLoader
{
    // read csv (name, mac) from csv file and return vector<Computer>
    public static Vector<Computer> readCSV(String path)
    {
        Vector<Computer> computers = new Vector<Computer>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(path));
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
        }
        return computers;
    }
}