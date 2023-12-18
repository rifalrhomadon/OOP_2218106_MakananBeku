/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author ASUS
 */
public class Sertifikasi extends MakananBeku {
    public String sertif, varian;
    public int produksi, harga;

    public Sertifikasi() {
        this.sertif = "Halal";
        this.varian = "Pedas Korea";
    }

    public Sertifikasi(String sertif, String varian) {
        this.sertif = sertif;
        this.varian = varian;
    }
    
    void SertifMakanan(String settif){
        this.sertif = sertif;
    }
    
    String cetakSertifMakanan(){
        return sertif;
    }
    
    void VarianMakanan(String varian){
        this.varian = varian;
    }
    
    String cetakVarianMakanan(){
        return varian;
    }

    @Override
    int infoMakanan() {
        this.produksi = 10;
        return produksi;
    }

    @Override
    int infoHarga() {
        this.harga = 44000;
        return harga;
    }
    
}
