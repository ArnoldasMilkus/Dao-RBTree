/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorit1;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Arnoldas
 */
public class Dao {
    RandomAccessFile raf;
    private int dydis;
    void open(String fileName){
        try{
            raf = new RandomAccessFile(fileName, "rw");
            dydis = (int) (raf.length() / 4); 
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getDydis() {
        return dydis;
    }
    void close() {
        try{
             raf.close();
        }
       catch(IOException e){
            e.printStackTrace();
        }
    }
    int get(int i){
        try{
            raf.seek(i*4);
        int val = raf.readInt();
        return val;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return -1;
    }
    int set(int i, int value){
        try{
            raf.seek(i*4);
        raf.writeInt(value);
        return value;
        
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return -1;
    }
    public static void main(String[] args) {
        Dao dao1 = new Dao();
//        dao1.open("binary.dat");
//        dao1.set(0, 69);
//        System.out.println(dao1.get(0));
//        dao1.close();
//        
//        makeFile("binary.dat");
        dao1.open("test.txt");
        
        long g1= System.nanoTime();
        bubbleSort(dao1);
         long g2= System.nanoTime();
        System.out.println(dao1.get(0) + " s "+(g2-g1));
        
    }
    public static void makeFile(String filename) {
       Dao dao1 = new Dao();
       int[] Array={4,90,10,9,7};
       dao1.open(filename);
        for (int i = 0; i < Array.length; i++) {
           
            dao1.set(i, Array[i]);
       
        }
       dao1.close();
    }
    public static void bubbleSort(Dao dao1)
    {
        boolean gerai = true;
        int a;
        int b;
        while (gerai) {
            gerai = false;
            for (int i = 1; i< dao1.getDydis(); i++)
            {
                a = dao1.get(i-1);
                b = dao1.get(i);
                if ( a > b)
                    {
                        gerai = true;
                        dao1.set(i-1,b);
                        dao1.set(i, a);
                    }
            }
        }
    }
}
