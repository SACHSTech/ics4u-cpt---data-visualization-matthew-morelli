package charts;

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

    public double getWorldRank() {
        return this.worldRank;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public double getTeaching() {
        return this.teaching;
    }

    public double getInternational() {
        return this.international;
    }

    public double getResearch() {
        return this.research;
    }

    public double getCitations() {
        return this.citations;
    }

    public double getIncome() {
        return this.income;
    }

    public double getTotalScore() {
        return this.totalScore;
    }

    public double getNumStudents() {
        return this.numStudents;
    }

    public double getStudentStaffRatio() {
        return this.studentStaffRatio;
    }

    public double getInternationalStudents() {
        return this.internationalStudents;
    }

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
    

}
