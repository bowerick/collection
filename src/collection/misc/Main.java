/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection.misc;

import java.util.Arrays;

/**
 *
 * @author pkumar
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(Arrays.toString(m.bitPrint(42)).replaceAll(", ", "").replaceAll("\\[", "").replaceAll("\\]", ""));
    }
    
    public char[] bitPrint(int num)
    {
        char[] bits = new char[32];
        for(int index = 31 ; index >= 0 ; index--)
        {
            int mask = 1 << index;
            if((num & mask) > 0)
                bits[index]='1';
            else
                bits[index]='0';
        }
        int low=0;
        int high = 31;
        
        while(low < high)
        {
            char temp = bits[low];
            bits[low]=bits[high];
            bits[high]=temp;
            low++;
            high--;
        }
        
        return bits;
    }
}
