/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package methodLaporan;

import methodTransaksi.*;
import methodBarang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class laporanController {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    
    public laporanController(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bencana", "root", "");
            st = con.createStatement();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi Kesalahan Pada : \n" + e);
        }
    }
    
    public List viewLaporan() {
        List<dataLaporan> logLaporan = new ArrayList<>();
        sql = "SELECT * from laporan order by id asc";
        
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                dataLaporan dl = new dataLaporan();
                dl.setnameUser(rs.getString("name"));
                dl.setdeskripsi(rs.getString("deskripsi"));
                dl.setdaerahBencana(rs.getString("lokasi"));
                dl.settanggalBencana(rs.getString("date"));
                dl.setidLaporan(rs.getInt("id"));
                dl.setnoHP(rs.getInt("no_hp"));
                logLaporan.add(dl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan: \n" + e);
        }       
        return logLaporan;
    }
    
    public int addLaporan(dataLaporan dl) {
        int hasil = 0;
        sql = "INSERT INTO laporan (id, name, no_hp, lokasi, deskripsi, date) " +
                     "VALUES ('" + dl.getidLaporan() + "', '" + dl.getnameUser() + "', '" + dl.getnoHP() + "', '" +
                     dl.getdaerahBencana() + "', '" + dl.getdeskripsi() + "', '" + dl.gettanggalBencana() + "')";
        
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada : \n" + e);
        }
        
        return hasil;
    }
    
//
//    public List cariBarang(String cari){
//        List logBarang = new ArrayList();
//        sql = "select idBarang, nameBarang, stokBarang, jenisBarang from barang where idBarang like '%" + cari + "%' or nameBarang like '%" + cari + "%' or jenisBarang like '%" + cari + "%'";
//        try{
//            rs = st.executeQuery(sql);
//            while(rs.next()){
//                dataBarang db = new dataBarang();
//                db.setidBarang(rs.getInt("idBarang"));
//                db.setnameBarang(rs.getString("nameBarang"));
//                db.setstokBarang(rs.getString("stokBarang"));
//                db.setjenisBarang(rs.getString("jenisBarang"));
//                logBarang.add(db);
//            }
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada : \n" + e);
//        }
//        return logBarang;
//    }
//
//    public int deleteBarang(dataBarang e){
//       sql="delete from barang where idBarang ='"+ e.getidBarang() + "'";
//       int hasil = 0;
//       try {
//           hasil = st.executeUpdate(sql);
//       } catch (Exception a){
//           JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada : \n" + a);
//       }
//       return hasil;
//    }
//    
//    public int getJumlahBarang() throws SQLException{
//        sql="select count (*) as jumlahBarang " + "from barang";
//        rs = st.executeQuery(sql);
//        int jumlah;
//        while(rs.next()){
//            jumlah = rs.getInt("jumlahBarang");
//            return jumlah;
//        }
//        return 0;
//    }
    
}
