/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorit1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.util.Random;

/**
 *
 * @author Arnoldas
 */
public class GenerateArray {
    
	 public static void main(String[] args) throws ParseException, IOException {
		
		 int counter = 0;
		 // atidaromas failas
		 RandomAccessFile raf = new RandomAccessFile("test.txt", "rw"); 
		 
		 // Sugeneruojami duomenys
		 int N = 1000; // total elements
		 Random rand = new Random();
		 for (int i=0; i < N; i++){   
			 int f  =rand.nextInt();
			  //f = 1.0f * i;  // testavimui atkomentuojame eilute, kad patikrintume, ar toliau esantys get set metodai veikia teisingai (i faila irasome ne atsitiktinius skaicius)
			 raf.writeInt(f); 
		 }
		 
		
		 
		 // Nuskatome elemento elmNumber reiksme ir ja atspausdiname
		 int elmNumber = 123; 
		 System.out.println("Elementas  " + elmNumber + ": " +	 getNumber(raf, elmNumber));
		 		 
		 // Irasome nauja reiksme  (555)
		 setNumber(raf, elmNumber, 555);
		 System.out.println("Elementas po pakeitimo " + elmNumber + ": " +	 getNumber(raf, elmNumber));
		 
		 // Uzdarome faila
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
