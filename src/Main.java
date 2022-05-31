import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

class Main
{


    public  static void main(String args[]) {
        JFrame frame = new JFrame("Mouse-Mover");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        JButton startButton = new JButton("Start");
        frame.add(startButton, BorderLayout.NORTH);
        JButton stopButton = new JButton("Stop");
        frame.add(stopButton, BorderLayout.SOUTH);
        frame.setVisible(true);
        //when start button is clicked, start the timer
        startButton.addActionListener(e -> {
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

                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Running: " + new java.util.Date());
                    JTextArea jTextArea = new JTextArea();
                    jTextArea.setEditable(false);
                    jTextArea.setText("Running: " + "X Coordinate: "+firstX + " " + "Y Coordinate: " + firstY + " " + new java.util.Date());
                    frame.add(jTextArea, BorderLayout.CENTER);
                    frame.add(jTextArea);
                    frame.setVisible(true);
                    stopButton.addActionListener(e -> timer.cancel());
                    //system.out.print size of jframe
                    System.out.println(frame.getSize());
                }
            }, 0, 10000);
        });}}





