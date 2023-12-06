import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BurgerStoreApp extends Application {                 
    private BurgerStore burgerStore;
    //Scene scene1.scene2;

    @Override
    public void start(Stage primaryStage) {
        burgerStore = new BurgerStore();

        primaryStage.setTitle("Burger Store");

        GridPane grid = createLoginForm();

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        

        primaryStage.show();
    }
    
   public GridPane storeMenu() {
      GridPane grid = new GridPane();
      grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

      
      Label itemsLabel = new Label ("Items:");
      grid.add(itemsLabel, 0,1);
    
      TextField menu = new TextField();
      grid.add(itemsLabel, 0, 1);
      
      return grid;
      }
    

    private GridPane createLoginForm() {
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 1);

        TextField usernameField = new TextField();
        grid.add(usernameField, 1, 1);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 3);

        Label messageLabel = new Label();
        grid.add(messageLabel, 1, 4);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (burgerStore.validateUser(username, password)) {
                //messageLabel.setText("Login successful!");
               
                Scene menuScene = new Scene (storeMenu(), 600, 400);
                storeMenu();
                
               
                
            } else {
                messageLabel.setText("Invalid username or password. Please try again.");
                usernameField.clear();
                passwordField.clear();
            }
        });

        return grid; //used gpt for this cos i didnt know why the grid wasnt showing
    }

    public static void main(String[] args) {
        launch(args);
    }
}
