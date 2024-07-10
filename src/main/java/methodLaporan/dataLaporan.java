/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package methodLaporan;

import methodTransaksi.*;


public class dataLaporan {
    String  nameUser,  deskripsi, daerahBencana, tanggalBencana;
    int idLaporan, noHP;
    
    
    public String getnameUser(){
        return nameUser;
    }
    
    public void setnameUser(String nameUser){
        this.nameUser = nameUser;
    }
    
    
    public String getdeskripsi(){
        return deskripsi;
    }
    
    public void setdeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    
    public String getdaerahBencana(){
        return daerahBencana;
    }
    
    public void setdaerahBencana(String daerahBencana){
        this.daerahBencana = daerahBencana;
    }
    
    public String gettanggalBencana(){
        return tanggalBencana;
    }
    
    public void settanggalBencana(String tanggalBencana){
        this.tanggalBencana = tanggalBencana;
    }
    
    public int getidLaporan(){
        return idLaporan;
    }
    
    public void setidLaporan(int idLaporan){
        this.idLaporan = idLaporan;
    }
    
    public int getnoHP(){
        return noHP;
    }
    
    public void setnoHP(int noHP){
        this.noHP = noHP;
    }
}
