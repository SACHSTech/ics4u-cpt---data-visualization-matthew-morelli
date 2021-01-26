package charts;
import java.io.*;
import java.util.ArrayList;

public class UniversityList {
    
    public ArrayList<University> dataSet = new ArrayList<University>();

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

    // selection sort
    public ArrayList<University> selectionSortUniversities(ArrayList<University> arrList, String paramater) {

        int currentMinIndex;
        for (int i = 0; i < arrList.size() - 1; i++) {

            currentMinIndex = i;

            for (int j = i + 1; j < arrList.size(); j++) {

                if(arrList.get(j).getParamater(paramater) > arrList.get(currentMinIndex).getParamater(paramater)) {
                    currentMinIndex = j;
                }

                if (i != currentMinIndex) {
            
                    University temp = arrList.get(currentMinIndex);
                    arrList.set(currentMinIndex, arrList.get(i));
                    arrList.set(i, temp);

                }
            



            }

        }

        return arrList;

    }

}
