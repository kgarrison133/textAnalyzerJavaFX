package application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

public class SceneController{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
//	try {
//		public List<Map.Entry<String, Integer>> sortedList = Main.scrapeWeb(); 
//
//	}catch (IOException e) {
//		System.out.println("Error");
//	}
//
//	
//
//	    @FXML
//	    private TableColumn<WordFreq, Integer> frequency;
//
//	    @FXML
//	    private TableColumn<WordFreq, Integer> ranking;
//
//	    @FXML
//	    private TableColumn<WordFreq, String> word;
//
//	    @FXML
//	    private TableView<WordFreq> wordFreq;
//	    
//	    ObservableList<WordFreq> list = FXCollections.observableArrayList(
//	    		new WordFreq(1, sortedList.get(sortedList.size() - 1).getKey(), sortedList.get(sortedList.size() - 1).getValue())
//);
////	    		int count = 1;
////
////	    		for (int i = sortedList.size() - 1; i>=sortedList.size() - 20; i--) {
////	    			new WordFreq(count,  sortedList.get(i).getKey(), sortedList.get(i).getValue()),
////	    			//System.out.println(count + ". " + sortedList.get(i).getKey() + ": " +  sortedList.get(i).getValue());
////	    			count++;
////	    		}
//
//	    
//	    
//	    @Override
//	    public void initialize(URL url, ResourceBundle resourceBundle) {
//	    	frequency.setCellValueFactory(new PropertyValueFactory<WordFreq, Integer>("frequency"));
//	    	ranking.setCellValueFactory(new PropertyValueFactory<WordFreq, Integer>("ranking"));
//	    	word.setCellValueFactory(new PropertyValueFactory<WordFreq, String>("word"));
//	    	
//	    	wordFreq.setItems(list);
//	    }


	
	public void switchToHome(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToResult(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Result.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
