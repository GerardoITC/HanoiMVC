package TorresHanoi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class Controlador implements ActionListener{
	private VistaHanoi vista;
	private ModeloHanoi modelo;
		
	
	public Controlador(VistaHanoi vista,ModeloHanoi modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vista.btnStart) {
			int noDiscos= vista.getDiscos();
			ArrayList<Vector> movimientos= modelo.getMovimientos(noDiscos);
			
			vista.setMovimientos(movimientos);
		}
		
	}
	
	
}
