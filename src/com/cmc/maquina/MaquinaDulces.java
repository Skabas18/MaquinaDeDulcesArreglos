package com.cmc.maquina;

import java.util.ArrayList;

import com.cmc.componentes.Celda;
import com.cmc.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas = new ArrayList<Celda>();
	private double saldo;

	public void agregarCelda(String codigo) {
		Celda c = new Celda(codigo);
		celdas.add(c);
	}

	public void mostrarConfiguracion() {
		Celda c1 = null;
		for (int i = 0; i < celdas.size(); i++) {
			c1 = celdas.get(i);
			System.out.println("Celda: " + c1.getCodigo());
		}
	}

	public Celda buscarCelda(String codigo) {
		Celda c;
		for (int i = 0; i < celdas.size(); i++) {
			c = celdas.get(i);
			if (c.getCodigo().equals(codigo)) {
				return celdas.get(i);
			}
		}
		return null;
	}

	public void cargarProducto(Producto atributo, String codigo, int items) {
		Celda celdaRecuperada = buscarCelda(codigo);
		celdaRecuperada.ingresarProducto(atributo, items);

	}

	public void mostrarProductos() {
		Celda c = null;
		for (int i = 0; i < celdas.size(); i++) {
			c = celdas.get(i);
			if (c.getProducto() != null) {
				System.out.println("Celda: " + c.getCodigo());
				System.out.println("Stock: " + c.getStock());
				System.out.println("Nombre producto: " + c.getProducto().getNombre());
				System.out.println("Precio producto: " + c.getProducto().getPrecio());
			}else{
				System.out.println("Celda: " + c.getCodigo());
				System.out.println("Stock: " + c.getStock());
				System.out.println("Producto sin asignar");
			}

		}
	}
	
	public Producto buscarProductoEnCelda(String codigo){
		Celda p=null;
		for (int i = 0; i < celdas.size(); i++) {
			p= celdas.get(i);
			if(p.getCodigo().equals(codigo)){
				if(p.getProducto()!=null){
					return p.getProducto();
				}
			}
		}
		return null;
	}
	public double consultarPrecio(String codigo){
		Celda pre=null;
		for (int i = 0; i < celdas.size(); i++) {
			pre=celdas.get(i);
			if(pre.getCodigo().equals(codigo)){
				if (pre.getProducto()!=null) {
					return pre.getProducto().getPrecio();
				}else{
					System.out.println("NO hay producto asignado");
				} 
				}
			}
		return 0;
	}
	public Celda buscarCeldaProducto(String codigo){
		Celda c=null;
		for (int i = 0; i < celdas.size(); i++) {
			c=celdas.get(i);
			if(c.getProducto()!=null){
				if(c.getProducto().getCodigo().equals(codigo)){
					return c;
				}
			}
		}
		return null;
	}
	public void incrementarProductos(String codigoproducto, int items){
		Celda celdaEncontrada= buscarCeldaProducto(codigoproducto);
		celdaEncontrada.setStock(celdaEncontrada.getStock()+items);
	}
	
	public void vender(String codigocelda){
		Celda c= null;
		for (int i = 0; i < celdas.size(); i++) {
			c= celdas.get(i);
			if(c.getCodigo().equals(codigocelda)){
				c.setStock(c.getStock()-1);
				saldo= saldo+c.getProducto().getPrecio();
			}
		}
		mostrarProductos();
	}
}
