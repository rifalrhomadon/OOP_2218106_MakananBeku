/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas.Interface;

import Tugas.*;

/**
 *
 * @author ASUS
 */
public class HargaMakananBeku implements MakananBeku {
    public String jenis, kemasan;
    public int Harga;
    private String nama;
    public String berat;
    
    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public HargaMakananBeku() {
        this.jenis = "Nugget";
        this.kemasan = "Mika";
    }

    public HargaMakananBeku(String jenis, String kemasan) {
        this.jenis = jenis;
        this.kemasan = kemasan;
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
    
    void dataBerat(String Berat){
        this.berat = Berat;
    }
    
    String cetakNama(){
        return nama;
    }
    
    String cetakBerat(){
        return berat;
    }

    @Override
    public int infoMakanan() {
        return 10;
    }

    @Override
    public int infoHarga() {
        return 44000;
    }
}
