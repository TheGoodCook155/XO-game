package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    @FXML
    private Pane pane;
    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    @FXML
    private Text text4;
    @FXML
    private Text text5;
    @FXML
    private Text text6;
    @FXML
    private Text text7;
    @FXML
    private Text text8;
    @FXML
    private Text text9;

    @FXML
    private Rectangle rect1;
    @FXML
    private Rectangle rect2;
    @FXML
    private Rectangle rect3;
    @FXML
    private Rectangle rect4;
    @FXML
    private Rectangle rect5;
    @FXML
    private Rectangle rect6;
    @FXML
    private Rectangle rect7;
    @FXML
    private Rectangle rect8;
    @FXML
    private Rectangle rect9;

    Button button;

    private boolean xTurn = true;


//
//        /*
//        1t 2t 3t
//        5t 4t 6t
//        7t 9t 8t
//         */
//

    public void mousePress(MouseEvent mouseEvent) {
        Text text = (Text) mouseEvent.getSource();
        text.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (xTurn) {
                    text.setText("X");
                    text.setDisable(true);
                    text.setTextAlignment(TextAlignment.CENTER);
                    xTurn = false;
                    checkState();
                    if (checkState() == true) {
                        try {
                            endGame();
                        } catch (InterruptedException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    return;
                }
            } else if (event.getButton().equals(MouseButton.SECONDARY)) {
                if (!xTurn) {
                    text.setText("O");
                    text.setDisable(true);
                    text.setTextAlignment(TextAlignment.CENTER);
                    xTurn = true;
                    checkState();
                    if (checkState() == true) {
                        try {
                            endGame();
                        } catch (InterruptedException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    return;
                }
            }
        });
    }



    public void endGame() throws InterruptedException, IOException {
        button = new Button("Restart Game?");
        button.setFont(Font.font(30));
        button.setLayoutX(185);
        button.setLayoutY(250);
        pane.getChildren().add(button);

        button.setOnMouseClicked(event -> {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            //get the stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        });

        text1.setDisable(true);
        text2.setDisable(true);
        text3.setDisable(true);
        text4.setDisable(true);
        text5.setDisable(true);
        text6.setDisable(true);
        text7.setDisable(true);
        text8.setDisable(true);
        text9.setDisable(true);

    }




    public  boolean checkState() {

        /*
        1R 2R 3R
        4R 5R 6R
        7R 8R 9R
         */

                /*
        1t 2t 3t 0,1,2
        5t 4t 6t 3,4,5
        7t 9t 8t 6,7,8
         */

        System.out.println("Checked state runs");
        boolean gameOver = false;

//        //1t
//        //1t horizontal
        if (text1.getText().isEmpty() == false && text2.getText().isEmpty() == false && text3.getText().isEmpty() == false) {
            if (text1.getText().equals(text2.getText()) && text1.getText().equals(text3.getText())) {
                rect1.setFill(Color.RED);
                rect2.setFill(Color.RED);
                rect3.setFill(Color.RED);
                System.out.println("Game over 1H" + gameOver);
                gameOver = true;
            }
        }
        //1t vertical
        if (text1.getText().isEmpty() == false && text5.getText().isEmpty() == false && text7.getText().isEmpty() == false) {
            if (text1.getText().equals(text5.getText()) && text1.getText().equals(text7.getText())) {
                rect1.setFill(Color.RED);
                rect4.setFill(Color.RED);
                rect7.setFill(Color.RED);
                System.out.println("Game over 1V" + gameOver);
                gameOver = true;
            }
        }
        //1t diagonal
        if (text1.getText().isEmpty() == false && text4.getText().isEmpty() == false && text8.getText().isEmpty() == false) {
            if (text1.getText().equals(text4.getText()) && text1.getText().equals(text8.getText())) {
                rect1.setFill(Color.RED);
                rect5.setFill(Color.RED);
                rect9.setFill(Color.RED);
                System.out.println("Game over 1D" + gameOver);
                gameOver = true;
            }
        }
        //2t vertical
        if (text2.getText().isEmpty() == false && text4.getText().isEmpty() == false && text9.getText().isEmpty() == false) {
            if (text2.getText().equals(text4.getText()) && text2.getText().equals(text9.getText())) {
                rect2.setFill(Color.RED);
                rect5.setFill(Color.RED);
                rect8.setFill(Color.RED);
                System.out.println("Game over 2V" + gameOver);
                gameOver = true;
            }
        }

        //vertical
        if (text3.getText().isEmpty() == false && text6.getText().isEmpty() == false && text8.getText().isEmpty() == false) {
            if (text3.getText().equals(text6.getText()) && text3.getText().equals(text8.getText())) {
                rect3.setFill(Color.RED);
                rect6.setFill(Color.RED);
                rect9.setFill(Color.RED);
                System.out.println("Game over 3V" + gameOver);
                gameOver = true;
            }
        }

        //diagonal
        if (text3.getText().isEmpty() == false && text4.getText().isEmpty() == false && text7.getText().isEmpty() == false) {
            if (text3.getText().equals(text4.getText()) && text3.getText().equals(text7.getText())) {
                rect3.setFill(Color.RED);
                rect5.setFill(Color.RED);
                rect7.setFill(Color.RED);
                System.out.println("Game over 3D" + gameOver);
                gameOver = true;
            }
        }
        //horizontal
        if (text5.getText().isEmpty() == false && text4.getText().isEmpty() == false && text6.getText().isEmpty() == false) {
            if (text5.getText().equals(text4.getText()) && text5.getText().equals(text6.getText())) {
                rect4.setFill(Color.RED);
                rect5.setFill(Color.RED);
                rect6.setFill(Color.RED);
                System.out.println("Game over 5H" + gameOver);
                gameOver = true;
            }
        }

       //horizontal
        if (text4.getText().isEmpty() == false && text5.getText().isEmpty() == false && text6.getText().isEmpty() == false) {
            if (text4.getText().equals(text5.getText()) && text4.getText().equals(text6.getText())) {
                rect4.setFill(Color.RED);
                rect5.setFill(Color.RED);
                rect6.setFill(Color.RED);
                System.out.println("Game over 6H" + gameOver);
                gameOver = true;
            }
        }


       //vertical
        if (text4.getText().isEmpty() == false && text2.getText().isEmpty() == false && text9.getText().isEmpty() == false) {
            if (text4.getText().equals(text2.getText()) && text4.getText().equals(text9.getText())) {
                rect2.setFill(Color.RED);
                rect5.setFill(Color.RED);
                rect8.setFill(Color.RED);
                System.out.println("Game over 4V" + gameOver);
                gameOver = true;
            }
        }

        //horizontal
        if (text7.getText().isEmpty() == false && text9.getText().isEmpty() == false && text8.getText().isEmpty() == false) {
            if (text7.getText().equals(text9.getText()) && text7.getText().equals(text8.getText())) {
                rect7.setFill(Color.RED);
                rect8.setFill(Color.RED);
                rect9.setFill(Color.RED);
                System.out.println("Game over 7H" + gameOver);
                gameOver = true;
            }
        }

        //vertical
        if (text9.getText().isEmpty() == false && text4.getText().isEmpty() == false && text2.getText().isEmpty() == false) {
            if (text9.getText().equals(text2.getText()) && text9.getText().equals(text4.getText())) {
                rect2.setFill(Color.RED);
                rect5.setFill(Color.RED);
                rect8.setFill(Color.RED);
                System.out.println("Game over 9V" + gameOver);
                gameOver = true;
            }
        }

       //hotizontal
        if (text8.getText().isEmpty() == false && text9.getText().isEmpty() == false && text7.getText().isEmpty() == false) {
            if (text8.getText().equals(text7.getText()) && text8.getText().equals(text9.getText())) {
                rect7.setFill(Color.RED);
                rect8.setFill(Color.RED);
                rect9.setFill(Color.RED);
                System.out.println("Game over 8H" + gameOver);
                gameOver = true;
            }
        }
        //vertical
        if (text8.getText().isEmpty() == false && text6.getText().isEmpty() == false && text3.getText().isEmpty() == false) {
            if (text8.getText().equals(text6.getText()) && text8.getText().equals(text3.getText())) {
                rect3.setFill(Color.RED);
                rect6.setFill(Color.RED);
                rect9.setFill(Color.RED);
                System.out.println("Game over 8V" + gameOver);
                gameOver = true;
            }
        }

        //diagonal
        if (text8.getText().isEmpty() == false && text4.getText().isEmpty() == false && text1.getText().isEmpty() == false) {
            if (text8.getText().equals(text4.getText()) && text8.getText().equals(text1.getText())) {
                rect1.setFill(Color.RED);
                rect5.setFill(Color.RED);
                rect9.setFill(Color.RED);
                System.out.println("Game over 8D" + gameOver);
                gameOver = true;
            }
        }
        return gameOver;
    }
}


