/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

/**
 *
 * @author matmy
 */
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;



public class Header extends JPanel
{

    private JButton save;
    private JButton load;

    public Header()
    {
        this.setPreferredSize(new Dimension(450, 50));

        //save button
        save = new JButton("Save");
        this.add(save, BorderLayout.WEST);

        this.add(Box.createHorizontalStrut(60));

        //title
        JLabel titleText = new JLabel("ToDos");
        titleText.setFont(new Font("Sans-serif", Font.BOLD, 25));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(titleText);

        this.add(Box.createHorizontalStrut(60));

        //load button
        load = new JButton("Load");
        this.add(load, BorderLayout.EAST);

        //background color
        this.setBackground(new Color(209, 238, 255));

    }

    //accessors
    public JButton getSaveBtn()
    {
        return save;
    }
    public JButton getLoadBtn()
    {
        return load;
    }
    
}
