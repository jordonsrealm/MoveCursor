package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import runners.CursorMover;


public class FrameListener implements MouseListener, WindowFocusListener {

	private CursorMover cursorMover;
	
	
	public FrameListener(CursorMover mover) {
		this.cursorMover = mover;
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		System.out.println("Entered");
	}

	@Override
	public void mouseExited(MouseEvent me) {
		System.out.println("Exited");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// not yet
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// not yet
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// not yet
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {		
		cursorMover.resetTimer();
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		cursorMover.getTimer().cancel();
		cursorMover.lockComputer();
	}

}
