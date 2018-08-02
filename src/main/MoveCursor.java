package main;


import javax.swing.JFrame;

import configuration.ConfigurationGetter;
import listeners.FrameListener;


public class MoveCursor {

    
    public static void main(String... args) throws Exception {

    	ConfigurationGetter configGetter = new ConfigurationGetter();
    	int frameWidth =  configGetter.getFrameWidth();
    	int frameHeight = configGetter.getFrameHeight();
    	
        JFrame frame = new JFrame();
        frame.setTitle( configGetter.getTitle() );
        frame.setVisible(true);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FrameListener listener = new FrameListener( new CursorMover(frame, configGetter) );
        frame.addWindowFocusListener(listener);
    }
}
