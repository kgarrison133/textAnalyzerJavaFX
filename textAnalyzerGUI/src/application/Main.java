package application;
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Date: 1 Nov 2022
 * This is a project that counts the word occurrence of a poem
 * @author Garrison
 * @version 1.0
 *
 */

public class Main extends Application {
	/**
	 * 
	 * This method scrapes words from a poem and returns words and its occurrences in sorted order
	 * @throws IOException
	 */

	@Override
	public void start(Stage stage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) throws IOException, Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/textanalyzedb", "root", "12341234");

        Statement sta = con.createStatement();

        ResultSet rs = sta.executeQuery("select * from word");

        while(rs.next()) {
            System.out.println(rs.getString("word") + ": " + rs.getString("frequency"));
        }

	launch(args);
	
	
}


	public static List<Map.Entry<String, Integer>> scrapeWeb() throws IOException {
//		Scrape from the website
		Document doc = Jsoup.connect("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm").timeout(6000).get();
		
		
		// Remove the special characters and HTML tags. Also convert to lower case letters
		String  poet = doc.select(".chapter").text().toLowerCase();
		poet = removeSp(poet);
		
		
		//Create HashMap which stores the words and their frequency 
		Map<String, Integer> wordFreq = new HashMap<>();
		
		int freq = 0;
		
		for (String word: poet.split(" ")) {
			if (wordFreq.containsKey(word)) {
				//retrieve word freq and add by 1
				freq = wordFreq.get(word) + 1;
				//updating the freq count
				wordFreq.put(word, freq);
			
			} else {
				//add word frequency for the hash map
				wordFreq.put(word, 1);
			} 
		}
		
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFreq.entrySet());
		
		Collections.sort(sortedList, new  Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> ent1, Map.Entry<String, Integer> ent2) {
				return ent1.getValue() - ent2.getValue();
				}
		});
		
		int count = 1;
		for (int i = sortedList.size() - 1; i>=sortedList.size() - 20; i--) {
//          String sql = "INSERT INTO word(id, word, frequency) VALUES(" + count + ", '" + sortedList.get(i).getKey() + "', " + sortedList.get(i).getValue() + ");";
//          sta.executeUpdate(sql);
//			System.out.println(count + ". " + sortedList.get(i).getKey() + ": " +  sortedList.get(i).getValue());
			count++;
			
		}
		
		return sortedList;

	}
	
	/**
	 * This method removes special characters
	 * @param s String value of poem with special characters
	 * @return String value without special characters
	 */
	public static String removeSp(String s) {
		
		return s.replaceAll("[^a-zA-Z0-9 ]", "");
	}
}