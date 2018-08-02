package main;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import configuration.ConfigurationGetter;


public class CursorMover {

	private boolean keepGoing = true;
	private Robot robot ;
	JFrame frame;
	private FrameLocation frameLocation;
	Thread movingThread;
	boolean justCreated = true;
	private Timer timer;
	public static final long ONE_SECOND_MILLIS = 1000;
	private int waitTimeFactor;


	public CursorMover(JFrame frame, ConfigurationGetter configGetter) throws AWTException {
		waitTimeFactor = configGetter.getTimerPeriod();
		
		this.robot = new Robot();
		this.frame = frame;
		this.frameLocation = new FrameLocation(frame);
		timer = new Timer(true);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				move();
			}
		};
		timer.scheduleAtFixedRate(task, 1000, waitTimeFactor * ONE_SECOND_MILLIS);
	}
	
	public void lockComputer() {
		try {
			String currentPath =  new File("").getCanonicalPath() + "\\LockComputer.bat";
			Process p =  Runtime.getRuntime().exec("cmd /c start " + currentPath);
			p.waitFor();
		} catch (IOException | InterruptedException ex) {
			// no logging at the moment
		}
	}


	private void move() {
		Point newPoint = frameLocation.getNextMove();
		robot.mouseMove(newPoint.x, newPoint.y);
	}
	
	public boolean isKeepGoing() {
		return keepGoing;
	}

	public void setKeepGoing(boolean keepGoing) {
		this.keepGoing = keepGoing;
	}

	public Timer getTimer() {
		return timer;
	}

	public void resetTimer() {
		this.timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				move();
			}
		}, 1000, waitTimeFactor * ONE_SECOND_MILLIS);
	}
}
