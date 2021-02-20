package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import entidades.ItemMenuAut;
import entidades.Rol;
import entidades.Usuario;


public class BaseDatos {
	List<Usuario> usuarios = new ArrayList<>();
	List<Rol> roles = new ArrayList<>();
	Map<Integer, ItemMenuAut> menus = new HashMap();
	
	
	public BaseDatos() {
		this.menus = cargarMapaMenus();
		this.roles = cargarRoles();
		this.usuarios = cargarUsuarios();
	}
	
	public Map<Integer, ItemMenuAut> cargarMapaMenus() {
		
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

	
	public List<Rol> cargarRoles(){
		Rol rolAdmin = new Rol(1l, "Administrador");
		Rol rolCliente = new Rol(2l, "Cliente");
		Rol rolUsuario = new Rol(3l, "Usuario");
		
		
		rolCliente.addItemMenu(this.menus.get(1));
		rolCliente.addItemMenu(this.menus.get(6));
		rolCliente.addItemMenu(this.menus.get(4));

		rolUsuario.addItemMenu(this.menus.get(1));
		
		rolAdmin.addItemMenu(this.menus.get(1));
		rolAdmin.addItemMenu(this.menus.get(2));
		rolAdmin.addItemMenu(this.menus.get(3));
		rolAdmin.addItemMenu(this.menus.get(4));
		rolAdmin.addItemMenu(this.menus.get(5));
		rolAdmin.addItemMenu(this.menus.get(6));

		
		
		
		ArrayList<Rol> roles = new ArrayList<>();
		roles.add(rolCliente);
		roles.add(rolUsuario);
		roles.add(rolAdmin);
		
		return roles;
	}
	
	
	public List<Usuario> cargarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		
		//Cliente
		Usuario pepe = new Usuario("pepe", "pepe123456", "pepe@pepsse.com");
		pepe.addRol(this.getRol("Cliente"));
		
		
		//Aministradora
		Usuario juana = new Usuario("juana", "juana123456", "juana@pepsse.com");
		juana.addRol(this.getRol("Administrador"));
		
		//Usuario
		Usuario ramon = new Usuario("ramon", "ramon123456", "rama@pepsse.com");		
		ramon.addRol(this.getRol("Usuario"));
		
		usuarios.add(pepe);
		usuarios.add(juana);
		usuarios.add(ramon);
		
		return usuarios;
	}
	
	private Rol getRol(String nombreRol) {
		
		return this.roles.stream()
				.filter(rol -> nombreRol.equalsIgnoreCase(rol.getNombre()))
				.findFirst()
				.orElseThrow(()->new RuntimeException("No se encontro el rol " + nombreRol));
	}

	public Usuario getUsuarioPorUsername(String nombre) {
		
		Usuario usuario = this.usuarios.stream()
				.filter(user -> nombre.equalsIgnoreCase(user.getUsername()))
				.findFirst()
				.orElseThrow(()->new RuntimeException("No se encontro el usuario " + nombre));

		return usuario;
	}
	
}
