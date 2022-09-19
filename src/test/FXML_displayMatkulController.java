/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXML_displayMatkulController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private TableView<matkulModel> tbvmatkul;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<matkulModel> data=testFXMLDocumentController.dtmatkul.Load();
        if(data!=null){            
            tbvmatkul.getColumns().clear();
            tbvmatkul.getItems().clear();
            TableColumn col=new TableColumn("KodeMk");
            col.setCellValueFactory(new PropertyValueFactory<matkulModel, String>("KodeMk"));
            tbvmatkul.getColumns().addAll(col);
            col=new TableColumn("NamaMk");
            col.setCellValueFactory(new PropertyValueFactory<matkulModel, String>("NamaMk"));
            tbvmatkul.getColumns().addAll(col);
            col=new TableColumn("SKS");
            col.setCellValueFactory(new PropertyValueFactory<matkulModel, String>("SKS"));
            tbvmatkul.getColumns().addAll(col);
            tbvmatkul.setItems(data);
            col=new TableColumn("Praktek");
            col.setCellValueFactory(new PropertyValueFactory<matkulModel, String>("Praktek"));
            tbvmatkul.getColumns().addAll(col);
            tbvmatkul.setItems(data);
            
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvmatkul.getScene().getWindow().hide();;
        }        
    }
    
    }    
    

