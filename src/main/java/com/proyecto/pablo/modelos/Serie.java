package com.proyecto.pablo.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="series")
public class Serie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AI
	private Long id;
	
	@NotBlank(message="Titulo obligatorio")
	@Size(min=2, message="Titulo debe tener al menos 2 caracteres")
	private String titulo;
	
	@NotNull(message="Ano obligatorio") // Cuando el tipo de dato es diferente a String, SOLO utilizamos NotNull
	@Min(value=1900, message="El año minimo en 1900")
	@Max(2025)
	private Integer anio;
	
	@NotBlank(message="Descripcion obligatoria")
	private String descripcion;
	
	@NotBlank(message="URL obligatorio")
	private String urlImagen;
	
	// CANTIDAD
	@NotNull(message="Cantidad obligatoria")
	private Integer cantidad;
	
	@NotBlank(message="Precio obligatorio")
	private String precio;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id") // Llave Foreana
	private Usuario creador; // Usuario que creo la peli
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="series_favoritas",joinColumns= @JoinColumn(name="serie_id"),inverseJoinColumns= @JoinColumn(name="usuario_id"))
	private List<Usuario> usuarios; // Los usuarios que dieron favoritos

	// Constructor Vacio
	public Serie() {
	}

	// Getters y Setters
	
	
	
	public Long getId() {
		return id;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	@PrePersist // Antes de crear el registro
	protected void onCreate() {
		this.createdAt = new Date(); // Genera una nueva fecha para createdAt {DEFAULT CURRENT_TIMESTAMP)
	}
	
	@PreUpdate // Antes de actualizar el registro
	protected void onUpdate() {
		this.updatedAt = new Date(); // Genera una nueva fecha para updatedAt {DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)
	}
	

}
