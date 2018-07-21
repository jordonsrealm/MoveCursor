package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import runners.CursorMover;


public class FrameListener implements MouseListener {

	private CursorMover cursorMover;
	
	
	public FrameListener(CursorMover mover) {
		this.cursorMover = mover;
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		cursorMover.start();
	}

	@Override
	public void mouseExited(MouseEvent me) {
		cursorMover.setKeepGoing(false);
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

}
