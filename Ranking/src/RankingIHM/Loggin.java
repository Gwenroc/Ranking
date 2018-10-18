package RankingIHM;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import RankingBLL.ConnexionManager;
import RankingBO.Connexion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Loggin extends JFrame {

	private JLabel JlNom, JlMdp;
	private JTextField JtNom;
	private JTextField JtMdp; // JPasswordField
	private JButton BtnValider;

	private ConnexionManager cnxMgr;

	public void EcranLog() {
		super("Connexion");

		initIHM();
	}

	private void initIHM() {
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// NOM ----------------------------------------
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getJlNom(), gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getJtNom(), gbc);
		// MDP ----------------------------------------
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getJlMdp(), gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getJtMdp(), gbc);
		// Valider ------------------------------------
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel.add(getBtnValider(), gbc);
		this.setContentPane(panel);
	}

	// Getteur-Setteur
	public JLabel getJlNom() {
		if (JlNom == null) {
			JlNom = new JLabel("Nom:");
		}
		return JlNom;
	}

	public JTextField getJtNom() {
		if (JtNom == null) {
			JtNom = new JTextField(20);
		}
		return JtNom;
	}

	public JLabel getJlMdp() {
		if (JlMdp == null) {
			JlMdp = new JLabel("Mot de passe:");
		}
		return JlMdp;
	}

	public JTextField getJtMdp() {
		if (JtMdp == null) {
			JtMdp = new JTextField(20);
			JtMdp.addActionListener(getBtnValider().getActionListeners()[0]);
		}
		return JtMdp;
	}

	private void lancerMenu() {
		if (!(getJtNom().getText() == null || getJtMdp().getText() == null || getJtNom().getText().equals("")
				|| getJtMdp().getText().equals(""))) {
			Connexion connEssai = new Connexion(getJtNom().getText(), getJtMdp().getText(), null);
			try {
				cnxMgr = ConnexionManager.getInstance();
				String r = cnxMgr.getRole(connEssai);
				if (r != "noRole") {
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							FenetreGenerale log = new FenetreGenerale(r);
							log.montre();
						}

					});
				} else {
					JOptionPane.showMessageDialog(EcranLog.this, "Erreur de nom ou de mot de passe !");
					getJtNom().setText(null);
					getJtMdp().setText(null);
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
			//
		} else {
			JOptionPane.showMessageDialog(EcranLog.this, "Champ(s) vide(s) !");
		}
	}

	// Bouton Valider
	public JButton getBtnValider() {
		if (BtnValider == null) {
			BtnValider = new JButton("Valider");
			BtnValider.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					lancerMenu();
				};
			});
		}
		return BtnValider;
		// public JButton BtnValider() {
		// if (BtnValider == null) {
		// BtnValider = new JButton();
		// }
		// return BtnValider;
		// }
	}
}