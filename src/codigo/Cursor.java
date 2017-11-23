package codigo;

import java.awt.Color;

import acm.graphics.GRect;

/**
 * 
 * @author Carlos Fuentes
 * 
 * la clase Barra es la que debuja el cursor del juego
 *
 */

public class Cursor extends GRect{
	/**
	 * Crea el cursor del juego
	 * @param width --> el ancho del cursor
	 * @param height --> el alto del cursor
	 * @param color -->color del cursor
	 */
	

	
	public Cursor (double width, double height, Color color){
	super (width, height);
	setFilled(true);
	setFillColor(color);

	
}
	/**
	 * mueveCursor reposiciona la barra en la coordenada
	 * en la que esta el raton
	 * @param posX la posicion X del raton. La Y la obtiene de la propia barra
	 * @param anchoPantalla porque asi no tengo que pasar nada mas.
	 */
	public void mueveCursor(int posX, int anchoPantalla){
		if (posX + getWidth()< anchoPantalla){
			setLocation(posX,getY());
			
		}
	}
	
	
}