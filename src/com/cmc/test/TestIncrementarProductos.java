package com.cmc.test;

import com.cmc.componentes.Producto;
import com.cmc.maquina.MaquinaDulces;

public class TestIncrementarProductos {
	public static void main(String[] args) {
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.agregarCelda("A");
		maquina.agregarCelda("B");
		maquina.agregarCelda("C");
		maquina.agregarCelda("D");
		
		Producto producto=new Producto("Papitas",0.85,"KE34");
		maquina.cargarProducto(producto, "B", 4);
		
		maquina.cargarProducto(new Producto( "Gatorade", 2.54,"BDCR"),"D",5);
		maquina.mostrarProductos();
		System.out.println("------------Luego de incrementar---------");
		
		maquina.incrementarProductos("KE34", 6);
		
		maquina.mostrarProductos();
	}
}
