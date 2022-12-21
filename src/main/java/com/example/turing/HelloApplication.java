package com.example.turing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 420, 550);
        stage.setTitle("Машина Тьюринга");
        stage.setScene(scene);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 0, 0, 25));

        Button btn_1 = new Button("Инструкция");
        HBox hbBtn_1 = new HBox(20);
        hbBtn_1.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn_1.getChildren().add(btn_1);
        grid.add(hbBtn_1, 0, 4);

        Text scenetitle = new Text("Симулятор машины Тьюринга");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scenetitle.setTextAlignment(TextAlignment.CENTER);
        grid.add(scenetitle, 0, 0);

        TextField InputStr = new TextField();
        InputStr.setPromptText("Введите строку");
        InputStr.setPrefColumnCount(30);
        grid.add(InputStr, 0, 1,2,1);

        TextArea Task = new TextArea();
        Task.setPromptText("Введите условие\n");
        Task.setPrefColumnCount(30);
        Task.setPrefRowCount(20);
        grid.add(Task,0,2,2,2);

        TextField Result = new TextField();
        Result.setPromptText("Результат работы...");
        grid.add(Result,0,5,2,5);

        Button btn = new Button("Старт");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        btn.setOnAction(value->{
            String input="";
            input=InputStr.getText();
            //System.out.println(input);
            String task="";
            task=Task.getText();
            String output="";
            if(!input.isEmpty()&&!task.isEmpty()&&Check.check_input(input))
            {
                try {
                    Solve solve = new Solve(input,task);
                    solve.start();
                    output = solve.get_output();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Result.setText(output);
            }
            else
                if(!Check.check_input(input))
                    Result.setText("Проверьте правильность введенной строки");
                else
                    Result.setText("Введите условие и входную строку");
        });
        btn_1.setOnAction(value->{
            Stage ins = new Stage();
            GridPane r = new GridPane();
            Text instruction = new Text();
            String s=File.read();
            instruction.setText(s);
            Scene sc = new Scene(r,800,300);
            ins.setTitle("Инструкция");
            ins.setScene(sc);
            r.add(instruction,1,1);
            ins.show();
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}