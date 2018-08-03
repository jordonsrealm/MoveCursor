package cursor.components;

import java.io.IOException;
import java.util.Timer;
import javax.swing.JFrame;

import configuration.ConfigurationGetter;


public class CursorMover {

	private boolean keepGoing = true;
	JFrame frame;
	private FrameLocation frameLocation;
	Thread movingThread;
	boolean justCreated = true;
	private CursorTimer cursorTimer;
	public static final long ONE_SECOND_MILLIS = 1000;
	private int waitTimeFactor;


	public CursorMover(JFrame frame, ConfigurationGetter configGetter) {
		this.waitTimeFactor = configGetter.getTimerPeriod();
		this.frame = frame;
		this.frameLocation = new FrameLocation(frame);
		cursorTimer = new CursorTimer(frameLocation, waitTimeFactor * ONE_SECOND_MILLIS);
	}
	
	public void lockComputer() {
		try {
			String currentPath =  getClass().getClassLoader().getResources("LockComputer.bat").nextElement().toString();
			Process p =  Runtime.getRuntime().exec("cmd /c start " + currentPath);
			p.waitFor();
		} catch (IOException | InterruptedException ex) {
			try {
				throw ex;
			} catch (Exception e) {
				// no logging at the moment
			}
		}
	}
	
	public boolean isKeepGoing() {
		return keepGoing;
	}

	public void setKeepGoing(boolean keepGoing) {
		this.keepGoing = keepGoing;
	}

	public Timer getTimer() {
		return cursorTimer;
	}

	public void resetTimer() {
		cursorTimer = new CursorTimer(frameLocation, waitTimeFactor * ONE_SECOND_MILLIS);
	}
}
