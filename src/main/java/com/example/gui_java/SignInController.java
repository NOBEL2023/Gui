package com.example.gui_java;

import Utils.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    @FXML
    private TextField nomsingup;

    @FXML
    private Button enregestrerbt;

    @FXML
    private Button seconnecterbt;

    @FXML
    private PasswordField passwordsingup;

    private Connection connection;
    private DataSource handler;
    private PreparedStatement pst;

   public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        handler=new DataSource();
    }
        @FXML
    public void seconnecter(ActionEvent e) throws IOException
    {
        //singup.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("sign in.fxml"));
        Scene scene = new Scene(root);
        Stage loginnn=new Stage();
        loginnn.setScene(scene);
        loginnn.setTitle("MYcaaar");
        loginnn.show();
    }

}