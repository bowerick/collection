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
public class StackDriver {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1).push(2).push(100).push(4).print();
        s.pop();
        s.pop();
        System.out.println(s.peek());
        s.print();
    }
}
