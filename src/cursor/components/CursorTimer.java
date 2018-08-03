package cursor.components;

import java.awt.AWTException;
import java.util.Timer;


public class CursorTimer extends Timer{

	private CursorTimerTask task;
	
	
	public CursorTimer(FrameLocation frameLocation, Long delayTime) {
		try {
			task = new CursorTimerTask(frameLocation);
		} catch (AWTException e) {
			// no logger implemented
		}
		scheduleAtFixedRate(task, 1000, delayTime);
	}

	public CursorTimer resetTimer(FrameLocation frameLocation, Long delayTime) {
		return new CursorTimer(frameLocation, delayTime);
	}
}
