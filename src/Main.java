import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import database.BaseDatos;
import entidades.ItemMenuAut;
import entidades.Rol;
import entidades.Usuario;

public class Main {

	public static void main(String[] args) {
		BaseDatos bd = new BaseDatos();
		
		Usuario ramon = bd.getUsuarioPorUsername("ramon");		
		Usuario juana = bd.getUsuarioPorUsername("Juana");		
		Usuario pepe = bd.getUsuarioPorUsername("pepe");		
		
		
		
		ramon.getMenusUsuario();
		juana.getMenusUsuario();
		pepe.getMenusUsuario();
		
		int itemMenuId = -1;
		
		
		while (itemMenuId != 0) {
			
			for (Rol rol : ramon.getRoles()) {
				
				for (ItemMenuAut menu : rol.getItemsMenu()) 
					System.out.println("Ingrese "+menu.getIdItemMenu()+" para acceder a la seccion del menu "+menu.getNombre());
				
			}
			
			itemMenuId = 0;
		}
		
		
	}	

	
}
