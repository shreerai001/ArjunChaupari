/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Dashboard;

import archjunchaupari.Services.Inventory.InventoryDaoService;
import archjunchaupari.Services.Inventory.InventoryService;
import archjunchaupari.Model.Darta.DartaDto;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Services.Darta.DartaServices;
import archjunchaupari.Utils.RestUrl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cri
 */
public class DashFXMLController implements Initializable {
    
    @FXML
    private TextField searchText;
    
    @FXML
    private Button searchButton;

    @FXML
    private SplitPane splitPane;

    @FXML
    private Button logOut;

    @FXML
    private Button b;

    @FXML
    private TreeView treeViewDash;

    @FXML
    private TableView tableView;

    @FXML
    private TableView dartaTable;

    @FXML
    private TableColumn<ExInventoryDto, Hyperlink> columnDelete;

    @FXML
    private TableColumn<ExInventoryDto, String> columnName;

    @FXML
    private TableColumn<ExInventoryDto, String> columnId;

    @FXML
    private TextField textName;

    @FXML
    private TableColumn<ExInventoryDto, String> columnRegistrationNumber;

    @FXML
    private TextField textRegistrationNumber;

    @FXML
    private TableColumn<ExInventoryDto, String> columnDate;

    @FXML
    private DatePicker textDate;

    @FXML
    private TableColumn<ExInventoryDto, String> columnQuantity;

    @FXML
    private TextField textQuantity;

    @FXML
    private TableColumn<ExInventoryDto, String> columnRate;

    @FXML
    private TextField textRate;

    @FXML
    private TableColumn<ExInventoryDto, String> columnSpecification;

    @FXML
    private TextArea textSpecification;

    @FXML
    private TableColumn<ExInventoryDto, String> columnSection;

    @FXML
    private TextField textSection;

    @FXML
    private TableColumn<ExInventoryDto, String> columnSection_number;

    @FXML
    private TextField textSection_number;

    @FXML
    private TableColumn<ExInventoryDto, String> columnRemarks;

    @FXML
    private TextArea textRemarks;

    @FXML
    private TableColumn<ExInventoryDto, String> columnIs_Approved;

    //Darta TableView column
    @FXML
    private TableColumn<DartaDto, String> darta_id;

    @FXML
    private TableColumn<DartaDto, String> created_date;

    @FXML
    private TableColumn<DartaDto, String> darta_number;

    @FXML
    private TableColumn<DartaDto, String> darta_date;

    @FXML
    private TableColumn<DartaDto, String> letter_quantity;

    @FXML
    private TableColumn<DartaDto, String> to_office;

    @FXML
    private TableColumn<DartaDto, String> subject;

    @FXML
    private TableColumn<DartaDto, String> image;

    @FXML
    private TableColumn<DartaDto, String> responsible_person_full_name;

    @FXML
    private TableColumn<DartaDto, String> signed_date;

    @FXML
    private TableColumn<DartaDto, String> remarks;

    @FXML
    private TextField textIsApproved;

    InventoryDaoService inventoryService;
    DartaServices dartaService;
    ExInventoryDto inventoryDto;
    int i = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        splitPane.setDividerPositions(-0.5);
        loadInventory("Spendable Item", "UnSpendable Item");
        loadDarta("Darta", "Chalani");
        loadTable();
        loadDartaTable();
    }

    //load Inventory on Table
    public void loadTable() {
        inventoryService = new InventoryService();
        //load item on tableview from pojo class 
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnRegistrationNumber.setCellValueFactory(new PropertyValueFactory<>("registration_number"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        columnSpecification.setCellValueFactory(new PropertyValueFactory<>("specification"));
        columnSection.setCellValueFactory(new PropertyValueFactory<>("section"));
        columnSection_number.setCellValueFactory(new PropertyValueFactory<>("section_number"));
        columnRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("created_date"));
        columnIs_Approved.setCellValueFactory(new PropertyValueFactory<>("is_approved"));
        tableView.getItems().setAll(inventoryService.getInventory());
    }
        //load searched Inventory on Table
    public void loadSearchTable(String inventory) {
        inventoryService = new InventoryService();
        //load item on tableview from pojo class 
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnRegistrationNumber.setCellValueFactory(new PropertyValueFactory<>("registration_number"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        columnSpecification.setCellValueFactory(new PropertyValueFactory<>("specification"));
        columnSection.setCellValueFactory(new PropertyValueFactory<>("section"));
        columnSection_number.setCellValueFactory(new PropertyValueFactory<>("section_number"));
        columnRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("created_date"));
        columnIs_Approved.setCellValueFactory(new PropertyValueFactory<>("is_approved"));
        tableView.getItems().setAll(inventoryService.getSearchInventory(inventory));
    }
    public void loadDartaTable() {
        dartaService = new DartaServices();
        darta_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        darta_number.setCellValueFactory(new PropertyValueFactory<>("darta_number"));
        darta_date.setCellValueFactory(new PropertyValueFactory<>("darta_date"));
        letter_quantity.setCellValueFactory(new PropertyValueFactory<>("letter_quantity"));
        to_office.setCellValueFactory(new PropertyValueFactory<>("to_office"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        responsible_person_full_name.setCellValueFactory(new PropertyValueFactory<>("reponsible_person_full_name"));
        signed_date.setCellValueFactory(new PropertyValueFactory<>("signed_date"));
        remarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        dartaTable.getItems().setAll(dartaService.getDarta());
    }

    //load item on treeView
    public void loadInventory(String... rootItems) {
        TreeItem<String> root = new TreeItem<>("Inventory");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }
        treeViewDash.setRoot(root);
    }

    //load Darta treeView node
    public void loadDarta(String... rootItems) {
        TreeItem<String> root = new TreeItem<>("Functionality");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }
        TreeItem<String> inventory = new TreeItem<>("Inventory");

        TreeItem<String> spendable = new TreeItem<>("Spendable Inventory");
        TreeItem<String> unspendable = new TreeItem<>("UnSpendable Inventory");
        /*
        spendable.addEventHandler(MouseEvent, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });*/
        root.getChildren().add(inventory);
        inventory.getChildren().add(spendable);
        inventory.getChildren().add(unspendable);
        treeViewDash.setRoot(root);
    }

    @FXML
    public void check() {
        JOptionPane.showMessageDialog(null, "hello");
    }

    @FXML
    public void saveInventory() {
        try {
            inventoryService = new InventoryService();
            inventoryDto = new ExInventoryDto();
            inventoryDto.setName(textName.getText());
            inventoryDto.setRegistration_number(textRegistrationNumber.getText());
            inventoryDto.setQuantity(textQuantity.getText());
            inventoryDto.setRate((textRate.getText()));
            inventoryDto.setSpecification(textSpecification.getText());
            inventoryDto.setSection(textSection.getText());
            inventoryDto.setSection_number(textSection_number.getText());
            inventoryDto.setRemarks(textRemarks.getText());
            inventoryService.saveInventory(inventoryDto);
            loadTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
    }

    @FXML
    public void logOut() {
        try {
            Stage primary_stage = (Stage) logOut.getScene().getWindow();
            primary_stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/archjunchaupari/FXMLDocument.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ArjunChaupari Gaupalika");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DashFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void deleteRow() {
        tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    ExInventoryDto inventoryDto1 = (ExInventoryDto) tableView.getSelectionModel().getSelectedItem();
                    VBox dialogVbox = new VBox(20);
                    Button button = new Button("Delete");
                    Button buttonUpdate = new Button("Update");
                    buttonUpdate.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event2) -> {
                        try {
                            Stage primary_stage = (Stage) buttonUpdate.getScene().getWindow();
                            primary_stage.close();
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/archjunchaupari/Update/UpdateFXML.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setTitle("ArjunChaupari Gaupalika");
                            stage.setScene(new Scene(root1));
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(DashFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                        int option = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            inventoryService.deleteInventory(inventoryDto1.getId());
                            loadTable();
                        }
                    });
                    dialogVbox.getChildren().add(new Text(inventoryDto1.getName() + "" + inventoryDto1.getId()));
                    dialogVbox.getChildren().add(button);
                    dialogVbox.getChildren().add(buttonUpdate);
                    Scene dialogScene = new Scene(dialogVbox, 300, 200);
                    dialog.setScene(dialogScene);
                    dialog.show();
                }
            }
        });
    }
    
    public void searchButtonAction(){
        if(searchText.getText()!=null){
        loadSearchTable(searchText.getText());}
        else{
            JOptionPane.showMessageDialog(null, "Enter items to be Searched");
        }
    }

    @FXML
    public void close() {
        Platform.exit();
    }

}
