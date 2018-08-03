package cursor.components;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.util.TimerTask;


public class CursorTimerTask extends TimerTask{
	
	private Robot robot ;
	private FrameLocation frameLocation;
	
	public CursorTimerTask(FrameLocation frameLocation) throws AWTException {
		this.frameLocation = frameLocation;
		this.robot = new Robot();
	}

	@Override
	public void run() {
		move();
	}
	

	private void move() {
		Point newPoint = frameLocation.getNextMove();
		robot.mouseMove(newPoint.x, newPoint.y);
	}

}
