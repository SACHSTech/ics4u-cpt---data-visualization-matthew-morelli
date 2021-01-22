package charts;
import java.io.*;
import java.util.ArrayList;

public class UniversityList {
    
    public ArrayList<University> dataSet = new ArrayList<University>();
    

    // put a constructor to create the object array list. parameter is file name

    public UniversityList(String theFileName) throws IOException {

        BufferedReader csvFile = new BufferedReader(new FileReader(theFileName));

        String line;
        String[] data;

        while ((line = csvFile.readLine()) != null) {

            data = line.split(",");

            if (!data[0].equals("world_rank")) {
                dataSet.add(new University(data));
            }

        }

        csvFile.close();

    }

}
