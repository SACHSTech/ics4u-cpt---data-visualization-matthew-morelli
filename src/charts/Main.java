package charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.text.DecimalFormat;;

/**
 * A program Main.java that lets you view graphs about top global universities, and also lets you
 * search through and filter all the data.
 * @author Matthre Morelli
 */
public class Main extends Application {

    /**
     * Runs the program
     * 
     * @param args  Required paramater to run
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates a sorted table view of the university data
     * 
     * @param propertyValues  The column header text
     * @param universityList  The UniversityList object
     * @param parameter  The paramater to be sorted by
     * @return  The sorted table view
     * @author Matthew Morelli
     */
    public TableView createTableView(String[] propertyValues, UniversityList universityList, String parameter) {

        ObservableList<University> tableViewData = FXCollections.observableArrayList();

        // add the row values
        for (int i = 0; i < universityList.dataSet.size(); i++) {
            String[] rowData = {
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, false).get(i).getWorldRank()),
                universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getName(),
                universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getCountry(),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getTeaching()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getInternational()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getResearch()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getCitations()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getIncome()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getTotalScore()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getNumStudents()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getStudentStaffRatio()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter, true).get(i).getInternationalStudents())
            };
            tableViewData.add(new University(rowData));
        }

        TableView tableView = new TableView();
        tableView.setItems(tableViewData);

        // add the column headers
        for (int i = 0; i < propertyValues.length; i++) {
            TableColumn theColumn = new TableColumn();
            theColumn.setText(propertyValues[i]);
            theColumn.setCellValueFactory(new PropertyValueFactory(propertyValues[i]));
            tableView.getColumns().add(theColumn);
        }

        return tableView;

    }

    /**
     * Creates a filtered table view
     * 
     * @param propertyValues  The column header text
     * @param universityList  The UniversityList object
     * @param column  The column to filter by
     * @param parameter  The paramater to filter by
     * @return  The filtered table view
     * @author Matthew Morelli
     */
    public TableView createFilteredTableView(String[] propertyValues, UniversityList universityList, String column, String parameter) {

        ObservableList<University> tableViewData = FXCollections.observableArrayList();

        // add the row values
        for (int i = 0; i < universityList.linearSearch(column, parameter).size(); i++) {
            String[] rowData = {
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getWorldRank()),
                universityList.linearSearch(column, parameter).get(i).getName(),
                universityList.linearSearch(column, parameter).get(i).getCountry(),
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getTeaching()),
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getInternational()),
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getResearch()),
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getCitations()),
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getIncome()),
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getTotalScore()),
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getNumStudents()),
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getStudentStaffRatio()),
                String.valueOf(universityList.linearSearch(column, parameter).get(i).getInternationalStudents())
            };
            tableViewData.add(new University(rowData));
        }

        TableView tableView = new TableView();
        tableView.setItems(tableViewData);

        // add the column headers
        for (int i = 0; i < propertyValues.length; i++) {
            TableColumn theColumn = new TableColumn();
            theColumn.setText(propertyValues[i]);
            theColumn.setCellValueFactory(new PropertyValueFactory(propertyValues[i]));
            tableView.getColumns().add(theColumn);
        }

        return tableView;

    }

    /**
     * Creates the vertical box containing all the labels for different information about the data
     * @param universityList  The UniversityList class in order to access its methods
     * @return The VBox containing all the labels
     * @author Matthew Morelli
     */
    public VBox createLabels(UniversityList universityList) {
        VBox theBox = new VBox();
        Label count = new Label("Number of Universities: " + universityList.getCount());

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        Label worldRankLabel = new Label("World Rank Info:");
        Label maxMin = new Label(universityList.getMaxMin("worldRank") + "     ");
        Label average = new Label("Average: " + decimalFormat.format(universityList.getAverage("worldRank")) + "     ");
        Label median = new Label("Median: " + universityList.getMedian("worldRank") + "     ");
        Label sd = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("worldRank")));
        HBox worldRank = new HBox();
        worldRank.getChildren().addAll(
            maxMin,
            average,
            median,
            sd
        );

        Label teachingLabel = new Label("Teaching Info:");
        Label maxMinTeaching = new Label(universityList.getMaxMin("teaching") + "     ");
        Label averageTeaching = new Label("Average: " + decimalFormat.format(universityList.getAverage("teaching")) + "     ");
        Label medianTeaching = new Label("Median: " + universityList.getMedian("teaching") + "     ");
        Label sdTeaching = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("teaching")));
        HBox teaching = new HBox();
        teaching.getChildren().addAll(
            maxMinTeaching,
            averageTeaching,
            medianTeaching,
            sdTeaching
        );

        Label internationalLabel = new Label("International Info:");
        Label maxMinInternational = new Label(universityList.getMaxMin("international") + "     ");
        Label averageInternational = new Label("Average: " + decimalFormat.format(universityList.getAverage("international")) + "     ");
        Label medianInternational = new Label("Median: " + decimalFormat.format(universityList.getMedian("international")) + "     ");
        Label sdInternational = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("international")));
        HBox international = new HBox();
        international.getChildren().addAll(
            maxMinInternational,
            averageInternational,
            medianInternational,
            sdInternational
        );

        Label researchLabel = new Label("Research Info:");
        Label maxMinResearch = new Label(universityList.getMaxMin("research") + "     ");
        Label averageResearch = new Label("Average: " + decimalFormat.format(universityList.getAverage("research")) + "     ");
        Label medianResearch = new Label("Median: " + universityList.getMedian("research") + "     ");
        Label sdResearch = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("research")));
        HBox research = new HBox();
        research.getChildren().addAll(
            maxMinResearch,
            averageResearch,
            medianResearch,
            sdResearch
        );

        Label citationsLabel = new Label("Citations Info:");
        Label maxMinCitations = new Label(universityList.getMaxMin("citations") + "     ");
        Label averageCitations = new Label("Average: " + decimalFormat.format(universityList.getAverage("citations")) + "     ");
        Label medianCitations = new Label("Median: " + universityList.getMedian("citations") + "     ");
        Label sdCitations = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("citations")));
        HBox citations = new HBox();
        citations.getChildren().addAll(
            maxMinCitations,
            averageCitations,
            medianCitations,
            sdCitations
        );

        Label incomeLabel = new Label("Income Info:");
        Label maxMinIncome = new Label(universityList.getMaxMin("income") + "     ");
        Label averageIncome = new Label("Average: " + decimalFormat.format(universityList.getAverage("income")) + "     ");
        Label medianIncome = new Label("Median: " + universityList.getMedian("income") + "     ");
        Label sdIncome = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("income")));
        HBox income = new HBox();
        income.getChildren().addAll(
            maxMinIncome,
            averageIncome,
            medianIncome,
            sdIncome
        );
        
        Label totalScoreLabel = new Label("Total Score Info:");
        Label maxMinTotalScore = new Label(universityList.getMaxMin("totalScore") + "     ");
        Label averageTotalScore = new Label("Average: " + decimalFormat.format(universityList.getAverage("totalScore")) + "     ");
        Label medianTotalScore = new Label("Median: " + universityList.getMedian("totalScore") + "     ");
        Label sdTotalScore = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("totalScore")));
        HBox totalScore = new HBox();
        totalScore.getChildren().addAll(
            maxMinTotalScore,
            averageTotalScore,
            medianTotalScore,
            sdTotalScore
        );

        Label numStudentsLabel = new Label("Number of Students Info:");
        Label maxMinNumStudents = new Label(universityList.getMaxMin("numStudents") + "     ");
        Label averageNumStudents = new Label("Average: " + decimalFormat.format(universityList.getAverage("numStudents")) + "     ");
        Label medianNumStudents = new Label("Median: " + universityList.getMedian("numStudents") + "     ");
        Label sdNumStudents = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("numStudents")));
        HBox numStudents = new HBox();
        numStudents.getChildren().addAll(
            maxMinNumStudents,
            averageNumStudents,
            medianNumStudents,
            sdNumStudents
        );

        Label ssrLabel = new Label("Student Staff Ratio Info:");
        Label maxMinStudentStaffRatio = new Label(universityList.getMaxMin("studentStaffRatio") + "     ");
        Label averageStudentStaffRatio = new Label("Average: " + decimalFormat.format(universityList.getAverage("studentStaffRatio")) + "     ");
        Label medianStudentStaffRatio = new Label("Median: " + universityList.getMedian("studentStaffRatio") + "     ");
        Label sdStudentStaffRatio = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("studentStaffRatio")));
        HBox studentStaffRatio = new HBox();
        studentStaffRatio.getChildren().addAll(
            maxMinStudentStaffRatio,
            averageStudentStaffRatio,
            medianStudentStaffRatio,
            sdStudentStaffRatio
        );

        Label internationalStudentsLabel = new Label("International Students Info:");
        Label maxMinInternationalStudents = new Label(universityList.getMaxMin("internationalStudents") + "     ");
        Label averageInternationalStudents = new Label("Average: " + decimalFormat.format(universityList.getAverage("internationalStudents")) + "     ");
        Label medianInternationalStudents = new Label("Median: " + universityList.getMedian("internationalStudents") + "     ");
        Label sdInternationalStudents = new Label("Standard Deviation: " + decimalFormat.format(universityList.getStandardDeviation("internationalStudents")));
        HBox internationalStudents = new HBox();
        internationalStudents.getChildren().addAll(
            maxMinInternationalStudents,
            averageInternationalStudents,
            medianInternationalStudents,
            sdInternationalStudents
        );

        theBox.getChildren().addAll(
            count,
            worldRankLabel,
            worldRank,
            teachingLabel,
            teaching,
            internationalLabel,
            international,
            researchLabel,
            research,
            citationsLabel,
            citations,
            incomeLabel,
            income,
            totalScoreLabel,
            totalScore,
            numStudentsLabel,
            numStudents,
            ssrLabel,
            studentStaffRatio,
            internationalStudentsLabel,
            internationalStudents
        );
        return theBox;
    }

    /**
     * Runs the javafx GUI
     * 
     * @param primaryStage  The window to be displayed
     */
    public void start(Stage primaryStage) throws IOException{

        UniversityList universityList = new UniversityList("src/charts/uniData.csv");

        // CREATE PIE CHART
        PieChart pieChart = new PieChart();

        for (int i = 0; i < 9; i++) {
            PieChart.Data pieChartData = new PieChart.Data(universityList.dataSet.get(i).getName(), universityList.dataSet.get(i).getTotalScore());
            pieChart.getData().add(pieChartData);
        }

        // CREATE SCATTER CHART
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Number of Students");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Total Score");

        ScatterChart scatterChart = new ScatterChart(xAxis, yAxis);

        for (int i = 0; i < 19; i++) {
            XYChart.Series scatterChartData = new XYChart.Series();
            scatterChartData.setName(universityList.dataSet.get(i).getName());
            scatterChartData.getData().add(new XYChart.Data(universityList.dataSet.get(i).getNumStudents(), universityList.dataSet.get(i).getTotalScore()));
            scatterChart.getData().add(scatterChartData);
        }

        // CREATE BAR CHART
        CategoryAxis thexAxis = new CategoryAxis();
        thexAxis.setLabel("Universities");

        NumberAxis theyAxis = new NumberAxis();
        theyAxis.setLabel("Teaching");

        BarChart barChart = new BarChart(thexAxis, theyAxis);
        for (int i = 0; i < 9; i++) {
            XYChart.Series barChartData = new XYChart.Series();
            barChartData.getData().add(new XYChart.Data(universityList.dataSet.get(i).getName(), universityList.dataSet.get(i).getTeaching()));
            barChart.getData().add(barChartData);
        }

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Pie Chart", pieChart);
        Tab tab2 = new Tab("Scatter Chart", scatterChart);
        Tab tab3 = new Tab("Bar Chart" , barChart);

        // CREATE TABLE VIEW TAB
        Tab tab4 = new Tab();
        tab4.setText("View All Data");

        String[] propertyValues = {"worldRank", "name", "country", "teaching", "international", "research", "citations", "income", "totalScore", "numStudents", "studentStaffRatio", "internationalStudents"};
        
        TextField textField = new TextField();
        HBox hbox = new HBox(textField);

        TableView tableView = createTableView(propertyValues, universityList, "worldRank");

        Button sortButton = new Button("Sort");
        Button searchButton = new Button("Search");

        sortButton.setOnAction(action -> {
            String parameter = "";
            parameter = textField.getText();
            System.out.println(parameter);
            VBox tab4_vBox = new VBox();
            tab4_vBox.getChildren().addAll(
                hbox,
                sortButton,
                searchButton,
                createTableView(propertyValues, universityList, parameter));
            tab4.setContent(tab4_vBox);
        });

        searchButton.setOnAction(action -> {
            String[] parameter;
            parameter = textField.getText().split(",");
            System.out.println(parameter);
            VBox tab4_vBox = new VBox();
            tab4_vBox.getChildren().addAll(
                hbox,
                sortButton,
                searchButton,
                createFilteredTableView(propertyValues, universityList, parameter[0], parameter[1]));
            tab4.setContent(tab4_vBox);
        });

        VBox tab4_vBox = new VBox();
        tab4_vBox.getChildren().addAll(
            hbox,
            sortButton,
            searchButton,
            tableView);
        tab4.setContent(tab4_vBox);

        // CREATE SUMMARY PAGE TAB
        Tab tab5 = new Tab();
        tab5.setText("Summary");

        VBox tab5_vBox = new VBox();
        tab5_vBox.getChildren().addAll(
            createLabels(universityList)
        );
        tab5.setContent(tab5_vBox);

        // add all the tabs to the tab pane
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        tabPane.getTabs().add(tab4);
        tabPane.getTabs().add(tab5);

        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("University Data");

        primaryStage.show();
    }
}