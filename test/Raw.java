import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.*;
import java.io.*;

public class Raw extends Application 
{
	Scene raw_scene;
	
	public static void main(String[] args) 
	{
        Application.launch(args);
    }
	public void start(Stage rawStage) throws Exception
	{	
		//read the file
		Scanner sc = new Scanner(new File("C:/Users/apple/Desktop/wrist_ext_1L.csv"));
        sc.useDelimiter(",|\\s");
		
		//Sort the data
		double[][] array = new double[6000][8];
		for(int i = 0; i < array.length; i++) 
		{
			for (int j = 0; j < array[0].length; j++) 
			{
				array[i][j] = Double.parseDouble(sc.next());
			}
        }
		
		//set x-axis and y-axis. creat a line Chart
		final NumberAxis yAxis = new NumberAxis();
        final NumberAxis xAxis = new NumberAxis();
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        yAxis.setLabel("Amplitude(V)");
        xAxis.setLabel("Time");
        lineChart.setTitle("Raw Data");
		raw_scene= new Scene(lineChart,800,600);
		
		/**
		XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
		
		// populating the series with data
		series.getData().add(new XYChart.Data<Number, Number>(1, 23));
		
		lineChart.getData().add(series);
		
		*/
		
		//creat 8 channels
		XYChart.Series channel_1 = new XYChart.Series();
        XYChart.Series channel_2 = new XYChart.Series();
        XYChart.Series channel_3 = new XYChart.Series();
        XYChart.Series channel_4 = new XYChart.Series();
        XYChart.Series channel_5 = new XYChart.Series();
        XYChart.Series channel_6 = new XYChart.Series();
        XYChart.Series channel_7 = new XYChart.Series();
        XYChart.Series channel_8 = new XYChart.Series();
		channel_1.setName("channel_1");
		channel_2.setName("channel_2");
		channel_3.setName("channel_3");
		channel_4.setName("channel_4");
		channel_5.setName("channel_5");
		channel_6.setName("channel_6");
		channel_7.setName("channel_7");
		channel_8.setName("channel_8");
		
		//input the data
		double y;
		XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
		
		//channel 1
		int x_1=0;//or=1?
		for(int i =0; i<array.length;i++)
		{
			y = array[i][0];
			channel_1.getData().add(x_1, y);
			x_1++;	
		}
		
		
		
		rawStage.setScene(raw_scene);
		rawStage.show();
		//Text showText = new Text(ZeroC);
		
    }
}