import javax.swing.*;
import java.awt.*;

public class TF 
{
    public static void main(String[]args)
    {
        loadHome();
    }

    public static void loadHome()
    {
        //Frame
        JFrame home = new JFrame("Trabalho Final");
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setSize(500, 500);
        
        //Top Panel
        JPanel top = new JPanel();
        JLabel head = new JLabel("Home");
        top.add(head);
        
        //Bottom Panel
        JPanel bottom = new JPanel();
        JLabel quant_dinos = new JLabel(App.dinoRatio());
        bottom.add(quant_dinos);

        //Center Panel
        JPanel middle = new JPanel();
        middle.setLayout(null);
        //Add Dinossauro        
        JButton addDino = new JButton("Add Dinosaur");
        addDino.setBounds(150, 10, 200, 25);
        addDino.addActionListener(e -> {home.setVisible(false); loadAddDino();});
        middle.add(addDino);
        //Remove Dinossauro
        JButton remDino = new JButton("Remove Dinosaur");
        remDino.setBounds(150, 45, 200, 25);
        remDino.addActionListener(e -> {home.setVisible(false); loadRemoveDino();});
        middle.add(remDino);
        //Added Dinosaurs
        JButton cadDino = new JButton("Added Dinosaurs");
        cadDino.setBounds(150, 80, 200, 25);
        cadDino.addActionListener(e -> {home.setVisible(false); loadCadastrados();});
        middle.add(cadDino);
        //Relatorio1
        JButton type_cat = new JButton("Quantity by Type and Category");
        type_cat.setBounds(125, 115, 250, 25);
        type_cat.addActionListener(e -> {home.setVisible(false); loadRelatorio1();});
        middle.add(type_cat);
        //Relatorio2
        JButton heavy_weight = new JButton("Heavy Weight");
        heavy_weight.setBounds(150, 150, 200, 25);
        heavy_weight.addActionListener(e -> {home.setVisible(false); loadRelatorio2();});
        middle.add(heavy_weight);
        //Relatorio3
        JButton food_quant = new JButton("Food Quantity");
        food_quant.setBounds(150, 185, 200, 25);
        food_quant.addActionListener(e -> loadFoodQuant());
        middle.add(food_quant);
        //Relatorio4
        JButton escape = new JButton("Escape from Dinosaur");
        escape.setBounds(150, 220, 200, 25);
        escape.addActionListener(e -> {loadEscape(); home.setVisible(false);;});
        middle.add(escape);
        //Relatorio5
        JButton danger = new JButton("Danger Zone");
        danger.setBounds(150, 255, 200, 25);
        danger.addActionListener(e -> loadDanger());
        middle.add(danger);
        //Relatorio6
        JButton vowels = new JButton("Most Vowels");
        vowels.setBounds(150, 290, 200, 25);
        vowels.addActionListener(e -> loadVowel());
        middle.add(vowels);

        //Add to Frame
        home.getContentPane().add(BorderLayout.SOUTH, bottom);
        home.getContentPane().add(BorderLayout.NORTH, top);
        home.getContentPane().add(middle);
        home.setVisible(true);
    }

    public static void loadAddDino()
    {
        //Frame
        JFrame add_dino = new JFrame("Trabalho Final");
        add_dino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add_dino.setSize(500, 500);
        
        //Top Panel
        JPanel top = new JPanel();
        JLabel head = new JLabel("Add Dinosaur");
        top.add(head);
    
        //Bottom Panel
        JPanel bottom = new JPanel();
        JButton back = new JButton("Return");
        back.addActionListener(e -> {add_dino.setVisible(false); loadHome();});
        bottom.add(back);

        //Center Panel
        JPanel middle = new JPanel();  
        middle.setLayout(null); 
        //ID
        JLabel id = new JLabel("ID:");
        id.setBounds(170, 25, 70, 25);
        Choice id_insert = new Choice();
        id_insert.setBounds(250, 25, 100, 25);
        for(int i = 1; i <= App.lengthCadDinos(); i++){
            id_insert.add(String.valueOf(i));
        }
        middle.add(id);
        middle.add(id_insert);
        //Race
        JLabel race = new JLabel("Race:");
        race.setBounds(170, 60, 70, 25);
        JTextField race_insert = new JTextField("race", 10);
        race_insert.setBounds(250, 60, 100, 25);
        middle.add(race);
        middle.add(race_insert);
        //Tipo
        JLabel type = new JLabel("Type:");
        type.setBounds(170, 95, 70, 25);
        Choice type_choice = new Choice();
        type_choice.setBounds(250, 95, 100, 25);
        type_choice.add("1");
        type_choice.add("2");
        middle.add(type);
        middle.add(type_choice);
        //Category
        JLabel category = new JLabel("Category:");
        category.setBounds(170, 130, 70, 25);
        Choice cat_choice = new Choice();
        cat_choice.setBounds(250, 130, 100, 25);
        for(int i = 1; i <= 3; i++){
            cat_choice.add(String.valueOf(i));
        }
        middle.add(category);
        middle.add(cat_choice);
        //Weight
        JLabel weight = new JLabel("Weight:");
        weight.setBounds(170, 165, 70, 25);
        JTextField weight_insert = new JTextField("0", 10);
        weight_insert.setBounds(250, 165, 100, 25);
        middle.add(weight);
        middle.add(weight_insert);
        //Zoo Position
        JLabel positionX = new JLabel("X Position:");
        positionX.setBounds(170, 200, 70, 25);
        Choice x_insert = new Choice();
        x_insert.setBounds(250, 200, 100, 25);
        JLabel positionY = new JLabel("Y Position:");
        positionY.setBounds(170, 235, 70, 25);
        Choice y_insert = new Choice();
        y_insert.setBounds(250, 235, 100, 25);
        for(int i = 1; i <= 150; i++){
            x_insert.add(String.valueOf(i));
            y_insert.add(String.valueOf(i));            
        }
        middle.add(positionX);
        middle.add(x_insert);
        middle.add(positionY);
        middle.add(y_insert);

        //Add button
        JButton add = new JButton("Add");
        add.setBounds(210, 295, 80, 25);
        add.addActionListener(e -> App.add(id_insert.getSelectedItem(),
                                           race_insert.getText(), 
                                           type_choice.getSelectedItem(),
                                           cat_choice.getSelectedItem(),
                                           weight_insert.getText(),
                                           x_insert.getSelectedItem(),
                                           y_insert.getSelectedItem()));
        middle.add(add);
        
        //Add to Frame
        add_dino.getContentPane().add(BorderLayout.PAGE_END, bottom);
        add_dino.getContentPane().add(BorderLayout.PAGE_START, top);
        add_dino.getContentPane().add(middle);
        add_dino.setVisible(true);
    }

    public static void loadRemoveDino()
    {
        //Frame
        JFrame rem_dino = new JFrame("Trabalho Final");
        rem_dino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rem_dino.setSize(500, 500);
        
        //Top Panel
        JPanel top = new JPanel();
        JLabel head = new JLabel("Remove Dinosaur");
        top.add(head);
        
        //Bottom Panel
        JPanel bottom = new JPanel();
        JButton back = new JButton("Return");
        back.addActionListener(e -> {rem_dino.setVisible(false); loadHome();});
        bottom.add(back);

        //Center Panel
        JPanel middle = new JPanel();  
        middle.setLayout(null); 
        //ID
        JLabel id = new JLabel("ID:");
        id.setBounds(180, 70, 25, 25);
        Choice id_insert = new Choice();
        id_insert.setBounds(210, 70, 100, 25);
        for(int i = 1; i <= App.lengthCadDinos(); i++){
            id_insert.add(String.valueOf(i));
        }
        middle.add(id);
        middle.add(id_insert);
        //Remove Button
        JButton remove = new JButton("Remove");
        remove.setBounds(195, 140, 100, 25);
        remove.addActionListener(e -> App.rem(id_insert.getSelectedItem()));
        middle.add(remove);
        
        //Add to Frame
        rem_dino.getContentPane().add(BorderLayout.PAGE_END, bottom);
        rem_dino.getContentPane().add(BorderLayout.PAGE_START, top);
        rem_dino.getContentPane().add(middle);
        rem_dino.setVisible(true);
    }

    public static void loadCadastrados()
    {
        //Frame
        JFrame cad = new JFrame("Trabalho Final");
        cad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cad.setSize(500, 500);

        //Top Panel
        JPanel top = new JPanel();
        JLabel head = new JLabel("Dinosaurs Added");
        top.add(head);

        //Bottom Panel
        JPanel bottom = new JPanel();
        JButton back = new JButton("Return");
        back.addActionListener(e -> {cad.setVisible(false); loadHome();});
        bottom.add(back);

        //Center Panel
        Box box = Box.createVerticalBox();
        JPanel middle = new JPanel();
        middle.add(box);
        int quant_dinos = App.quant_dinos();
        if(quant_dinos == 0){
            JLabel label = new JLabel("No Dinosaurs Added");
            box.add(label);
        }
        else{
            for(int i = 0; i < quant_dinos; i++){
                JLabel label = new JLabel(App.dinoString(i));
                box.add(label);
            }
        }

        //Add to Frame
        cad.getContentPane().add(BorderLayout.SOUTH, bottom);
        cad.getContentPane().add(BorderLayout.NORTH, top);
        cad.getContentPane().add(middle);
        cad.setVisible(true);
    }

    public static void loadRelatorio1()
    {
        //Frame
        JFrame rel1 = new JFrame("Trabalho Final");
        rel1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rel1.setSize(500, 500);

        //Top Panel
        JPanel top = new JPanel();
        JLabel head = new JLabel("Dinosaurs by Type and Category");
        top.add(head);

        //Bottom Panel
        JPanel bottom = new JPanel();
        JButton back = new JButton("Return");
        back.addActionListener(e -> {rel1.setVisible(false); loadHome();});
        bottom.add(back);

        //Center Panel
        Box box = Box.createVerticalBox();
        JPanel middle = new JPanel();
        middle.add(box);
        for(int i = 1; i < 3; i++){
            JLabel label = new JLabel(App.typeCategory(i));
            box.add(label);
        }

        //Add to Frame
        rel1.getContentPane().add(BorderLayout.SOUTH, bottom);
        rel1.getContentPane().add(BorderLayout.NORTH, top);
        rel1.getContentPane().add(middle);
        rel1.setVisible(true);
    }

    public static void loadRelatorio2()
    {
        //Frame
        JFrame rel2 = new JFrame("Trabalho Final");
        rel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rel2.setSize(500, 500);

        //Top Panel
        JPanel top = new JPanel();
        JLabel head = new JLabel("Heavy Weight");
        top.add(head);

        //Bottom Panel
        JPanel bottom = new JPanel();
        JButton back = new JButton("Return");
        back.addActionListener(e -> {rel2.setVisible(false); loadHome();});
        bottom.add(back);

        //Center Panel
        JPanel middle = new JPanel();
        middle.setLayout(null);
        //Tipo
        JLabel type = new JLabel("Type:");
        type.setBounds(165, 25, 60, 25);
        Choice type_choice = new Choice();
        type_choice.setBounds(232, 25, 100, 25);
        type_choice.add("1");
        type_choice.add("2");
        middle.add(type);
        middle.add(type_choice);
        //Category
        JLabel category = new JLabel("Category:");
        category.setBounds(165, 60, 60, 25);
        Choice cat_choice = new Choice();
        cat_choice.setBounds(232, 60, 100, 25);
        for(int i = 1; i <= 3; i++){
            cat_choice.add(String.valueOf(i));
        }
        middle.add(category);
        middle.add(cat_choice);
        //Generate Button
        JButton report = new JButton("Generate Report");
        report.setBounds(175, 110, 150, 25);
        report.addActionListener(e -> loadReport2PopUp(type_choice.getSelectedItem(),
                                                       cat_choice.getSelectedItem()));
        middle.add(report);
        
        //Add to Frame
        rel2.getContentPane().add(BorderLayout.PAGE_END, bottom);
        rel2.getContentPane().add(BorderLayout.PAGE_START, top);
        rel2.getContentPane().add(middle);
        rel2.setVisible(true);
    }

    public static void loadReport2PopUp(String a, String b)
    {
        //Frame
        JFrame report = new JFrame("Report");
        report.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        report.setSize(450, 200);

        //Report Header
        JPanel top = new JPanel();
        String str = "Heaviest Dinosaur of Type: " + a + " and Category: " + b;
        JLabel header = new JLabel(str);
        top.add(header);

        //Report Content
        Box box = Box.createVerticalBox();
        JPanel middle = new JPanel();
        middle.add(box);
        Dinossauro[] dino = App.heavyWeight(a, b);
        int index = dino.length;
        int count = 0;
        for(int i = 0; i < index; i++){
            if(dino[i] == null){
                count++;
            }
        }
        if(count == index){
            JLabel label = new JLabel("No Dinosaurs Added");
            box.add(label);
        }
        else{
            for(int i = 0; i < index; i++){
                JLabel label = new JLabel(App.report2(a, b, i));
                box.add(label);
            }
        }
    
        //Button
        JPanel bottom = new JPanel();
        JButton close = new JButton("Close");
        close.addActionListener(e -> report.setVisible(false));
        bottom.add(close);

        //Add to Frame
        report.getContentPane().add(BorderLayout.NORTH, top);
        report.getContentPane().add(BorderLayout.SOUTH, bottom);
        report.getContentPane().add(middle);
        report.setVisible(true);
    }

    public static void loadFoodQuant()
    {
        //Frame
        JFrame food = new JFrame("Report");
        food.setLayout(null);
        food.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        food.setSize(300, 145);

        //Message
        String str = App.food();
        JLabel message = new JLabel(str);
        message.setBounds(75, 25, 175, 25);;
        food.add(message);

        //Button
        JButton ok = new JButton("Close");
        ok.setBounds(100, 65, 100, 25);
        ok.addActionListener(e -> food.setVisible(false));
        food.add(ok);

        //Add to Frame
        food.setVisible(true);
    }

    public static void loadEscape()
    {
        //Frame
        JFrame escape = new JFrame("Trabalho Final");
        escape.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        escape.setSize(500, 500);
        
        //Top Panel
        JPanel top = new JPanel();
        JLabel head = new JLabel("Escape from Dinosaur");
        top.add(head);
    
        //Bottom Panel
        JPanel bottom = new JPanel();
        JButton back = new JButton("Return");
        back.addActionListener(e -> {escape.setVisible(false); loadHome();});
        bottom.add(back);

        //Center Panel
        JPanel middle = new JPanel();  
        middle.setLayout(null); 
        //Distance Dinosaur
        JLabel dist_dino = new JLabel("Distance between Dinosaur and Bunker:");
        dist_dino.setBounds(55, 25, 250, 25);
        JTextField distDino_insert = new JTextField(10);
        distDino_insert.setBounds(315, 25, 100, 25);
        middle.add(dist_dino);
        middle.add(distDino_insert);
        //Distance Human
        JLabel dist_human = new JLabel("Distance between Human and Bunker:");
        dist_human.setBounds(55, 60, 250, 25);
        JTextField distHuman_insert = new JTextField(10);
        distHuman_insert.setBounds(315, 60, 100, 25);
        middle.add(dist_human);
        middle.add(distHuman_insert);
        //Dino Speed
        JLabel speed = new JLabel("Dinosaur Speed:");
        speed.setBounds(55, 95, 250, 25);
        JTextField speed_insert = new JTextField(10);
        speed_insert.setBounds(315, 95, 100, 25);
        middle.add(speed);
        middle.add(speed_insert);
        //Add button
        JButton calc = new JButton("Calculate");
        calc.setBounds(200, 150, 100, 25);
        calc.addActionListener(e -> App.escapeRep(distDino_insert.getText(),
                                                  distHuman_insert.getText(),
                                                  speed_insert.getText()));
        middle.add(calc);
        
        //Add to Frame
        escape.getContentPane().add(BorderLayout.PAGE_END, bottom);
        escape.getContentPane().add(BorderLayout.PAGE_START, top);
        escape.getContentPane().add(middle);
        escape.setVisible(true);
    }

    public static void loadDanger()
    {
        //Frame
        JFrame danger = new JFrame("Report");
        danger.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        danger.setSize(450, 145);

        //Message
        JPanel middle = new JPanel();
        Box box = Box.createVerticalBox();
        middle.add(box);
        JLabel message = new JLabel(App.dangerZone());
        box.add(message);

        //Button
        JPanel bottom = new JPanel();
        JButton ok = new JButton("Close");
        ok.setBounds(175, 70, 100, 25);
        ok.addActionListener(e -> danger.setVisible(false));
        bottom.add(ok);

        //Add to Frame
        danger.getContentPane().add(BorderLayout.PAGE_END, bottom);
        danger.getContentPane().add(middle);
        danger.setVisible(true);
    }

    public static void loadVowel()
    {
        //Frame
        JFrame report = new JFrame("Report");
        report.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        report.setSize(450, 200);

        //Report Header
        JPanel top = new JPanel();
        String str = "Races with the Most Vowels in Alphabetical Order";
        JLabel header = new JLabel(str);
        top.add(header);

        //Report Content
        Box box = Box.createVerticalBox();
        JPanel middle = new JPanel();
        middle.add(box);
        String[] race = App.raceVowel();
        int count = 0;
        for(int i = 0; i < race.length; i++){
            if(race[i] == null){
                count++;
            }
        }
        if(count == race.length){
            JLabel label = new JLabel("No Dinosaurs Added");
            box.add(label);
        }
        else{
            for(int i = 0; i < race.length; i++){
                JLabel label = new JLabel(race[i]);
                box.add(label);
            }
        }
        
        //Button
        JPanel bottom = new JPanel();
        JButton close = new JButton("Close");
        close.addActionListener(e -> report.setVisible(false));
        bottom.add(close);

        //Add to Frame
        report.getContentPane().add(BorderLayout.NORTH, top);
        report.getContentPane().add(BorderLayout.SOUTH, bottom);
        report.getContentPane().add(middle);
        report.setVisible(true);
    }

    public static void loadAddedMessage()
    {
        //Frame
        JFrame added = new JFrame("Success");
        added.setLayout(null);
        added.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        added.setSize(250, 145);

        //Error Message
        JLabel message = new JLabel("Dinosaur Added");
        message.setBounds(75, 25, 125, 25);;
        added.add(message);

        //Button
        JButton ok = new JButton("Okay");
        ok.setBounds(75, 70, 100, 25);
        ok.addActionListener(e -> added.setVisible(false));
        added.add(ok);

        //Add to Frame
        added.setVisible(true);
    }

    public static void loadRemMessage()
    {
        //Frame
        JFrame removed = new JFrame("Success");
        removed.setLayout(null);
        removed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        removed.setSize(250, 145);

        //Error Message
        JLabel message = new JLabel("Dinosaur Removed");
        message.setBounds(75, 25, 125, 25);;
        removed.add(message);

        //Button
        JButton ok = new JButton("Okay");
        ok.setBounds(75, 70, 100, 25);
        ok.addActionListener(e -> removed.setVisible(false));
        removed.add(ok);

        //Add to Frame
        removed.setVisible(true);
    }

    public static void loadSafe()
    {
        //Frame
        JFrame report = new JFrame("Report");
        report.setLayout(null);
        report.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        report.setSize(250, 145);

        //Error Message
        JLabel message = new JLabel("Human Survived");
        message.setBounds(75, 25, 125, 25);;
        report.add(message);

        //Button
        JButton ok = new JButton("Okay");
        ok.setBounds(75, 70, 100, 25);
        ok.addActionListener(e -> report.setVisible(false));
        report.add(ok);

        //Add to Frame
        report.setVisible(true);
    }

    public static void loadDead()
    {
        //Frame
        JFrame report = new JFrame("Report");
        report.setLayout(null);
        report.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        report.setSize(250, 145);

        //Error Message
        JLabel message = new JLabel("Human Deceased");
        message.setBounds(75, 25, 125, 25);;
        report.add(message);

        //Button
        JButton ok = new JButton("Okay");
        ok.setBounds(75, 70, 100, 25);
        ok.addActionListener(e -> report.setVisible(false));
        report.add(ok);

        //Add to Frame
        report.setVisible(true);
    }

    public static void loadErrorID()
    {
        //Frame
        JFrame error = new JFrame("Error");
        error.setLayout(null);
        error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        error.setSize(400, 145);

        //Error Message
        JLabel message = new JLabel("ERROR 001: 'Dinosaur already exists with this ID'");
        message.setBounds(45, 25, 310, 25);;
        error.add(message);

        //Button
        JButton ok = new JButton("Okay");
        ok.setBounds(150, 70, 100, 25);
        ok.addActionListener(e -> error.setVisible(false));
        error.add(ok);

        //Add to Frame
        error.setVisible(true);
    }

    public static void loadErrorRACE()
    {
        //Frame
        JFrame error = new JFrame("Error");
        error.setLayout(null);
        error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        error.setSize(400, 145);

        //Error Message
        JLabel message = new JLabel("ERROR 002: 'No race input'");
        message.setBounds(113, 25, 175, 25);;
        error.add(message);

        //Button
        JButton ok = new JButton("Okay");
        ok.setBounds(150, 70, 100, 25);
        ok.addActionListener(e -> error.setVisible(false));
        error.add(ok);

        //Add to Frame
        error.setVisible(true);
    }

    public static void loadErrorWEIGHT()
    {
        //Frame
        JFrame error = new JFrame("Error");
        error.setLayout(null);
        error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        error.setSize(400, 145);

        //Error Message
        JLabel message = new JLabel("ERROR 003: 'No weight input'");
        message.setBounds(113, 25, 200, 25);;
        error.add(message);

        //Button
        JButton ok = new JButton("Okay");
        ok.setBounds(150, 70, 100, 25);
        ok.addActionListener(e -> error.setVisible(false));
        error.add(ok);

        //Add to Frame
        error.setVisible(true);
    }

    public static void loadErrorPOS()
    {
        //Frame
        JFrame error = new JFrame("Error");
        error.setLayout(null);
        error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        error.setSize(400, 145);

        //Error Message
        JLabel message = new JLabel("ERROR 004: 'Position already filled with Dinosaur'");
        message.setBounds(43, 25, 315, 25);;
        error.add(message);

        //Button
        JButton ok = new JButton("Okay");
        ok.setBounds(150, 70, 100, 25);
        ok.addActionListener(e -> error.setVisible(false));
        error.add(ok);

        //Add to Frame
        error.setVisible(true);
    }

    public static void loadErrorDATA()
    {
        //Frame
        JFrame error = new JFrame("Error");
        error.setLayout(null);
        error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        error.setSize(400, 145);

        //Error Message
        JLabel message = new JLabel("ERROR 005: 'Field left empty: Fill in all areas'");
        message.setBounds(43, 25, 315, 25);;
        error.add(message);

        //Button
        JButton ok = new JButton("Okay");
        ok.setBounds(150, 70, 100, 25);
        ok.addActionListener(e -> error.setVisible(false));
        error.add(ok);

        //Add to Frame
        error.setVisible(true);
    }
}