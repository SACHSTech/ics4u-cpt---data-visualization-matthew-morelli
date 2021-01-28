package charts;

/**
 * A program University.java that creates a university object with info and stats
 * @author Matthew Morelli
 */
public class University {
    
    // made all numebers doubles in order to have only one sort method
    private double worldRank;
    private String name;
    private String country;
    // stats
    private double teaching;
    private double international;
    private double research;
    private double citations;
    private double income;
    private double totalScore;
    private double numStudents;
    private double studentStaffRatio;
    private double internationalStudents;

    /**
     * Creates a University object with all the info and stats
     * 
     * @param data  An array of the info and stats for the univeristy
     * @author Matthew Morelli
     */
    public University(String[] data) {
        
        this.worldRank = Double.parseDouble(data[0]);
        this.name = data[1];
        this.country = data[2];
        this.teaching = Double.parseDouble(data[3]);
        this.international = Double.parseDouble(data[4]);
        this.research = Double.parseDouble(data[5]);
        this.citations = Double.parseDouble(data[6]);
        this.income = Double.parseDouble(data[7]);
        this.totalScore = Double.parseDouble(data[8]);
        this.numStudents = Double.parseDouble(data[9]);
        this.studentStaffRatio = Double.parseDouble(data[10]);
        this.internationalStudents = Double.parseDouble(data[11]);

    }

    /**
     * Gets the value of the world rank for the university
     * 
     * @return The world rank
     * @author Matthew Morelli
     */
    public double getWorldRank() {
        return this.worldRank;
    }

    /**
     * Gets the value of the world rank for the university
     * 
     * @return The university name
     * @author Matthew Morelli
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the value of the country for the university
     * 
     * @return The country
     * @author Matthew Morelli
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Gets the value of the teaching stat for the university
     * 
     * @return The teaching stat
     * @author Matthew Morelli
     */
    public double getTeaching() {
        return this.teaching;
    }

    /**
     * Gets the value of the international stat for the university
     * 
     * @return The international stat
     * @author Matthew Morelli
     */
    public double getInternational() {
        return this.international;
    }

    /**
     * Gets the value of the research stat for the university
     * 
     * @return The research stat
     * @author Matthew Morelli
     */
    public double getResearch() {
        return this.research;
    }

    /**
     * Gets the value of the citation stat for the university
     * 
     * @return The citation stat
     * @author Matthew Morelli
     */
    public double getCitations() {
        return this.citations;
    }

    /**
     * Gets the value of the income stat for the university
     * 
     * @return The income stat
     * @author Matthew Morelli
     */
    public double getIncome() {
        return this.income;
    }

    /**
     * Gets the value of the total score for the university
     * 
     * @return The total score
     * @author Matthew Morelli
     */
    public double getTotalScore() {
        return this.totalScore;
    }

    /**
     * Gets the value of the number of students for the university
     * 
     * @return The number of students
     * @author Matthew Morelli
     */
    public double getNumStudents() {
        return this.numStudents;
    }

    /**
     * Gets the value of the student staff ratio for the university
     * 
     * @return The student staff ratio
     * @author Matthew Morelli
     */
    public double getStudentStaffRatio() {
        return this.studentStaffRatio;
    }

    /**
     * Gets the value of the international students stat for the university
     * 
     * @return The international students stat
     * @author Matthew Morelli
     */
    public double getInternationalStudents() {
        return this.internationalStudents;
    }

    /**
     * Gets a double paramater based on what is given
     * 
     * @param paramater  The parameater to be returned
     * @return The chosen paramater
     * @author Matthew Morelli
     */
    public double getParamater(String paramater) {

        if (paramater.equalsIgnoreCase("teaching")) {
            return this.teaching;
        } else if (paramater.equalsIgnoreCase("international")) {
            return this.international;
        } else if (paramater.equalsIgnoreCase("research")) {
            return this.research;
        } else if (paramater.equalsIgnoreCase("citations")) {
            return this.citations;
        } else if (paramater.equalsIgnoreCase("income")) {
            return this.income;
        } else if (paramater.equalsIgnoreCase("totalScore")) {
            return this.totalScore;
        } else if (paramater.equalsIgnoreCase("numStudents")) {
            return this.numStudents;
        } else if (paramater.equalsIgnoreCase("studentStaffRatio")) {
            return this.studentStaffRatio;
        } else if (paramater.equalsIgnoreCase("internationalStudents")) {
            return this.internationalStudents;
        } else if (paramater.equalsIgnoreCase("worldRank")) {
            return this.worldRank;
        }

        return 0.0;

    }

    /**
     * Gets a string paramater based on what is given
     * 
     * @param parameter  The paramater to be returned
     * @return The chosen paramater
     * @author Matthew Morelli
     */
    public String getStringParameter(String parameter) {

        if (parameter.equalsIgnoreCase("name")) {
            return this.name;
        } else if (parameter.equalsIgnoreCase("country")) {
            return this.country;
        }

        return "";

    }

}
