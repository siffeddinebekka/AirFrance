package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel

{
	private String entetes[];
	private Object [][] donnees;
	
	
			
	public Tableau(String[] entetes, Object[][] donnees) {
		super();
		this.entetes = entetes;
		this.donnees = donnees;
	}

	@Override
	public int getRowCount() {
		
		return  this.donnees.length;
	}

	@Override
	public int getColumnCount() {
		
		return this.entetes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return this.donnees[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
	
		return this.entetes[column];
	}
	public void ajouterligne(Object ligne[])
	{
		Object matrice[] [] = new Object[this.donnees.length+1][this.entetes.length];
		for (int i = 0; i < this.getRowCount(); i++)
		{
			matrice[i] = this.donnees[i];
		}
		// ajout de la ligne de fin de tableau matrice 
		matrice [this.getRowCount()] = ligne;
		//ecrassement du tableau
		this.donnees = matrice;
		//actualisation de l'affichage
		this.fireTableDataChanged();
	}

	public void supprimerLigne(int numligne) {
		Object matrice [] [] = new Object[this.getRowCount() -1][this.getColumnCount()];
		int j = 0;
		for (int i = 0; i < this.getRowCount(); i++)
		{
			if (numligne != i)
			{
				matrice[j] = this.donnees[i];
				j++;
			}
			
		}
		this.donnees = matrice;
		this.fireTableDataChanged();
		
	}
	public void modifierLigne(int numligne , Object[] ligne )
	{
		Object matrice [] [] = new Object[this.getRowCount() -1][this.getColumnCount()];
		int j = 0;
		for (int i = 0 ; i   < this.getRowCount(); i++)
		{
			if(numligne == 0)
			{
				matrice[i] = ligne;
			}else {
				matrice[i] =this.donnees[i];
			}
		}
		this.donnees = matrice;
		this.fireTableDataChanged();
	}
	public void setDonnees(Object[][] matrice)
	{
		this.donnees= matrice;
		this.fireTableDataChanged();
	}
	
}
