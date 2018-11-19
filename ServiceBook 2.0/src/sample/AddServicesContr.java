package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.hmmmm.Date;
import sample.hmmmm.Service;
import sample.hmmmm.ServiceBook;

import java.lang.NullPointerException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;


public class AddServicesContr {

    @FXML
    private Button addServiceBtn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField mileagesArea;

    @FXML
    private TextField serviceNameArea;

    @FXML
    private Label confirmationLabel;

    @FXML
    private Label errorLabel1;

    @FXML
    private Label errorLabel2;


    @FXML
    void addNewService (){
        LocalDate local = datePicker.getValue();
        Date date = new Date();
        Service service = new Service();

        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setHeaderText("");
        alert1.setContentText("Enter a valid number in the Mileage field!");

        Alert alert2 = new Alert(Alert.AlertType.ERROR);
        alert2.setHeaderText("");
        alert2.setContentText("Enter a valid Service Name!");

        date.setDay(local.getDayOfMonth());
        date.setMonth(local.getMonthValue());
        date.setYear(local.getYear());

        try {
            service.setMileage(Integer.parseInt(mileagesArea.getText()));
            if(service.getMileage() < 0 || service.getMileage()> 24 ){
                throw new NumberFormatException();
            }
            service.setService(serviceNameArea.getText());
            if((service.getService().equals(""))||(!(service.getService().matches("[a-zA-Z]+")))){
                throw new IllegalArgumentException();
            }
            service.setDate(date);
            ServiceBook.inst().addService(service);
            mileagesArea.setText("");
            datePicker.setValue(null);
            serviceNameArea.setText("");
            confirmationLabel.setVisible(true);
            errorLabel2.setVisible(false);
            errorLabel1.setVisible(false);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            confirmationLabel.setVisible(false);
            mileagesArea.setText("");
            alert1.showAndWait();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            confirmationLabel.setVisible(false);
            serviceNameArea.setText("");
            alert2.showAndWait();
        }
    }
}
