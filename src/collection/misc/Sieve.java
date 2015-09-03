/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection.misc;

/**
 *
 * @author pkumar
 */
public class Sieve {
    public static void main(String[] args) {
        boolean[] source=new boolean[640000];
        for(int fill=0 ; fill < source.length ; fill++)
            source[fill]=true;
        
        for(int index = 2 ; index < source.length ; index++)
        {
            for(int iterations = index ; iterations < source.length/index; iterations ++)
            {
                source[iterations*index]=false;
            }
        }
        
        int target = 52090;
        int count = 0;
        int index = 2;
        for(index = 2 ; index < source.length && (count < target); index++)
        {
            if(source[index] == true)
                count++;
        }
        System.out.println(index-1);
    }
}
