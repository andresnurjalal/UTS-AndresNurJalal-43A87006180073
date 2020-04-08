/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.entity.npm073;

import com.app.uts.entity073.Pasien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class pasienData {
    private Connection connection;
    
    //berisi fungsi atau method bisa melakukan operasi database
    public pasienData(){
        connection = ConnectionUtil.getConnection();
    }
    
    public List<Pasien> getALL(){
        List<Pasien> list = new ArrayList<>();
        String sql = "SELECT * FROM Pasien";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Pasien pas;
            while (rs.next()) {                
                pas = new Pasien();
                pas.setIdPasien(rs.getString("idPasien"));
                pas.setNama(rs.getString("nama"));
                pas.setPenyakit(rs.getString("penyakit"));
                pas.setDokter(rs.getString("dokter"));
                pas.setUmur(rs.getString("umur"));
                list.add(pas);
            }
        } catch (Exception e) {
            System.out.println("Error get All"+e.getMessage());
        }
        return list;
    }
    
    //mengambil data tunggal / 1 id saja
    public Pasien getByID(String penyakit){
        //? adalah parameter yang di berikan sebagai ganti isi
        String sql = "SELECT * FROM pasien WHERE penyakit = ?";
        Pasien pas = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pengisian parameter ?
            statement.setString(1, penyakit);
            //ditampung dalam resutset
            ResultSet rs = statement.executeQuery();
            //Pengecekan data rs
            //pakai if karena data tunggal, tidak perlu pakai while
            if (rs.next()) {
                pas = new Pasien();
                pas.setIdPasien(rs.getString("idPasien"));
                pas.setNama(rs.getString("nama"));
                pas.setPenyakit(rs.getString("penyakit"));
                pas.setDokter(rs.getString("dokter"));
                pas.setUmur(rs.getString("umur"));
            }
        } catch (SQLException e) {
        }
        return pas;
    }
    
    //Pembuatan Kelas Manipulasi database Insert
    public boolean insert(Pasien pas){
        boolean status = false;
        String sql = "INSERT INTO pasien VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            statement.setString(1, pas.getIdPasien());
            statement.setString(2, pas.getNama());
            statement.setString(3, pas.getPenyakit());
            statement.setString(4, pas.getDokter());
            statement.setString(5, pas.getUmur());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Update
    public boolean update(Pasien pas){
        boolean status = false;
        String sql = "UPDATE pasien SET nama=?, penyakit=?, dokter=?, umur=?" +
                "WHERE IdPasien=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Update, nim jadi dipaling akhir
            
            statement.setString(1, pas.getNama());
            statement.setString(2, pas.getPenyakit());
            statement.setString(3, pas.getDokter());
            statement.setString(4, pas.getUmur());
            statement.setString(5, pas.getIdPasien());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Delete
    public boolean delete(Pasien pas){
        boolean status = false;
        String sql = "DELETE FROM pasien WHERE nama=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Delete, hanya 1 parameter saja
            statement.setString(6, pas.getNama());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
}
