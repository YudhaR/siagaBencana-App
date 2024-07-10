/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package methodTransaksi;

import methodBarang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class transaksiController {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    
    public transaksiController(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bencana", "root", "");
            st = con.createStatement();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi Kesalahan Pada : \n" + e);
        }
    }
    
    public List viewTransaksi() {
        List<dataTransaksi> logTransaksi = new ArrayList<>();
        sql = "SELECT t.idTransaksi, t.idBarang, t.idUser, t.jumlahBarang, t.daerahBencana, t.tanggalTransaksi, " +
                     "b.nameBarang, b.stokBarang, " +
                     "u.username " +
                     "FROM transaksi t " +
                     "INNER JOIN barang b ON t.idBarang = b.idBarang " +
                     "INNER JOIN user u ON t.idUser = u.id " +
                     "ORDER BY t.idTransaksi ASC";
        
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                dataTransaksi dt = new dataTransaksi();
                dt.setnomorTransaksi(rs.getInt("idTransaksi"));
                dt.setidBarang(rs.getInt("idBarang"));
                dt.setidUser(rs.getInt("idUser"));
                dt.setjumlahBarang(rs.getString("jumlahBarang"));
                dt.setdaerahBencana(rs.getString("daerahBencana"));
                dt.settanggalTransaksi(rs.getString("tanggalTransaksi"));
                dt.setnameBarang(rs.getString("nameBarang"));
                dt.setstokBarang(rs.getString("stokBarang"));
                dt.setnameUser(rs.getString("username"));
                logTransaksi.add(dt);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan: \n" + e);
        }       
        return logTransaksi;
    }
    
    public int addTransaksi(dataTransaksi dt) {
        int hasil = 0;
        sql = "INSERT INTO transaksi (idBarang, idUser, jumlahBarang, daerahBencana, tanggalTransaksi) " +
                     "VALUES ('" + dt.getidBarang() + "', '" + dt.getidUser() + "', '" + dt.getjumlahBarang() + "', '" +
                     dt.getdaerahBencana() + "', '" + dt.gettanggalTransaksi() + "')";
        
        try {
            hasil = st.executeUpdate(sql);
            // Step 2: Update stokBarang in barang table
            if (hasil > 0) { // Jika transaksi berhasil diinsert
                int idBarang = dt.getidBarang();
                
                int jumlahBarang = Integer.parseInt(dt.getjumlahBarang().split(" ")[0]); // Ambil jumlah dari format "jumlah satuan"
                
                
                // Ambil stok barang saat ini
                sql = "SELECT stokBarang FROM barang WHERE idBarang = " + idBarang;
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    int stokSekarang = Integer.parseInt(rs.getString("stokBarang").split(" ")[0]); // Ambil stok saat ini dari format "jumlah satuan"
                    
                    int stokBaru = stokSekarang - jumlahBarang;
                    
                    // Update stok barang
                    sql = "UPDATE barang SET stokBarang = '" + stokBaru + " " + dt.getjumlahBarang().split(" ")[1] + "' WHERE idBarang = " + idBarang;
                    st.executeUpdate(sql);
                }
            }
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
