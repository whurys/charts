package com.organon.charts;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.AxesGridLines;
import org.primefaces.model.charts.axes.cartesian.CartesianScaleLabel;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

@ManagedBean(name = "lineChartView")
public class LineChartView {

	private LineChartModel lineModel;

	public LineChartView() {
		createLineModel();
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
		//dataSet.setLineTension(0.1);
		
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
		
		//Start X properties for axis
		CartesianScaleLabel cScaleLabelX = new CartesianScaleLabel();
		cScaleLabelX.setDisplay(true);
		cScaleLabelX.setFontSize(14);
		cScaleLabelX.setFontColor("red");
		cScaleLabelX.setLabelString("axis X");
		
		CartesianLinearAxes cLinearAxesX = new CartesianLinearAxes();
		cLinearAxesX.setStacked(true);  
		cLinearAxesX.setPosition("left");
		cLinearAxesX.setScaleLabel(cScaleLabelX);
		//End X properties for axis
		
		//Start Y properties for axis
		CartesianScaleLabel cScaleLabelY = new CartesianScaleLabel();
		cScaleLabelY.setDisplay(true);
		cScaleLabelY.setFontSize(14);
		cScaleLabelY.setFontColor("green");
		cScaleLabelY.setLabelString("axis Y");
	
		
		CartesianLinearTicks cLinearTicksY = new CartesianLinearTicks();
		cLinearTicksY.setBeginAtZero(true);//if true, scale will include 0 if it is not already included.
		cLinearTicksY.setMax(150);
		cLinearTicksY.setMin(-10);
		
		AxesGridLines gridLinesY = new AxesGridLines(); //Grid lines for Y
		gridLinesY.setDisplay(true);
		
		CartesianLinearAxes cLinearAxesY = new CartesianLinearAxes();
		cLinearAxesY.setStacked(true);  
		cLinearAxesY.setPosition("left");
		cLinearAxesY.setTicks(cLinearTicksY);
		cLinearAxesY.setScaleLabel(cScaleLabelY);
		cLinearAxesY.setGridLines(gridLinesY); //Grid lines for Y
		//End Y properties for axis
	        
	    
	    CartesianScales cScales = new CartesianScales();
	    cScales.addXAxesData(cLinearAxesX);
	    cScales.addYAxesData(cLinearAxesY);
	        
	    
	    options.setScales(cScales);
		options.setTitle(title);

		lineModel.setOptions(options);
		lineModel.setData(data);
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

}
