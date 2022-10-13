package multipageBook.member.list;

import multipageBook.Main;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import multipageBook.member.Member;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ListView<Member> lvMember;
    public static ObservableList<Member> listMember = FXCollections.observableArrayList();
    public static Member editMember;
    public static Member chooseMember;
    public void addMember(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../form/form.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Add Member");
        Main.bookStage.setScene(listScene);
    }

    boolean sortCode = true;
    public void sortCode(ActionEvent actionEvent) {
        Collections.sort(listMember, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return sortCode?o1.getCode()-o2.getCode():o2.getCode()-o1.getCode();
            }
        });
        sortCode=!sortCode;
    }

    public void removeMember(ActionEvent actionEvent) {
        editMember=lvMember.getSelectionModel().getSelectedItem();
        if(editMember==null) return;
        listMember.remove(editMember);
    }

    boolean sortName = true;
    public void sortName(ActionEvent actionEvent) {
        Collections.sort(listMember, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return sortName?o1.layTen().compareTo(o2.layTen()):o2.layTen().compareTo(o1.layTen());

            }
        });
        sortName=!sortName;
    }

    public void editMember(ActionEvent actionEvent) throws Exception {
        editMember = lvMember.getSelectionModel().getSelectedItem();
        if(editMember==null) return;
        Parent listPage = FXMLLoader.load(getClass().getResource("../edit/edit.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Edit Member");
        Main.bookStage.setScene(listScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvMember.setItems(listMember);
        lvMember.refresh();
    }



    public void goToMain(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../../main.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.bookStage.setTitle("Main");
        Main.bookStage.setScene(listScene);
    }

    public void chooseMember(ActionEvent actionEvent) {
        chooseMember=lvMember.getSelectionModel().getSelectedItem();
        if(chooseMember==null) return;
    }
}
