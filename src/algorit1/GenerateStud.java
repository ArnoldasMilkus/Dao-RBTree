/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorit1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.Random;

/**
 *
 * @author Arnoldas
 */
public class GenerateStud {
    
	 public static void main(String[] args) throws ParseException, IOException {
//		boolean success = (new File("studs.txt")).delete();
		 int counter = 0;
		 // atidaromas failas
                 
		 RandomAccessFile raf = new RandomAccessFile("studs.txt", "rw"); 
                 String[] pavarde = { "Jonaitis", 
                     "Antanaitis" , 
                     "Petraitis",
                     "Deividaitis",
                    "Krumas",
                    "Baltimoras",
                    "Davislovas",
                    "Krombaderis"};
		 // Sugeneruojami duomenys
		 int N = 1000; // total elements
//                 String vard = new String("s");
//                 for (int i = 0; i < 10; i++) {
//                     System.out.println("Tai");
//                 try{
//                     System.out.println(vard.charAt(1));
//                 }
//                 catch (Exception E){
//                     System.out.println("ne");
//                 }
//             }
                 
		 Random rand = new Random();
                 char[] charai = {'v','a'};
		 for (int i=0; i < N; i++){   
                     counter++;
                        System.out.println(counter + " cointer");
                         int f1  =rand.nextInt(pavarde.length);
                         String pav = pavarde[f1];
			  //f = 1.0f * i;  // testavimui atkomentuojame eilute, kad patikrintume, ar toliau esantys get set metodai veikia teisingai (i faila irasome ne atsitiktinius skaicius)
                         for (int j = 0; j < 14; j++) {
                             try{
                     raf.writeChar(pav.charAt(j));
                 }
                 catch (Exception E){
                     raf.writeChar(' ');
                 }
                         
//                             System.out.println(charai[j]);
                     }
                         raf.writeInt(counter);
			 
		 }
//                 raf.seek(0);
//                  for (int i = 0; i < 14; i++) {
//                 System.out.println(raf.readChar());
//             }
//                  System.out.println(raf.readInt());
//////                 raf.seek(14*2+4);
//////                    for (int i = 0; i < 14; i++) {
//////                 System.out.println(raf.readChar());
//////             }
//                    raf.seek(14*2);
//                    System.out.println(raf.readInt());
//                    raf.seek(14*2+1);
//		       for (int i = 0; i < 14; i++) {
//                 System.out.println(raf.readChar());
//             }    
		
		 
		
		 raf.close();
                 
	 }
	
	 // nuskaitome i-taji elementa is binarinio failo (zinome, kad visi elementai uzima po 4 bitus, todel i-tojo reiksmes pradzia bus i*4)
	 public static int getNumber(RandomAccessFile raf, int i) throws IOException{
		 int k = (i)*4;
		 raf.seek(k);
		 return  raf.readInt();
	 }
	 
	 // priskiriame i-tajam elementui nauja reiksme
	 public static void setNumber(RandomAccessFile raf, int i, int value) throws IOException{
		 raf.seek(4*i);
		 raf.writeInt(value);
	 }
	 
	 
}
