/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.Date;


/**
 *
 * @author LENOVO
 */
public class NilaiModel {
    private String NPM,KodeMk;
    private Date tanggal;
    private double nilai;
    private int hadir;
    public String getNPM() {        
        return NPM;    }
    public void setNPM(String NPM) {        
        this.NPM = NPM;    }
    public String getKodeMk() {        
        return KodeMk;    }
    public void setKodeMk(String KodeMk) {        
        this.KodeMk = KodeMk;    }
    public Date getTanggal() {        
        return tanggal;    }
    public void setTanggal(Date tanggal) {        
        this.tanggal = tanggal;    }
    public double getNilai() {        
        return nilai;    }
    public void setNilai(double nilai) {        
        this.nilai = nilai;    }
    public int getHadir() {        
        return hadir;    }
    public void setHadir(int hadir) {        
        this.hadir = hadir;    }
}

