/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package test;

import java.net.URL;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXML_InputNilaiController implements Initializable {

    @FXML
    private DatePicker dtptanggal;
    @FXML
    private Slider sldhadir;
    @FXML
    private TextField txtkodemk;
    @FXML
    private TextField txtnpm;
    @FXML
    private TextField txtnilai;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnkeluar;
    @FXML
    private Label lblhadir;
    boolean editdata=false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sldhadir.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, 
                    Number oldVal, Number newVal){
                lblhadir.setText(String.valueOf(newVal.intValue()));        
                              }   });

    }    
    public void execute(NilaiModel d){
        if(!d.getNPM().isEmpty()&&!d.getKodeMk().isEmpty()){
          editdata=true;
          txtnpm.setText(d.getNPM());
          txtkodemk.setText(d.getKodeMk());
          dtptanggal.setValue(d.getTanggal().toLocalDate());  
          sldhadir.setValue(d.getHadir());
          txtnilai.setText(String.valueOf(d.getNilai()));
          txtnpm.setEditable(false);
          txtkodemk.setEditable(false);
          dtptanggal.requestFocus();
        }
    }


    @FXML
    private void simpanklik(ActionEvent event) {
        NilaiModel n=new NilaiModel();
        n.setNPM(txtnpm.getText());
        n.setKodeMk(txtkodemk.getText());
        n.setHadir((int)sldhadir.getValue());
        n.setNilai(Double.parseDouble(txtnilai.getText()));
        n.setTanggal(Date.valueOf(dtptanggal.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));        
        testFXMLDocumentController.dtnilai.setNilaiModel(n);
        if(editdata){
            if(testFXMLDocumentController.dtnilai.update()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtnpm.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(testFXMLDocumentController.dtnilai.validasi(n.getNPM(),n.getKodeMk())<=0){
            if(testFXMLDocumentController.dtnilai.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
                       Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtnpm.requestFocus();
        }
    }

    @FXML
    private void batalklik(ActionEvent event) {
        txtnpm.setText("");
        txtkodemk.setText("");
        txtnilai.setText("");
        dtptanggal.getEditor().clear();
        sldhadir.setValue(0);
        txtnpm.requestFocus();

    }

    @FXML
    private void keluarklik(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }
    
}
