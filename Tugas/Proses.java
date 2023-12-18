/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author ASUS
 */
public class Proses extends Produksi {
    int jmlbahan;
    String bahan;
    String merek;

    public Proses() {
        this.bahan = "Daging";
        this.merek = "Kenzler";
        this.jmlbahan = 100;
    }
    void bahanMakanan(String Bahan){
        this.bahan = Bahan;
    }
    String CetakBahanMakanan(){
        return bahan;
    }
    void merekMakanan(String Merek){
        this.merek = Merek;
    }
    String CetakMerekMakanan(){
        return merek;
    }
    void jmlBahanMakanan(int jumlah){
        this.jmlbahan = jumlah;
    }
    int CetakjmlBahanMakanan(){
        return jmlbahan;
    }
    public String ProsesPembuatan() {
       return "Produksi 80 kg perhari";
    }
}
