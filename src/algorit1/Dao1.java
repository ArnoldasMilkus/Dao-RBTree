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
public class Dao1 {

    RandomAccessFile raf;
    RandomAccessFile raf1;
    private int dydis;
    private int dydis1;
    int current;
    int elem = 0;

    void open(String fileName, String pointersFile) {
        try {
            raf = new RandomAccessFile(fileName, "rw");
            dydis = (int) (raf.length() / 4);
            raf1 = new RandomAccessFile(pointersFile, "rw");
            dydis1 = (int) (raf1.length() / 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getDydis() {
        return dydis;
    }

    public int getDydis1() {
        return dydis1;
    }

    void close() {
        try {
            raf.close();
            raf1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void pirmyn() {
        try {
            raf1.seek(8 + current * 8);
            elem++;
            current = raf1.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void atgal() {
        try {
            raf1.seek(4 + current * 8);
            elem--;
            current = raf1.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void pradzia() {

        try {
            elem =0;
            raf1.seek(0);
            current = raf1.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    void galas() {
//
//        try {
//            
//            raf1.seek(dydis);
//            current = raf1.readInt();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    boolean pabaiga() {

        return current == -1;

    }

    void test() {
        for (pradzia(); !pabaiga(); pirmyn()) {
            System.out.printf("%6d",getValue());
        }
        System.out.println("");
    }

    int getValue() {
        try {
            raf.seek(current*4);
            return raf.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    int get(int i) {

        try {
            raf1.seek(0);
            int curr = raf1.readInt();
            for (int j = 0; j < i; j++) {
                raf1.seek(8 + curr * 8);
                curr = raf1.readInt();
            }
            if(curr == -1)
                throw new IOException("fail");
            raf.seek(curr * 4);
            int val = raf.readInt();
            return val;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    int set(int value){
        try{
            raf.seek(current*4);
        raf.writeInt(value);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
//    int set(int i, int value) {
//        try {
//            
//            raf.seek(i * 4);
//            raf.writeInt(value);
//            return value;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//    int set1(int i, int value) {
//        try {
//            raf1.seek(i * 4);
//            raf1.writeInt(value);
//            return value;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        Dao1 dao = new Dao1();
//        dao1.open("binary.dat");
//        dao1.set(0, 69);
//        System.out.println(dao1.get(0));
//        dao1.close();
//        dao1.open1("binary1.dat");
//        makeFile("binary1.dat");
//        dao1.set1(0, 690);
//        System.out.println(dao1.get1(0));
//        dao1.close1();
        makeFile("binary.dat");
        makeFilePointers("binary1.dat");
        dao.open("binary.dat", "binary1.dat");
        for (int i = 0; i < dao.dydis; i++) {
            System.out.printf("%6d",dao.get(i));
        }
        System.out.println("");
        dao.test();
        bubbleSort(dao);
        for (int i = 0; i < dao.dydis; i++) {
            System.out.printf("%6d",dao.get(i));
        }
        dao.open("test.txt","testlinks.txt");
        bubbleSort(dao);
        System.out.println("");
        System.out.println(dao.dydis);
//        for (int i = 0; i < dao.dydis; i++) {
//            System.out.println(dao.get(i));
//        }
//        makeFile("binary.dat");
//        dao1.open("binary.dat");
//        
//        
//        bubbleSort(dao1);
//        System.out.println(dao1.get(0));
    }

    public static void makeFile(String filename) {
        Dao dao1 = new Dao();
        int[] Array = {4, 90, 10, 9, 7};
        dao1.open(filename);
        for (int i = 0; i < Array.length; i++) {

            dao1.set(i, Array[i]);

        }
        dao1.close();
    }

    public static void makeFilePointers(String filename) {
        Dao dao1 = new Dao();
        int[] Array = {0, -1, 4, 4, 2, 1, 3, 2, -1, 0, 1};
        dao1.open(filename);
        for (int i = 0; i < Array.length; i++) {

            dao1.set(i, Array[i]);

        }
        dao1.close();
    }

    public static void bubbleSort(Dao1 dao1) {
        boolean gerai = true;
        int prev ;
        int current;
        while (gerai) {
            gerai = false;
            prev = Integer.MIN_VALUE;
            for (dao1.pradzia(); !dao1.pabaiga(); dao1.pirmyn()) {
                current = dao1.getValue();
                
                if(prev > current) {
                    
                    dao1.set(prev);
                    dao1.atgal();
                    dao1.set(current);
                    dao1.pirmyn();
                    gerai = true;
                }
                else {
                    prev = current;
                }
                 
            }
            
        }
    }
}
