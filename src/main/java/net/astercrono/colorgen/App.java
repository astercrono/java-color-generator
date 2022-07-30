package net.astercrono.colorgen;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import net.astercrono.colorgrid.ColorGrid;
import net.astercrono.colorgrid.ColorGridDimensions;

public class App {
	private ColorGeneration colorGeneration;
	private int numberOfColors;
	
	public App(final ColorGeneration colorGeneration, final int numberOfColors) {
		this.colorGeneration = colorGeneration;
		this.numberOfColors = numberOfColors;
	}
	
	public static void main(final String[] args) {
		final int width = 700;
		final int height = 700;
		final int rows = 100;
		final int columns = 100;
		final int numberOfColors = 100;
	
		final ColorGeneration colorGeneration = new ColorGeneration();
		
		final App app = new App(colorGeneration, numberOfColors);
		app.renderColors(width, height, rows, columns);
	}

	public void renderColors(final int width, final int height, final int rows, final int columns) {
		final ColorGridDimensions dimensions = new ColorGridDimensions();
		dimensions.setRows(rows);
		dimensions.setColumns(columns);
		dimensions.setWidth(width);
		dimensions.setHeight(height);

		final ColorGrid grid = new ColorGrid(dimensions);

		final JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(new Dimension(width, height + 20));
		window.add(grid);
		window.setVisible(true);
		
		final Color[] colors = colorGeneration.generate(numberOfColors).toArray(new Color[numberOfColors]);
		for (int i = 0; i < rows; i++) {
			grid.setRowColors(i, colors);
		}
		
		grid.repaint();
	}
}
