/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection.datastructures;

/**
 *
 * @author pkumar
 */
public class Stack {
    
    private int[] data;
    
    private int top;
    
    public Stack()
    {
        data = new int[100];
        top = 0;
    }
    
    public Stack push(int num)
    {
        data[top] = num;
        top++;
        return this;
    }
    
    public int pop()
    {
        return data[top--];
    }
    
    public int peek()
    {
        return data[top-1];
    }
    
    public void print()
    {
        for(int index = 0 ; index < top ; index++)
            System.out.println(data[index]);
    }
}
