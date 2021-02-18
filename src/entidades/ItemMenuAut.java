package entidades;

public class ItemMenuAut {
	private Integer idItemMenu;
	private String nombre;
	
	
	public ItemMenuAut(int id, String nombre) {
		this.setIdItemMenu(id);
		this.setNombre(nombre);
	}

	public int getIdItemMenu() {
		return idItemMenu;
	}

	public void setIdItemMenu(int idItemMenu) {
		this.idItemMenu = idItemMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
