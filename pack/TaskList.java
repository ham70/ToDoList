/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

/**
 *
 * @author matmy
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class TaskList extends JPanel
{

    private static GridLayout grid;

    TaskList()
    {
        grid = new GridLayout(10, 1);
        grid.setVgap(5);
        this.setLayout(grid);

        this.setBackground(new Color(66, 66, 66));
    }

    //accessors
    public GridLayout getGrid()
    {
        return grid;
    }

    //methods
    public void updateTasks()
    {
        for(Component c : getComponents())
		{
			if(c instanceof Task)
			{
				((Task)c).update();
			}
		}
    }
    public void removeCompletedTasks()
    {
        for(Component c : getComponents())
		{
			if(c instanceof Task)
			{
				if(((Task)c).getCompleted())
				{
					remove(c);
				}
			}
		}

    }
}
