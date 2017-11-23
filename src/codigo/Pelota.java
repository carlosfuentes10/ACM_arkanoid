package codigo;
/*
 * Autos: Carlos Fuentes
 * 
 * la clase pelota es la que vamos a utilizar
 * para el juego del arkanoid
 * Tieje dos constructores.
 */
import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Pelota extends GOval{
	
	double xVelocidad = 1;
	double yVelocidad = -1;
/**
 * Este es el Constructor basico, que es identico 
 * al de la clase GOval
 * @param _ancho
 * @param _alto
 */
	public Pelota(double _ancho, double _alto){
		super(_ancho,_alto);
	}
	
/**
 * Este es el constructor dabuti que permite
 * pasar el color como parametro
 * @param _ancho indica el ancho y el alto de la pelota
 * @param _color
 */
	public Pelota(double _ancho, Color _color){
		super(_ancho,_ancho);
		if(_ancho <=0){
			this.setSize(1,1);
		}
		
		this.setFillColor(_color);
		this.setFilled(true);
	}
	/**
	 * se encarga de mover a la pelota y chequear si ha habido colision
	 */
	public void muevete(Arkanoid _arkanoid){
		//chequea si ha chocado con las paredes izq o derecha
		if(this.getX() + this.getWidth() >= _arkanoid.getWidth()- _arkanoid.espacioMenu 
				|| this.getX()<0){
			xVelocidad *=-1; 
			
		}
		//chequea si ha chocado con el techo
		if (this.getY()<0){
			yVelocidad*=-1;
		}
		if (chequeaColision(getX(), getY(), _arkanoid)){//chequeo la esquina superior izq
			if (chequeaColision(getX()+getWidth(), getY()+getHeight(), _arkanoid)){// chequeo la esquinas superior derech
				if (chequeaColision(getX(), getY()+getHeight(), _arkanoid)){// chequeo la esquina superior izq
					if (chequeaColision(getX()+getWidth(), getY(), _arkanoid)){// chequeo la esquina inferior derecha
				}
				}
			}
		}
		
		//voy a crear un metodo chequeacolision gernerico
		//que sirva para comprobar loso choques entre la bola y los ladrillos
		// y la bola y el cursor
		move(xVelocidad, yVelocidad);
	}
	
	private boolean chequeaColision(double posX, double posY, Arkanoid _arkanoid){
		boolean noHaChocado = true;
		GObject auxiliar;
		auxiliar = _arkanoid.getElementAt(posX,posY);
		
		if(auxiliar instanceof Ladrillo){
			if(auxiliar.getY() == posY || auxiliar.getY() + auxiliar.getHeight() == posY){
				yVelocidad *=-1;
			}
			else if (auxiliar.getX() == posX || auxiliar.getX()+auxiliar.getWidth()==posX){
				xVelocidad *=-1;
			}
			_arkanoid.remove(auxiliar);
			noHaChocado= false;
		}
		else if(auxiliar instanceof Cursor){
			yVelocidad *=-1;
			noHaChocado= false;
		}
		return noHaChocado;
		
	}
	
	//private void chequeaColisionConBarra(Arkanoid _arkanoid){
		//chquea las esquinas infwerior de la pelota
		//para ver si hay una barra
		//if (_arkanoid.getElementAt(getX(),getY()+getHeight())
			//	== _arkanoid.cursor1){
			//yVelocidad *=-1;
		//}else if (_arkanoid.getElementAt(getX()+getWidth(),getY()+getHeight())
			//	== _arkanoid.cursor1){
			//yVelocidad *=-1;
			
		//}
	//}
	
	
}
