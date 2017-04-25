package net.astercrono.colorgen;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ColorSpectrum {
	private static final int MAX_COLOR = 1530;	
	private final List<Color> allColors = new ArrayList<Color>();
	
	public ColorSpectrum() {
		initColorsFromRGB();
	}
	
	public List<Color> getColors(final int numberOfColors) {
		final List<Color> colors = new ArrayList<Color>();
		final int spectrumSpacing = determineSpectrumSpacing(numberOfColors);
		
		for (int i = 0; i < MAX_COLOR; i += spectrumSpacing)
		{
			final Color color = allColors.get(i);
			colors.add(color);
		}
		
		return colors;
	}
	
	private int determineSpectrumSpacing(final int numberOfColors) {
		return allColors.size() / numberOfColors;
	}
	
	private void initColorsFromRGB()
	{
		int r = 255;
		int g = 0;
		int b = 0;

		for (int i = 0; i <= MAX_COLOR; i++)
		{
			if (i >= 1 && i <= 255)
			{
				g = g + 1;
			}
			else if (i >= 256 && i <= 510)
			{
				r = r - 1;

			}
			else if (i >= 511 && i <= 765)
			{
				b = b + 1;
			}
			else if (i >= 766 && i <= 1020)
			{
				g = g - 1;
			}
			else if (i >= 1021 && i <= 1275)
			{
				r = r + 1;
			}
			else if (i >= 1276 && i <= MAX_COLOR)
			{
				b = b - 1;
			}

			final Color color = new Color(r, g, b);
			allColors.add(color);
		}
	}
}
