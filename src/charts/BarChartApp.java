package charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import java.io.*;
//import java.util.ArrayList;
 
public class BarChartApp extends Application {
 
    @Override public void start(Stage stage) throws IOException {

        BufferedReader csvFile = new BufferedReader(new FileReader("src/charts/unis.csv"));

        csvFile.close();

        Scene scene = new Scene(new Group());
        stage.setTitle("Test Data");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("One", 25),
                new PieChart.Data("Two", 10),
                new PieChart.Data("Three", 25),
                new PieChart.Data("Four", 30),
                new PieChart.Data("Five", 5),
                new PieChart.Data("Six", 19));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Test Data");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}