package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class DiscosDonPepe implements Serializable {

	HashMap<String, String> hashMapUsuarios = new HashMap<>();
	ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
	ArbolBinarioArtistas arbolArtistas = new ArbolBinarioArtistas();
	Usuario usuarioLogeado;

	public DiscosDonPepe() {
	}

	public HashMap<String, String> getHashMapUsuarios() {
		return hashMapUsuarios;
	}

	public void setHashMapUsuarios(HashMap<String, String> hashMapUsuarios) {
		this.hashMapUsuarios = hashMapUsuarios;
	}

	public ArbolBinarioArtistas getArbolArtistas() {
		return arbolArtistas;
	}

	public void setArbolArtistas(ArbolBinarioArtistas arbolArtistas) {
		this.arbolArtistas = arbolArtistas;
	}

	public ArrayList<Cancion> getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}

	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

}
