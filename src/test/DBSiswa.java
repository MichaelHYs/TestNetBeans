/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.*;

/**
 *
 * @author LENOVO
 */
public class DBSiswa {
    private SiswaModel dt=new SiswaModel();    
    public SiswaModel getSiswaModel(){ return(dt);}
    public void setSiswaModel(SiswaModel s){ dt=s;}    

    public ObservableList<SiswaModel>  Load() {
        try {   ObservableList<SiswaModel> TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
           con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select NPM, Nama, Alamat from siswa");
            int i = 1;
            while (rs.next()) {
                SiswaModel d=new SiswaModel();
                d.setNPM(rs.getString("NPM")); 
                d.setNama(rs.getString("Nama"));
                d.setAlamat(rs.getString("Alamat"));
                TableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return TableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int validasi(String nomor) {
        int val = 0;
        try {  Koneksi con = new Koneksi();     con.bukaKoneksi();   con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from siswa where NPM = '" + nomor + "'");
            while (rs.next()) {   val = rs.getInt("jml");            }
            con.tutupKoneksi();
        } catch (SQLException e) {            e.printStackTrace();        }
        return val;
    }
    public boolean insert() {
        boolean berhasil = false;    Koneksi con = new Koneksi();
        try {         con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into siswa (NPM, Nama, Alamat) values (?,?,?)");
            con.preparedStatement.setString(1, getSiswaModel().getNPM());
            con.preparedStatement.setString(2, getSiswaModel().getNama());
            con.preparedStatement.setString(3, getSiswaModel().getAlamat());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            e.printStackTrace();            berhasil = false;
        } finally {            con.tutupKoneksi();            return berhasil;        }
    }
    public boolean delete(String nomor) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from siswa where NPM  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "update siswa set Nama = ?, Alamat = ?  where  NPM = ? ; ");
            con.preparedStatement.setString(1, getSiswaModel().getNama());
            con.preparedStatement.setString(2, getSiswaModel().getAlamat());
            con.preparedStatement.setString(3, getSiswaModel().getNPM());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }




}

