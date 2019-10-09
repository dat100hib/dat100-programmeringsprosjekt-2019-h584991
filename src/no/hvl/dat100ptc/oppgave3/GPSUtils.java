package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] latitudes = new double[gpspoints.length];
		int teller = 0;
		
		for (GPSPoint g : gpspoints) {
			latitudes[teller] = g.getLatitude();
			teller++;
		}
		
		return latitudes;
		
		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] longitudes = new double[gpspoints.length];
		int teller = 0;
		
		for (GPSPoint g : gpspoints) {
			longitudes[teller] = g.getLongitude();
			teller++;
		}
		
		return longitudes;

		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		double deltaPhi = latitude2 - latitude1;
		double deltaLambda = longitude2 - longitude1;
		
		double a = Math.pow(Math.sin(deltaPhi/2), 2) + Math.cos(latitude1)*Math.cos(latitude2)*Math.pow(Math.sin(deltaLambda/2), 2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		d = R*c;
		
		return d;

		// throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		double distance = distance(gpspoint1, gpspoint2);
		
		speed = (distance/secs)*3.6;
		
		return speed;

		// throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		
		int hh = secs/3600;
		int rest = secs%3600;
		int mm = rest/60;
		int ss = rest%60;

		String hhStr = String.format("%02d", hh);
		String mmStr = String.format("%02d", mm);
		String ssStr = String.format("%02d", ss);
		
		timestr = hhStr + TIMESEP + mmStr + TIMESEP + ssStr;
		
		timestr = String.format("%10s", timestr);
		
		return timestr;
		

		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START
		
		str = String.format(Locale.US, "%.2f", d);
		str = String.format("%10s", str);
		
		return str;

		// throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
}
