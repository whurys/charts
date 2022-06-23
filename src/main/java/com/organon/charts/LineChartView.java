package com.organon.charts;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.AxesGridLines;
import org.primefaces.model.charts.axes.cartesian.CartesianScaleLabel;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.title.Title;

@ManagedBean(name = "lineChartView")
@SessionScoped
public class LineChartView {

	private LineChartModel lineModel;
	private LineChartModel multiLineModel;
	
	private List<String> labels = new ArrayList<>();
	private Map<String, List<Object>> mapValues = new LinkedHashMap<>();
	
	private List<Object> values1 = new ArrayList<>();

	

	public LineChartView() {
		createLineModel();

		Map<String, List<Object>> map = new LinkedHashMap<>();

		List<String> labels = new ArrayList<>();
		labels.add("0");
		labels.add("February");
		labels.add("March");
		labels.add("April");
		labels.add("May");
		labels.add("June");
		labels.add("July");

		List<Object> values1 = new ArrayList<>();
		values1.add(0);
		values1.add(59);
		values1.add(80);
		values1.add(81);
		values1.add(56);
		values1.add(55);
		values1.add(40);

		List<Object> values2 = new ArrayList<>();
		values2.add(63);
		values2.add(53);
		values2.add(85);
		values2.add(90);
		values2.add(50);
		values2.add(53);
		values2.add(12);
		
		List<Object> values3 = new ArrayList<>();
		values3.add(10);
		values3.add(20);
		values3.add(32);
		values3.add(45);
		values3.add(50);
		values3.add(53);
		values3.add(67);

		map.put("Linha 1", values1);
		map.put("Linha 2", values3);
		map.put("Linha 3", values2);

		createLineModel(labels, map);
		
		


	}

	public void createLineModel() {
		lineModel = new LineChartModel();
		ChartData data = new ChartData();

		LineChartDataSet dataSet = new LineChartDataSet();
		List<Object> values = new ArrayList<>();
		values.add(65);
		values.add(59);
		values.add(80);
		values.add(81);
		values.add(56);
		values.add(55);
		values.add(40);
		dataSet.setData(values);
		dataSet.setFill(false);
		dataSet.setLabel("Dataset");
		dataSet.setBorderColor("rgb(75, 192, 192)");
		// dataSet.setLineTension(0.1);

		data.addChartDataSet(dataSet);

		List<String> labels = new ArrayList<>();
		labels.add("January");
		labels.add("February");
		labels.add("March");
		labels.add("April");
		labels.add("May");
		labels.add("June");
		labels.add("July");

		data.setLabels(labels);

		// Options
		LineChartOptions options = new LineChartOptions();

		Title title = new Title();
		title.setDisplay(true);
		title.setText("Line Chart");
		title.setFontColor("rgb(255, 255, 255)");
		title.setFontSize(30);
		title.setFontFamily("Arial");
		title.setPadding(20);
		title.setPosition("top");

		// Start X properties for axis
		CartesianScaleLabel cScaleLabelX = new CartesianScaleLabel();
		cScaleLabelX.setDisplay(true);
		cScaleLabelX.setFontSize(14);
		cScaleLabelX.setFontColor("red");
		cScaleLabelX.setLabelString("axis X");

		CartesianLinearAxes cLinearAxesX = new CartesianLinearAxes();
		cLinearAxesX.setStacked(true);
		cLinearAxesX.setPosition("left");
		cLinearAxesX.setScaleLabel(cScaleLabelX);
		// End X properties for axis

		// Start Y properties for axis
		CartesianScaleLabel cScaleLabelY = new CartesianScaleLabel();
		cScaleLabelY.setDisplay(true);
		cScaleLabelY.setFontSize(14);
		cScaleLabelY.setFontColor("green");
		cScaleLabelY.setLabelString("axis Y");

		CartesianLinearTicks cLinearTicksY = new CartesianLinearTicks();
		cLinearTicksY.setBeginAtZero(true);// if true, scale will include 0 if it is not already included.
		cLinearTicksY.setMax(150);
		cLinearTicksY.setMin(-10);

		AxesGridLines gridLinesY = new AxesGridLines(); // Grid lines for Y
		gridLinesY.setDisplay(true);

		CartesianLinearAxes cLinearAxesY = new CartesianLinearAxes();
		cLinearAxesY.setStacked(true);
		cLinearAxesY.setPosition("left");
		cLinearAxesY.setTicks(cLinearTicksY);
		cLinearAxesY.setScaleLabel(cScaleLabelY);
		cLinearAxesY.setGridLines(gridLinesY); // Grid lines for Y
		// End Y properties for axis

		CartesianScales cScales = new CartesianScales();
		cScales.addXAxesData(cLinearAxesX);
		cScales.addYAxesData(cLinearAxesY);

		options.setScales(cScales);
		options.setTitle(title);

		lineModel.setOptions(options);
		lineModel.setData(data);
	}

	public void createLineModel(Map<Object, List<Object>> labelValues) {

		multiLineModel = new LineChartModel();
		ChartData data = new ChartData();

		LineChartDataSet dataSet = new LineChartDataSet();

		List<String> labels = new ArrayList<>();

		labelValues.forEach((x, y) -> {

			System.out.print(x);
			labels.add((String) x);

			List<Object> values = new ArrayList<>();
			y.forEach(v -> {

				System.out.print(": " + v);
				values.add(v);

			});

			System.out.println();
			dataSet.setData(values);
			dataSet.setFill(false);
			dataSet.setLabel("D-" + x);
			dataSet.setBorderColor(randomLightRGB());

			data.addChartDataSet(dataSet);
		});

		data.setLabels(labels);

		multiLineModel.setData(data);

	}

	public void createLineModel(List<String> labels, Map<String, List<Object>> mapValues) {

		multiLineModel = new LineChartModel();
		ChartData data = new ChartData();

		

		mapValues.forEach((lineName, values) -> {

			LineChartDataSet dataSet = new LineChartDataSet();
			
			dataSet.setData(values);
			dataSet.setFill(false);
			
			dataSet.setLabel(lineName);
			dataSet.setBorderColor(randomLightRGB());
			
			data.addChartDataSet(dataSet);

		});

		data.setLabels(labels);
		
		
		//Options
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line Chart 2");
        options.setTitle(title);
        
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        multiLineModel.setOptions(options);
		

		multiLineModel.setData(data);

	}
	
	
	public void createMultiLineModel() {

		multiLineModel = new LineChartModel();
		ChartData data = new ChartData();

		mapValues.forEach((lineName, values) -> {

			LineChartDataSet dataSet = new LineChartDataSet();
			
			dataSet.setData(values);
			dataSet.setFill(false);
			
			dataSet.setLabel(lineName);
			dataSet.setBorderColor(randomLightRGB());
			
			data.addChartDataSet(dataSet);

		});

		data.setLabels(labels);
		
		
		//Options
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line Chart 2");
        options.setTitle(title);
        
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        multiLineModel.setOptions(options);
		

		multiLineModel.setData(data);

	}
	
	private int numberCount;
	
	public void testPool() {
		numberCount++;
		
		System.out.println("Pool "+numberCount);
		
		labels.add(""+numberCount);
		values1.add(rangeMinMax(-10, 10));
		
		if(labels.size() >= 20) {
			labels.remove(0);
			values1.remove(0);
			
		}
		
		mapValues.put("Dynamic Data", values1);
		
		createMultiLineModel();
		System.out.println("Finish Pool "+numberCount);
		
	}
	
	 private int number;

	    public void increment() {
	        number++;
	    }

	    public int getNumber() {
	        return number;
	    }

	
	public static String randomLightRGB() {
		Random rand = new Random();
		int min = 100;
		int max = 256;
		return "rgb(" + (rand.nextInt((max - min) + 1) + min) + "," + (rand.nextInt((max - min) + 1) + min) + ","
				+ (rand.nextInt((max - min) + 1) + min) + ")";
	}
	
	public static int rangeMinMax(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

	public LineChartModel getMultiLineModel() {
		return multiLineModel;
	}

	public void setMultiLineModel(LineChartModel multiLineModel) {
		this.multiLineModel = multiLineModel;
	}

	public int getNumberCount() {
		return numberCount;
	}

}
