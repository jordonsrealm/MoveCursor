package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import cursor.components.CursorMover;


public class FrameListener implements WindowFocusListener {

	private CursorMover cursorMover;
	
	
	public FrameListener(CursorMover mover) {
		this.cursorMover = mover;
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {		
		cursorMover.resetTimer();
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		cursorMover.getTimer().cancel();
		cursorMover.lockComputer();
		System.exit(0);
	}

}
