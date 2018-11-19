package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.hmmmm.Date;
import sample.hmmmm.Service;
import sample.hmmmm.ServiceBook;

public class ServicesContr {

    @FXML
    private Button showServicesBtn;

    @FXML
    private Button showMileagesBtn;

    @FXML
    private Button showLastBtn;

    @FXML
    private TextArea textArea;

    @FXML
    private TextArea textArea2;

    @FXML
    private TextArea textArea3;

    @FXML
    void showServices (javafx.event.ActionEvent event) {

        textArea.setText("");

        for (Service allService : ServiceBook.inst().getAllServices()) {
            textArea.appendText(allService.toString() + "\n");
        }

    }

    @FXML
    void showMileages (javafx.event.ActionEvent event){

        textArea2.setText("");

        for (int allMileages : ServiceBook.inst().getAllServiceMileages()) {
            textArea2.appendText(allMileages + " hours" + "\n");
        }

    }
    @FXML
    void showLast (javafx.event.ActionEvent event){

        textArea3.setText("");

        textArea3.appendText(ServiceBook.inst().getDateOfLastService()+ "\n");
        }



    }
