package AirFrance.src.vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
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

public class VueConnexion extends JFrame  implements ActionListener, KeyListener 
{
private static final String Air = null;
private JPanel panelConnexion = new JPanel();
private JButton btSeconnecter = new JButton("se Connecter");
private JButton btAnnuler = new JButton("Annuler");
private JTextField txtEmail = new JTextField();
private JPasswordField txtMdp = new JPasswordField();


	public VueConnexion() {
		this.setTitle("Air france admin");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.cyan);
		this.setBounds(300,300,500,250);
		this.setLayout(null);
		
		this.panelConnexion.setLayout(new GridLayout(3,2));
		this.panelConnexion.setBounds(200,50,240,150);
		this.panelConnexion.setBackground(Color.cyan);
		this.panelConnexion.setBounds(240, 50, 200, 150);
		this.panelConnexion.add(new JLabel("Email :"));
		this.panelConnexion.add(this.txtEmail);
		
		this.panelConnexion.add(new JLabel("MDP :"));
		this.panelConnexion.add(this.txtMdp);
		
		
		this.panelConnexion.add(new JLabel("btAnnuler :"));
		this.panelConnexion.add(new JLabel("btSeConnecter :"));
		
		
		this.add(this.panelConnexion);
		
		//installation du logo
		
		ImageIcon lelogo = new ImageIcon("scr/image/logo.png");
		JLabel lblogo = new JLabel(lelogo);
		lblogo.setBounds(20,40,150,150);
		this.add(lblogo);
		// rendre les bouton ecoutable 
		
		this.btAnnuler.addActionListener(this);
		this.btSeconnecter.addActionListener(this);
		//rendre les txrx ecoutable
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
		else if (e.getSource() == this.btSeconnecter)
		{
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
			
			User unUser = Air.France.selectWhereUser(email,mdp);
			if(unUser == null)
			{
				JOptionPane.showMessageDialog(this,"Veuillez verifier vos identifiants");
				this.txtEmail.setText("");
				this.txtMdp.setText("");
			}else {
				JOptionPane.showMessageDialog(this,"Bienvenue " + unUser.getNom()+ " Vous avez le role :" +unUser.getRole());
				
				//instancier la vue general .
				AirFrance.instancierVueGenerale();
				
				
				// cacher la vue connexion
				
				AirFrance.rendreVisibleVueConnexion(false);
			}
		}
	
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	public void traitement() {

		String email = this.txtEmail.getText();
		String mdp = new String (this.txtMdp.getPassword());
		
		User unUser = Air.France.selectWhereUser(email,mdp);
		if(unUser == null)
		{
			JOptionPane.showMessageDialog(this,"Veuillez verifier vos identifiants");
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}else {
			JOptionPane.showMessageDialog(this,"Bienvenue " + unUser.getNom()+ " Vous avez le role :" +unUser.getRole());
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			traitement();
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
}
