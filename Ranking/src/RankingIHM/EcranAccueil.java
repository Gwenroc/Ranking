package RankingIHM;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class EcranAccueil extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JDesktopPane desktopPane;
	private JMenuBar menuBarre;
	//private JMenu menuAgenda;
	private InternalFrame1 frm1;


	public EcranAccueil() {
		
		setTitle("BeatBy44 - Ranking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
//		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("IconBB44.jpg"));
//	    this.setIconImage(icon);

		// initialiser l'ecran MDI
		desktopPane = new JDesktopPane();

		// Associer le JDesktopPane à la JFrame
		setContentPane(desktopPane);

		// Barre de menus
		setJMenuBar(getMenuBarre());
		
		//Frame interne exemple		
		desktopPane.add(getFrm1());
		
//		ImageIcon fondEcran = new ImageIcon(getClass().getClassLoader().getResource("IconBB44.jpg"));
//		class ImagePanel extends JPanel {
//			private Image img;
//
//			public ImagePanel(Image img) {
//				this.img = img;
//			}
//
//			public void paintComponent(Graphics g) {
//				g.drawImage(img, 0, 0, null);
//			}
//		}
//		;
//		ImagePanel panel = new ImagePanel(fondEcran.getImage());

	}

	// Lancement de l'application
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				EcranAccueil ecran = new EcranAccueil();
				ecran.setVisible(true);
			}
		});

	}

	public void createMenuBar() {

		// Menu Fichier
					JMenu menu1 = new JMenu("Log");
					menuBarre.add(menu1);
					menuBarre.setAlignmentX(LEFT_ALIGNMENT);

					// Sous menu nouvelle saison
					JMenuItem menuItem1 = new JMenuItem("New");
					menuItem1 = new JMenuItem("Nouvelle saison");
					menuItem1.setActionCommand("Nouvelle saison");
					menuItem1.addActionListener((ActionListener) this);
					menu1.add(menuItem1);
					
					// Menu Ranking
					JMenu menu2 = new JMenu("Ranking");
					menuBarre.add(menu2);
					menuBarre.setAlignmentX(LEFT_ALIGNMENT);
					
					// Sous menu nouveau ranking
					JMenuItem menuItem2 = new JMenuItem("New Ranking");
					menuItem2 = new JMenuItem("New Ranking");
					menuItem2.setActionCommand("ouvrir");
					menuItem2.addActionListener((ActionListener) this);
					menu2.add(menuItem2);
					
					// Sous menu ancien ranking
				    JMenuItem menuItem3 = new JMenuItem("Old Ranking");
					menuItem3 = new JMenuItem("Old Ranking");
					menuItem3.setActionCommand("ouvrir");
					menuItem3.addActionListener((ActionListener) this);
					menu2.add(menuItem3);
					
					// Menu Jeux
					JMenu menu3 = new JMenu("Jeux");
					menuBarre.add(menu3);
					menuBarre.setAlignmentX(LEFT_ALIGNMENT);
					
					// Sous menu 2X
				    JMenuItem menuItem4 = new JMenuItem("SSF2X");
					menuItem4 = new JMenuItem("SSF2X");
					menuItem4.setActionCommand("ouvrir");
					menuItem4.addActionListener((ActionListener) this);
					menu3.add(menuItem4);
					
								// Sous Sous menu 2X Classement
							    JMenuItem menuItem6 = new JMenuItem("Classement");
								menuItem6 = new JMenuItem("Classement");
								menuItem6.setActionCommand("ouvrir");
								menuItem6.addActionListener((ActionListener) this);
								menuItem4.add(menuItem6);
					
					// Sous menu USF4
				    JMenuItem menuItem5 = new JMenuItem("USF4");
					menuItem5 = new JMenuItem("USF4");
					menuItem5.setActionCommand("ouvrir");
					menuItem5.addActionListener((ActionListener) this);
					menu3.add(menuItem5);
					
								// Sous Sous menu USF4 Classement
							    JMenuItem menuItem7 = new JMenuItem("Classement");
								menuItem7 = new JMenuItem("Classement");
								menuItem7.setActionCommand("ouvrir");
								menuItem7.addActionListener((ActionListener) this);
								menuItem5.add(menuItem7);
								
					// Menu Video
					JMenu menu4 = new JMenu("Video");
					menuBarre.add(menu4);
					menuBarre.setAlignmentX(LEFT_ALIGNMENT);
	}

	// Réagir aux clicks sur les menus
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "deconnexion":
			System.out.println("Deconnexion");
			break;
			
		case "fermer":
			System.exit(0);
			break;
			
		case "ecran":
			System.out.println("coucou");

setVisible(true);
			break;

		default:
			System.out.println("Probleme e=" + e);
		}

	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public JMenuBar getMenuBarre() {
		if (menuBarre == null) {
			menuBarre = new JMenuBar();

			createMenuBar();
		}
		return menuBarre;
	}

	public InternalFrame1 getFrm1() {
		if(frm1== null){
			frm1 = new InternalFrame1();
		}
		return frm1;
	}

}

