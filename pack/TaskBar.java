/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

/**
 *
 * @author matmy
 */
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;


public class TaskBar extends JPanel
{
    private JButton addTask;
    private JButton clearTasks;
    private JTextField textBox;

    Border emptyBorder = BorderFactory.createEmptyBorder();

    //constructor
    TaskBar()
    {
        this.setPreferredSize(new Dimension(450, 70));
        this.setBackground(new Color(209, 238, 255));

        textBox = new JTextField(25);
        this.add(textBox);

        this.add(Box.createHorizontalStrut(15));

        addTask = new JButton("Add Task");
        addTask.setBorder(emptyBorder);
        addTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(addTask);

        this.add(Box.createHorizontalStrut(10));

        clearTasks = new JButton("Clear");
        clearTasks.setBorder(emptyBorder);
        clearTasks.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(clearTasks);
    }

    //accessors
    public JTextField getTextBox()
    {
        return textBox;
    }
    public JButton getAddTask()
    {
        return addTask;
    }
    public JButton getClearTasks()
    {
        return clearTasks;
    }
}
