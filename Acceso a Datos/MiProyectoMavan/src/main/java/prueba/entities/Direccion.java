package prueba.entities;

public class Direccion {
	private int id;
	private int personaId;
	private String direccion;
	public Direccion(int id, int personaId, String direccion) {
		this.id = id;
		this.personaId = personaId;
		this.direccion = direccion;
	}
	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", personaId=" + personaId + ", direccion=" + direccion + "]";
	}
	
	
}
