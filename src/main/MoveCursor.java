package main;


import javax.swing.JFrame;

import listeners.FrameListener;
import runners.CursorMover;


public class MoveCursor {
    public static final int  FRAME_HEIGHT = 100;
    public static final int  FRAME_WIDTH = 200;

    
    public static void main(String... args) throws Exception {
        
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        
        
        CursorMover cursorMover = new CursorMover(frame);
        FrameListener listener = new FrameListener(cursorMover);
        frame.addMouseListener(listener);
    }
}
