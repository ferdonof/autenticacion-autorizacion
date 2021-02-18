package entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rol {
	private Long id = 1l;
	private String nombre = "";
	private List<Usuario> usuarios = new ArrayList<>();
	private Set<ItemMenuAut> itemsMenu = new HashSet<>();
	
	
	public Rol(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<ItemMenuAut> getItemsMenu() {
		return itemsMenu;
	}

	public void setItemsMenu(Set<ItemMenuAut> itemsMenu) {
		this.itemsMenu = itemsMenu;
	}
	
	public void addItemMenu(ItemMenuAut item) {
		this.itemsMenu.add(item);
	}
	
	
}
