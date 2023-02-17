package TorresHanoi;

public class AplHanoi {

	public static void main(String[] args) {
		VistaHanoi vista = new VistaHanoi();
		ModeloHanoi modelo = new ModeloHanoi();
		Controlador controlador = new Controlador(vista,modelo);
		
		vista.setControlador(controlador);	
	}

}
