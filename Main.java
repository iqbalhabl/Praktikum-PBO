import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iqbal
 */
interface MenghitungBidang{
    public void rumusLuas(double panjang, double lebar);
}

interface MenghitungRuang{
    public void rumusVol(double jari, double tinggi);
}

class bangunDatar{
    double panjang, lebar, jari;
    void rumusKel(double panjang, double lebar) {
        System.out.println("Keliling Persegi Panjang adalah = " + (2*(panjang+lebar)));
    }
    void rumusKel(double jari) {
        System.out.println("Keliling Lingkaran adalah = " + (2*3.14*jari));
    }     
}

class bangunRuang{
    double panjang, lebar, tinggi, jari;
    void rumusLuasPer(double panjang, double lebar, double tinggi) {
        System.out.println("Luas Permukaan Balok adalah = " + (2*(panjang*lebar+panjang*tinggi+tinggi*lebar)));
    }
    void rumusLuasPer(double jari, double tinggi) {
        System.out.println("Luas Permukaan Tabung adalah = " + (2*3.14*jari*(jari+tinggi)));
    }    
}

class PersegiPanjang extends bangunDatar implements MenghitungBidang{
@Override
    public void rumusLuas(double panjang, double lebar) {
        System.out.println("Luas Persegi Panjang adalah = " + (panjang*lebar));
    }
}

class Lingkaran extends bangunDatar{
    void rumusLuas(double jari) {
        System.out.println("Luas Lingkaran adalah = " + (3.14*jari*jari));
    }
}

class Balok extends bangunRuang{
    void rumusVol(double panjang, double lebar, double tinggi) {
        System.out.println("Volume Balok adalah = " + (panjang*lebar*tinggi));
    }
}

class Tabung extends bangunRuang implements MenghitungRuang{
@Override
    public void rumusVol(double jari, double tinggi) {
        System.out.println("Volume Tabung adalah = " + (3.14*jari*jari*tinggi));
    }
}


class Main {
    public static void main(String[] args) {
        double panjang, lebar, tinggi, jari;
        int ulangi = 1, pilihan;
        Scanner input = new Scanner(System.in);
        PersegiPanjang prsg = new PersegiPanjang();
        Lingkaran lngkrn = new Lingkaran();
        Balok blk = new Balok();
        Tabung tbng = new Tabung();
                
        while(ulangi==1 && ulangi!=0){
            System.out.println("=================");
            System.out.println("   MENU UTAMA    ");
            System.out.println("=================");
            System.out.println("1. Hitung Balok");
            System.out.println("2. Hitung Tabung");
            System.out.println("0. Exit");
            System.out.printf("Pilih : ");
            pilihan = input.nextInt();
            
            switch (pilihan){
                case 1:
                    System.out.print("Input Panjang : ");
                    panjang = input.nextDouble();
                    System.out.print("Input Lebar : ");
                    lebar = input.nextDouble();
                    System.out.print("Input Tinggi : ");
                    tinggi = input.nextDouble();
                    prsg.rumusLuas(panjang, lebar);
                    prsg.rumusKel(panjang, lebar);
                    blk.rumusVol(panjang, lebar, tinggi);
                    blk.rumusLuasPer(panjang, lebar, tinggi);
                    break;
                case 2:
                    System.out.print("Input Tinggi : ");
                    tinggi = input.nextDouble();
                    System.out.print("Input Jari - Jari : ");
                    jari = input.nextDouble();        
                    lngkrn.rumusLuas(jari);
                    lngkrn.rumusKel(jari);
                    tbng.rumusVol(jari, tinggi);
                    tbng.rumusLuasPer(jari, tinggi);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.print("InputSalah, Coba Inputkan Lagi!\n");
                    break;
            }
        System.out.print("Ulangi? [Iya=1 Atau Tidak=2] --> ");
        ulangi = input.nextInt();
        System.out.println("");
        }
    }
}
