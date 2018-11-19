package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.io.IOException;

public class Controller {

    @FXML
    private Button displayOne;

    @FXML
    private Button displayTwo;


    @FXML
    void switchTabOne (javafx.event.ActionEvent event) {
        try{
            URL servicesPanelUrl = getClass().getResource("ServicesPanel.fxml");
            AnchorPane servicesPanel = FXMLLoader.load(servicesPanelUrl);

            BorderPane border = Main.getRoot();
            border.setCenter(servicesPanel);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void switchTabTwo(javafx.event.ActionEvent event) {
        try{
            URL addServicesPanelUrl = getClass().getResource("AddServicesPanel.fxml");
            AnchorPane addServicesPanel = FXMLLoader.load(addServicesPanelUrl);

            BorderPane border = Main.getRoot();
            border.setCenter(addServicesPanel);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
