package net.astercrono.colorgen;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ColorGeneration {
	private static final float DEFAULT_SATURATION = 1;
	private static final int DEFAULT_BRIGHTNESS = 1;
	
	private float saturation = DEFAULT_SATURATION;
	private float brightness = DEFAULT_BRIGHTNESS;

	public ColorGeneration() {
	}
	
	public ColorGeneration(final float saturation, final float brightness) {
		this.saturation = saturation;
		this.brightness = brightness;
	}
	
	public List<Color> generate(final int numberOfColors) {
		final ColorSpectrum spectrum = new ColorSpectrum();
		final List<Color> colors = spectrum.getColors(numberOfColors);
		return adjustColorsForHueAndSaturation(colors);
	}
	
	private List<Color> adjustColorsForHueAndSaturation(final List<Color> colors) {
		final List<Color> adjustedColors = new ArrayList<Color>(colors.size());

		colors.forEach((Color color) -> {
			final int r = color.getRed();
			final int g = color.getGreen();
			final int b = color.getBlue();
			
			final float[] hsb = Color.RGBtoHSB(r, g, b, null);
			final int rgb = Color.HSBtoRGB(hsb[0], saturation, brightness);
			
			final Color newColor = new Color(rgb);
			adjustedColors.add(newColor);
		});
		
		return adjustedColors;
	}
}
