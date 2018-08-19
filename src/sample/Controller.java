package sample;

import sample.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class Controller {
    public TextField UsernameTextField;
    public javafx.scene.control.Button Button;
    public PasswordField PasswordTextField;
    public Label PasswordLabel;
    public Label HelloLabel;
    public Label EnterInformationLabel;
    public Pane UsernameLabel;
    public Label isConnected;



    public void login(ActionEvent actionEvent) {

        ConnectionClass connectionClass = new ConnectionClass();

        Connection connection = connectionClass.getConnection();

        isConnected.setText("");

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT FROM userAuth WHERE username = "+ UsernameTextField.getText() +"AND password = " + PasswordTextField.getText();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()){
                isConnected.setText("Connected");

            } else {
                isConnected.setText("Not Connected");
            }
        } catch (SQLException e){
            e.printStackTrace();

        }
    }
}
