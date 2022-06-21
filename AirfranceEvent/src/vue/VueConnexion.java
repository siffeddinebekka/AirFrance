package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import controleur.AirFrance;
import controleur.User;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JPanel panelConnexion = new JPanel();
	private JButton btSeConnecter = new JButton("Se Connecter"); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField(); 
	
	public VueConnexion()
	{
		this.setTitle("Air France Administration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(23, 78, 90));
		this.setBounds(300, 300, 600, 250);
		this.setLayout(null);
		
		//construction du panel connexion 
		this.panelConnexion.setLayout(new GridLayout(3,2));
		this.panelConnexion.setBounds(300, 40, 260, 150);
		this.panelConnexion.setBackground(new Color(23, 78, 90));
		this.panelConnexion.add(new JLabel("Email :")); 
		this.panelConnexion.add(this.txtEmail); 
		
		this.panelConnexion.add(new JLabel("MDP :")); 
		this.panelConnexion.add(this.txtMdp); 
		
		this.panelConnexion.add(this.btAnnuler); 
		this.panelConnexion.add(this.btSeConnecter);
		
		this.add(this.panelConnexion); 
		
		//installation du logo 
		ImageIcon leLogo = new ImageIcon("src/images/logo.png"); 
		JLabel lbLogo = new JLabel(leLogo); 
		lbLogo.setBounds(20, 40, 250, 150);
		this.add(lbLogo); 
		
		//rendre les boutons écoutables 
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		//rendre les txt écoutables 
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if (e.getSource() == this.btSeConnecter)
		{
			traitement(); 
		}
	}
	public void traitement () {
		String email = this.txtEmail.getText(); 
		String mdp = new String (this.txtMdp.getPassword()); 
		//vérification en BDD de l'user. 
		
		User unUser = AirFrance.selectWhereUser(email, mdp);
		if(unUser == null) 
		{
			JOptionPane.showMessageDialog(this, 
					"Veuillez vérifier vos identifiants");
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}else
		{
			JOptionPane.showMessageDialog(this, 
			"Bienvenue M./MM " + unUser.getNom()
			+ "\n Vous avez le rôle : " +unUser.getRole());
			//appel de la vue Générale
			//instancier la vue Générale. 
			AirFrance.instancierVueGenerale();
			
			//cacher la vue connexion. 
			AirFrance.rendreVisibleVueConnexion(false);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			traitement (); 
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}



















