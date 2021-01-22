package charts;

public class University {
    
    private int worldRank;
    private String name;
    private String country;
    // stats
    private double teaching;
    private double international;
    private double research;
    private double citations;
    private double income;
    private double totalScore;
    private int numStudents;
    private double studentStaffRatio;
    private int internationalStudents;
    //private int femaleMaleRatio;

    //public University(int theWorldRank, String theName, String theCountry, double theTeaching, double theInternational, double theResearch, double theCitations, double theIncome, double theTotalScore, double theNumStudents, double theStudentStaffRatio, int theInternationalStudents, int theFemaleMaleRatio) {
    public University(String[] data) {
        
        this.worldRank = Integer.parseInt(data[0]);
        this.name = data[1];
        this.country = data[2];
        this.teaching = Double.parseDouble(data[3]);
        this.international = Double.parseDouble(data[4]);
        this.research = Double.parseDouble(data[5]);
        this.citations = Double.parseDouble(data[6]);
        this.income = Double.parseDouble(data[7]);
        this.totalScore = Double.parseDouble(data[8]);
        this.numStudents = Integer.parseInt(data[9]);
        this.studentStaffRatio = Double.parseDouble(data[10]);
        this.internationalStudents = Integer.parseInt(data[11]);
        

        /*
        this.worldRank = theWorldRank;
        this.name = theName;
        this.country = theCountry;
        this.teaching = theTeaching;
        this.international = theInternational;
        this.research = theResearch;
        this.citations = theCitations;
        this.income = theIncome;
        this.totalScore = theTotalScore;
        this.numStudents = theNumStudents;
        this.studentStaffRatio = theStudentStaffRatio;
        this.internationalStudents = theInternationalStudents;
        this.femaleMaleRatio = theFemaleMaleRatio;*/

    }

    public int getWorldRank() {
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

    public int getInternationalStudents() {
        return this.internationalStudents;
    }
    /*
    public int getFemaleMaleRatio() {
        return this.femaleMaleRatio;
    }*/

}
