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
import archjunchaupari.Model.PatraChalani.PatraChalaniDto;
import archjunchaupari.Model.Staff.StaffDto;
import archjunchaupari.Services.Darta.DartaServices;
import archjunchaupari.Services.PatraChalani.PatraChalaniService;
import archjunchaupari.Services.Staff.StaffService;
import archjunchaupari.Utils.LangSts;
import archjunchaupari.Utils.RestUrl;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author cri
 */
public class DashFXMLController extends LangSts implements Initializable {

    private TreeItem<String> root;
    TreeItem<String> spendable;
    TreeItem<String> unspendable;
    TreeItem<String> discardedSpendable;
    TreeItem<String> savedSpendable;
    TreeItem<String> discardedUnspendable;
    TreeItem<String> savedUnspendable;

    @FXML
    private Menu File;

    @FXML
    private Menu Language;

    @FXML
    private Menu Help;

    //Staff label
    @FXML
    private Label Staff_Id;
    @FXML
    private Label Staff_Name;
    @FXML
    private Label Staff_Designation;
    @FXML
    private Label Salary;
    @FXML
    private Label Address;
    @FXML
    private Label Email;
    @FXML
    private Label Joined_Date;
    @FXML
    private Label Gender;
    @FXML
    private Label Password;
    @FXML
    private Label Confirm_Password;

    @FXML
    private Label EnterDetailsInventory;

    @FXML
    private Label EnterDetailsChalani;

    @FXML
    private Label EnterDetailsDarta;

    @FXML
    private Label EnterDetailsStaff;

    @FXML
    private Label id_Darta;

    @FXML
    private Label Darta_Date;

    @FXML
    private Label Darta_Number;

    @FXML
    private Label Letter_Quantity_Darta;

    @FXML
    private Label Reception_Darta;

    @FXML
    private Label Signed_Date_Darta;

    @FXML
    private Label Responsible_Person;

    @FXML
    private Label Subject_Darta;

    @FXML
    private Label Image;

    @FXML
    private Label Remarks_Darta;
    //Patra Chalani Tab label
    @FXML
    private Label Chalani_Date;
    @FXML
    private Label Chalani_NUmber;
    @FXML
    private Label Letter_Quantity;
    @FXML
    private Label Receiption;
    @FXML
    private Label Ticket;
    @FXML
    private Label Subject;
    @FXML
    private Label Remarks_Chalani;
    @FXML
    private Label Letter_Date;
    @FXML
    private Label id;

    //Inventory Tab Label
    @FXML
    private Label Id;

    @FXML
    private Label Name;

    @FXML
    private Label Registration_Number;

    @FXML
    private Label Quantity;

    @FXML
    private Label Rate;

    @FXML
    private Label Section_Number;

    @FXML
    private Label Section;

    @FXML
    private Label Specification;

    @FXML
    private Label Date;

    @FXML
    private Label Type;

    @FXML
    private Label Remarks;

    @FXML
    private ComboBox typeComboBox;

    //patra chalani table 
    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniId;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalani_date;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalani_number;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniLetter_quantity;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniLetter_date;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniSubject;

    @FXML
    private TableColumn<PatraChalaniDto, String> to_office;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniTicket;

    @FXML
    private TableColumn<PatraChalaniDto, String> chalaniRemarks;

    //staff table
    @FXML
    private TableColumn<StaffDto, String> staffTableId;

    @FXML
    private TableColumn<StaffDto, String> staffTableEmail;

    @FXML
    private TableColumn<StaffDto, String> staffTableName;

    @FXML
    private TableColumn<StaffDto, String> staffTableDOB;

    @FXML
    private TableColumn<StaffDto, String> staffTableGender;

    @FXML
    private TableColumn<StaffDto, String> staffTableSalary;

    @FXML
    private TableColumn<StaffDto, String> staffTableJoinedDate;

    @FXML
    private TableColumn<StaffDto, String> staffTableDesignation;

    //staff field
    @FXML
    private ComboBox staffGenderCombo;

    @FXML
    private TextField inventoryId;

    @FXML
    private TextField staffId;

    @FXML
    private TextField dartaId;

    @FXML
    private TextField dartaChalaniId;

    @FXML
    private Button updateInventory;

    @FXML
    private Button updateStaff;

    @FXML
    private Button updateDarta;

    @FXML
    private Button updateDartaChalani;

    @FXML
    private Button uploadImage;

    @FXML
    private TextField searchText;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab inventoryTab;

    @FXML
    private Tab patraTab;

    @FXML
    private Tab dartaTab;

    @FXML
    private Tab staffTab;

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
    private TableView staffTable;

    @FXML
    private TableView chalaniTable;

    @FXML
    private TableColumn<ExInventoryDto, Hyperlink> columnDelete;

    @FXML
    private TableColumn<ExInventoryDto, String> columnName;

    @FXML
    private TableColumn<ExInventoryDto, String> columnId;

    @FXML
    private TableColumn<ExInventoryDto, String> columnType;

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

    //staff Field
    @FXML
    private TextField staffName;

    @FXML
    private TextField staffDesignation;

    @FXML
    private TextField staffAddress;

    @FXML
    private TextField staffEmail;

    @FXML
    private TextField staffPassword;

    @FXML
    private DatePicker staffJoinedDate;

    @FXML
    private TextField staffGender;

    @FXML
    private TextField staffSalary;

    //Darta Field
    @FXML
    private TextField dartaNumber;

    @FXML
    private TextField letterQuantity;

    @FXML
    private TextField reception;

    @FXML
    private TextArea dartaSubject;

    @FXML
    private TextArea dartaRemarks;

    @FXML
    private TextField dartaImage;

    @FXML
    private DatePicker dartaDate;

    @FXML
    private DatePicker signedDate;

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
    private TableColumn<DartaDto, String> to_officee;

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
    private TableColumn<DartaDto, String> is_deleted;

    @FXML
    private TextField textIsApproved;

    private InventoryDaoService inventoryService;
    private DartaServices dartaService;
    private ExInventoryDto inventoryDto;
    private DartaDto dartaDto;
    private StaffDto staffDto;
    private PatraChalaniService patraChalaniService;
    private StaffService staffService;
    private Locale locale;
    private ResourceBundle resourceBundle;
    int i = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        splitPane.setDividerPositions(-0.5);
        LoadLang();
        loadStaffGender();
        loadDarta(resourceBundle.getString("Darta"), resourceBundle.getString("Chalani"), resourceBundle.getString("Staff"));
        loadTable();
        loadPatraChalaniTable();
        loadDartaTable();
        loadStaffTable();
        Editable();
        loadComboBox();
        updateInventory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Hello World");
                updateInventoryDetail(Integer.parseInt(inventoryId.getText()));
            }

        });
    }

    void loadComboBox() {
        ObservableList<String> Type = typeComboBox.getItems();
        Type.add("Expendable");
        Type.add("UnExpendable");
    }

    //Avoids users from overwriting on field | used for update
    void Editable() {
        updateInventory.setDisable(true);
        updateDarta.setDisable(true);
        updateDartaChalani.setDisable(true);
        updateStaff.setDisable(true);
        inventoryId.setEditable(false);
        staffId.setEditable(false);
        dartaChalaniId.setEditable(false);
        dartaId.setEditable(false);
    }

    void loadStaffTable() {
        staffService = new StaffService();
        staffTableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffTableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        staffTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        staffTableDOB.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        staffTableGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        staffTableSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        staffTableJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joined_date"));
        staffTableDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        staffTable.getItems().setAll(staffService.getStaffList());
    }

    void loadPatraChalaniTable() {

        patraChalaniService = new PatraChalaniService();
        chalaniId.setCellValueFactory(new PropertyValueFactory<>("id"));
        chalani_date.setCellValueFactory(new PropertyValueFactory<>("chalani_date"));
        chalani_number.setCellValueFactory(new PropertyValueFactory<>("chalani_number"));
        chalaniLetter_quantity.setCellValueFactory(new PropertyValueFactory<>("letter_quantity"));
        chalaniLetter_date.setCellValueFactory(new PropertyValueFactory<>("letter_date"));
        chalaniSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        to_office.setCellValueFactory(new PropertyValueFactory<>("to_office"));
        chalaniTicket.setCellValueFactory(new PropertyValueFactory<>("ticket"));
        chalaniRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        chalaniTable.getItems().setAll(patraChalaniService.getPatraChalaniList());
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
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
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
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableView.getItems().setAll(inventoryService.getSearchInventory(String.valueOf(10)));
    }

    public void loadDartaTable() {
        dartaService = new DartaServices();
        darta_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        darta_number.setCellValueFactory(new PropertyValueFactory<>("darta_number"));
        darta_date.setCellValueFactory(new PropertyValueFactory<>("darta_date"));
        letter_quantity.setCellValueFactory(new PropertyValueFactory<>("letter_quantity"));
        to_officee.setCellValueFactory(new PropertyValueFactory<>("to_office"));
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        responsible_person_full_name.setCellValueFactory(new PropertyValueFactory<>("responsible_person_full_name"));
        signed_date.setCellValueFactory(new PropertyValueFactory<>("signed_date"));
        remarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        is_deleted.setCellValueFactory(new PropertyValueFactory<>("is_deleted"));
        dartaTable.getItems().setAll(dartaService.getDarta());
        dartaService.getDarta();
    }

    //load item on treeView
    public void loadInventory(String... rootItems) {
        TreeItem<String> root = new TreeItem<>("Saved Inventory");
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }
        treeViewDash.setRoot(root);
    }

    //load Darta treeView node
    public void loadDarta(String... rootItems) {
        root = new TreeItem<>(resourceBundle.getString("Functionality"));
        root.setExpanded(true);
        for (String itemString : rootItems) {
            root.getChildren().add(new TreeItem<>(itemString));
        }
        //  TreeItem<String> inventory = new TreeItem<>("Inventory");

        spendable = new TreeItem<>(resourceBundle.getString("Spendable_Inventory"));
        unspendable = new TreeItem<>(resourceBundle.getString("UnSpendable_Inventory"));

        //saved or discarded for unspendable
        discardedSpendable = new TreeItem(resourceBundle.getString("Discarded_Inventory"));
        savedSpendable = new TreeItem(resourceBundle.getString("Saved_Inventory"));

        discardedUnspendable = new TreeItem(resourceBundle.getString("Discarded_Inventory"));
        savedUnspendable = new TreeItem(resourceBundle.getString("Saved_Inventory"));

        root.getChildren().add(spendable);
        root.getChildren().add(unspendable);
        //   inventory.getChildren().add(spendable);
        spendable.getChildren().add(savedSpendable);
        spendable.getChildren().add(discardedSpendable);

        unspendable.getChildren().add(savedUnspendable);
        unspendable.getChildren().add(discardedUnspendable);
        //   inventory.getChildren().add(unspendable);
        treeViewDash.setRoot(root);
    }

    @FXML
    public void check() {
        JOptionPane.showMessageDialog(null, "hello");
    }

    @FXML
    public void saveStaff() {
        staffDto = new StaffDto();
        staffService = new StaffService();
        staffDto.setName(staffName.getText());
        staffDto.setDesignation(staffDesignation.getText());
        staffDto.setEmail(staffEmail.getText());
        staffDto.setJoined_date(staffJoinedDate.getValue().toString());
        staffDto.setGender(staffGenderCombo.getValue().toString());
        staffDto.setSalary(staffSalary.getText());
        staffService.saveStaff(staffDto);
    }

    @FXML
    public void saveDarta() {
        dartaDto = new DartaDto();
        dartaService = new DartaServices();
        dartaDto.setDarta_number(dartaNumber.getText());
        dartaDto.setLetter_quantity(letterQuantity.getText());
        dartaDto.setRemarks(dartaRemarks.getText());
        dartaDto.setResponsible_person_full_name(reception.getText());
        dartaDto.setSubject(dartaSubject.getText());
        //  dartaDto.setImage(uploadImage());
        String dateValue = dartaDate.getValue().format(DateTimeFormatter.ISO_DATE);
        dartaDto.setDarta_date(dateValue);
        String signedValue = signedDate.getValue().format(DateTimeFormatter.ISO_DATE);
        dartaDto.setSigned_date(signedValue);
        dartaService.saveDarta(dartaDto);
    }

    @FXML
    public void saveInventory() {
        try {
            inventoryService = new InventoryService();
            inventoryDto = new ExInventoryDto();
            inventoryDto.setName(textName.getText());
            inventoryDto.setRegistration_number(Integer.parseInt(textRegistrationNumber.getText()));
            inventoryDto.setQuantity(Integer.parseInt(textQuantity.getText()));
            inventoryDto.setRate(textRate.getText());
            inventoryDto.setSpecification(textSpecification.getText());
            inventoryDto.setSection_number(textSection_number.getText());
            inventoryDto.setRemarks(textRemarks.getText());
            inventoryDto.setCreated_date(textDate.getValue().toString());
            inventoryDto.setType(typeComboBox.getValue().toString());
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
    public void deleteRowDarta() {
        dartaTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    DartaDto dartaDto = (DartaDto) dartaTable.getSelectionModel().getSelectedItem();
                    VBox dialogVbox = new VBox(20);
                    Button button = new Button("Delete");
                    Button buttonUpdate = new Button("Update");
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                        int option = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            loadTable();
                        }
                    });
                    dialogVbox.getChildren().add(new Text(dartaDto.getDarta_date() + " " + dartaDto.getId()));
                    dialogVbox.getChildren().add(button);
                    dialogVbox.getChildren().add(buttonUpdate);
                    Scene dialogScene = new Scene(dialogVbox, 300, 200);
                    dialog.setScene(dialogScene);
                    dialog.show();
                }
            }
        });
    }

    @FXML
    public void deleteRow() {
        tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    //Dialog to display information and delete and update option
                    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    ExInventoryDto inventoryDto1 = (ExInventoryDto) tableView.getSelectionModel().getSelectedItem();
                    VBox dialogVbox = new VBox(20);
                    Button button = new Button("Delete");
                    Button buttonUpdate = new Button("Update");
                    //Transfers to another update view
                    button.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event1) -> {
                        int option = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Warning", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            dialog.close();
                            inventoryService.deleteInventory(inventoryDto1.getId());
                            loadTable();
                        }
                    });
                    buttonUpdate.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event2) -> {
                        updateInventoryField(
                                inventoryDto1.getId(),
                                inventoryDto1.getName(),
                                inventoryDto1.getRegistration_number(),
                                inventoryDto1.getCreated_date(),
                                inventoryDto1.getQuantity(),
                                inventoryDto1.getRate(),
                                inventoryDto1.getSpecification(),
                                inventoryDto1.getSection_number(),
                                inventoryDto1.getRemarks(),
                                inventoryDto1.getIs_approved(),
                                inventoryDto1.getType());
                        dialog.close();
                        updateInventory.setDisable(false);
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

    public void searchButtonAction() {
        switch (tabPane.getSelectionModel().getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, "Hello");
                loadSearchTable(searchText.getText());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "1");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "2");
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    @FXML
    public void close() {
        Platform.exit();
    }

    @FXML
    public Image uploadImage() {
        Image image1 = null;
        try {
            FileChooser fileChooser = new FileChooser();
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
            FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.jpeg");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG, extFilterJPEG);
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
            BufferedImage bufferedImage = ImageIO.read(file);
            image1 = SwingFXUtils.toFXImage(bufferedImage, null);
        } catch (IOException | NullPointerException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "No Image Selected");
        }
        return image1;
    }

    //method for staff Gender combobox
    void loadStaffGender() {
        ObservableList<String> roleType = staffGenderCombo.getItems();
        roleType.add("Male");
        roleType.add("Female");
    }

    void updateInventoryDetail(int id) {
        updateInventory.setDisable(false);
        inventoryService = new InventoryService();
        inventoryDto = new ExInventoryDto();
        inventoryDto.setName(textName.getText());
        inventoryDto.setRegistration_number(Integer.parseInt(textRegistrationNumber.getText()));
        inventoryDto.setQuantity(Integer.parseInt(textQuantity.getText()));
        inventoryDto.setRate(textRate.getText());
        inventoryDto.setSpecification(textSpecification.getText());
        inventoryDto.setSection_number(textSection_number.getText());
        inventoryDto.setRemarks(textRemarks.getText());
        inventoryDto.setCreated_date(textDate.getValue().toString());
        inventoryDto.setType(typeComboBox.getValue().toString());
        inventoryService.updateInventory(id);
    }

    void updateInventoryField(
            int id,
            String name,
            int registration_number,
            String created_date,
            int quantity,
            String rate,
            String specification,
            String section_number,
            String remarks,
            String is_approved,
            String type) {
        inventoryId.setText(String.valueOf(id));
        textName.setText(name);
        textRegistrationNumber.setText(String.valueOf(registration_number));
        textQuantity.setText(String.valueOf(quantity));
        textRate.setText(rate);
        textSpecification.setText(specification);
        textSection_number.setText(section_number);
        textRemarks.setText(remarks);
    }

    void LoadLangInventoryTable() {

    }

    void loadGeneric() {
        EnterDetailsInventory.setText(resourceBundle.getString("Enter_Detail’s_below"));

        EnterDetailsChalani.setText(resourceBundle.getString("Enter_Detail’s_below"));

        EnterDetailsDarta.setText(resourceBundle.getString("Enter_Detail’s_below"));

        EnterDetailsStaff.setText(resourceBundle.getString("Enter_Detail’s_below"));

        updateInventory.setText(resourceBundle.getString("Update"));

        updateStaff.setText(resourceBundle.getString("Update"));

        updateDarta.setText(resourceBundle.getString("Update"));

        File.setText(resourceBundle.getString("File"));

        Help.setText(resourceBundle.getString("Help"));

        Language.setText(resourceBundle.getString("Language"));
        searchButton.setText(resourceBundle.getString("Search"));
    }

    void LoadTextField() {
        //inventoryId.setPromptText(resourceBundle.getString("Inventory_Id"));
        textName.setPromptText(resourceBundle.getString("Name"));
        textRegistrationNumber.setPromptText(resourceBundle.getString("Registration_Number"));
        textQuantity.setPromptText(resourceBundle.getString("Quantity"));
        textRate.setPromptText(resourceBundle.getString("Rate"));
        textSpecification.setPromptText(resourceBundle.getString("Specification"));
        textSection_number.setPromptText(resourceBundle.getString("Section_Number"));
        textSection.setPromptText(resourceBundle.getString("Section"));
        textRemarks.setPromptText(resourceBundle.getString("Remarks"));
        textDate.setPromptText(resourceBundle.getString("Signed_Date"));
    }

    void loadChalaniTextField() {
    }

    void LoadLabel() {
        Name.setText(resourceBundle.getString("Name"));
        Registration_Number.setText(resourceBundle.getString("Registration_Number"));
        Quantity.setText(resourceBundle.getString("Quantity"));
        Rate.setText(resourceBundle.getString("Rate"));
        Specification.setText(resourceBundle.getString("Specification"));
        Section_Number.setText(resourceBundle.getString("Section_Number"));
        Section.setText(resourceBundle.getString("Section"));
        Remarks.setText(resourceBundle.getString("Remarks"));
        Type.setText(resourceBundle.getString("Type"));
        Date.setText(resourceBundle.getString("Date"));
    }

    void LoadLabelChalani() {
        Chalani_Date.setText(resourceBundle.getString("Chalani_Date"));
        Chalani_NUmber.setText(resourceBundle.getString("Chalani_Number"));
        Letter_Quantity.setText(resourceBundle.getString("Letter_Quantity"));
        Receiption.setText(resourceBundle.getString("Reception"));
        Ticket.setText(resourceBundle.getString("Ticket"));
        Subject.setText(resourceBundle.getString("Subject"));
        Remarks_Chalani.setText(resourceBundle.getString("Remarks"));
        Letter_Date.setText(resourceBundle.getString("Letter_Date"));
    }

    @FXML
    void setNepali() {
        setStatus("Nepali");
        LoadLang();
    }

    @FXML
    void setEnglish() {
        setStatus("English");
        LoadLang();
    }

    void LoadLang() {
        if (("English").equals(getStatus())) {
            locale = new Locale("en", "US");
            resourceBundle = ResourceBundle.getBundle("archjunchaupari.Utils.lang/Bundle", locale);
        }
        if (("Nepali").equals(getStatus())) {
            locale = new Locale("ne", "NP");
            resourceBundle = ResourceBundle.getBundle("archjunchaupari.Utils.lang/Bundle", locale);

        }
        loadGeneric();
        LoadTextField();
        LoadLabel();
        LoadLabelChalani();
        loadLabelDarta();
        loadLabelStaff();
        loadFieldStaff();
        loadDarta(resourceBundle.getString("Darta"), resourceBundle.getString("Chalani"), resourceBundle.getString("Staff"));

    }

    void loadLabelDarta() {
        Darta_Date.setText(resourceBundle.getString("Darta_Date"));
        Darta_Number.setText(resourceBundle.getString("Darta_Number"));
        Letter_Quantity_Darta.setText(resourceBundle.getString("Letter_Quantity"));
        Reception_Darta.setText(resourceBundle.getString("Reception"));
        Signed_Date_Darta.setText(resourceBundle.getString("Signed_Date"));
        Responsible_Person.setText(resourceBundle.getString("Responsible_Person"));
        Subject_Darta.setText(resourceBundle.getString("Subject"));
        Image.setText(resourceBundle.getString("Select_Image"));
        Remarks_Darta.setText(resourceBundle.getString("Remarks"));
    }

    void loadLabelStaff() {
        Staff_Name.setText(resourceBundle.getString("Name"));
        Staff_Designation.setText(resourceBundle.getString("Designation"));
        Salary.setText(resourceBundle.getString("Salary"));
        Address.setText(resourceBundle.getString("Address"));
        Email.setText(resourceBundle.getString("Email"));
        Joined_Date.setText(resourceBundle.getString("Joined_Date"));
        Gender.setText(resourceBundle.getString("Gender"));
        Password.setText(resourceBundle.getString("Password"));
        Confirm_Password.setText(resourceBundle.getString("Confirm_Password"));
    }

    void loadFieldStaff() {
        staffName.setPromptText(resourceBundle.getString("Name"));
        staffDesignation.setPromptText(resourceBundle.getString("Designation"));
        staffAddress.setPromptText(resourceBundle.getString("Address"));
        staffEmail.setPromptText(resourceBundle.getString("Email"));
        staffPassword.setPromptText(resourceBundle.getString("Password"));
        staffSalary.setPromptText(resourceBundle.getString("Salary"));
        staffJoinedDate.setPromptText(resourceBundle.getString("Joined_Date"));
    }
    

}
