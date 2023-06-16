/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipCalc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Gautam
 */
public class TipCalculator extends Application {
    @Override
 public void start(Stage stage) throws Exception{
 Parent root =
 FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));

 Scene scene = new Scene(root); // attach scene graph to scene
 stage.setTitle("Tip Calculator"); // displayed in window's title bar
 stage.setScene(scene); // attach scene to stage
 stage.show(); // display
 }
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      launch(args);
  }
  
}
