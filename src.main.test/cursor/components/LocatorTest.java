package cursor.components;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;


public class LocatorTest {

	
	@Test
	public void getCurrentPointTest() {
		JFrame frame = new JFrame();
		frame.setLocation(new Point(100,100));
		FrameLocation location = new FrameLocation(frame);
		assertEquals(location.getCurrentPoint().getX(), 100);
		assertEquals(location.getCurrentPoint().getY(), 100);
	}
	
	@Test
	public void getNextMoveTest() {

		JFrame frame = new JFrame();
		frame.setLocation(new Point(100,100));
		FrameLocation location = new FrameLocation(frame);

		assertNotEquals(location.getNextMove(), location.getCurrentPoint());
	}
	
}
