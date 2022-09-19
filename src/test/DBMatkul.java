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
public class DBMatkul {
    private matkulModel dt=new matkulModel();    
    public matkulModel getmatkulModel(){ return(dt);}
    public void setmatkulModel(matkulModel s){ dt=s;}    

    public ObservableList<matkulModel>  Load() {
        try {   ObservableList<matkulModel> TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
           con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select KodeMk, NamaMk, SKS, Praktek from matakuliah");
            int i = 1;
            while (rs.next()) {
                matkulModel d=new matkulModel();
                d.setKodeMk(rs.getString("KodeMk")); 
                d.setNamaMk(rs.getString("NamaMk"));
                d.setSKS(rs.getInt("SKS"));
                d.setPraktek(rs.getInt("Praktek"));
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from matakuliah where KodeMk = '" + nomor + "'");
            while (rs.next()) {   val = rs.getInt("jml");            }
            con.tutupKoneksi();
        } catch (SQLException e) {            e.printStackTrace();        }
        return val;
    }
    public boolean insert() {
        boolean berhasil = false;    Koneksi con = new Koneksi();
        try {         con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into matakuliah (KodeMk, NamaMk, SKS, Praktek) values (?,?,?,?)");
            con.preparedStatement.setString(1, getmatkulModel().getKodeMk());
            con.preparedStatement.setString(2, getmatkulModel().getNamaMk());
            con.preparedStatement.setInt(3, getmatkulModel().getSKS());
            con.preparedStatement.setInt(4, getmatkulModel().getPraktek());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            e.printStackTrace();            berhasil = false;
        } finally {            con.tutupKoneksi();            return berhasil;        }
    }
}
