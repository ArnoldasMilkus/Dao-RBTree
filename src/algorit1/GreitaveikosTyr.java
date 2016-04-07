/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Random;
//import studijosKTU.Ks;
//import studijosKTU.ListKTU;
//import studijosKTU.Timekeeper;

/**
 *
 * @author arnmil
 */
public class GreitaveikosTyr {
    int[] kompBazė1;
    Random ag = new Random();  // atsitiktinių generatorius
    int[] tiriamiKiekiai = {2_000, 4_000, 8_000, 16_000};
    Dao dao1 = new Dao();
     Dao1 dao2 = new Dao1();
//    static int[] tiriamiKiekiai = {10_000, 20_000, 40_000, 80_000};
//        static int[] tiriamiKiekiai = {2_000, 20_000, 200_000, 2000_000};
    void generuotiKompiuterius(int kiekis){
       String[] vaizd = { // galimų kopiuteri7 vaizdo plok62i7 pavadinimai
          "Nvidia", "AMD", "Intel"
       };
       String[] proc = { // galimų kopiuteri7 procesori7 pavadinimai
           "AMD", "Intel"
       };
       
       
        kompBazė1= new int[kiekis];
        ag.setSeed(2017);
//        for(int i=0;i<kiekis;i++){
//            int ma = ag.nextInt(vaizd.length);        // 
//            int mo = ag.nextInt(proc.length);// 
//            kompBazė1[i]= new intvaizd[ma], proc[mo],
//                1 + ag.nextInt(100),           // darbin4 atrmintis tarp 1 ir 64
//                1 + ag.nextInt(4_000));      // visa atmintis tarp 1 ir 3000 
//        }
//        Collections.shuffle(Arrays.asList(kompBazė1));
//        aSeries.clear();
//        for(int a: kompBazė1) aSeries.add(a);
    }
    void paprastasTyrimas(){
// Paruošiamoji tyrimo dalis
        long t0=System.nanoTime();
//        generuotiKompiuterius(elementųKiekis);
        long t1=System.nanoTime();
        System.gc(); System.gc(); System.gc();
        long t2=System.nanoTime();
//  Greitaveikos bandymai ir laiko matavimai
//        aSeries.sortSystem();
//        dao1.open("test.txt");
        
        long t3=System.nanoTime();
//        Dao.bubbleSort(dao1);
        
        
//        aSeries2.sortSystem(Kompiuteris.pagalDarbAtmint);
        long t4=System.nanoTime();
        dao2.open("test.txt","testlinks.txt");
//        aSeries3.sortBuble();
        long t5=System.nanoTime();
        Dao1.bubbleSort(dao2);
//        aSeries4.sortBuble(Kompiuteris.pagalDarbAtmint);
        long t6=System.nanoTime();
        Ks.ouf("%7.4f %7.4f %7.4f %7.4f %7.4f %7.4f \n", 
                (t1-t0)/1e9, (t2-t1)/1e9, (t3-t2)/1e9,
                (t4-t3)/1e9, (t5-t4)/1e9, (t6-t5)/1e9);
    }
// sekančio tyrimo metu gaunama normalizuoti įvertinimai su klase TimeKeeper
    void sisteminisTyrimas(){
    // Paruošiamoji tyrimo dalis
        Timekeeper tk = new Timekeeper(tiriamiKiekiai);
//        for (int kiekis : tiriamiKiekiai) 
        {
//           generuotiKompiuterius(kiekis);
//           ListKTU<Kompiuteris> aSeries2 = aSeries.clone();
//           ListKTU<Kompiuteris> aSeries3 = aSeries.clone();
//           ListKTU<Kompiuteris> aSeries4 = aSeries.clone();

    //  Greitaveikos bandymai ir laiko matavimai
            tk.start();
            
        dao1.open("test.txt");
        tk.finish("atidaromas failas");
        Dao.bubbleSort(dao1);
//            aSeries.sortSystem();
//            tk.finish("SysBeCom");
//            aSeries2.sortSystem(Kompiuteris.pagalDarbAtmint);
//            tk.finish("SysSuCom");
//            aSeries3.sortBuble();
//            tk.finish("BurBeCom");
//            aSeries4.sortBuble(Kompiuteris.pagalDarbAtmint);
            tk.finish("Burbulas masyvui");
            tk.seriesFinish();
        }
    }
    void tyrimoPasirinkimas(){
        long memTotal = Runtime.getRuntime().totalMemory();
        Ks.oun("memTotal= "+memTotal);
        // Pasižiūrime kaip generuoja kompiuterius (20) vienetų)
        generuotiKompiuterius(20);
//        for(int a: aSeries) Ks.oun(a);
        Ks.oun("1 - Pasiruošimas tyrimui - duomenų generavimas");
        Ks.oun("2 - Pasiruošimas tyrimui - šiukšlių surinkimas");
        Ks.oun("3 - Rūšiavimas sisteminiu greitu būdu be Comparator");
        Ks.oun("4 - Rūšiavimas sisteminiu greitu būdu su Comparator");
        Ks.oun("5 - Rūšiavimas List burbuliuku be Comparator");
        Ks.oun("6 - Rūšiavimas List burbuliuku su Comparator");
        Ks.ouf("%6d %7d %7d %7d %7d %7d %7d \n", 0,1,2,3,4,5,6);
//        for(int n: tiriamiKiekiai) 
            paprastasTyrimas();
        // sekančio tyrimo metu gaunama normalizuoti įvertinimai
//        sisteminisTyrimas();
    }
   public static void main(String[] args){
          // suvienodiname skaičių formatus pagal LT lokalę (10-ainis kablelis)
        Locale.setDefault(new Locale("LT"));
        
        Random ag = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(ag.nextInt(1000));
       }
        new GreitaveikosTyr().tyrimoPasirinkimas();
   }    
}
