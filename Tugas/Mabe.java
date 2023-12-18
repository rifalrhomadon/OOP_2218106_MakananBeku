/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

/**
 *
 * @author ASUS
 */
public class Mabe {
    //Atribut
    public String berat;
    private String nama;
    public int harga,produksi;
    public String jenis, kemasan;
    public int Harga;
    public String sertif, varian;
    
    public Mabe() {
        this.jenis = "Nugget";
        this.kemasan = "Mika";
        this.Harga = 20000;
        this.produksi = 10;
        this.harga = 40000;
        this.sertif = "Halal";
        this.varian = "Pedas Korea";
    }

    public Mabe(String jenis, String kemasan, int Harga, String sertif, String varian) {
        this.jenis = jenis;
        this.kemasan = kemasan;
        this.Harga = Harga;
        this.sertif = sertif;
        this.varian = varian;
    }
    
    void jenisMakanan(String jenis){
        this.jenis = jenis;
    }
    
    String cetakjenisMakanan(){
        return jenis;
    }
    
    void kemasanMakanan(String kemasan){
        this.kemasan = kemasan;
    }
    
    String cetakkemasanMakanan(){
        return kemasan;
    }
    
    void HargaMakanan(int Harga){
        this.Harga = Harga;
    }
    
    int cetakHargaMakanan(){
        return Harga;
    }
    
    //Method
    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    void namaPembeli(String Nama){
        this.nama = Nama;
    }
    String cetakPembeli(){
        return nama;
    }
    void dataBerat(String Berat){
        this.berat = Berat;
    }
    String cetakNama(){
        return nama;
    }
    String cetakBerat(){
        return berat;
    }
    int cetakHarga(){
        return harga;
    }
    int cetakProduksi(){
        return produksi;
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
    
    
}
