package controller;

import entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.io.Serializable;

public class StudentFormController {

    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public ToggleGroup Gender;
    public RadioButton rbtnFemale;
    public TableView tblStudentDetails;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colGender;
    public TableColumn colOption;

    public void btnOnActionSave(ActionEvent actionEvent) {
        Student student = new Student(
                Long.parseLong(txtId.getText()),
                txtName.getText(),
                txtAddress.getText(),
                rbtnFemale.isSelected()?"Female":"Male"
        );

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(student);
        System.out.println(save);
        transaction.commit();
    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
    }
}
