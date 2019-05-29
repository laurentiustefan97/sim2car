package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapObjectImpl;
import org.openstreetmap.gui.jmapviewer.Style;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

/**
 * A simple implementation of the {@link MapMarker} interface. Each map marker
 * is painted as a circle with a black border line and filled with a specified
 * color.
 *
 * @author Andreea Sonea
 *
 */
public class MapMarkerTrafficLight extends MapObjectImpl implements MapMarker {

    double lat;
    double lon;
    STYLE markerStyle = STYLE.VARIABLE;
    double radius = 4;
    Coordinate coord;

    public static final int DOT_RADIUS = 5;

    public MapMarkerTrafficLight(Coordinate coord) {
        this(null, null, coord);
    }
    public MapMarkerTrafficLight(String name, Coordinate coord) {
        this(null, name, coord);
    }
    public MapMarkerTrafficLight(Layer layer, Coordinate coord) {
        this(layer, null, coord);
    }
    public MapMarkerTrafficLight(Layer layer, String name, Coordinate coord) {
        this(layer, name, coord, getDefaultStyle());
    }
    public MapMarkerTrafficLight(Color color, double lat, double lon) {
        this(null, null, lat, lon);
        setColor(color);
    }
    public MapMarkerTrafficLight(double lat, double lon) {
        this(null, null, lat, lon);
    }
    public MapMarkerTrafficLight(Layer layer, double lat, double lon) {
        this(layer, null, lat, lon);
    }
    public MapMarkerTrafficLight(Layer layer, String name, double lat, double lon) {
        this(layer, name, new Coordinate(lat, lon), getDefaultStyle());
    }
    
    public MapMarkerTrafficLight(Layer layer, String name, Coordinate coord, Style style) {
        this(layer, name, coord, DOT_RADIUS, STYLE.FIXED, style);
    }

    public MapMarkerTrafficLight(Coordinate coord, double radius) {
        this(null, null, coord, radius);
    }
    public MapMarkerTrafficLight(String name, Coordinate coord, double radius) {
        this(null, name, coord, radius);
    }
    public MapMarkerTrafficLight(Layer layer, Coordinate coord, double radius) {
        this(layer, null, coord, radius);
    }
    public MapMarkerTrafficLight(double lat, double lon, double radius) {
        this(null, null, new Coordinate(lat,lon), radius);
    }
    public MapMarkerTrafficLight(Layer layer, double lat, double lon, double radius) {
        this(layer, null, new Coordinate(lat,lon), radius);
    }
    public MapMarkerTrafficLight(Layer layer, String name, Coordinate coord, double radius) {
        this(layer, name, coord, radius, STYLE.VARIABLE, getDefaultStyle());
    }
    public MapMarkerTrafficLight(Layer layer, String name, Coordinate coord, double radius, STYLE markerStyle, Style style) {
        super(layer, name, style);
        this.markerStyle = markerStyle;
        this.coord = coord;
        this.radius = radius;
    }

    public Coordinate getCoordinate(){
        return coord;
    }
    public double getLat() {
        return coord.getLat();
    }

    public double getLon() {
        return coord.getLon();
    }

    public double getRadius() {
        return radius;
    }

    public STYLE getMarkerStyle() {
        return markerStyle;
    }

    public static Style getDefaultStyle(){
        return new Style(Color.RED, new Color(200,200,200,200), null, getDefaultFont());
    }
    @Override
    public String toString() {
        return "MapMarker at " + getLat() + " " + getLon();
    }
    @Override
    public void setLat(double lat) {
        if(coord==null) coord = new Coordinate(lat,0);
        else coord.setLat(lat);
    }
    @Override
    public void setLon(double lon) {
        if(coord==null) coord = new Coordinate(0,lon);
        else coord.setLon(lon);
    }



    public void paint(Graphics g, Point position, int radio) {
    	
    	//System.out.println("Painting traffic light again"); // To see when
	       // paint() is called
    	
    	Dimension d = new Dimension(50, 50);		// Get size of canvas
    	int TLWidth = d.width/4;		// Set width of traffic light
    	int TLHeight = 3*d.height/4;		// Set height of traffic light
    	int xOrigin = position.x; // Center traffic light on canvas
    	int yOrigin = position.y;

    	//Draw outline of traffic light
    	g.drawRect(xOrigin,yOrigin,TLWidth,TLHeight);

    	Color onLight = getColor();
		if ( onLight  == Color.red ){
    	      g.setColor(Color.red);
    	      g.fillOval(xOrigin+TLWidth/4,yOrigin+TLHeight/8,TLHeight/5,
    	                 TLHeight/5);
    	   } else if ( onLight == Color.yellow ){
    	      g.setColor(Color.yellow);
    	      g.fillOval(xOrigin+TLWidth/4,yOrigin+5*TLHeight/12,TLHeight/5,
    	                 TLHeight/5);
    	   } else {			// Green light
    	      g.setColor(Color.green);
    	      g.fillOval(xOrigin+TLWidth/4,yOrigin+17*TLHeight/24,TLHeight/5,
    	                 TLHeight/5);
    	   }

    	   // Now draw black outline around each light
    	   // Red light
    	   g.setColor(Color.black);
    	   g.drawOval(xOrigin+TLWidth/4,yOrigin+TLHeight/8,TLHeight/5,
    	                TLHeight/5);
    	   // Yellow light
    	   g.drawOval(xOrigin+TLWidth/4,yOrigin+5*TLHeight/12,TLHeight/5,
    	                TLHeight/5);
    	   // Green light
    	   g.drawOval(xOrigin+TLWidth/4,yOrigin+17*TLHeight/24,TLHeight/5,
    	                TLHeight/5);
    }

        
}
