/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altaik.ui.priceoffers.view;

import com.altaik.priceoffers.CertificateStorage;
import com.altaik.priceoffers.PriceOffersRobot;
import com.altaik.ui.priceoffers.model.PriceOffersData;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author Aset
 */

public class MainController implements Initializable {

    @FXML
    private Button startBtn;
    @FXML
    private Label titleLbl;
    @FXML
    private Label lotNumberLbl;
    @FXML
    private Label sumLbl;
    @FXML
    private Label authFileLbl;
    @FXML
    private Label gosFileLbl;
    @FXML
    private TextField lotNumber;
    @FXML
    private TextField offerSum;
    @FXML
    private Button authFileBtn;
    @FXML
    private Button gosFileBtn;
    @FXML
    private TextField authPassword;
    @FXML
    private TextField gosPassword;

    private Stage stage;
    PriceOffersData priceOffersData;
    File authInitDir = null;
    File gosInitDir = null;
    @FXML
    private TextField zakupPassword;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Init();
    }

    private void Init() {
        priceOffersData = new PriceOffersData();
        lotNumber.textProperty().bindBidirectional(priceOffersData.lotNumberProperty());
        
        //StringConverter<Number> stringConverter = new NumberStringConverter();
        //offerSum.textProperty().bindBidirectional(priceOffersData.offerSumProperty(), stringConverter);
        
        offerSum.textProperty().bindBidirectional(priceOffersData.lotsPricesProperty());
        authPassword.textProperty().bindBidirectional(priceOffersData.authPassProperty());
        gosPassword.textProperty().bindBidirectional(priceOffersData.gosPassProperty());
        zakupPassword.textProperty().bindBidirectional(priceOffersData.zakupPassProperty());
    }

    @FXML
    private void StartAction(ActionEvent event) {
        SignAction();
    }
    
    private void SignAction(){
//        GosAuthCrawler gosAuthCrawler = new GosAuthCrawler();
//        Document document = gosAuthCrawler.getDoc();
//        PriceOffersRobot robot = new PriceOffersRobot();
//        Map<String, String> signerParams = robot.GetAppletParams(document);
//        robot.Signer(gosAuthCrawler.baseUrl, signerParams.get("downloadUrl"), signerParams.get("uploadUrl"), signerParams.get("fileAttributes"), signerParams.get("userName"));
        
        CertificateStorage certStorage = new CertificateStorage(priceOffersData.getGosPath(), priceOffersData.getGosPass(), priceOffersData.getAuthPath(), priceOffersData.getAuthPass(), priceOffersData.getAuthType(), priceOffersData.getJksPath(), priceOffersData.getJksPass());
//        PriceOffersRobot priceOffersRobot = new PriceOffersRobot(certStorage,"123456dmm");
        
        PriceOffersRobot priceOffersRobot = new PriceOffersRobot(certStorage,priceOffersData.getZakupPass(),priceOffersData.lotsPricesProperty().get().replace(" ", "").split(","));
        
        
        priceOffersRobot.MainSignProcess();
    }
    
    private void SignActionTaskExecutor(){
        final Task task;
        task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int max = 50;
                for (int i = 1; i <= max; i++) {
                    if (isCancelled()) {
                        break;
                    }
                    updateProgress(i, max);
                    updateMessage(String.valueOf(i));

                }
                return null;
            }
        };
        
    }

    @FXML
    private void AuthFileChoose(ActionEvent event) {
        if (!isStageValid(event.getSource())) {
            return;
        }
        FileChooser authFileChooser = new FileChooser();
        authFileChooser.setTitle("Выбрать файл авторизации (AUTH)");
        authFileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("p12", "*.p12"));
        if(authInitDir!=null) authFileChooser.setInitialDirectory(authInitDir);
        else if(gosInitDir!=null) authFileChooser.setInitialDirectory(gosInitDir);
        File authFile = authFileChooser.showOpenDialog(stage);
        if (authFile != null) {
            priceOffersData.setAuthPath(authFile.getAbsolutePath());
            ((Button) event.getSource()).setText(authFile.getName());
            authInitDir = authFile.getParentFile();
        }
    }

    @FXML
    private void GosFileChoose(ActionEvent event) {
        if (!isStageValid(event.getSource())) {
            return;
        }
        FileChooser gosFileChooser = new FileChooser();
        gosFileChooser.setTitle("Выбрать файл подписи (GOST)");
        gosFileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("p12", "*.p12"));
        gosFileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*", "*.*"));
        if(gosInitDir!=null) gosFileChooser.setInitialDirectory(gosInitDir);
        else if(authInitDir!=null) gosFileChooser.setInitialDirectory(authInitDir);
        File gosFile = gosFileChooser.showOpenDialog(stage);
        if (gosFile != null) {
            priceOffersData.setGosPath(gosFile.getAbsolutePath());
            ((Button) event.getSource()).setText(gosFile.getName());
            gosInitDir = gosFile.getParentFile();
        }
    }

    private boolean isStageValid(Object control) {
        if (stage == null) {
            if (control instanceof Control) {
                stage = (Stage) ((Control) control).getScene().getWindow();
            } else {
                return false;
            }
        }
        return true;
    }

}
