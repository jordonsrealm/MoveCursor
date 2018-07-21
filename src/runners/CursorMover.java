package runners;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.io.IOException;

import javax.swing.JFrame;

import main.FrameLocation;


public class CursorMover implements Runnable {

	boolean keepGoing = true;
	Robot robot ;
	JFrame frame;
	FrameLocation frameLocation;
	Thread movingThread;
	boolean justCreated = true;

	public static final long ONE_SECOND_MILLIS = 1000;
	public static final int  WAIT_TIME_FACTOR = 5;


	public CursorMover(JFrame frame) throws AWTException {
		this.robot = new Robot();
		this.frame = frame;
		this.frameLocation = new FrameLocation(frame);
	}

	public void start() {
		if(	movingThread != null && movingThread.isAlive()) {
			stop();		
		}
		
		this.keepGoing = true;
		this.movingThread = new Thread(this);
		this.movingThread.start();
	}
	
	public void stopThread() {
		this.keepGoing = false;
		if(	movingThread != null) {
			try {
				movingThread.join();
				movingThread = null;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void stop() {
		stopThread();
		lockComputer();
	}
	
	private void lockComputer() {
		try {
			Process p =  Runtime.getRuntime().exec("cmd /c start resources\\LockComputer.bat");
			p.waitFor();
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
	}
	
	@Override
	public void run() {
		while( true ) {
			if( keepGoing ) {
				move();
			}
		}
	}

	private void move() {
		try {
			Point newPoint = frameLocation.getNextMove();
			robot.mouseMove(newPoint.x, newPoint.y);
			sleep();
			newPoint = frameLocation.getNextMove();
			robot.mouseMove(newPoint.x, newPoint.y);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void sleep() throws InterruptedException {
		Thread.sleep(WAIT_TIME_FACTOR * ONE_SECOND_MILLIS);
	}
	
	public boolean isKeepGoing() {
		return keepGoing;
	}

	public void setKeepGoing(boolean keepGoing) {
		this.keepGoing = keepGoing;
	}
}
