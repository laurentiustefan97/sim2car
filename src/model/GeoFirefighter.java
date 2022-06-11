package model;

import java.awt.Color;

import com.beust.jcommander.Parameter;

import model.parameters.Globals;
import model.personality.EmergencyPersonality;

public class GeoFirefighter extends GeoCar {
	public static final Color initialColor = Color.RED;
	public static final Color alternativeColor = Color.YELLOW;

	private int clockTickCounter = 0;
	private int stallNoClockTicks = 0;

	public GeoFirefighter(int id) {
		super(id, new EmergencyPersonality());
		this.emergencyVehicle = true;
	}

	@Override
	public void prepareMove() {
		if (stallNoClockTicks > 0) {
			if (--stallNoClockTicks == 0) {
				clockTickCounter = 0;
				super.prepareMove();
			}
			return;
		}

		clockTickCounter++;

		MapPoint currentPos = this.getCurrentPos();
		/*
		 * Every @firefighterFirePeriod rounds a fire incident happens and the firefighter
		 * needs to stall for @firefighterStallRounds rounds to handle the incident.
		 */
		if (clockTickCounter >= Globals.firefighterFirePeriod && !isStoppedAtTrafficLight() && currentPos != null) {
			stallNoClockTicks = Globals.firefighterStallRounds;
		} else {
			super.prepareMove();
		}
	}

	@Override
	public void move() {
		if (stallNoClockTicks > 0)
			return;
		super.move();
	}

	@Override
	public Color generateColor() {
		return GeoFirefighter.initialColor;
	}

	@Override
	public Color changeColor() {
		if (color == GeoFirefighter.initialColor)
			color = GeoFirefighter.alternativeColor;
		else
			color = GeoFirefighter.initialColor;
		return color;
	}
}
