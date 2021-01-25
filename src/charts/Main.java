package charts;

import java.io.IOException;

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

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException{

        UniversityList universityList = new UniversityList("src/charts/uniData.csv");

        // CREATE PIE CHART
        PieChart pieChart = new PieChart();

        for (int i = 0; i < universityList.dataSet.size(); i++) {
            PieChart.Data pieChartData = new PieChart.Data(universityList.dataSet.get(i).getName(), universityList.dataSet.get(i).getTotalScore());
            pieChart.getData().add(pieChartData);
        }

        // CREATE SCATTER CHART
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Total Score");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of Students");

        ScatterChart scatterChart = new ScatterChart(xAxis, yAxis);

        for (int i = 0; i < universityList.dataSet.size(); i++) {
            XYChart.Series scatterChartData = new XYChart.Series();
            scatterChartData.setName(universityList.dataSet.get(i).getName());
            scatterChartData.getData().add(new XYChart.Data(universityList.dataSet.get(i).getTotalScore(), universityList.dataSet.get(i).getNumStudents()));
            scatterChart.getData().add(scatterChartData);
        }

        CategoryAxis thexAxis = new CategoryAxis();
        thexAxis.setLabel("Universities");

        NumberAxis theyAxis = new NumberAxis();
        theyAxis.setLabel("Teaching");

        BarChart barChart = new BarChart(thexAxis, theyAxis);
        for (int i = 0; i < universityList.dataSet.size(); i++) {
            XYChart.Series barChartData = new XYChart.Series();
            //dataSeries1.setName(universityList.dataSet.get(i).getName());
            barChartData.getData().add(new XYChart.Data(universityList.dataSet.get(i).getName(), universityList.dataSet.get(i).getTeaching()));
            barChart.getData().add(barChartData);
        }

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Pie Chart", pieChart);
        Tab tab2 = new Tab("Scatter Chart", scatterChart);
        Tab tab3 = new Tab("Bar Chart" , barChart);


        Tab tab4 = new Tab();
        tab4.setText("Tab C");
        
        VBox tab4_vBox = new VBox();
        tab4_vBox.getChildren().addAll(
              new Label("Test Label"),
              new Button("Test Button"));
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