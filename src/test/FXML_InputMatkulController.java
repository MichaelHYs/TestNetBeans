/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXML_InputMatkulController implements Initializable {
    

    @FXML
    private TextField txtkodemk;
    @FXML
    private TextField txtnamamk;
    @FXML
    private Spinner<Integer> txtsks;
    @FXML
    private Spinner<Integer> txtpraktek;
    @FXML
    private Button btnbatal;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnkeluar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SpinnerValueFactory<Integer> spinnerSks =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,24,1);
        txtsks.setValueFactory(spinnerSks);
        SpinnerValueFactory<Integer> spinnerPraktek =new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1);
        txtpraktek.setValueFactory(spinnerPraktek);
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
        matkulModel s=new matkulModel();
        s.setKodeMk(txtkodemk.getText());
        s.setNamaMk(txtnamamk.getText());
        s.setSKS((int) txtsks.getValue());
        s.setPraktek((int) txtpraktek.getValue());
        testFXMLDocumentController.dtmatkul.setmatkulModel(s);
        if(testFXMLDocumentController.dtmatkul.validasi(s.getKodeMk())<=0){
            if(testFXMLDocumentController.dtmatkul.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtkodemk.requestFocus();
        }

    }

    @FXML
    private void batalklik(ActionEvent event) {
        int a=0;
        txtkodemk.setText("");
        txtnamamk.setText("");
    }

    @FXML
    private void keluarklik(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }
    
}
