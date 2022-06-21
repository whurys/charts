package com.organon.tools;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class NumberTool {

	public static BigDecimal parse(final String amount, final Locale locale) throws ParseException {
		final NumberFormat format = NumberFormat.getNumberInstance(locale);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setParseBigDecimal(true);
		}
		return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
	}

	public static int random(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	public static double random(double min, double max) {
		double diff = max - min;
		return min + Math.random() * diff;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static String randomLightRGB() {
		Random rand = new Random();
		int min = 100;
		int max = 256;
		return "rgb(" + (rand.nextInt((max - min) + 1) + min) + "," + (rand.nextInt((max - min) + 1) + min) + ","
				+ (rand.nextInt((max - min) + 1) + min) + ")";
	}

	/**
	 * 
	 * @param x              between minimal and maximal value. e.g: -1 <-> +1
	 * @param normalizedLow  minimal value
	 * @param normalizedHigh maximal value
	 * @return
	 */
	public static double[] normalize(double[] x, double normalizedLow, double normalizedHigh) {

		DoubleSummaryStatistics stat = Arrays.stream(x).summaryStatistics();
		double[] normalized = new double[x.length];

		for (int i = 0; i < x.length; i++) {
			normalized[i] = normalize(x[i], stat.getMin(), stat.getMax(), normalizedLow, normalizedHigh);
		}

		return normalized;
	}

	/**
	 * Normalize x between 0 <-> 1.
	 * 
	 * @param x The value to be normalized.
	 * @return The result of the normalization.
	 */
	public static double[] normalize(double[] x) {

		DoubleSummaryStatistics stat = Arrays.stream(x).summaryStatistics();
		double[] normalized = new double[x.length];

		for (int i = 0; i < x.length; i++) {
			normalized[i] = normalize(x[i], stat.getMin(), stat.getMax());
		}

		return normalized;
	}

	public static double normalize(double x, double dataLow, double dataHigh, double normalizedLow,
			double normalizedHigh) {
		return ((x - dataLow) / (dataHigh - dataLow)) * (normalizedHigh - normalizedLow) + normalizedLow;
	}

	public static double normalize(double x, double dataLow, double dataHigh) {
		return ((x - dataLow) / (dataHigh - dataLow));
	}

//	/**
//	 * Normalize x.
//	 * @param x The value to be normalized.
//	 * @return The result of the normalization.
//	 */
//	public double normalize(double x) {
//	    return ((x - dataLow) 
//	            / (dataHigh - dataLow))
//	            * (normalizedHigh - normalizedLow) + normalizedLow;
//	}

	public double[] randCirclePoint(double radius, double x_center, double y_center) {
		double len = radius;
		double deg = Math.random() * 2 * Math.PI;
		double x = x_center + len * Math.cos(deg);
		double y = y_center + len * Math.sin(deg);
		return new double[] { x, y };
	}

	public double[] randDiskPoint(double radius, double x_center, double y_center) {
		double len = Math.sqrt(Math.random()) * radius;
		double deg = Math.random() * 2 * Math.PI;
		double x = x_center + len * Math.cos(deg);
		double y = y_center + len * Math.sin(deg);
		return new double[] { x, y };
	}

	public static List<org.primefaces.model.charts.data.NumericPoint> randDiskPoint(double radius, double x_center,
			double y_center, int quantityPoints) {
		List<org.primefaces.model.charts.data.NumericPoint> list = new ArrayList<>();

		for (int i = 0; i < quantityPoints; i++) {
			double len = Math.sqrt(Math.random()) * radius;
			double deg = Math.random() * 2 * Math.PI;
			double x = x_center + len * Math.cos(deg);
			double y = y_center + len * Math.sin(deg);
			list.add(new org.primefaces.model.charts.data.NumericPoint(x, y));
		}

		return list;
	}
	
	public static List<org.primefaces.model.charts.data.NumericPoint> randCirclePoint(double radius, double x_center,
			double y_center, int quantityPoints) {
		List<org.primefaces.model.charts.data.NumericPoint> list = new ArrayList<>();

		for (int i = 0; i < quantityPoints; i++) {
			double len = radius;
			double deg = Math.random() * 2 * Math.PI;
			double x = x_center + len * Math.cos(deg);
			double y = y_center + len * Math.sin(deg);
			list.add(new org.primefaces.model.charts.data.NumericPoint(x, y));
		}

		return list;
	}
}
