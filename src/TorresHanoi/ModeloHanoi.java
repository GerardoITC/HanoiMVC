package TorresHanoi;

import java.util.ArrayList;
import java.util.Vector;

public class ModeloHanoi {
	private ArrayList <Vector> movimientos;
	private int contador;
	
	public ModeloHanoi() {
		this.movimientos= new ArrayList();
		this.contador=0;
	}
	public ArrayList getMovimientos(int discos) {
		this.contador=0;
		this.movimientos= new ArrayList();
		
		Hanoi(discos,1,2,3);
		
		return movimientos;
	}
	//Método Torres de Hanoi Recursivo
    public void Hanoi(int n, int origen,  int auxiliar, int destino){
        if(n==1){
        	creaMov(n,origen,destino);
        	
        }else{
        	Hanoi(n-1, origen, destino, auxiliar);
        	creaMov(n,origen,destino);
        	
        	Hanoi(n-1, auxiliar, origen, destino);
        }
        
    }
    public void creaMov(int n,int origen,int destino) {
    	Vector fila = new Vector();
    	contador++;
    	String torreOrigen = "";
    	String torreDestino = "";
    	
    	torreOrigen = identificaTorre(origen)+"";
    	torreDestino = identificaTorre(destino)+"";
    	
    	fila.addElement(contador);
    	fila.addElement(n);
    	fila.addElement(torreOrigen);
    	fila.addElement(torreDestino);
    	
    	movimientos.add(fila);
    	
    }
    private char identificaTorre(int t) {
    	char torre='A';
    	switch (t) {
    		case 1: torre = 'A';
    		break;
    		case 2: torre = 'B';
    		break;
    		case 3: torre = 'C';
    		break;
    	}
    	return torre;
    }
}
