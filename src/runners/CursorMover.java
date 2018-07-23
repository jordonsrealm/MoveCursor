package runners;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import configuration.ConfigurationGetter;
import main.FrameLocation;


public class CursorMover {

	boolean keepGoing = true;
	Robot robot ;
	JFrame frame;
	FrameLocation frameLocation;
	Thread movingThread;
	boolean justCreated = true;
	Timer timer;

	public static final long ONE_SECOND_MILLIS = 1000;
	int waitTimeFactor;


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
			Process p =  Runtime.getRuntime().exec("cmd /c start resources\\LockComputer.bat");
			p.waitFor();
		} catch (IOException e) {
		} catch (InterruptedException e) {
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
