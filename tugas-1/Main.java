import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

	/*
		Nama : Muhammad Syaifulloh
		NIM: 055501181
		UT : Surabaya
	*/

	 /* Soal : */	

	 // 1. Buatlah sebuah deklarasi variabel dengan tipe data integer yang bernama ‘StrukturBaris’?	

	 int StrukturBaris;
	 StrukturBaris = 5;
	 System.out.println(StrukturBaris);

	 // 2. Buatlah sebuah deklarasi variabel dengan tipe data string yang bernama ‘KataBaru’ yang berisi kata ‘Deklarasi tipe data String’?

	 String KataBaru = "Deklarasi tipe data String ";
	 String kata1 = "Ini adalah kata 1";
	 System.out.println(KataBaru.concat(kata1));

	 // 3. Buatlah pendeklarasian array satu dimensi dengan nama ‘empatAngka’, tipe data integer, yang berisi angka (07, 10, 20, 23)? 

	 int [] empatAngka = {07, 10, 20, 23};

	 for(int i = 0; i < 4; i++) {
	 	System.out.println(empatAngka[i]);
	 }

	 // 4. Buatlah pendeklarasian array dua dimensi dengan nama ‘Angka’, tipe data String, yang terdiri dari tiga baris dan tiga kolom, 
	 // isi baris dan kolom berisi angka berikut (1, 3, 5, 14, 19, 20, 22, 27, 29)

	 String [][] Angka = {
	 	{"1", "3", "5"},
	 	{"14", "19", "20"},
	 	{"22", "27", "29"},
	 };

	 for(int row = 0; row < 3; row++) {
	 	for(int col = 0; col < 3; col++) {
	 		System.out.println("Row[" + row + "] Col[" + col + "] = " + Angka[row][col]);
	 	}
	 }

	 // 5. Buatlah deklarasi linked list dengan nama 'listAngka' yang memiliki list (22, 19, 44, 60, 72),

	 LinkedList <Integer> listAngka = new LinkedList <Integer> ();
	 	listAngka.add(22);
	 	listAngka.add(19);
	 	listAngka.add(44);
	 	listAngka.add(60);
	 	listAngka.add(72);

	 // listAngka.addFirst(90);
	 // listAngka.addLast(80);
	 listAngka.removeLast();
	 System.out.println(listAngka);
		
	}

}