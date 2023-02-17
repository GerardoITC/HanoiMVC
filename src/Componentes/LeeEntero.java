package Componentes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class LeeEntero extends JTextField implements FocusListener, KeyListener{
	private int tamano;
	
	private Color colorBg;
	Font  font;
	public LeeEntero() {
		//this.tama�o=5;
		this(5);
	}
	public LeeEntero(int tamano) {
		this.tamano=tamano;
		this.setSize(new Dimension(30,50));
		HazEscuchas();
		
		colorBg=getBackground();
		font=getFont();
	}
	private void HazEscuchas() {
		this.addFocusListener(this);
		this.addKeyListener(this);
	}
	public long getCantidad() {
		long cantidad=0;
		try {
			cantidad=Long.parseLong( getText() );
		} catch (Exception ex) {
			
		}
		return cantidad;
	}
	@Override
	public void focusGained(FocusEvent e) {
		selectAll();
		//setBackground(Color.YELLOW);
		setBorder(new LineBorder(Color.RED));
		setFocusTraversalKeysEnabled(false);
		setFont(new Font( "Tahoma", Font.ITALIC, 20      ));
	}
	@Override
	public void focusLost(FocusEvent e) {
		setBackground(colorBg);
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setFont(font);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		if(  this.getText().length()>=tamano ) {
			Toolkit.getDefaultToolkit().beep();
			e.consume();
			return;
		}		
		char car=e.getKeyChar();
		//System.out.println(car);******************************************************
		if ("-0123456789".indexOf(car)==-1) {
			e.consume();
			return;
		}
		if(car=='-' && getText().length()>0) {
			e.consume();
			return;
			
		}
//		setText(getText()+car);
//		e.consume();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown()){
//System.out.println("se puls� un control");	**************************************************		
			e.consume();
			return;
		}
		//consume la tecla Inicio,flecha izq o flecha der
		if(e.getKeyCode()==36 ||e.getKeyCode()==37 || e.getKeyCode()==39){
			e.consume();
			return;
		}		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
				
	}

}
