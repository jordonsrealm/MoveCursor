package cursor.components;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import configuration.ConfigurationGetter;


public class CursorLockerTest {

	
	@Test
	public void lockComputerTest() {
		Boolean lockedComputer = true;
		CursorLocker mover = null;
		
		try {
			mover= new CursorMover(new JFrame(), new ConfigurationGetter()) {
				@Override
				public void lockComputer() {
					assertTrue(lockedComputer);
				}
			};
		} catch (HeadlessException | IOException e) {
			assertNull(e);
		}
		
		mover.lockComputer();
	}
	
	@Test
	public void resetTimerTest() {
		Boolean resetTimer = true;
		CursorLocker mover = null;
		
		try {
			mover= new CursorMover(new JFrame(), new ConfigurationGetter()) {
				@Override
				public void resetTimer() {
					assertTrue(resetTimer);
				}
			};
		} catch (HeadlessException | IOException e) {
			assertNull(e);
		}
		
		mover.resetTimer();
	}
	
	@Test
	public void getTimerTest() {
		CursorLocker mover = null;
		
		try {
			mover = new CursorMover(new JFrame(), new ConfigurationGetter()) {
				@Override
				public CursorTimer getTimer() {
					return new CursorTimer(new FrameLocation(new JFrame()), (long) 7);
				}
			};
		} catch (HeadlessException | IOException e) {
			assertNull(e);
		}
		
		assertNotNull(mover.getTimer());
	}
}
