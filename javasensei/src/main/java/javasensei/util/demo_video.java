package javasensei.util;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.javacv.Frame;
//import static com.googlecode.javacv.cpp.opencv_core.cvFlip;

public class demo_video {

    public static void main(String[] args) {
        //Create canvas frame for displaying webcam.
        CanvasFrame canvas = new CanvasFrame("Webcam");

        //Set Canvas frame to close on exit
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        //Declare FrameGrabber to import output from webcam
        FrameGrabber grabber = new OpenCVFrameGrabber("");        
        
        try {

            //Start grabber to capture video
            grabber.start();

            //Declare img as IplImage
            Frame img;
            
            do {
                //inser grabed video fram to IplImage img
                img = grabber.grabFrame();

                //Set canvas size as per dimentions of video frame.
                canvas.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight());
                
                if (img != null) {
                    //Flip image horizontally
                    //opencv_core.cvFlip(img, img, 1);
                    //Show video frame in canvas
                    canvas.showImage(img);                    
                }
            }while(img!=null);
        } catch (Exception e) {            
        }
    }
}
