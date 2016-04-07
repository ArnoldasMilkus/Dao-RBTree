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
public class Dao2 {

    RandomAccessFile raf;
    private int dydis;
    int current;
    int elem = 0;

    void open(String fileName) {
        try {
            raf = new RandomAccessFile(fileName, "rw");
            dydis = (int) (raf.length() / 32);
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

    Studentas getStud(int i) {
        try {
            raf.seek(14 * 2 * i + 4 * i);
            StringBuilder s = new StringBuilder();
            char[] charai = new char[14];
            int ch = 0;
            for (int j = 0; j < 14; j++) {

                charai[ch++] = (raf.readChar());

            }
            s.append(charai);

            String pavarde = s.toString();
            int id = raf.readInt();
            return new Studentas(pavarde, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Studentas("vardas", 5);
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
            System.out.println(pavarde + " s");
            int id = raf.readInt();
            boolean color = raf.readBoolean();
            int lpoint = raf.readInt();
            int rpoint = raf.readInt();
            System.out.println(color + " cl " + lpoint + " lp " + rpoint + " rpoint");
            return new Studentas(pavarde, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Studentas("nezinomas", -1);
    }

    void write(int pos, RedBlackTree<Studentas> tree) {
////         try{
//////             raf.seek(14*2*pos+4*pos);
////             Studentas st = getStud(pos);
////             tree.get(st);
////             for (int j = 0; j < 14; j++) {
////                             try{
////                     raf.writeChar(pav.charAt(j));
////                 }
////                 catch (Exception E){
////                     raf.writeChar(' ');
////                 }
////                         
//////                             System.out.println(charai[j]);
////                     }
////         }
////         catch(IOException e){
////            e.printStackTrace();
////        }
    }

    public static void main(String[] args) {
        Dao2 dao2 = new Dao2();
//        dao2.open("rezultatai.txt");
         dao2.open("studs.txt");
        RedBlackTree<Studentas> tree = new RedBlackTree<>();
//        tree.open();
//        Studentas std = new Studentas ("pav", 5);
//        tree.w(std);
//        Studentas stds = new Studentas ("pssav", 5);
//        tree.w(stds);
//          Studentas stdss = new Studentas ("pssasv", 40);
//        tree.w(stdss);
//          Studentas stdsss = new Studentas ("pssassv", 401);
//        tree.w(stdsss);
//        Studentas sstdsss = new Studentas ("pav", 4001);
//        tree.w(sstdsss);
//        tree.close();
//        
//        long l1=System.nanoTime();
//        for (int i = 0; i < 5; i++) {
//            Studentas studentas = dao2.getStud1(i);
//            System.out.println("dydis " + dao2.dydis);
//            System.out.println(studentas);
//
//            tree.add(studentas);
//        }
//
////        long l2=System.nanoTime();
////        System.out.println((l2-l1)/1e9);
//        System.out.println(tree.toVisualizedString("Kvadratas", ""));
//        tree.wr(tree.root);
//        dao2.close();
        tree.open();
         for (int i = 0; i < dao2.dydis; i++) {
             Studentas studentas = dao2.getStud(i);
//             System.out.println(studentas);
             tree.w(studentas);
//             tree.add(studentas);
//             System.out.println(tree.toVisualizedString("Kvadratas", ""));
         }
         tree.close();
    }
}
