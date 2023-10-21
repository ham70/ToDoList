/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

/**
 *
 * @author matmy
 */
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Task extends JPanel
{
    private JLabel label;
    private JButton complete;
    private boolean completed;

    //construtors
    //making a new task from the text box
    Task(String name)
    {
        completed = false;

        this.setPreferredSize(new Dimension(450, 20));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.YELLOW);

        label = new JLabel(name);
        this.add(label, BorderLayout.CENTER);

        complete = new JButton();
        complete.setPreferredSize(new Dimension(50, 20));
        complete.setBorder(BorderFactory.createEmptyBorder());
        complete.setFocusPainted(false);
        this.update();

        this.add(complete, BorderLayout.EAST);
        
    }

    //used for making a copy of a saved task
    Task(JLabel name, boolean checked)
    {
        completed = checked;

        this.setPreferredSize(new Dimension(450, 20));
        this.setLayout(new BorderLayout());

        label = name;
        this.add(label, BorderLayout.CENTER);
        

        complete = new JButton();
        complete.setPreferredSize(new Dimension(50, 20));
        complete.setBorder(BorderFactory.createEmptyBorder());
        complete.setFocusPainted(false);
        this.update();

        this.add(complete, BorderLayout.EAST);

    }

    //accessors
    public boolean getCompleted()
    {
        return completed;
    }
    public JButton getComplete()
    {
        return complete;
    }
    public JLabel getJLabel()
    {
        return label;
    }

    //mutators
    public void setCompleted(boolean b)
    {
        completed = b;
    }

    //methods
    public void update()//changes color of task based on if it's completed
    {
        this.paintBackground();
        if(completed)
            complete.setText("UnDo");
        else
            complete.setText("Done");
    }

    public void paintBackground()
    {
        if(completed)
            this.setBackground(new Color(213, 255, 128));
        else
            this.setBackground(new Color(255, 247, 130));
    }
}