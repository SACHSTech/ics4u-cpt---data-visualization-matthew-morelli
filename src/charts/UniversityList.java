package charts;
import java.io.*;
import java.util.ArrayList;

/**
 * A program UniversityList.java that creates an array list of university objects to be accessed elsewhere,
 * and can sort and search through it.
 * @author Matthew Morelli
 */
public class UniversityList {
    
    public ArrayList<University> dataSet = new ArrayList<University>();

    /**
     * Adds universities to the data set array list
     * 
     * @param theFileName  The file path to the csv file
     * @throws IOException
     * @author Matthew Morelli
     */
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

    /**
     * Sorts the given array by a given paramater using a selection sort algorithm
     * 
     * @param arrList  The array to be sorted
     * @param paramater  The paramater to be sorted by 
     * @return The sorted array list
     * @author Matthew Morelli
     */
    public ArrayList<University> selectionSortUniversities(ArrayList<University> arrList, String paramater, boolean sortHigh) {

        int currentMinIndex;
        for (int i = 0; i < arrList.size() - 1; i++) {

            currentMinIndex = i;

            for (int j = i + 1; j < arrList.size(); j++) {

                if (sortHigh) {
                    if(arrList.get(j).getParamater(paramater) > arrList.get(currentMinIndex).getParamater(paramater)) {
                        currentMinIndex = j;
                    }
                } else {
                    if(arrList.get(j).getParamater(paramater) < arrList.get(currentMinIndex).getParamater(paramater)) {
                        currentMinIndex = j;
                    }
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

    /**
     * Searches through the university array list for a given value
     * 
     * @param column  The column to be filtered
     * @param parameter  The paramaeter to be filtered
     * @return The filtered array
     * @author Matthew Morelli
     */
    public ArrayList<University> linearSearch(String column, String parameter) {

        ArrayList<University> arrList = new ArrayList<University>();
        String element;

        for(int i = 0; i < dataSet.size(); i++) {
            element = selectionSortUniversities(dataSet, parameter, true).get(i).getStringParameter(column);
            if(element.equalsIgnoreCase(parameter)) {
                arrList.add(dataSet.get(i));
            }
        }
        return arrList;
   }

   /**
    * Gets the number of universities in the data set
    *
    * @return  The number of universities
    * @author Matthew Morelli
    */
   public int getCount() {
       int count = 0;
       for (int i = 0; i < dataSet.size(); i++) {
           count++;
       }
       return count;
   }

   /**
    * Gets the maximum and minimum value for a specified column
    *
    * @param parameter  The column to be analyzed
    * @return The max and min number in that column
    * @author Matthew Morelli
    */
   public String getMaxMin(String parameter) {
       int count = 0;
       for (int i = 0; i < dataSet.size(); i++) {
           count++;
       }
       return "Min: " + String.valueOf(selectionSortUniversities(dataSet, parameter, false).get(0).getParamater(parameter)) + ", Max: " + String.valueOf(selectionSortUniversities(dataSet, parameter, false).get(count - 1).getParamater(parameter));
   }

   /**
    * Gets the average values of a specified column
    * @param parameter  The column to be analyzed
    * @return The average of the column
    * @author Matthew Morelli
    */
   public double getAverage(String parameter) {
       double total = 0;
       int count = 0;
       double average = 0;
       for (int i = 0; i < dataSet.size(); i++) {
           count++;
           total += dataSet.get(i).getParamater(parameter);
       }
       average = total / count;
       return average;
   }
   
   /**
    * Gets the median of the specified column
    *
    * @param parameter  The column to be analyzed
    * @return The median of the column
    * @author Matthew Morelli
    */
   public double getMedian(String parameter) {
       int middleNum = (selectionSortUniversities(dataSet, parameter, false).size()) / 2;
       double left = 0;
       double right = 0;
       if (selectionSortUniversities(dataSet, parameter, false).size() % 2 == 0) {
           left = selectionSortUniversities(dataSet, parameter, false).get(middleNum).getParamater(parameter);
           right = selectionSortUniversities(dataSet, parameter, false).get(middleNum - 1).getParamater(parameter);
           return (left + right) / 2;
       } else {
           return middleNum + 1;
       }
   }

   /**
    * Gets the standard deviation of the specified column
    *
    * @param parameter  The column to be analyzed
    * @return The standard deviation of that column
    * @author Matthew Morelli
    */
   public double getStandardDeviation(String parameter) {
       double mean = getAverage(parameter);
       double newMean = 0;
       double total = 0;
       int count = 0;
       for (int i = 0; i < dataSet.size(); i++) {
           count++;
           total += Math.pow(selectionSortUniversities(dataSet, parameter, false).get(i).getParamater(parameter) - mean, 2);
       }
       newMean = total / count;
       return Math.sqrt(newMean);
   }

}
