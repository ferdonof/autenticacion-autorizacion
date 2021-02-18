import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import entidades.ItemMenuAut;
import entidades.Rol;
import entidades.Usuario;

public class Main {

	public static void main(String[] args) {
		Map<Integer, ItemMenuAut> mapaMenus = cargarMapaMenus();
		
		
		Rol rolAdmin = new Rol(1l, "Administrador");
		Rol rolCliente = new Rol(2l, "Cliente");
		Rol rolUsuario = new Rol(3l, "Usuario");				
				
				
		rolCliente.addItemMenu(mapaMenus.get(1));
		rolCliente.addItemMenu(mapaMenus.get(6));
		rolCliente.addItemMenu(mapaMenus.get(4));

		rolUsuario.addItemMenu(mapaMenus.get(1));
		
		rolAdmin.addItemMenu(mapaMenus.get(1));
		rolAdmin.addItemMenu(mapaMenus.get(2));
		rolAdmin.addItemMenu(mapaMenus.get(3));
		rolAdmin.addItemMenu(mapaMenus.get(4));
		rolAdmin.addItemMenu(mapaMenus.get(5));
		rolAdmin.addItemMenu(mapaMenus.get(6));
		
		//Cliente
		Usuario pepe = new Usuario("pepe", "pepe123456", "pepe@pepsse.com");
		pepe.addRol(rolCliente);
		
		
		//Aministradora
		Usuario juana = new Usuario("juana", "juana123456", "juana@pepsse.com");
		juana.addRol(rolAdmin);
		
		//Usuario
		Usuario ramon = new Usuario("ramon", "ramon123456", "rama@pepsse.com");		
		ramon.addRol(rolUsuario);
		
		
		
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

	public static Map<Integer, ItemMenuAut> cargarMapaMenus() {
		
		Map<Integer, ItemMenuAut> mapa = new HashMap<Integer, ItemMenuAut>();
		
		//Administrador - Cliente - Usuario
		mapa.put(1, new ItemMenuAut(1, "Acerca de"));	
		
		//Administrador
		mapa.put(2, new ItemMenuAut(2, "Cargar usuario"));
		
		//Administrador
		mapa.put(3, new ItemMenuAut(3, "Borrar usuario"));

		//Administrador - Cliente
		mapa.put(4, new ItemMenuAut(4, "Acceso restringido cliente"));
		
		//Administrador
		mapa.put(5, new ItemMenuAut(5, "Acceso restringido 2"));
		
		//Cliente
		mapa.put(6, new ItemMenuAut(6, "Acceso Cliente"));
	
		return mapa;
		
	}
	
}
