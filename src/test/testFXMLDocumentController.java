/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.*;

/**
 *
 * @author LENOVO
 */
public class testFXMLDocumentController implements Initializable {
    public static DBSiswa dtsiswa=new DBSiswa();
    public static DBMatkul dtmatkul=new DBMatkul();
    public static DBNilai dtnilai=new DBNilai();

    @FXML
    private MenuItem dis_siswa;
    @FXML
    private MenuItem dis_matkul;
    @FXML
    private MenuItem clk_dis_nilai;
    @FXML
    private MenuItem btn_keluar;
    
    
    @FXML
    private void btn_keluar(ActionEvent event) {
        System.out.println("OUTTT");
        System.exit(0);
    }
    @FXML
    private void clk_dis_siswa(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_displaysiswa.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
    @FXML
    private void clk_dis_matkul(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_displayMatkul.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
    @FXML
    private void clk_dis_nilai(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_disNilai.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
    @FXML
    private void clk_master_siswa(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_InputSiswa.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
    @FXML
    private void clk_master_matkul(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_InputMatkul.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clk_master_nilai(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_InputMatkul.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }
    
}
