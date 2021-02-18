package entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entidades.Rol;

public class Usuario {
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private Set<Rol> roles  = new HashSet<>();
	
	public Usuario(String username, String password, String email) {
		this.username = username;
		if ((password.length() >= 10) == false)
			throw new RuntimeException("La contraseña debe ser de al menos 10 caracteres.");
		this.password = password;
		if (!(email.contains("@")))
			throw new RuntimeException("El email no tiene el @, por lo tanto no es válido");
		this.email = email;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	public void addRol(Rol rol) {
		this.roles.add(rol);
	}
	
	public void getMenusUsuario() {
		System.out.println("Menus de usuario de "+this.getUsername());
		for (Rol rol : roles) {
			for (ItemMenuAut item : rol.getItemsMenu()) {
				System.out.println(item.getNombre());
			}
		}
		System.out.println("******************");
	}
}
