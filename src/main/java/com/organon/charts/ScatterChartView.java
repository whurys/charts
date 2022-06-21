package com.organon.charts;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.data.NumericPoint;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.scatter.ScatterChartModel;

import com.organon.tools.NumberTool;


@ManagedBean(name = "scatterChartView")
public class ScatterChartView {

	private ScatterChartModel scatterModel;

	public ScatterChartView() {
		createScatterModel();
	}

	public void createScatterModel() {
        scatterModel = new ScatterChartModel();
        ChartData data = new ChartData();

        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        
        List<NumericPoint> l = NumberTool.randCirclePoint(10, 5, 5, 200);
        
        l.forEach(numeric -> {
        	values.add(numeric);
        	
        });
        
        
        dataSet.setData(values);
        dataSet.setLabel("Dataset");
        dataSet.setBorderColor("rgb(249, 24, 24)");
        dataSet.setShowLine(false);
        
        
        LineChartDataSet dataSet2 = new LineChartDataSet();
        List<Object> values2 = new ArrayList<>();
        
        List<NumericPoint> l2 = NumberTool.randDiskPoint(9, 5, 5, 2000);
        
        l2.forEach(numeric -> {
        	values2.add(numeric);
        	
        });
        
        
        dataSet2.setData(values2);
        dataSet2.setLabel("Dataset2");
        dataSet2.setBorderColor("rgb(255, 245, 0)");
        dataSet2.setShowLine(false);
        
        data.addChartDataSet(dataSet);
        data.addChartDataSet(dataSet2);
        
        //Options
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
		title.setDisplay(true);
		title.setText("Scartter Chart");
		title.setFontColor("rgb(255, 255, 255)");
		title.setFontSize(30);
		title.setFontFamily("Arial");
		title.setPadding(20);
		title.setPosition("top");
        
        
        options.setShowLines(false);
        options.setTitle(title);

        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setType("linear");
        linearAxes.setPosition("bottom");
        cScales.addXAxesData(linearAxes);
        options.setScales(cScales);

        scatterModel.setOptions(options);
        scatterModel.setData(data);
    }

	public ScatterChartModel getScatterModel() {
		return scatterModel;
	}

	public void setScatterModel(ScatterChartModel scatterModel) {
		this.scatterModel = scatterModel;
	}

	
}
