/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorit1;

import java.util.Random;

/**
 *
 * @author Arnoldas
 */
public class Algorit1 {

   
    public List start = new List();
    public List end = new List();

    /**
     * @param args the command line arguments
     */
    private void add(int elem) {

        if (start == null) {
            start = new List(null, null, elem);
            end = start;
        } else {
            List newroot = new List(end.back, null, elem);
            end.front = newroot;
            List newback = end;
            end = newroot;
            end.back = newback;
        }

    }

    private void generate() {
        Random ag = new Random();
        for (int i = 0; i < 10; i++) {
            add(ag.nextInt(50));
        }
        List newroot = end;
        for (int i = 0; i < 10; i++) {
            System.out.println(newroot.getElement());
            newroot = newroot.back;
        }
    }

    public static void main(String[] args) {
//        int i1=9,i2=6,i3=3,i4=5;
//        double sum1=0;
//        int sum4=0;
//        for (int i = 1; i<= 50; i++) {
//           int[] Arr = {9,6,3,5,i};
//            for (int j = 0; j < Arr.length-1; j++) {
//                for (int k = j+1; k < Arr.length; k++){
//                    if(Arr[j]>Arr[k]){
//                        int temp = Arr[j];
//                        Arr[j]=Arr[k];
//                        Arr[k]=temp;
//                    }
//                }
//            }
//            int sum=Arr[0]*5+Arr[1]*4+Arr[2]*3+Arr[3]*2+Arr[4];
//            
//            sum1+=sum/5;
//            sum4++;
//            System.out.println((sum/5));
//        }
//        System.out.println(" vid ");
//        System.out.println(sum1/sum4);
//        new Algorit1().generate();
        RedBlackTree<Studentas> tree = new RedBlackTree<>();
        Studentas naujas = new Studentas("pavarde",0);
        tree.add(naujas);
        Studentas naujas1 = new Studentas("pavarde",1);
        System.out.println(naujas);
        tree.add(naujas1);
//        for (int i = 1; i <12; i++) {
//             tree.addly(naujas);
//        }
        
        
        System.out.println(tree.toVisualizedString("Kvadratas", ""));
//       tree.findUncle(9);
//        
//        System.out.println(tree.toVisualizedString("Kvadratas", ""));
    }
    
    private class List {

        private List back;
        private List front;
        private int element;

        public List() {
        }

        public List(List back, List front, int element) {
            this.back = back;
            this.front = front;
            this.element = element;
        }

        public int size() {
            int c = 0;
            List newroot = start;
            while (newroot != null) {
                newroot = newroot.front;
                c++;
            }
            return c;
        }

        public List getBack() {
            return back;
        }

        public List getFront() {
            return front;
        }

        public int getElement() {
            return element;
        }

        public void setBack(List back) {
            this.back = back;
        }

        public void setFront(List front) {
            this.front = front;
        }

        public void setElement(int element) {
            this.element = element;
        }

    }

}
