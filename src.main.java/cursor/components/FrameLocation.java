package cursor.components;

import java.awt.Point;

import javax.swing.JFrame;


public class FrameLocation implements Locator{

	private JFrame mainFrame;

	public static final int  INCREMENTAL_MOVE = 1;
	private int tracker = 0;
	
	
	public FrameLocation(JFrame frame) {
		this.setMainFrame(frame);
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}


	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	@Override
	public Point getCurrentPoint() {
        // This center around the close button to allow the user to stop
        int closePointX = mainFrame.getLocation().x;
        int closePointY = mainFrame.getLocation().y;
		return new Point(closePointX, closePointY);
	}
	
	@Override
	public Point getNextMove() {
		Point nextPoint;
		Point currentPoint = getCurrentPoint();
		int bufferX = mainFrame.getWidth() / 2;
		int bufferY = mainFrame.getHeight() / 2;
		
		if(tracker == 0) {
			nextPoint = new Point( currentPoint.x + bufferX + INCREMENTAL_MOVE, currentPoint.y + bufferY + INCREMENTAL_MOVE);
			tracker = 1;
		} else {
			nextPoint = new Point( currentPoint.x + bufferX - INCREMENTAL_MOVE, currentPoint.y + bufferY - INCREMENTAL_MOVE);
			tracker = 0;
		}
		
		return nextPoint;
	}
}
