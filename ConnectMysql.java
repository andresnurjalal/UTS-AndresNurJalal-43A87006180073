/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.entity.npm073;

import com.app.uts.entity073.Pasien;


/**
 *
 * @author Andres
 */
public class ConnectMysql {
    pasienData datasource = new pasienData();
   
        public static void main(String[] args) {
          //  Pemanggilan method insert
          // new ConnectMysql().testInsert();
           
            //Pemanggilan method update
          new ConnectMysql().testUpdate();
    }
        
        
    //pembuatan method insert
    public void testInsert(){
        //pemanggilan kelas mahasiswa
        Pasien pas = new Pasien();
        pas.setIdPasien("PAS125");
        pas.setNama("Udin");
        pas.setPenyakit("Batuk");
        pas.setDokter("Dokter Paru");
        pas.setUmur("12");
        boolean sukses = datasource.insert(pas);
        //berhasil
        if (sukses) {
            System.out.println("Insert Data Berhasil!");
        }else{
            System.out.println("Insert Data Gagal!");
        }
    }
    
    //pembuatan method Update
    public void testUpdate(){
        //pemanggilan kelas getByID
        Pasien pas = datasource.getByID("Batuk");
        pas.setNama("uuuuuuu");
        boolean sukses = datasource.update(pas);
        //berhasil
        if (sukses) {
            System.out.println("Update Data Berhasil!");
        }else{
            System.out.println("Update Data Gagal!");
        }
    }
}
