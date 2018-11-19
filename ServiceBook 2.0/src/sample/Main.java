package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.hmmmm.Date;
import sample.hmmmm.Service;
import sample.hmmmm.ServiceBook;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {



    private static BorderPane root = new BorderPane();

    public static BorderPane getRoot() {
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws IOException{

        URL toolBarUrl = getClass().getResource("sample.fxml");
        ToolBar toolBar = FXMLLoader.load(toolBarUrl);

        URL servicesPanelUrl = getClass().getResource("ServicesPanel.fxml");
        AnchorPane servicesPanel = FXMLLoader.load(servicesPanelUrl);

        root.setTop(toolBar);
        root.setCenter(servicesPanel);

        Scene scene = new Scene(root, 400, 440);
        primaryStage.setTitle("ServiceBook 2000 Ultra Turbo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        Date date1 = new Date(2,11,2018);
        Date date2 = new Date(28,7,2017);
        Date date3 = new Date(11,9,2019);
        Date date4 = new Date(4,2,2011);

        Service service1 = new Service(10,date1,"Service");
        Service service2 = new Service(12,date2,"Service");
        Service service3 = new Service(2,date3,"Service");
        Service service4 = new Service(4,date4,"Service");

        ServiceBook book1 = ServiceBook.inst();

        book1.addService(service1);
        book1.addService(service2);
        book1.addService(service3);
        book1.addService(service4);



        launch(args);
    }
}
