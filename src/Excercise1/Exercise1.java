package Excercise1;
import  javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.*;

public class Exercise1 extends  Application {

    Stage window;
    Scene menuScene, insertScene, updateScene, displayScene, playerUpdateScene;
    GridPane menuGrid, insertGrid, updateGrid, displayGrid, playerIDGrid;
    TableView<Game> table;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Games");

        //Menu Scene
        menuGrid = new GridPane();
        menuGrid.setPadding(new Insets(10, 10, 10, 10));
        menuGrid.setVgap(8);
        menuGrid.setHgap(10);


        //Welcome
        Label welcome = new Label("Welcome to the Game World");
        GridPane.setConstraints(welcome, 2, 0);

        // Go to Insert Scene
        Button btnInsertScene = new Button("Click to Insert Player");
        GridPane.setConstraints(btnInsertScene, 2, 2);
        btnInsertScene.setOnAction(e -> window.setScene(insertScene));

        // Go to Update Scene
        Button btnUpdateScene = new Button("Click to Update Player");
        GridPane.setConstraints(btnUpdateScene, 2, 3);
        btnUpdateScene.setOnAction(e -> window.setScene(playerUpdateScene));

        // Go to Display Scene
        Button btnDisplayeScene = new Button("Click to Display Player");
        GridPane.setConstraints(btnDisplayeScene, 2, 4);
        btnDisplayeScene.setOnAction(e -> window.setScene(displayScene));


        menuGrid.getChildren().addAll(welcome, btnInsertScene, btnUpdateScene, btnDisplayeScene);

        menuScene = new Scene(menuGrid, 300, 200);


        //Insert Scene

        insertGrid = new GridPane();
        insertGrid.setPadding(new Insets(10, 10, 10, 10));
        insertGrid.setVgap(8);
        insertGrid.setHgap(10);


        //Game Title
        Label gameDetails = new Label("Game Details: ");
        GridPane.setConstraints(gameDetails, 0, 0);


        Label gameID = new Label("Enter the Game ID: ");
        GridPane.setConstraints(gameID, 0, 1);

        //Game Title Input
        TextField gameIDInput = new TextField();
        GridPane.setConstraints(gameIDInput, 1, 1);


        Label gameName = new Label("Enter the Game Title: ");
        GridPane.setConstraints(gameName, 0, 2);

        //Game Title Input
        TextField gameTitleInput = new TextField();
        GridPane.setConstraints(gameTitleInput, 1, 2);

        //Player Details
        Label playerDetails = new Label("Player Details: ");
        GridPane.setConstraints(playerDetails, 0, 3);

        //Player Name
        Label playerFirstName = new Label("Enter the Player  Name: ");
        GridPane.setConstraints(playerFirstName, 0, 4);

        //Player Name Input
        TextField playerFirstNameInput = new TextField();
        GridPane.setConstraints(playerFirstNameInput, 1, 4);

        //Player ID
        Label playerid = new Label("Enter the Player ID: ");
        GridPane.setConstraints(playerid, 0, 5);

        //Player Last Name Input
        TextField playeridInput = new TextField();
        GridPane.setConstraints(playeridInput, 1, 5);

        //Player Address
        Label playerAddress = new Label("Enter the Address: ");
        GridPane.setConstraints(playerAddress, 0, 6);

        //Player Address Input
        TextField playerAddressInput = new TextField();
        GridPane.setConstraints(playerAddressInput, 1, 6);

        //Player Postal code
        Label playerPostalCode = new Label("Enter the Postal code: ");
        GridPane.setConstraints(playerPostalCode, 0, 7);

        //Player Name Input
        TextField playerPostalCodeInput = new TextField();
        GridPane.setConstraints(playerPostalCodeInput, 1, 7);

        //Player Province
        Label playerProvince = new Label("Enter the Province Name: ");
        GridPane.setConstraints(playerProvince, 0, 8);

        //Player province Input
        TextField playerProvinceInput = new TextField();
        GridPane.setConstraints(playerProvinceInput, 1, 8);

        //Phone number
        Label playerPhoneNumber = new Label("Enter the Player Phone Number: ");
        GridPane.setConstraints(playerPhoneNumber, 0, 9);

        //Phone number Input
        TextField playerPhoneNumberInput = new TextField();
        GridPane.setConstraints(playerPhoneNumberInput, 1, 9);


        //Player and Game Details
        Label playerNGame = new Label("Player and Game Details: ");
        GridPane.setConstraints(playerNGame, 0, 10);

        //Player Game
        Label playerNGameID = new Label("Enter the Player and Game ID: ");
        GridPane.setConstraints(playerNGameID, 0, 11);

        //Player Game Input
        TextField playerNGameIDInput = new TextField();
        GridPane.setConstraints(playerNGameIDInput, 1, 11);

        //Playing Date
        Label playingDate = new Label("Enter the Playing Date: ");
        GridPane.setConstraints(playingDate, 0, 12);

        //Player Date Input
        TextField playingDateInput = new TextField();
        GridPane.setConstraints(playingDateInput, 1, 12);

        //Playing Score
        Label playerScore = new Label("Enter the Game Score: ");
        GridPane.setConstraints(playerScore, 0, 13);

        //Player Score Input
        TextField playerScoreInput = new TextField();
        GridPane.setConstraints(playerScoreInput, 1, 13);


        Button insertPlayer = new Button("Insert Player");
        GridPane.setConstraints(insertPlayer, 1, 14);
        insertPlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    this.insertData();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }

            private void insertData() throws Exception {
                try {
                    Connection conn = DriverManager.getConnection("jdbc:sqlserver://PR-COMMONS-28\\ACL (CENCOL\\300989777).example.com:1433;database=COMP228GameDB");
                    Statement stt = conn.createStatement();
                    PreparedStatement pstt;
                    try {
                        stt.execute("Create Table IF NOT EXISTS PlayerInfo" +
                                "( PlayerName text," +
                                "PlayerID text," +
                                "Address text," +
                                "Postal_Code text," +
                                "Provice text," +
                                "Phone_Number text, " +
                                "primary key  (PlayerID) )");

                        stt.execute("Create Table IF NOT EXISTS GameInfo" +
                                "(GameID text," +
                                "GameTitle text, " +
                                "primary key (GameID) )");

                        stt.execute("Create Table IF NOT EXISTS PlayerAndGameInfo" +
                                "( PlayerAndGameID text," +
                                " GameID text," +
                                " PlayerID text, " +
                                " PlayingDate text," +
                                " Score text ," +
                                " primary key (PlayerAndGameID), " +
                                " foreign key (PlayerID) REFERENCES PlayerInfo(PlayerID)," +
                                " foreign key (GameID) REFERENCES GameInfo(GameID)  )");


                        pstt = conn.prepareStatement("Insert into PlayerInfo Values(?,?,?,?,?,?)");
                        pstt.setString(1, playerFirstNameInput.getText());
                        pstt.setString(2, playeridInput.getText());
                        pstt.setString(3, playerAddressInput.getText());
                        pstt.setString(4, playerPostalCodeInput.getText());
                        pstt.setString(5, playerProvinceInput.getText());
                        pstt.setString(6, playerPhoneNumberInput.getText());

                        if (pstt.executeUpdate() > 0) {

                            pstt = conn.prepareStatement("Insert into GameInfo Values(?,?)");
                            pstt.setString(1, gameIDInput.getText());
                            pstt.setString(2, gameTitleInput.getText());

                            if (pstt.executeUpdate() > 0) {
                                pstt = conn.prepareStatement("Insert into PlayerAndGameInfo Values(?,?,?,?,?)");
                                pstt.setString(1, playerNGameID.getText());
                                pstt.setString(2, gameIDInput.getText());
                                pstt.setString(3, playeridInput.getText());
                                pstt.setString(4, playingDateInput.getText());
                                pstt.setString(5, playerScoreInput.getText());
                                JOptionPane.showMessageDialog(null, " date is inserted");
                                if (!(pstt.executeUpdate() <= 0)) {
                                    System.out.println("Player And Game Info Error :");
                                }
                            } else {
                                System.out.println("Game Info Table Error : ");
                            }
                        } else {
                            System.out.println("Player Info Table Error : ");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"Exception is Thrown");
                        //e.printStackTrace();
                        stt.close();
                        conn.close();
                    } finally {
                        stt.close();
                        conn.close();
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });



        Button btnCancelInsert = new Button("Cancel");
        GridPane.setConstraints(btnCancelInsert, 1, 15);
        btnCancelInsert.setOnAction(e -> window.setScene(menuScene));


        insertGrid.getChildren().addAll(gameDetails, gameID, gameIDInput, gameName, gameTitleInput, playerDetails, playerFirstName, playerFirstNameInput, playerid, playeridInput, playerAddress, playerAddressInput,
                playerPostalCode, playerPostalCodeInput, playerProvince, playerProvinceInput, playerPhoneNumber, playerPhoneNumberInput, playerNGame, playerNGameID, playerNGameIDInput, playingDate, playingDateInput,
                playerScore, playerScoreInput, insertPlayer, btnCancelInsert);

        insertScene = new Scene(insertGrid, 800, 800);


        //Player ID Scene

        playerIDGrid = new GridPane();
        playerIDGrid.setPadding(new Insets(10, 10, 10, 10));
        playerIDGrid.setVgap(8);
        playerIDGrid.setHgap(10);


        //Player ID
        Label UpdateplayerID = new Label("Enter Player ID to Update: ");
        GridPane.setConstraints(UpdateplayerID, 1, 2);


        //Player ID Input
        TextField playerIDInput = new TextField();
        GridPane.setConstraints(playerIDInput, 1, 3);

        Button btnUpdatePlayerID = new Button("Click to Update");
        GridPane.setConstraints(btnUpdatePlayerID, 1, 10);
        btnUpdatePlayerID.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    boolean has = hasRecord(playerIDInput.getText());

                    if(has)
                    {
                        window.setScene(updateScene);
                        JOptionPane.showMessageDialog(null,"data exists now u can edit from following");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"data not exists with this provided id try again with differ id");

                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }


            }

            private boolean hasRecord(String id) throws SQLException {

                Connection conn = null;
                try {
                    conn = DriverManager.getConnection("jdbc:sqlite:GamePlayer.db");
                    String sql = "Select 1 from PlayerInfo where PlayerID = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1,id);
                    ResultSet rs = ps.executeQuery();
                    conn.close();
                    return rs.next();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });


        playerIDGrid.getChildren().addAll(UpdateplayerID, playerIDInput, btnUpdatePlayerID);

        playerUpdateScene = new Scene(playerIDGrid, 400, 400);


        //Update Scene

        updateGrid = new GridPane();
        updateGrid.setPadding(new Insets(10, 10, 10, 10));
        updateGrid.setVgap(8);
        updateGrid.setHgap(10);


        //Player Details
        Label updatePlayerDetails = new Label("Update Player Details: ");
        GridPane.setConstraints(updatePlayerDetails, 0, 2);

        //Player Name
        Label uplayerFirstName = new Label("Enter the Player  Name: ");
        GridPane.setConstraints(uplayerFirstName, 0, 3);

        //Player Name Input
        TextField uplayerFirstNameInput = new TextField();
        GridPane.setConstraints(uplayerFirstNameInput, 1, 3);

        //Player Address
        Label uplayerAddress = new Label("Enter the Address: ");
        GridPane.setConstraints(uplayerAddress, 0, 5);

        //Player Address Input
        TextField uplayerAddressInput = new TextField();
        GridPane.setConstraints(uplayerAddressInput, 1, 5);

        //Player Postal code
        Label uplayerPostalCode = new Label("Enter the Postal code: ");
        GridPane.setConstraints(uplayerPostalCode, 0, 6);

        //Player Name Input
        TextField uplayerPostalCodeInput = new TextField();
        GridPane.setConstraints(uplayerPostalCodeInput, 1, 6);

        //Player Province
        Label uplayerProvince = new Label("Enter the Province Name: ");
        GridPane.setConstraints(uplayerProvince, 0, 7);

        //Player province Input
        TextField uplayerProvinceInput = new TextField();
        GridPane.setConstraints(uplayerProvinceInput, 1, 7);

        //Phone number
        Label uplayerPhoneNumber = new Label("Enter the Player Phone Number: ");
        GridPane.setConstraints(uplayerPhoneNumber, 0, 8);

        //Phone number Input
        TextField uplayerPhoneNumberInput = new TextField();
        GridPane.setConstraints(uplayerPhoneNumberInput, 1, 8);


        //Game Details
        Label updateGameDetails = new Label("Update Game Details: ");
        GridPane.setConstraints(updateGameDetails, 0, 9);


        //Game Title
        Label uGameTitle = new Label("Enter the Game Title: ");
        GridPane.setConstraints(uGameTitle, 0, 10);

        //Game Title Input
        TextField uGameTitleInput = new TextField();
        GridPane.setConstraints(uGameTitleInput, 1, 10);


        //Game and Player Details
        Label updateGameNPlayerDetails = new Label("Update Game and Player Details: ");
        GridPane.setConstraints(updateGameNPlayerDetails, 0, 11);

        //Score
        Label uScore = new Label("Enter the Player Score: ");
        GridPane.setConstraints(uScore, 0, 12);

        //Score Input
        TextField uScoreInput = new TextField();
        GridPane.setConstraints(uScoreInput, 1, 12);

        //Playing Date
        Label uPlayingDate = new Label("Enter the Player Date: ");
        GridPane.setConstraints(uPlayingDate, 0, 13);

        //Playing Date Input
        TextField uPlayingDateInput = new TextField();
        GridPane.setConstraints(uPlayingDateInput, 1, 13);


        Button updatePlayer = new Button("Update Player");
        GridPane.setConstraints(updatePlayer, 1, 14);
        updatePlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    boolean isUpdated = updateTableData(uplayerFirstNameInput.getText() , uplayerAddressInput.getText()
                            ,uplayerPostalCodeInput.getText() , uplayerProvinceInput.getText() , uplayerPhoneNumberInput.getText()
                            ,uGameTitleInput.getText() , uPlayingDateInput.getText() , uScoreInput.getText() , playerIDInput.getText());

                    if(isUpdated)
                    {
                        window.setScene(menuScene);
                        JOptionPane.showMessageDialog(null," Data is updated");

                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }


            private boolean updateTableData( String updatePlayerNameField , String updateAddressField
                    ,String updatePostalCodeField ,String updateProvienceField ,  String updatePhonNUmberField
                    ,String updateGameTitleField , String updatePlayingDate ,String updateScoreField , String playerId) throws SQLException {
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://PR-COMMONS-28\\ACL (CENCOL\\300989777).example.com:1433;database=COMP228GameDB");
                String sql = "UPDATE PlayerInfo SET "
                        + "PlayerName = ? "
                        + " , Address = ? "
                        + " , Postal_Code = ? "
                        + " , Provice = ? "
                        + " , Phone_Number = ? "
                        + "WHERE PlayerID = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, updatePlayerNameField);
                ps.setString(2, updateAddressField);
                ps.setString(3, updatePostalCodeField);
                ps.setString(4, updateProvienceField);
                ps.setString(5, updatePhonNUmberField);
                ps.setString(6, playerId );
                int r = ps.executeUpdate();
                ps.close();

                String sqlsql = "UPDATE PlayerAndGameInfo SET "
                        + "Score = ? "
                        + ", PlayingDate = ? "
                        + "WHERE PlayerID = ?";
                PreparedStatement ps2 = conn.prepareStatement(sqlsql);
                ps2.setString(1, updateScoreField);
                ps2.setString(2, updatePlayingDate);
                ps2.setString(3,playerId );
                int rr = ps2.executeUpdate();
                ps2.close();

                String sqlgameId = "Select GameID from PlayerAndGameInfo where PlayerID = ?";
                PreparedStatement psGame = conn.prepareStatement(sqlgameId);
                psGame.setString(1,playerId );
                ResultSet regameID = psGame.executeQuery();



                String sqlsqlsql = "UPDATE GameInfo SET "
                        + "GameTitle = ? "
                        + "WHERE GameID = ?";
                PreparedStatement pss = conn.prepareStatement(sqlsqlsql);
                pss.setString(1, updateGameTitleField);
                pss.setString(2, regameID.toString());
                int rrr = pss.executeUpdate();
                pss.close();

                conn.close();
                return true;


            }


        });


        Button btnCancelUpdate = new Button("Cancel");
        GridPane.setConstraints(btnCancelUpdate, 1, 15);
        btnCancelUpdate.setOnAction(e -> window.setScene(menuScene));


        updateGrid.getChildren().addAll(updatePlayerDetails, uplayerFirstName, uplayerFirstNameInput, uplayerAddress, uplayerAddressInput, uplayerPostalCode, uplayerPostalCodeInput,
                uplayerProvince, uplayerProvinceInput, uplayerPhoneNumber, uplayerPhoneNumberInput,updateGameDetails,uGameTitle,uGameTitleInput,updateGameNPlayerDetails,uScore,uScoreInput,
                uPlayingDate,uPlayingDateInput, updatePlayer, btnCancelUpdate);

        updateScene = new Scene(updateGrid, 600, 600);



        //Display

        displayGrid = new GridPane();
        displayGrid.setPadding(new Insets(10, 10, 10, 10));
        displayGrid.setVgap(8);
        displayGrid.setHgap(10);



        final ObservableList<Game> data = FXCollections.observableArrayList();

        TableColumn<Game, String> col1 = new TableColumn<>("Player Name");
        col1.setMinWidth(200);

        TableColumn<Game, Integer> col2 = new TableColumn<>("Player ID");
        col2.setMinWidth(200);

        TableColumn<Game, String> col3 = new TableColumn<>("Player Address");
        col3.setMinWidth(200);

        TableColumn<Game, String> col4 = new TableColumn<>("Postal Code");
        col4.setMinWidth(200);

        TableColumn<Game, String> col5 = new TableColumn<>("Province");
        col5.setMinWidth(200);

        TableColumn<Game, String> col6 = new TableColumn<>("Phone Number");
        col6.setMinWidth(200);

        TableColumn<Game, String> col7 = new TableColumn<>("Playing Date");
        col7.setMinWidth(200);

        TableColumn<Game, Integer> col8 = new TableColumn<>("Game ID");
        col8.setMinWidth(200);

        TableColumn<Game, Double> col9 = new TableColumn<>("Score");
        col9.setMinWidth(200);

        TableColumn<Game, Integer> col10 = new TableColumn<>("Player and Game ID");
        col10.setMinWidth(200);

        TableColumn<Game, String> col11 = new TableColumn<>("Game Title");
        col11.setMinWidth(200);

        table.getColumns().addAll(col1,col2,col3,col4,col5,col6,col7,col8,col9,col10,col11);

        Connection conn = DriverManager.getConnection("jdbc:sqlite:GamePlayer.db");
        Statement st = conn.createStatement();
        PreparedStatement pstt;
        String sql="SELECT * from PlayerInfo" +
                " INNER join PlayerAndGameInfo on PlayerInfo.PlayerID = PlayerAndGameInfo.PlayerID" +
                " INNER JOIN GameInfo on GameInfo.GameID = PlayerAndGameInfo.GameID";
        ResultSet rs = st.executeQuery(sql);

       /* while(rs.next())
        {
            data.add(new Game(rs.getString()));

            table.setItems(data);

        }*/

        st.close();
        conn.close();

        displayGrid.getChildren().addAll(table);

        displayScene = new Scene(displayGrid, 600, 600);


        window.setScene(menuScene);
        window.show();

    }

}