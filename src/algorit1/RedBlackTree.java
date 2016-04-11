/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorit1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Arnoldas
 */
public class RedBlackTree<E extends Comparable<E>> implements SetADT<E> {

    private static boolean Red = true;
    private static boolean Black = false;
    // Medžio šaknies mazgas
    protected RBNode<E> root = null;
    RandomAccessFile raf;
    private int dydis;
    int current;
    // Medžio dydis
    protected int size = 0;
    // Rodyklė į komparatorių
    protected Comparator<? super E> c = null;

    /**
     * Sukuriamas aibės objektas DP-medžio raktams naudojant Comparable<T>
     */
    public RedBlackTree() {
        this.c = (e1, e2) -> e1.compareTo(e2);
    }

    /**
     * Sukuriamas aibės objektas DP-medžio raktams naudojant Comparator<T>
     *
     * @param c Komparatorius
     */
    public RedBlackTree(Comparator<? super E> c) {
        this.c = c;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size(RBNode x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    public E get(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element is null in get(E element)");
        }

        RBNode<E> node = root;
        while (node != null) {
            int cmp = c.compare(element, node.element);

            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.element;
            }
        }

        return null;
    }

    /**
     * Grąžina maksimalaus rakto elementą paiešką pradedant mazgu node
     *
     * @param node
     * @return
     */
    RBNode<E> getMax(RBNode<E> node) {
        return get(node, true);
    }

    /**
     * Grąžina minimalaus rakto elementą paiešką pradedant mazgu node
     *
     * @param node
     * @return
     */
    RBNode<E> getMin(RBNode<E> node) {
        return get(node, false);
    }

    private RBNode<E> get(RBNode<E> node, boolean findMax) {
        RBNode<E> parent = null;
        while (node != null) {
            parent = node;
            node = (findMax) ? node.right : node.left;
        }
        return parent;
    }

    @Override
    public boolean contains(E element) {

        if (element == null) {
            throw new IllegalArgumentException("Element is null in contains(E element)");
        }

        return get(element) != null;
    }

    /**
     * Grąžinamas aibės elementų masyvas.
     *
     * @return Grąžinamas aibės elementų masyvas.
     */
    @Override
    public Object[] toArray() {
        int i = 0;
        Object[] array = new Object[size];
        for (Object o : this) {
            array[i++] = o;
        }
        return array;
    }

    /**
     * Aibės elementų išvedimas į String eilutę Inorder (Vidine) tvarka. Aibės
     * elementai išvedami surikiuoti didėjimo tvarka pagal raktą.
     *
     * @return elementų eilutė
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E element : this) {
            sb.append(element.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     *
     * Medžio vaizdavimas simboliais, žiūr.: unicode.org/charts/PDF/U2500.pdf
     * Tai 4 galimi terminaliniai simboliai medžio šakos gale
     */
    private static final String[] term = {"\u2500", "\u2534", "\u252C", "\u253C"};
    private static final String rightEdge = "\u250C";
    private static final String leftEdge = "\u2514";
    private static final String endEdge1 = "\u25AA";
    private static final String endEdge2 = "\u25CF";
    private static final String vertical = "\u2502  ";
    private String horizontal;
    private String endEdge;

    /* Papildomas metodas, išvedantis aibės elementus į vieną String eilutę.
     * String eilutė formuojama atliekant elementų postūmį nuo krašto,
     * priklausomai nuo elemento lygio medyje. Galima panaudoti spausdinimui į
     * ekraną ar failą tyrinėjant medžio algoritmų veikimą.
     *
     * 
     */
    public String toVisualizedString(String treeDrawType, String dataCodeDelimiter) {
        horizontal = term[0] + term[0];
        endEdge = (treeDrawType.equals("Kvadratas")) ? endEdge1 : endEdge2;
        return toTreeDraw(root, ">", "", dataCodeDelimiter);
    }

    private String toTreeDraw(RBNode<E> node, String edge, String indent, String dataCodeDelimiter) {
        if (node == null) {
            return "";
        }
        String step = (edge.equals(leftEdge)) ? vertical : "   ";
        StringBuilder sb = new StringBuilder();
        sb.append(toTreeDraw(node.right, rightEdge, indent + step, dataCodeDelimiter));
//        sb.append(node.color);
        int t = (node.right != null) ? 1 : 0;
        t = (node.left != null) ? t + 2 : t;
        sb.append(indent).append(edge).append(horizontal).append(term[t]).append(endEdge).append(
                split(node.element.toString(), dataCodeDelimiter) + node.color).append(System.lineSeparator());
        step = (edge.equals(rightEdge)) ? vertical : "   ";

        sb.append(toTreeDraw(node.left, leftEdge, indent + step, dataCodeDelimiter));

        return sb.toString();
    }

    private String split(String s, String dataCodeDelimiter) {
        int k = s.indexOf(dataCodeDelimiter);
        if (k <= 0) {
            return s;
        }
        return s.substring(0, k);
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class RBNode<E> {

        //Elementas

        E element;
        //Šakos
        RBNode<E> left = null;
        RBNode<E> right = null;
        //Mazgo spalva
        boolean color = Black;
        protected int height;
        int N;

        protected void setLeft(RBNode<E> left) {
            this.left = (RBNode<E>) left;
        }

        protected RBNode<E> getLeft() {
            return (RBNode<E>) left;
        }

        protected void setRight(RBNode<E> right) {
            this.right = (RBNode<E>) right;
        }

        protected RBNode<E> getRight() {
            return (RBNode<E>) right;
        }

        public RBNode() {
        }

        public RBNode(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.color = Red;
        }

        public RBNode(E element, boolean color) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.color = color;
        }

    }

    @Override
    public void add(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element is null in add(E element)");
        }

        root = addRecursivelyly(element, root);
        root.color = Black;
    }

    private RBNode<E> addRecursivelyly(E element, RBNode<E> node) {
        if (node == null) {
            size++;

            return new RBNode<>(element);
        }

        int cmp = c.compare(element, node.element);

        if (cmp < 0) {
            node.left = addRecursivelyly(element, node.left);
//            adjustAfterInsertion(node.left,node.left.element);
        } else if (cmp > 0) {
            node.right = addRecursivelyly(element, node.right);
//            adjustAfterInsertion(node.right,node.right.element);
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        node.N = size(node.left) + size(node.right) + 1;

        return node;
    }

    // make a left-leaning link lean to the right

    private RBNode rotateRight(RBNode h) {
        // assert (h != null) && isRed(h.left);
        RBNode x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = Red;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    // make a right-leaning link lean to the left
    private RBNode rotateLeft(RBNode h) {
        // assert (h != null) && isRed(h.right);
        RBNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = Red;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    // flip the colors of a node and its two children
    private void flipColors(RBNode h) {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private boolean isRed(RBNode<E> n) {
        return n != null && n.color == Red;
    }

    public void wr(RBNode<E> n) {
        if (n == null) {
            System.out.println("empty");
        } else {
            if (n.left != null && n.right != null) {
                System.out.println(n.element + " " + n.color + "  kairys " + n.left.element
                        + " desinys " + n.right.element);
            } else if (n.left != null) {
                System.out.println(n.element + " " + n.color + "  kairys " + n.left.element
                        + " ");
            } else if (n.right != null) {
                System.out.println(n.element + " " + n.color + "  desinys " + n.right.element
                        + " ");
            } else {
                System.out.println(n.element + " " + n.color);
            }
            wr(n.left);
            wr(n.right);
        }
    }

    public void open() {
        try {
            raf = new RandomAccessFile("rezultatai.txt", "rw");
            dydis = (int) (raf.length() / 40);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findRoot() {
        try {
            int dyd = (int) (raf.length() / 41);
//            raf.seek(14*2*1+4*1+1*1);

            int lpoint = -1;
            int rpoint = -1;
            for (int j = 0; j < dyd; j++) {
                int counter = 0;
                
                for (int i = 0; i < dyd; i++) {
                    if(j!=i){
                        try{
                            raf.seek(14 * 2 * i + 4 * i + 
                        1 * i + 4 * i + 4 * i + 14 * 2 + 4 * 1 + 1);
                             lpoint = raf.readInt();
                            rpoint = raf.readInt();
                            if(lpoint == j || rpoint == j){
                                counter++;
                            }
                            if (counter>=1){
                                i=dyd-1;
                            }
                            if(i==dyd-1 &&counter == 0){
                                return j;
                            }
                        }
                        catch (IOException e) {
                    e.printStackTrace();
                }       
                    }
                    
                    //ieskot kad jo neturetu :D
                }
            }
//            for (int i = 0; i < dyd; i++) {
//                raf.seek(14 * 2 * i + 4 * i + 
//                        1 * i + 4 * i + 4 * i + 14 * 2 + 4 * 1 + 1);
//                lpoint = raf.readInt();
//                rpoint = raf.readInt();
//                if (lpoint == pos) {
////                    System.out.println(pos + " pos " + i);
//                    return findRoot(lpoint);
//
//                } else if (rpoint == pos) {
////                    System.out.println(pos + " pos " + i);
//                    return findRoot(rpoint);
//                } else if (i == dyd - 1) {
//                    return pos;
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void w(Studentas st) {

        System.out.println(findRoot());
        
        rasyti(st, findRoot());
//        System.out.println("w " + dydis);
        try {
            dydis = (int) (raf.length() / 41);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        System.out.println("wend " + dydis);
    }

    public void rasyti(Studentas st, int pos) {
        int id = -1;
        int lpointer = -1;
        int rpointer = -1;
        boolean color;
        String pavarde;
        try {
//            raf.seek(pos);
            raf.seek(14 * 2 * pos + 4 * pos +
                    1 * pos + 4 * pos + 4 * pos);//pavarde id color lpointer rpointer
            StringBuilder s = new StringBuilder();
            char[] charai = new char[14];
            int ch = 0;
            for (int j = 0; j < 14; j++) {

                charai[ch++] = (raf.readChar());

            }
            s.append(charai);

            pavarde = s.toString();
//            System.out.println("pavarde read " + pavarde);
            id = raf.readInt();
            color = raf.readBoolean();
            lpointer = raf.readInt();
            rpointer = raf.readInt();
            if (st.getId() < id) {
                if (lpointer == -1) {
                    if (pos == 0) {
                        raf.seek(14 * 2 * 1 + 4 * 1 + 1 * 1);//yrasome y pirmaja poziciaj
                        raf.writeInt(dydis);
                    } else {
                        raf.seek(14 * 2 * pos + 4 * pos + 
                                1 * pos + 4 * pos + 4 * pos +
                                14 * 2 * 1 + 4 * 1 + 1 * 1);
//                         raf.seek(14*2*(pos+1)+4*(pos+1)+1*(pos+1));
////                    System.out.println(dydis +" dydis ");
                        raf.writeInt(dydis);
                    }

                    rasyti(st, dydis);
                } else {
                    rasyti(st, lpointer);
                }

            } else if (st.getId() > id) {
//                System.out.println(st.getId() + " " + id);
                if (rpointer == -1) {
                    if (pos == 0) {
                        raf.seek(14 * 2 * 1 + 4 * 1 + 1 * 1 + 4 * 1);//yrasome y pirmaja poziciaj
                        raf.writeInt(dydis);
                    } else {
                        raf.seek(14 * 2 * pos + 4 * pos 
                                + 1 * pos + 4 * pos + 4 * pos + 
                                14 * 2 * 1 + 4 * 1 + 1 * 1 + 4 * 1);
//                         raf.seek(14*2*pos+4*pos+1*pos+4*pos);
//                        System.out.println(pos + " p ");
                        raf.writeInt(dydis);
                    }

                    rasyti(st, dydis);
////                    raf.seek(14*2*pos+4*pos+1*pos+4*pos);
////                    raf.writeInt(dydis+1);
//                    rasyti(st,dydis+1);
                } else {
                    rasyti(st, rpointer);
                }

            }
            else if(st.getId() == id){
                try {
                raf.seek(14 * 2 * pos + 4 * pos + 1 * pos + 4 * pos + 4 * pos);

                for (int j = 0; j < 14; j++) {
                    try {
                        raf.writeChar(st.getPavarde().charAt(j));
                    } catch (Exception E) {
                        raf.writeChar(' ');
                    }
                }
            }
                catch (IOException e) {
                    
                }}
        } catch (IOException e) {
            try {
                raf.seek(14 * 2 * pos + 4 * pos + 1 * pos + 4 * pos + 4 * pos);

                for (int j = 0; j < 14; j++) {
                    try {
                        raf.writeChar(st.getPavarde().charAt(j));
                    } catch (Exception E) {
                        raf.writeChar(' ');
                    }
                }
//                System.out.println("write pavarde " + st.getPavarde());
                raf.writeInt(st.getId());
                raf.writeBoolean(Red);
                raf.writeInt(-1);
                raf.writeInt(-1);
            } catch (IOException ex) {
                System.out.println("neyrasomas elementas");
            }
        }
        //beliko apkeisti spalvas

        if (isRedNode(rpointer) && !isRedNode(lpointer)) {
            System.out.println("rotate");
            rotateLeftNode(pos);
        }
        try {
            raf.seek(14 * 2 * lpointer + 4 * lpointer +
                    1 * lpointer + 4 * lpointer + 4 * lpointer + 14 * 2 + 4 * 1 + 1 * 1);
            int llpoint = raf.readInt();
            if (isRedNode(lpointer) && isRedNode(llpoint)) {
                rotateRightNode(pos);
            }
        } catch (IOException ex) {
            System.out.println("no left left pointer");
        }
        if (isRedNode(lpointer) && isRedNode(rpointer)) {
            System.out.println("flip color");
            flipColorsNode(pos);
        }
//        node.N = size(lpointer) + size(rpointer) + 1;

//        int cmp = st.getId().compare(id);
    }

    private boolean isRedNode(int pos) {
        boolean spalva = false;
        try {
            raf.seek(14 * 2 * pos + 4 * pos + 1 * pos +
                    4 * pos + 4 * pos + 14 * 2 * 1 + 4 * 1);
//            raf.seek(14 * 2 * pos + 4 * pos);
            spalva = raf.readBoolean();
//            14*2*1+4*1
        } catch (IOException ex) {
            System.out.println("neymanoma patikrinti ar raudonas");
        }
        return spalva == Red;
    }

    private void rotateRightNode(int pos) {
        // assert (h != null) && isRed(h.left);
        try {
            raf.seek(14 * 2 * pos + 4 * pos + 1 * pos +
                    4 * pos + 4 * pos + 14 * 2 + 4 * 1);
            boolean color = raf.readBoolean();
            int lpointer = raf.readInt();
            raf.seek(14 * 2 * lpointer + 4 * lpointer + 
                    1 * lpointer + 4 * lpointer + 4 * lpointer + 14 * 2 + 4 * 1);
            boolean lcolor = raf.readBoolean();
            int llpointer = raf.readInt();
            int lrpointer = raf.readInt();
            raf.seek(14 * 2 * pos + 4 * pos + 1 * pos +
                    4 * pos + 4 * pos + 14 * 2 + 4 * 1 + 1 * 1);
            raf.writeInt(lrpointer);

            raf.seek(14 * 2 * lpointer + 4 * lpointer +
                    1 * lpointer + 4 * lpointer + 4 * lpointer + 14 * 2 + 4 * 1 + 1 * 1 + 4 * 1);
            raf.writeInt(pos);

            raf.seek(14 * 2 * lpointer + 4 * lpointer + 
                    1 * lpointer + 4 * lpointer + 4 * lpointer + 14 * 2 + 4 * 1);
            raf.writeBoolean(color);

            raf.seek(14 * 2 * pos + 4 * pos + 1 * pos + 
                    4 * pos + 4 * pos + 14 * 2 + 4 * 1);
            raf.writeBoolean(Red);

        } catch (IOException ex) {
            System.out.println("negalimas desinys pasukimas");
        }
//        RBNode x = h.left;
//        h.left = x.right;
//        x.right = h;
//        x.color = x.right.color;
//        x.right.color = Red;
//        x.N = h.N;
//        h.N = size(h.left) + size(h.right) + 1;
//        return x;
    }

    // make a right-leaning link lean to the left
    private void rotateLeftNode(int pos) {
        // assert (h != null) && isRed(h.right);
        try {
            raf.seek(14 * 2 * pos + 4 * pos + 1 * pos + 
                    4 * pos + 4 * pos + 14 * 2 + 4 * 1);
            boolean color = raf.readBoolean();
            System.out.println(color + "cpolor");
            int lpointer = raf.readInt();
            int rpointer = raf.readInt();
            raf.seek(14 * 2 * rpointer + 4 * rpointer +
                    1 * rpointer + 4 * rpointer + 4 * rpointer + 14 * 2 + 4 * 1);
            boolean rcolor = raf.readBoolean();
            int rlpointer = raf.readInt();
            int rrpointer = raf.readInt();
            raf.seek(14 * 2 * pos + 4 * pos + 1 * pos + 4 * pos + 
                    4 * pos + 14 * 2 + 4 * 1 + 1 * 1 + 4 * 1);
            raf.writeInt(rlpointer);

            raf.seek(14 * 2 * rpointer + 4 * rpointer + 
                    1 * rpointer + 4 * rpointer + 4 * rpointer + 14 * 2 + 4 * 1 + 1 * 1);
            raf.writeInt(pos);

            raf.seek(14 * 2 * rpointer + 4 * rpointer +
                    1 * rpointer + 4 * rpointer + 4 * rpointer + 14 * 2 + 4 * 1);
            raf.writeBoolean(color);
            
            raf.seek(14 * 2 * pos + 4 * pos + 1 * pos + 4 * pos + 
                    4 * pos + 14 * 2 + 4 * 1);
            raf.writeBoolean(Red);

        } catch (IOException ex) {
            System.out.println("negalimas kairys pasukimas");
        }

//        RBNode x = h.right;
//        h.right = x.left;
//        x.left = h;
//        x.color = x.left.color;
//        x.left.color = Red;
//        x.N = h.N;
//        h.N = size(h.left) + size(h.right) + 1;
//        return x;
    }

    // flip the colors of a node and its two children
    private void flipColorsNode(int pos) {

        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        try {
            raf.seek(14 * 2 * pos + 4 * pos + 1 * pos + 4 * pos + 
                    4 * pos + 14 * 2 + 4 * 1);
            boolean color = raf.readBoolean();
            int lpointer = raf.readInt();
            int rpointer = raf.readInt();
            raf.seek(14 * 2 * pos + 4 * pos + 1 * pos + 4 * pos + 
                    4 * pos + 14 * 2 + 4 * 1);
            System.out.println("color " + color);
            raf.writeBoolean(!color);

            raf.seek(14 * 2 * lpointer + 4 * lpointer + 1 * lpointer + 
                    4 * lpointer + 4 * lpointer + 14 * 2 + 4 * 1);
            boolean lcolor = raf.readBoolean();
            raf.seek(14 * 2 * lpointer + 4 * lpointer + 1 * lpointer +
                    4 * lpointer + 4 * lpointer + 14 * 2 + 4 * 1);
            System.out.println("color" + lcolor);
            raf.writeBoolean(!lcolor);

            raf.seek(14 * 2 * rpointer + 4 * rpointer + 1 * rpointer + 
                    4 * rpointer + 4 * rpointer + 14 * 2 + 4 * 1);
            boolean rcolor = raf.readBoolean();
            raf.seek(14 * 2 * rpointer + 4 * rpointer + 1 * rpointer + 
                    4 * rpointer + 4 * rpointer + 14 * 2 + 4 * 1);
            System.out.println("color" + rcolor);
            raf.writeBoolean(!rcolor);
        } catch (IOException ex) {
            System.out.println("negaliams spalvu sukeitimas");
        }
//        h.color = !h.color;
//        h.left.color = !h.left.color;
//        h.right.color = !h.right.color;
    }

}
