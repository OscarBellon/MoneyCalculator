package view;

import controller.Controller;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Model;

public class View {
    private final Model model;
    private final Controller controller;
    private final JLabel label;
    private final JTextField input;
    private final JLabel originLabel;
    private final JComboBox originList;
    private final JLabel destinyLabel;
    private final JComboBox destinyList;
    private final JTextField result;
    private final JLabel resultLabel;
    
    public View(Model model) throws IOException{
        this.resultLabel = new JLabel("divisa convertida:");
        this.result = new JTextField();
        this.destinyLabel = new JLabel();
        this.originLabel = new JLabel();
        this.input = new JTextField();
        this.label = new JLabel();
        this.destinyList = new JComboBox(model.getCurrencies().getCurrenciesNames());
        this.originList = new JComboBox(model.getCurrencies().getCurrenciesNames());
        this.model = model;
        this.controller = new Controller(model);
        controller.updateDestiny((String) destinyList.getSelectedItem());
        controller.updateOrigin((String) destinyList.getSelectedItem());
        createUI();
    }
    
    private void createUI(){
       JFrame frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       label.setText("Introducir cantidad:");
       originLabel.setText("elegir moneda de origen");
       destinyLabel.setText("introducir moneda de destino");
       
       originList.addActionListener((ae)->{
           try {
               controller.updateOrigin((String) originList.getSelectedItem());
               controller.updateRate();
               controller.updateMoneyDestinyAmmount();
               result.setText(Double.toString(model.getMoneyDestino().getAmmount()));
           } catch (IOException ex) {
               Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
       destinyList.addActionListener((ae)->{
           try {
               controller.updateDestiny((String) destinyList.getSelectedItem());
               controller.updateRate();
               controller.updateMoneyDestinyAmmount();
               result.setText(Double.toString(model.getMoneyDestino().getAmmount()));
           } catch (IOException ex) {
               Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
           }

       });
       
       input.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent arg0){
                controller.updateMoneyOriginAmmount(input.getText());
                controller.updateMoneyDestinyAmmount();
                result.setText(Double.toString(model.getMoneyDestino().getAmmount()));
           }
           @Override
           public void removeUpdate(DocumentEvent arg0){
                controller.updateMoneyOriginAmmount(input.getText());
                controller.updateMoneyDestinyAmmount();
                result.setText(Double.toString(model.getMoneyDestino().getAmmount()));
           }
           @Override
           public void changedUpdate(DocumentEvent e) {
           }
       });
       
       result.setEditable(false);
       
       Box leftBox = Box.createVerticalBox();
       leftBox.add(originLabel);
       leftBox.add(originList);
       leftBox.add(label);
       leftBox.add(input);
       
       
       Box rightBox = Box.createVerticalBox();
       rightBox.add(destinyLabel);
       rightBox.add(destinyList);
       rightBox.add(resultLabel);
       rightBox.add(result);
       
       frame.add(leftBox, BorderLayout.WEST);
       frame.add(rightBox, BorderLayout.EAST);
       frame.setVisible(true);
       frame.setLocationRelativeTo(null);
       frame.pack();
       frame.setResizable(false);
    } 
}
