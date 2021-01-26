package charts;

//import java.io.IOException;

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
import java.util.Arrays;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public TableView createTableView(String[] propertyValues, UniversityList universityList, String parameter) {

        ObservableList<University> tableViewData = FXCollections.observableArrayList();

        for (int i = 0; i < universityList.dataSet.size(); i++) {
            String[] rowData = {
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getWorldRank()),
                universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getName(),
                universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getCountry(),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getTeaching()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getInternational()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getResearch()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getCitations()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getIncome()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getTotalScore()),
                String.valueOf(universityList.dataSet.get(i).getNumStudents()),
                //String.valueOf(11111),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getStudentStaffRatio()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getInternationalStudents())
            };
            tableViewData.add(new University(rowData));
        }

        TableView tableView = new TableView();
        tableView.setItems(tableViewData);

        for (int i = 0; i < propertyValues.length; i++) {
            TableColumn theColumn = new TableColumn();
            theColumn.setText(propertyValues[i]);
            theColumn.setCellValueFactory(new PropertyValueFactory(propertyValues[i]));
            tableView.getColumns().add(theColumn);
        }

        return tableView;

    }

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

        for (int i = 0; i < 10; i++) {
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
            //dataSeries1.setName(universityList.dataSet.get(i).getName());
            barChartData.getData().add(new XYChart.Data(universityList.dataSet.get(i).getName(), universityList.dataSet.get(i).getTeaching()));
            barChart.getData().add(barChartData);
        }

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Pie Chart", pieChart);
        Tab tab2 = new Tab("Scatter Chart", scatterChart);
        Tab tab3 = new Tab("Bar Chart" , barChart);

        // CREATE TABLE VIEW TAB
        Tab tab4 = new Tab();
        tab4.setText("View ALl Data");
        /*
        BufferedReader csvFile = new BufferedReader(new FileReader("src/charts/uniData.csv"));

        String line;
        String[] propertyValues;

        line = csvFile.readLine();
        csvFile.close();

        propertyValues = line.split(",");

        //System.out.println(Arrays.toString(propertyValues));
        for (int i = 0; i < propertyValues.length; i++) {
            System.out.println(propertyValues[i]);
        }*/

        String[] propertyValues = {"worldRank", "name", "country", "teaching", "international", "research", "citations", "income", "totalScore", "numStudents", "studentStaffRatio", "internationalStudents"};
        
        TextField textField = new TextField();
        HBox hbox = new HBox(textField);

        TableView tableView = createTableView(propertyValues, universityList, "worldRank");

        Button sortButton = new Button("Sort");

        sortButton.setOnAction(action -> {
            String parameter = "";
            parameter = textField.getText();
            System.out.println(parameter);
            VBox tab4_vBox = new VBox();
            tab4_vBox.getChildren().addAll(
                hbox,
                sortButton,
                createTableView(propertyValues, universityList, parameter));
                //new Label("Test Label"),
                //new Button("Test Button"));
            tab4.setContent(tab4_vBox);
            //tableView = createTableView(propertyValues, universityList, parameter);
        });

        //final ObservableList<University> tableViewData = FXCollections.observableArrayList();

        /*
        for (int i = 0; i < universityList.dataSet.size(); i++) {
            String[] rowData = {
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getWorldRank()),
                universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getName(),
                universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getCountry(),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getTeaching()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getInternational()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getResearch()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getCitations()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getIncome()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getTotalScore()),
                //String.valueOf(universityList.dataSet.get(i).getNumStudents()),
                String.valueOf(11111),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getStudentStaffRatio()),
                String.valueOf(universityList.selectionSortUniversities(universityList.dataSet, parameter).get(i).getInternationalStudents())
            };
            tableViewData.add(new University(rowData));
        }
        
        BufferedReader csvFile = new BufferedReader(new FileReader("src/charts/uniData.csv"));

        String line;
        String[] data;

        line = csvFile.readLine();

        data = line.split(",");

        final TableView tableView = new TableView();
        tableView.setItems(tableViewData);

        for (int i = 0; i < 11; i++) {
            TableColumn theColumn = new TableColumn();
            theColumn.setText(propertyValues[i]);
            theColumn.setCellValueFactory(new PropertyValueFactory(propertyValues[i]));
            tableView.getColumns().add(theColumn);
        }*/

        VBox tab4_vBox = new VBox();
        tab4_vBox.getChildren().addAll(
            hbox,
            sortButton,
            tableView);
            //new Label("Test Label"),
            //new Button("Test Button"));
        tab4.setContent(tab4_vBox);
    

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        tabPane.getTabs().add(tab4);

        

        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("University Data");

        primaryStage.show();
    }
}