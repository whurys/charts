package com.organon.charts;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bubble.BubbleChartDataSet;
import org.primefaces.model.charts.bubble.BubbleChartModel;
import org.primefaces.model.charts.data.BubblePoint;

@ManagedBean(name = "bubbleChartView")
public class BubbleChartView {
	
	private BubbleChartModel bubbleModel;
	
	
	public BubbleChartView() {
		createBubbleModel();
	}
	
	public void createBubbleModel() {
        bubbleModel = new BubbleChartModel();
        ChartData data = new ChartData();

        BubbleChartDataSet dataSet = new BubbleChartDataSet();
        List<BubblePoint> values = new ArrayList<>();
        values.add(new BubblePoint(20, 30, 15));
        values.add(new BubblePoint(40, 10, 10));
        dataSet.setData(values);
        dataSet.setBackgroundColor("rgb(255, 99, 132)");
        dataSet.setLabel("First Dataset");
        data.addChartDataSet(dataSet);
        bubbleModel.setData(data);
    }
	

	public BubbleChartModel getBubbleModel() {
		return bubbleModel;
	}

	public void setBubbleModel(BubbleChartModel bubbleModel) {
		this.bubbleModel = bubbleModel;
	}

}
