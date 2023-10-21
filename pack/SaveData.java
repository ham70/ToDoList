/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

/**
 *
 * @author matmy
 */
public class SaveData implements java.io.Serializable
{
    private static final long serivalVersionUID = 1L;

    private TaskList list;

    public TaskList getList()
    {
        return list;
    }
    public void setList(TaskList t)
    {
        list = t;
    }

}

