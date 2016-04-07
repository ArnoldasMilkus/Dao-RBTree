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
public class RBTreeSearch {
    RandomAccessFile raf;
    private int dydis;
    int current;
    int elem = 0;

    void open(String fileName) {
        try {
            raf = new RandomAccessFile(fileName, "rw");
            dydis = (int) (raf.length() / 41);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public int getDydis() {
        return dydis;
    }

    void close() {
        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Studentas getStud1(int i) {
        try {
            raf.seek(14 * 2 * i + 4 * i + 1 * i + 4 * i + 4 * i);
            StringBuilder s = new StringBuilder();
            char[] charai = new char[14];
            int ch = 0;
            for (int j = 0; j < 14; j++) {

                charai[ch++] = (raf.readChar());

            }
            s.append(charai);

            String pavarde = s.toString();
//            System.out.println(pavarde + " s");
            int id = raf.readInt();
            boolean color = raf.readBoolean();
            int lpoint = raf.readInt();
            int rpoint = raf.readInt();
//            System.out.println(color + " cl " + lpoint + " lp " + rpoint + " rpoint");
            return new Studentas(pavarde, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void search (String name){
        int[] studentsPositionsArray = new int[dydis];
        int spacounter=0;
        for (int i = 0; i < dydis; i++) {
            Studentas student = getStud1(i);
            System.out.println(student.getPavarde() + "||" + name + "||");
            if(student.getPavarde().equals(name)){
                studentsPositionsArray[spacounter]=i;
            spacounter++;
            }
        }
        for (int i = 0; i < spacounter ; i++) {
            System.out.println(studentsPositionsArray[i]);
        }
    }
    public static void main(String[] args) {
        RBTreeSearch search = new RBTreeSearch();
        search.open("rezultatai.txt");
        search.search("Davislovas    ");
        search.close();
    }
}
