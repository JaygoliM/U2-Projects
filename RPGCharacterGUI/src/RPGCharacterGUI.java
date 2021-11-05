import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class RPGCharacterGUI {
    JFrame frame;
    static JTextField textInputName;
    static JTextField textInputStrength;
    static JLabel PhysicalDamage;
    static JTextField textInputSpirit;
    static JLabel Initiative;
    static JTextField textInputDex;
    static JLabel Constitution;
    static JLabel MagicDamage;
    static JLabel Name;
    public RPGCharacterGUI(){
        frame = new JFrame("RPG Character");
        textInputName = new JTextField(10);
        textInputStrength = new JTextField(10);
        textInputSpirit = new JTextField(10);
        textInputDex = new JTextField(10);
        JLabel Namejpg = new JLabel("Enter Name: ");

        JLabel textStrength = new JLabel("Enter your Strength #: ");
        JLabel textDexterity = new JLabel("Enter your Dexterity #: ");
        JLabel textSpirit = new JLabel("Enter your Spirit #: ");
        JButton getStats = new JButton("Calculate");

        Name = new JLabel("Name: ");
        PhysicalDamage = new JLabel("Physical Damage: ");
        Initiative = new JLabel("Initiative: ");
        Constitution = new JLabel("Max Health: ");
        MagicDamage = new JLabel("Magic Damage: ");


        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new CharSheet();

        getStats.addActionListener(new ButtonWorker());


        panel.add(Namejpg);
        panel.add(textInputName);

        panel.add(textStrength);
        panel.add(textInputStrength);

        panel.add(textSpirit);
        panel.add(textInputSpirit);

        panel.add(textDexterity);
        panel.add(textInputDex);

        panel.add(getStats);

        panel.add(Name);
        panel.add(PhysicalDamage);
        panel.add(Initiative);
        panel.add(Constitution);
        panel.add(MagicDamage);
        frame.add(panel);
        frame.setVisible(true);


    }

    private class CharSheet extends JPanel{

        public CharSheet(){
            setBackground(new Color(255, 68, 0, 255));
        }
    }

    private static class ButtonWorker implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent){

            double physicalDamage = Double.parseDouble(textInputStrength.getText())/3;
            double Init = Double.parseDouble(textInputDex.getText())/5 + Double.parseDouble(textInputSpirit.getText())/10;
            double Con = Double.parseDouble(textInputStrength.getText()) * 2 + Double.parseDouble(textInputSpirit.getText())/8;
            double magicDamage = Double.parseDouble(textInputSpirit.getText())/2;
            String nameInput = textInputName.getText();

            Name.setText("Name: " + (nameInput));
            PhysicalDamage.setText("Physical Damage: " + physicalDamage);
            Initiative.setText("Initiative: " + Init);
            Constitution.setText("Max Health: " + Con);
            MagicDamage.setText("Magic Damage: " + magicDamage);
        }
    }
}
