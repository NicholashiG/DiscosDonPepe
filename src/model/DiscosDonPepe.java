package model;

import java.io.Serializable;
import java.util.ArrayList;

public class DiscosDonPepe implements Serializable{
	
	ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
    ArrayList<Artista> listaArtistas = new ArrayList<Artista>();
    Usuario usuarioLogeado;
	
    public DiscosDonPepe() {
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ArrayList<Cancion> getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}

	public ArrayList<Artista> getListaArtistas() {
		return listaArtistas;
	}

	public void setListaArtistas(ArrayList<Artista> listaArtistas) {
		this.listaArtistas = listaArtistas;
	}

	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}
    
    
    
    
    
    

}
