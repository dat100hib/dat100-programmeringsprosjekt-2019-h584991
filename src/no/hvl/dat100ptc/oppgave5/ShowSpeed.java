package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowSpeed extends EasyGraphics {
			
	private static int MARGIN = 50;
	private static int BARHEIGHT = 200; // assume no speed above 200 km/t

	private GPSComputer gpscomputer;
	private GPSPoint[] gpspoints;
	
	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}
	
	// read in the files and draw into using EasyGraphics
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length-1; // number of data points
		
		makeWindow("Speed profile", 2*MARGIN + 2 * N, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT,N);
	}
	
	public void showSpeedProfile(int ybase, int N) {
		
		System.out.println("Angi tidsskalering i tegnevinduet ...");
		int timescaling = Integer.parseInt(getText("Tidsskalering"));
				
		// TODO - START
		
		setColor(0,0,255);
		
		int xposition = MARGIN + 1;
		
		double totalDistance = 0;
		
		double totalSpeed = 0;
		
		for (int i = 1; i < gpspoints.length; i++) {
			double distance = GPSUtils.distance(gpspoints[i-1], gpspoints[i]);
			int time = gpspoints[i].getTime() - gpspoints[i-1].getTime();
			
			double speed = ((distance/time)*3.6);
			int intSpeed = (int)(speed + 0.5);
			
			totalDistance += distance;
			totalSpeed += speed;
			
			
			drawLine(xposition, ybase, xposition, ybase - intSpeed);
			
			
			xposition += 2;
			
		}
		
		double averageSpeed = totalSpeed / N;
		
		int intAvgSpd = (int)(averageSpeed + 0.5);
		
		setColor(0,255,0);
		drawLine(MARGIN + 1, ybase - intAvgSpd, MARGIN + 2*N, ybase - intAvgSpd);
		
		
		
		// throw new UnsupportedOperationException(TODO.method());
	
		// TODO - SLUTT
	}
}
