package main;

import javax.swing.JFrame;

import configuration.ConfigurationGetter;
import cursor.components.CursorMover;
import listeners.FrameListener;


public class MoveCursor {

    
    public static void main(String... args) throws Exception {

    	ConfigurationGetter configGetter = new ConfigurationGetter();
        JFrame frame = new JFrame();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle( configGetter.getTitle() );
        frame.setSize(configGetter.getFrameWidth(), configGetter.getFrameHeight());
        
        FrameListener listener = new FrameListener( new CursorMover( frame, configGetter) );
        frame.addWindowFocusListener(listener);
    }
}