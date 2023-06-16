/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipCalc;

 import java.math.BigDecimal;
 import java.math.RoundingMode;
 import java.text.NumberFormat;
 import javafx.beans.value.ChangeListener;
 import javafx.beans.value.ObservableValue;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.scene.control.Label;
 import javafx.scene.control.Slider;
 import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Gautam
 */
public class TipCalculatorController {
 // formatters for currency and percentages
 private static final NumberFormat currency =
 NumberFormat.getCurrencyInstance();
 private static final NumberFormat percent =
 NumberFormat.getPercentInstance();

 private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default

 // GUI controls defined in FXML and used by the controller's code
 @FXML
 private TextField amountTextField;

 @FXML
 private Label tipPercentageLabel;

 @FXML
 private Slider tipPercentageSlider;

 @FXML
 private TextField tipTextField;

 @FXML
 private TextField totalTextField;
 @FXML
 private TextField totalPersons;
 @FXML
 private TextField individualAmount;
 
 @FXML
 private void ButtonEvent(ActionEvent event) {
 try {
 BigDecimal people = new BigDecimal(totalPersons.getText());
 BigDecimal amount = new BigDecimal(amountTextField.getText());
 BigDecimal tip = amount.multiply(tipPercentage);
 BigDecimal total = amount.add(tip);
BigDecimal individual = total.divide(people);
 tipTextField.setText(currency.format(tip));
 totalTextField.setText(currency.format(total));
 individualAmount.setText(currency.format(individual));
 }
 catch (NumberFormatException ex) {
 amountTextField.setText("Enter amount");
 amountTextField.selectAll();
 amountTextField.requestFocus();
 }
 }
 public void initialize() {
 // 0-4 rounds down, 5-9 rounds up
 currency.setRoundingMode(RoundingMode.HALF_UP);

 // listener for changes to tipPercentageSlider's value
 tipPercentageSlider.valueProperty().addListener(
 new ChangeListener<Number>() {
 @Override
 public void changed(ObservableValue<? extends Number> ov,
 Number oldValue, Number newValue) {
 tipPercentage =
 BigDecimal.valueOf(newValue.intValue() / 100.0);
 tipPercentageLabel.setText(percent.format(tipPercentage));
}
});
         }
}

