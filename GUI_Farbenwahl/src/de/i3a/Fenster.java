package de.i3a;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Fenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container c;
	private JPanel jpWest, jpcenter, jpsouth, jpNorth;
	private JButton jbtnrot, jbtnblau, jbtngelb;
	private JRadioButton jrbtnrot, jrbtnblau, jrbtngelb;
	private ButtonGroup bg;
	private JComboBox<String> jcomboBox;
	private String[] eintraege = { "Rot", "Gelb" };
	private JMenuItem jmiRot, jmiGelb, jmiBlau, jmiBeenden;
	
	
	public Fenster() {
		this.setTitle("Farbwahl");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		initComponents();
		createMenu();
		initEvents();
		this.setVisible(true);
	}

	private void initComponents() {
		c = this.getContentPane();

		jpNorth = new JPanel();
		jcomboBox = new JComboBox<>(eintraege);
		jcomboBox.addItem("Blau");
		jpNorth.add(jcomboBox);

		jpWest = new JPanel();
		jpWest.setLayout(new BoxLayout(jpWest, BoxLayout.Y_AXIS));
		jpcenter = new JPanel();
		jpsouth = new JPanel();

		jbtnrot = new JButton("Rot");
		jbtnblau = new JButton("Blau");
		jbtngelb = new JButton("Gelb");

		jrbtnblau = new JRadioButton("Blau");
		jrbtngelb = new JRadioButton("Gelb");
		jrbtnrot = new JRadioButton("Rot");

		bg = new ButtonGroup();
		bg.add(jrbtnblau);
		bg.add(jrbtngelb);
		bg.add(jrbtnrot);
		jrbtnrot.setSelected(true);
		jpcenter.setBackground(Color.RED);

		jpWest.add(jrbtnrot);
		jpWest.add(jrbtngelb);
		jpWest.add(jrbtnblau);

		jpsouth.add(jbtnrot);
		jpsouth.add(jbtngelb);
		jpsouth.add(jbtnblau);

		c.add(jpNorth, BorderLayout.NORTH);
		c.add(jpWest, BorderLayout.WEST);
		c.add(jpcenter, BorderLayout.CENTER);
		c.add(jpsouth, BorderLayout.SOUTH);

	}
	
	private void createMenu(){
		
		jmiBeenden = new JMenuItem("Beenden");
		jmiRot = new JMenuItem("Rot");
		jmiBlau = new JMenuItem("Blau");
		jmiGelb = new JMenuItem("Gelb");
		
		JMenu jmenuDatei = new JMenu("Datei");
		jmenuDatei.add(jmiBeenden);
		
		JMenu jmenuBearbeiten = new JMenu("Bearbeiten");
		jmenuBearbeiten.add(jmiRot);
		jmenuBearbeiten.add(jmiBlau);
		jmenuBearbeiten.add(jmiGelb);
		
		JMenuBar jmenubar = new JMenuBar();
		jmenubar.add(jmenuDatei);
		jmenubar.add(jmenuBearbeiten);
		
		this.setJMenuBar(jmenubar);
	}

	private void initEvents() {
		MeinActionListener mal = new MeinActionListener();
		jbtnrot.addActionListener(mal);
		jbtnblau.addActionListener(mal);
		jbtngelb.addActionListener(mal);
		jrbtnblau.addActionListener(mal);
		jrbtngelb.addActionListener(mal);
		jrbtnrot.addActionListener(mal);
		jcomboBox.addActionListener(mal);

	}

	private class MeinActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if (actionCommand.equals("comboBoxChanged")) {
				actionCommand = (String) jcomboBox.getSelectedItem();
			}
			switch (actionCommand) {
			case "Rot":
				jpcenter.setBackground(Color.RED);
				jrbtnrot.setSelected(true);
				jcomboBox.setSelectedItem("Rot");
				break;
			case "Blau":
				jpcenter.setBackground(Color.BLUE);
				jrbtnblau.setSelected(true);
				jcomboBox.setSelectedItem("Blau");
				break;
			case "Gelb":
				jpcenter.setBackground(Color.YELLOW);
				jrbtngelb.setSelected(true);
				jcomboBox.setSelectedItem("Gelb");
				break;
			}
		}

	}

}
