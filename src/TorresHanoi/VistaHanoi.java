package TorresHanoi;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Componentes.LeeEntero;

public class VistaHanoi extends JFrame {
	public JButton btnStart;
	private JPanel panelArriba;
	private LeeEntero txtDiscos;
	
	private JTable tbl;
	private DefaultTableModel modelo;
	private Vector<String> col;
	
	
	public VistaHanoi() {
		super("Torres de Hanoi MVC");
		
		hazInterfaz();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void hazInterfaz() {
		setSize(300,400);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);
		//setLayout(new GridLayout(0,1));
		
		panelArriba=new JPanel();
		panelArriba.setLayout(new GridLayout(1,0));
		add(panelArriba,BorderLayout.NORTH);
		
		txtDiscos = new LeeEntero(2);
		btnStart= new JButton("Start");
		
		JLabel lbl = new JLabel("No. Discos: ");
		panelArriba.add(lbl);
		panelArriba.add(txtDiscos);
		panelArriba.add(btnStart);


		col=new Vector();
		col.addElement("No. mov");
		col.addElement("Disco");
		col.addElement("Origen");
		col.addElement("Destino");
		
	
		tbl = new JTable();
        modelo=new DefaultTableModel();
        modelo.setColumnIdentifiers(col);
        
        tbl.setModel(modelo);
        
        JScrollPane sp =new JScrollPane(tbl);
		add(sp,BorderLayout.CENTER);
	
	}
	public void setControlador(Controlador c) {
		//Asignar los eventos btnEj.addActionListener(c);
		btnStart.addActionListener(c);
	}
	public void setMovimientos(ArrayList <Vector> movimientos) {
		modelo=new DefaultTableModel();
        modelo.setColumnIdentifiers(col);
   
        for(int i=0; i<movimientos.size();i++) {
        	modelo.addRow(movimientos.get(i));
        }
        tbl.setModel(modelo);
	}
	public int getDiscos() {
		return (int)(txtDiscos.getCantidad());
	}
}
