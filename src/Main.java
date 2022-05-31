import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

class Main
{


    public  static void main(String args[])
    {
        JFrame frame = new JFrame("Mouse-Mover");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
        JTextArea jTextArea = new JTextArea();

        frame.add(jTextArea);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int cursorPositionX = MouseInfo.getPointerInfo().getLocation().x;
                int cursorPositionY = MouseInfo.getPointerInfo().getLocation().y;
                int firstX = cursorPositionX + 1;
                int firstY = cursorPositionY + 1;

                try {
                    Robot robot = new Robot();
                    robot.mouseMove(firstX, firstY);


                }catch (AWTException e) {
                    e.printStackTrace();
                }
                System.out.println("Running: " + new java.util.Date());
            }
        }, 0, 30000);}}

