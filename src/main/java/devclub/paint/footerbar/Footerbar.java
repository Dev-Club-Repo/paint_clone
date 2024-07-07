package devclub.paint.footerbar;

import devclub.paint.enums.Operation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

import static devclub.paint.enums.Operation.*;

public class Footerbar {

    private static final int MAX_VALUE_SLIDER = 800;
    private static final int MIN_VALUE_SLIDER = 10;
    private static final int BREAKPOINT_ZOOMBUTTON = 200;

    @FXML
    public ComboBox<String> dropDownMenu;

    private final String[] dropDownValues = new String[]{"800", "700", "600", "500", "400", "300", "200", "100", "75", "50", "25"};

    @FXML
    public Slider zoomSlider;

    @FXML
    public Button zoomInButton;

    @FXML
    public Button zoomOutButton;

    @FXML
    public HBox saveBox;

    @FXML
    protected void initialize() {
        addDropDownMenuItems();
        configureDropdown();
        configureSlider();
        configureButtons();

        saveBox.visibleProperty().setValue(false);
    }

    private void addDropDownMenuItems() {
        for (String num : dropDownValues) {
            dropDownMenu.getItems().add(num + " %");
        }
    }

    private void setCurrentZoom(double value) {
        if( MIN_VALUE_SLIDER > value ) {
            value =  MIN_VALUE_SLIDER;
        } else if (value > MAX_VALUE_SLIDER){
            value = MAX_VALUE_SLIDER;
        }
            zoomSlider.valueProperty().set(value);
            dropDownMenu.setValue(String.format("%.0f", value) + " %");
    }

    private void configureSlider() {
        zoomSlider.valueProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                setCurrentZoom((Double) t1);
            }
        });

        zoomSlider.setMax(MAX_VALUE_SLIDER);
        zoomSlider.setMin(MIN_VALUE_SLIDER);
        zoomSlider.setValue(100);
    }

    private void configureDropdown(){
        dropDownMenu.valueProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try {
                    double zoomValue = Double.parseDouble(t1.replace("%", "").trim());
                    setCurrentZoom(zoomValue);

                } catch (NullPointerException | NumberFormatException ignored){
                    if (s != null) {
                        setCurrentZoom(Double.parseDouble(s.replace(" %", "").trim()));
                        return;
                    }
                        setCurrentZoom(Double.parseDouble("100"));
                }
            }
        });
    }

    private void configureButtons(){
        zoomInButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setCurrentZoom(zoomSlider.getValue() + zoomOperation(INCREMENT));
            }
        });

        zoomOutButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setCurrentZoom(zoomSlider.getValue() - zoomOperation(DECREMENT));
            }
        });
    }

    private double zoomOperation(Operation operation){
        double currentZoomValue = zoomSlider.getValue();
        int modulo = 10;

        if (currentZoomValue >= BREAKPOINT_ZOOMBUTTON){
            modulo = 25;
        }

        switch (operation) {
            case INCREMENT:
                return modulo - (currentZoomValue % modulo);

            case DECREMENT:
                if (currentZoomValue == BREAKPOINT_ZOOMBUTTON){
                    modulo = 10;
                }

                if( currentZoomValue % modulo != 0){
                    return (currentZoomValue % modulo);
                }

            default:
                return modulo;
        }
    }
}
