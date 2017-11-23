package codigo;


import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;

/*
 * Autor: Carlos Fuentes
 * 
 * El arkanoid pero orientado a objetos
 * 
 */
import acm.graphics.*;
public class Arkanoid  extends acm.program.GraphicsProgram{
	
	Pelota pelota1 = new Pelota(20, Color.BLACK);
	
	Cursor cursor1 = new Cursor(60,15,Color.DARK_GRAY);
	int anchoLadrillo = 25;
	int altoLadrillo=15;
	int espacioMenu =200;
	int numeroLadrillo=14;
	//el sistema del marcador
	int puntuacion =0;
	Marcador marcador = new Marcador (20, 40);
	
	public void init (){
		addMouseListeners();
		setSize(600,600);
		GRect lateral = new GRect(3, getHeight());
		lateral.setFilled(true);
		
		add (lateral, getWidth() - espacioMenu - lateral.getWidth()-pelota1.getWidth(),0);
		add (pelota1, 0, getHeight()*0.60-pelota1.getHeight());
		add (cursor1,0,getHeight()*0.80);

		dibujaNivel01();
	}

	public void run (){

	
		marcador.dibuja(this);
		while(true){
			pelota1.muevete(this);
		
			
			pause(5);
		}
		
	}
	
	public void mouseMoved(MouseEvent evento){
		cursor1.mueveCursor(evento.getX(), getWidth());
	
	}
	
	private void dibujaNivel01(){
		for (int j=0; j<numeroLadrillo; j++){
			for(int i=j; i<numeroLadrillo; i++){
				Ladrillo miLadrillo = new Ladrillo(anchoLadrillo*i-anchoLadrillo*j/2+ (getWidth()-espacioMenu)/2-numeroLadrillo*anchoLadrillo/2,
						 altoLadrillo*j + altoLadrillo,
						anchoLadrillo,
						altoLadrillo,
						Color.LIGHT_GRAY);
				add(miLadrillo);
				pause(7);
				
			}
		}
	}
}
