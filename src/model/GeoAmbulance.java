package model;

import java.awt.Color;

import model.personality.EmergencyPersonality;

public class GeoAmbulance extends GeoCar {
	public static final Color initialColor = Color.RED;
	public static final Color alternativeColor = Color.WHITE;

	public GeoAmbulance(int id) {
		super(id, new EmergencyPersonality());
		this.emergencyVehicle = true;
	}

	@Override
	public Color generateColor() {
		return GeoAmbulance.initialColor;
	}

	@Override
	public Color changeColor() {
		if (color == GeoAmbulance.initialColor)
			color = GeoAmbulance.alternativeColor;
		else
			color = GeoAmbulance.initialColor;
		return color;
	}
}
