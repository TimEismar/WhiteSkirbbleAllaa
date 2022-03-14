import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class STTestMain extends JFrame {
    STDrawingArea drawingArea = new STDrawingArea();
    public STTestMain()
    {
        //JFrame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gartic");
        setResizable(false);
        setVisible(true);
        setJMenuBar(createMenuBar());


        //Panel of buttons
        JPanel buttonContainer = new JPanel();
        JButton btnRedPen = new JButton("Red Pen");
        JButton btnGreenPen = new JButton("Green Pen");
        JButton btnClear = new JButton("Clear");
        buttonContainer.add(btnRedPen);
        buttonContainer.add(btnGreenPen);
        buttonContainer.add(btnClear);
        //Drawing Area instantiation


        //Adding things to JFrame
        getContentPane().add(drawingArea);
        getContentPane().add(buttonContainer,BorderLayout.PAGE_END);
        pack();


        //button listener
        btnRedPen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                drawingArea.setCurrentColor(Color.RED);
            }
        });

        btnGreenPen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                drawingArea.setCurrentColor(Color.GREEN);
            }
        });

        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                drawingArea.clearDrawings();
            }
        });
    }


    public static void main(String args[])
    {
        STTestMain test = new STTestMain();
    }
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createColorMenu());
        return menuBar;
    }
    private JMenu createColorMenu() {
        JMenu editMenu = new JMenu("Color");
        JMenuItem re = new JMenuItem("Red");
        re.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                drawingArea.setCurrentColor(Color.RED);
            }});
        editMenu.add(re);
        JMenuItem cus = new JMenuItem("Custom");
        cus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                drawingArea.setCurrentColor(JColorChooser.showDialog(null,
                        "Farbauswahl", null));
                System.out.println("cus");
            }});

        editMenu.add(cus);
        return editMenu;
    }


}