/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package methodTransaksi;


public class dataTransaksi {
    String nameBarang, stokBarang, jumlahBarang, nameUser, daerahBencana, tanggalTransaksi;
    int nomorTransaksi, idBarang, idUser;
    
    public String getnameBarang(){
        return nameBarang;
    }
    
    public void setnameBarang(String nameBarang){
        this.nameBarang = nameBarang;
    }
    
    public String getstokBarang(){
        return stokBarang;
    }
    
    public void setstokBarang(String stokBarang){
        this.stokBarang = stokBarang;
    }
    
    public String getjumlahBarang(){ 
        return jumlahBarang;
    }
    
    public void setjumlahBarang(String jumlahBarang){ 
        this.jumlahBarang = jumlahBarang;
    }
    
    public String getnameUser(){
        return nameUser;
    }
    
    public void setnameUser(String nameUser){
        this.nameUser = nameUser;
    }
    
    public String getdaerahBencana(){
        return daerahBencana;
    }
    
    public void setdaerahBencana(String daerahBencana){
        this.daerahBencana = daerahBencana;
    }
    
    public String gettanggalTransaksi(){
        return tanggalTransaksi;
    }
    
    public void settanggalTransaksi(String tanggalTransaksi){
        this.tanggalTransaksi = tanggalTransaksi;
    }
    
    public int getnomorTransaksi(){
        return nomorTransaksi;
    }
    
    public void setnomorTransaksi(int nomorTransaksi){
        this.nomorTransaksi = nomorTransaksi;
    }
    
    public int getidBarang(){
        return idBarang;
    }
    
    public void setidBarang(int idBarang){
        this.idBarang = idBarang;
    }
    
    public int getidUser(){
        return idUser;
    }
    
    public void setidUser(int idUser){
        this.idUser = idUser;
    }
}
