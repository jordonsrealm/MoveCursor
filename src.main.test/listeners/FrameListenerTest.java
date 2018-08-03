package listeners;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import org.junit.jupiter.api.Test;

import cursor.components.CursorMover;


public class FrameListenerTest {

	@Test
	public void testWindowGainFocus() {
		CursorMover cursorMover = null;

		WindowFocusListener listener = new FrameListener( cursorMover ) {
			public Boolean didGainFocus = true;
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				assertTrue(didGainFocus);
			}
		};
		
		listener.windowGainedFocus(null);
	}
	
	@Test
	public void testWindowLostFocus() {
		CursorMover cursorMover = null;

		WindowFocusListener listener = new FrameListener( cursorMover ) {
			public Boolean didLostFocus = true;

			@Override
			public void windowLostFocus(WindowEvent e) {
				assertTrue(didLostFocus);
			}
		};
		
		listener.windowLostFocus(null);
	}
}
