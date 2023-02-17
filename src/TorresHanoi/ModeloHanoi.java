package TorresHanoi;

import java.util.ArrayList;
import java.util.Vector;

public class ModeloHanoi {
	private ArrayList <Vector> movimientos;
	private int contador;
	
	public ModeloHanoi() {
	}
	public ArrayList getMovimientos(int discos) {
		this.contador=0;
		this.movimientos= new ArrayList();
		
		Hanoi(discos,'A','B','C');
		
		return movimientos;
	}
	//Método Torres de Hanoi Recursivo
    public void Hanoi(int n, char origen,  char auxiliar, char destino){
        if(n==1){
        	creaMov(n,origen,destino);
        	
        }else{
        	Hanoi(n-1, origen, destino, auxiliar);
        	creaMov(n,origen,destino);
        	
        	Hanoi(n-1, auxiliar, origen, destino);
        }
        
    }
    public void creaMov(int n,char origen,char destino) {
    	Vector fila = new Vector();
    	contador++;
	
    	fila.addElement(contador);
    	fila.addElement(n);
    	fila.addElement(origen);
    	fila.addElement(destino);
    	
    	movimientos.add(fila);
    	
    }
}
