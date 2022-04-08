public class Prenda {
    private int precioPropio;
    private TipoPrenda tipo;
    private EstadoPrenda estado;
    
    public int getPrecioVenta(){
        return estado.calcularPrecioVenta(precioPropio);
    }
    
    public TipoPrenda getTipoPrenda(){
        return tipo;
    }
}

public enum TipoPrenda {
	SACO, PANTALON, CAMISA;
}

public interface EstadoPrenda {
	public int calcularPrecioVenta(int precioPropio);
}

public class Nueva implements EstadoPrenda {
	public int calcularPrecioVenta(int precioPropio){
		return precioPropio;
	}
}

public class Promocion implements EstadoPrenda {
	int valor;
	
	public int calcularPrecioVenta(int precioPropio){
		return precioPropio - valor;
	}
}

public class Liquidacion implements EstadoPrenda {
	public int calcularPrecioVenta(int precioPropio){
		return precioPropio * 0.50;
	}
}

public class Negocio {
	private List<Venta> ventas = new ArrayList<>();
	
	public int calcularGananciasDeDia(LocalDate dia){
		return ventas.stream().filter(venta -> venta.getDia().equals(dia)).sum(venta -> venta.PrecioVentaTotal());
	}
}

public class Venta {
	private List<Prenda> prendasVendidas = new ArrayList<>();
	private LocalDate dia;
	private MedioDePago medio;
	
	public int PrecioVentaNeto(){
		return prendasVendidas.sum(prenda -> prenda.getPrecioVenta());
	}
	
	public int PrecioVentaTotal(){
		return medio.calcularPrecioTotal(getPrecioVentaNeto());
	}
}

public interface MedioDePago {
	public int calcularPrecioTotal(int precio);
}

public class Efectivo implements MedioDePago {
	public int calcularPrecioTotal(int precio){
		return precio;
	}
}

public class Tarjeta implements MedioDePago {
	private int cuotas;
	private float coeficiente;
		
	public int calcularPrecioTotal(int precio){
		return precio + (precio * 0.01 + cuotas * coeficiente);
	}
}