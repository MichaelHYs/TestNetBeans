/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class DBNilai {
    private NilaiModel dt=new NilaiModel();    
    public NilaiModel getNilaiModel(){ return(dt);}
    public void setNilaiModel(NilaiModel s){ dt=s;}    

    public ObservableList<NilaiModel>  Load() {
        try {   ObservableList<NilaiModel> TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
           con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select NPM, KodeMk, Tanggal, Nilai, Hadir from penilaian");
            int i = 1;
            while (rs.next()) {
                NilaiModel d=new NilaiModel();
                d.setNPM(rs.getString("NPM")); 
                d.setKodeMk(rs.getString("KodeMk"));
                d.setTanggal(rs.getDate("Tanggal"));
                d.setNilai(rs.getFloat("Nilai"));
                d.setHadir(rs.getInt("Hadir"));
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
    public int validasi(String nomor, String kode) {
        int val = 0;
        try {  Koneksi con = new Koneksi();     con.bukaKoneksi();   con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from nilai where NPM = '" + nomor + "and KodeMk="+kode+"");
            while (rs.next()) {   val = rs.getInt("jml");            }
            con.tutupKoneksi();
        } catch (SQLException e) {            e.printStackTrace();        }
        return val;
    }
    public boolean insert() {
        boolean berhasil = false;    Koneksi con = new Koneksi();
        try {         con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into penilaian (NPM, KodeMk, Tanggal, Nilai, Hadir) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getNilaiModel().getNPM());
            con.preparedStatement.setString(2, getNilaiModel().getKodeMk());
            con.preparedStatement.setDate(3, getNilaiModel().getTanggal());
            con.preparedStatement.setDouble(4, getNilaiModel().getNilai());
            con.preparedStatement.setInt(5, getNilaiModel().getHadir());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            e.printStackTrace();            berhasil = false;
        } finally {            con.tutupKoneksi();            return berhasil;        }
    }
    public boolean delete(String nomor,String kode) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from penilaian where NPM  = ? and KodeMk = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.setString(2, kode);
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
                    "update penilaian set Tanggal = ?, Nilai = ?, Hadir = ?  where  NPM = ? and KodeMk = ?; ");
            con.preparedStatement.setDate(1, getNilaiModel().getTanggal());
            con.preparedStatement.setDouble(2, getNilaiModel().getNilai());
            con.preparedStatement.setInt(3, getNilaiModel().getHadir());
            con.preparedStatement.setString(4, getNilaiModel().getNPM());
            con.preparedStatement.setString(5, getNilaiModel().getKodeMk());

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
