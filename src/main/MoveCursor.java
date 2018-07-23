package main;


import javax.swing.JFrame;

import configuration.ConfigurationGetter;
import listeners.FrameListener;
import runners.CursorMover;


public class MoveCursor {
	
    public static int FRAME_HEIGHT;
    public static int FRAME_WIDTH;

    
    public static void main(String... args) throws Exception {

    	ConfigurationGetter configGetter = new ConfigurationGetter();
    	FRAME_WIDTH =  configGetter.getFrameWidth();
    	FRAME_HEIGHT = configGetter.getFrameHeight();
    	
        JFrame frame = new JFrame();
        frame.setTitle(configGetter.getTitle());
        frame.setVisible(true);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CursorMover cursorMover = new CursorMover(frame, configGetter);
        FrameListener listener = new FrameListener(cursorMover);
        frame.addMouseListener(listener);
        frame.addWindowFocusListener(listener);
    }
}
