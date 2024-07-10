/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package methodLogin;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class userController {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;


    public userController(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bencana", "root", "");
            st = con.createStatement();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi Kesalahan Pada : \n" + e);
        }
    }
    
    public List searchLogin(String username, String password){
        List logLogin = new ArrayList();
        int result;
        sql = "select username, password, role from user where username='" + username + "' and password ='" + password + "'";
        try{
            rs = st.executeQuery(sql);
            while(rs.next()){
                dataUser ep = new dataUser();
                ep.setUsername(rs.getString("username"));
                ep.setPassword(rs.getString("password"));
                ep.setRole(rs.getString("role"));
                logLogin.add(ep);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Login, Pada : \n" + e);
        }
        return logLogin;
    }
    
    public String userRole(String uname){
        String uname1 = uname;
        String role = "";
        sql = "SELECT role FROM user WHERE username = '" + uname1 + "'";

        try {
            // Query untuk mendapatkan role dari tabel users berdasarkan username
            
            rs = st.executeQuery(sql);

            if (rs.next()) {
                role = rs.getString("role");
            }

            // Set nilai jLabelRole dengan peran pengguna
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada : \n" + e);
        }
        return role;
    }
}
