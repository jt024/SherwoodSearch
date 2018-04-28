/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sherwoodsearch;

//import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Trevi
 */
public class SherwoodSearch {
    static int[] numbers;
    static final int SIZE = 1000;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Random rnd = new Random(3);
        
        numbers = new int[SIZE];
        
        for (int i = 0; i < SIZE-1; i++) {
            numbers[i] = rnd.nextInt(1000)+1;
        }
        System.out.println("Array before sorting:");
        for (int i = 0; i < SIZE-1; i++) {
            System.out.println(numbers[i]);
        }        
        sort(0,SIZE-1);
        System.out.println("Array after sorting:");
        for (int i = 0; i < numbers.length-1; i++) {
            System.out.println(numbers[i]);
        }        
        
        
        int input;
        System.out.println("What number do you want to find?");
        input = sc.nextInt();
        
        sherwoodSearch(numbers,input);
        
        
        
    }
    
    public static void sherwoodSearch(int[ ] array, int value){
        int first, last, middle, position, count;
        boolean found;


        first = 0;
        last = array.length-1;
        position = -1;
        found = false;
        count =1;
        Random rand = new Random();

        while (!found && first <= last)
        {
            count++;
            middle = first + rand.nextInt(last - first + 1);
            if (array[middle] == value)
            {
                found = true;
                position = middle;
            }
            else if (array[middle] > value)
                last = middle -1;
            else
                first = middle + 1;
            if (first <= last && position != -1)
            {
                System.out.println("The number was found in array at posistion " + position);
                System.out.println("The sherwood search found the number after " + count +
                    " comparisons.");

            }
            else
                System.out.println("Number not found yet.  The sherwood search made "
                    +count  + " comparisons.");
        }    
    }
    
    static void sort(int l, int r)
    {
        if (l < r)
        {

            int m = (l+r)/2;
 

            sort(l, m);
            sort(m+1, r);
 

            merge(l, m, r);
        }
    }    
    
    public static void merge(int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;
 

        int L[] = new int [n1];
        int R[] = new int [n2];
 

        for (int i=0; i<n1; ++i)
            L[i] = numbers[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = numbers[m + 1+ j];
 
 

 

        int i = 0, j = 0;
 

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                numbers[k] = L[i];
                i++;
            }
            else
            {
                numbers[k] = R[j];
                j++;
            }
            k++;
        }
 

        while (i < n1)
        {
            numbers[k] = L[i];
            i++;
            k++;
        }
 

        while (j < n2)
        {
            numbers[k] = R[j];
            j++;
            k++;
        }
    }
    
    
    
    
}
