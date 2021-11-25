package pe.edu.upc.trabajo.utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Carrito {
		
	//----Products---   //----Order---
	//product_id        //order_id 
	//producer_id 		//shipment_id
	//product_name		//payment_id
	//description		//wholesaler_id
	//price				//amount
	//category_id		//date	
	
	//----Details---  
	//order_id
	//product_id
	//producer_id
	//quantity
	//unit_price
	
	private Integer item;//tiene aumento del item 
	private Integer idOrder;//captura el ide del producto
	private Float precio;//precio de producto
	private Integer cantidad;//cantidad es un atributo que esta en la funcion
	private Float monto;//es la monto=(cantidad * precio)
	
	//Int a = Integer.parseInt(null)
	
	//listarCarrito.add(objeto) 
	//se debe devolver un objeto con el tamaño y el objeto carrito
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
}
