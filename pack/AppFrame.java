/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

/**
 *
 * @author matmy
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class AppFrame extends JFrame
{
    private Header title;
    private TaskBar bar;
    private TaskList list;
    private JButton addTask;
    private JButton clearTasks;
    private JTextField textBox;
    private JButton save;
    private JButton load;

    public AppFrame()
    {        
        this.setTitle("Today's ToDos");
        this.setSize(450, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title = new Header();
        bar = new TaskBar();
        list = new TaskList();
        addTask = bar.getAddTask();
        textBox = bar.getTextBox();
        clearTasks = bar.getClearTasks();
        save = title.getSaveBtn();
        load = title.getLoadBtn();

        this.add(title, BorderLayout.NORTH);
        this.add(bar, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        addListeners(); 
        setIconImage();
        
        this.setVisible(true);
    }

    public void addListeners()
    {
        textBox.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                int key = e.getKeyCode();
                if(key == 10)//when pressing enter within the text box the task will be added
                {
                    String taskName = textBox.getText();
                    if(!(taskName.equals("")))
                    {
                        Task task = new Task(taskName);
                        list.add(task);
                        textBox.setText("");
                        
                        task.getComplete().addMouseListener(new MouseAdapter()
                        {
                            @Override
                            public void mousePressed(MouseEvent e)
                            {
                                task.setCompleted(!task.getCompleted());
                                task.update();
                                revalidate();
                                repaint();
                            }
                        });
                        
                        revalidate();
                        repaint();
                    }
                }
            }
        });
        addTask.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                String taskName = textBox.getText();

                if(!(taskName.equals("")))
                {
                    Task task = new Task(taskName);
                    list.add(task);
                    textBox.setText("");

                    task.getComplete().addMouseListener(new MouseAdapter()
                    {
                        
                        @Override
                        public void mousePressed(MouseEvent e)
                        {
                            task.setCompleted(!task.getCompleted());
                            task.update();
                            revalidate();
                            repaint();
                        }
                    });
                }

                revalidate();
            }
        });
        clearTasks.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                list.removeCompletedTasks();
                revalidate();
                repaint();
            }
        });
        save.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                SaveData data = new SaveData();
                data.setList(list);
                try {
                    ResourceManager.save(data, "1.save");
                }
                catch (Exception ex) {
                    System.out.println("Could not save: " + ex.getMessage());
                }
            }
        });
        load.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e)
            {
                try {
                    SaveData data = (SaveData) ResourceManager.load("1.save");
                    TaskList saved = data.getList();


                    for(Component c : saved.getComponents())
                    {
                        if(c instanceof Task)
                        {
                            boolean taskStatus = (((Task)c).getCompleted());
                            JLabel name = (((Task)c).getJLabel());

                            Task task = new Task(name, taskStatus);
                            task.getComplete().addMouseListener(new MouseAdapter()
                            {
                                
                                @Override
                                public void mousePressed(MouseEvent e)
                                {
                                    task.setCompleted(!task.getCompleted());
                                    task.update();
                                    revalidate();
                                    repaint();
                                }
                            });
                            list.add(task);
                        }
                    }
                    revalidate();
                    repaint();
                }
                catch (Exception ex) {
                    System.out.println("Could not load: " + ex.getMessage());
                }
            }
        });
    }

    private void setIconImage()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/Icon.png")));
    }
}