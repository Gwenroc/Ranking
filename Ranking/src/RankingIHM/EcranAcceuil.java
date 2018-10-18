package RankingIHM;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



public class EcranAcceuil extends JFrame implements ActionListener {

	public static void main(String[] args) {
		
	}
		private JDesktopPane desktopPane;
		private JFrame fenetre;
		private JMenuBar jmBar;
//		private String ecran;
//		private Ranking rank;
//		private Jeux jeux;
//		private Video video;

		// Lancement de l'application
		public void montre() {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					setVisible(true);

				}
			});

		}

		public EcranAcceuil(String r) {
			desktopPane = new JDesktopPane();
			setTitle("BeatBy44 - Ranking");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setResizable(false);
			pack();
			setExtendedState(JFrame.MAXIMIZED_BOTH);			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     		setBounds(0, 0, screenSize.width, screenSize.height);

			// initialiser l'ecran MDI
     		
     		// Associer le JDesktopPane à  la JFrame
			setContentPane(desktopPane);
			// Barre de menus
			setJMenuBar(getJmBar());
			//Frame interne		
//			desktopPane.add(getrank());
//			desktopPane.add(getjeux());
//			desktopPane.add(getvideo());
			setJMenuBar(getJmBar());

		}

		public void getGeneralMenuBar() {

			// Menu Fichier
			JMenu menu1 = new JMenu("Log");
			jmBar.add(menu1);
			jmBar.setAlignmentX(LEFT_ALIGNMENT);

			// Sous menu fermer
			JMenuItem menuItem1 = new JMenuItem("Log");
			menuItem1 = new JMenuItem("Fermer");
			menuItem1.setActionCommand("Fermer");
			menuItem1.addActionListener((ActionListener) this);
			menu1.add(menuItem1);
			
			// Menu Ranking
			JMenu menu2 = new JMenu("Ranking");
			jmBar.add(menu2);
			jmBar.setAlignmentX(LEFT_ALIGNMENT);
			
			// Sous menu nouveau ranking
			JMenuItem menuItem2 = new JMenuItem("Nouveau");
			menuItem2 = new JMenuItem("Nouveau");
			menuItem2.setActionCommand("ouvrir");
			menuItem2.addActionListener((ActionListener) this);
			menu2.add(menuItem2);
			
			// Sous menu ancien ranking
		    JMenuItem menuItem3 = new JMenuItem("Ancien");
			menuItem3 = new JMenuItem("");
			menuItem3.setActionCommand("ouvrir");
			menuItem3.addActionListener((ActionListener) this);
			menu2.add(menuItem3);
			
			// Menu Jeux
			JMenu menu3 = new JMenu("Jeux");
			jmBar.add(menu3);
			jmBar.setAlignmentX(LEFT_ALIGNMENT);
			
			// Sous menu 2X
		    JMenuItem menuItem4 = new JMenuItem("SSF2X");
			menuItem4 = new JMenuItem("Nouveau");
			menuItem4.setActionCommand("ouvrir");
			menuItem4.addActionListener((ActionListener) this);
			menu3.add(menuItem4);
			
						// Sous Sous menu 2X Classement
					    JMenuItem menuItem6 = new JMenuItem("Classement");
						menuItem6 = new JMenuItem("Nouveau");
						menuItem6.setActionCommand("ouvrir");
						menuItem6.addActionListener((ActionListener) this);
						menuItem4.add(menuItem6);
			
			// Sous menu USF4
		    JMenuItem menuItem5 = new JMenuItem("USF4");
			menuItem5 = new JMenuItem("Nouveau");
			menuItem5.setActionCommand("ouvrir");
			menuItem5.addActionListener((ActionListener) this);
			menu3.add(menuItem5);
			
						// Sous Sous menu USF4 Classement
					    JMenuItem menuItem7 = new JMenuItem("Classement");
						menuItem7 = new JMenuItem("Nouveau");
						menuItem7.setActionCommand("ouvrir");
						menuItem7.addActionListener((ActionListener) this);
						menuItem5.add(menuItem7);
						
			// Menu Video
			JMenu menu4 = new JMenu("Jeux");
			jmBar.add(menu4);
			jmBar.setAlignmentX(LEFT_ALIGNMENT);
			
		
		}
		

		

		public JMenuBar getJmBar() {
			if (jmBar == null) {
				jmBar = new JMenuBar();
				
			}
			return jmBar;
		}
//
//		public JMenuBar getrank() {
//			if (rank == null) {
//				rank = new JMenuBar();
//			}
//			return rank;
//		}
//
//		public JMenuBar getjeux() {
//			if (jeux == null) {
//				jeux = new JMenuBar();
//			}
//			return jeux;
//		}
//		public JMenuBar getvideo() {
//			if (video == null) {
//				video = new JMenuBar();
//			}
//			return video;
//		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		// Réagir aux clicks sur les menus
//		public void actionPerformed(ActionEvent e) {
//			switch (e.getActionCommand()) {
//			case "fermer":
//				System.exit(0);
//				break;
//			case "Ranking":
//				getRank().setVisible(true);
//				break;
//			case "Jeux":
//				getJeux().setVisible(true);
//				break;
//			case "Video":
//				getVideo().setVisible(true);
//				break;
//
//			default:
//				System.out.println("Probleme e=" + e);
//			}
//
//		}
//
//		private Window getJeux() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		private Window getVideo() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		private Window getRank() {
//			// TODO Auto-generated method stub
//			return null;
//		}
	}
