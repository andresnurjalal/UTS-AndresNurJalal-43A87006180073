/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.entity073;

/**
 *
 * @author Andres
 */
public class Pasien {
    
    private String idPasien;
    private String nama;
    private String penyakit;
    private String dokter;
    private String umur;

    
    
    public Pasien() {
        
    }

    public Pasien(String IdPasien, String nama, String penyakit, String dokter, String umur) {
        this.idPasien = IdPasien;
        this.nama = nama;
        this.penyakit = penyakit;
        this.dokter = dokter;
        this.umur = umur;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String IdPasien) {
        this.idPasien = IdPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public Object getValue(int index) {
        switch (index) {
                 case 0: 
                return idPasien;
                  case 1: 
                return nama;
                  case 2: 
                return penyakit;
                  case 3: 
                return dokter;
                  case 4: 
                return umur;
                  default: 
                return null;
                
            
    }
    }

    public void setId(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
