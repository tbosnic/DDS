import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Negocio {
	private List<Venta> ventas;
  
	public Negocio(){
	  ventas = new ArrayList<>();
	}
  
	public void registrarVenta(Venta venta){
	  ventas.add(venta);
	}
  
	public Double gananciasDeUnDia(LocalDate unDia){
	  return ventasDeUnDia(unDia).stream().mapToDouble(venta -> venta.importe()).sum();
	}
  
	private List<Venta> ventasDeUnDia(LocalDate unDia){
	  return ventas.stream().filter(venta -> venta.esDeFecha(unDia)).collect(Collectors.toList());
	}
}

// PATRON TEMPLATE METHOD -> CLASE PADRE, DONDE HAY METODOS CON COMPORTAMIENTO COMUN EN SUS CLASES HIJAS, EXCEPTO POR UNA PEQUENIA PARTE, DONDE CADA CLASE HIJA LO IMPLEMENTA
// 							 A SU MANERA.

abstract class Venta {
	private List<Item> items;
	private LocalDate fecha;
  
	public Venta(List<Item> items, LocalDate fecha){
	  this.items = items;
	  this.fecha = fecha;
	}
  
	public boolean esDeFecha(LocalDate fecha){
	  return (this.fecha.isEqual(fecha));
	}
  
	public Double importe(){
	  return recargo(this.sumaDeItems());
	}
  
	private Double sumaDeItems(){
	  return items.stream().mapToDouble(item -> item.importe()).sum();
	}
  
	protected abstract Double recargo(Double importeBase);
}

class VentaEnEfectivo extends Venta{
	public VentaEnEfectivo(List<Item> items, LocalDate fecha){
	  super(items, fecha);
	}

	@Override
	protected Double recargo(Double importeBase) {
	  return importeBase;
	}
}

class VentaConTarjeta extends Venta{
	Integer cantidadCuotas;
	Double coeficienteTarjeta;
  
	public VentaConTarjeta(List<Item> items, LocalDate fecha, Integer cantidadCuotas, Double coeficienteTarjeta){
	  super(items, fecha);
	  this.cantidadCuotas = cantidadCuotas;
	  this.coeficienteTarjeta = coeficienteTarjeta;
	}

	@Override
	protected Double recargo(Double importeBase) {
	  return importeBase + (importeBase * 0.01 + cantidadCuotas * coeficienteTarjeta);
	}
}

class Item {
	private Prenda prenda;
	private Integer cantidad;
  
	public Item(Prenda prenda, Integer cantidad){
	  this.prenda = prenda;
	  this.cantidad = cantidad;
	}
  
	public Double importe(){
	  return prenda.precioVenta() * cantidad;
	}
}

class Prenda {
	private Integer precioOriginal;
	private TipoPrenda tipoPrenda;
	private EstadoPrenda estadoPrenda;
  
	public Prenda(Integer precioOriginal, TipoPrenda tipoPrenda, EstadoPrenda estadoPrenda){
	  this.precioOriginal = precioOriginal;
	  this.tipoPrenda = tipoPrenda;
	  this.estadoPrenda = estadoPrenda;
	}
  
	public Double precioVenta(){
	  return estadoPrenda.precioFinal(this.precioOriginal);
	}
  
	public TipoPrenda tipoPrenda(){
	  return this.tipoPrenda;
	}
}

enum TipoPrenda {
	SACO,
	PANTALON,
	CAMISA
}

// PATRON STRATEGY -> LA PRENDA DELEGA PARTE DE SU COMPORTAMIENTO EN TRES OBJETOS POLIMORFICOS QUE COMPARTEN UNA INTERFAZ. CADA OBJETO (O CLASE) SE LLAMAN ESTRATEGIAS
// 					  QUE SE PUEDEN INTERCAMBIAR DINAMICAMENTE.
//                    EL CAMBIO DE ESTRATEGIA ES SIEMPRE ARBITARIO (NO HAY ORDEN). EJ: SI UNA PRENDA EMPIEZA SIENDO NUEVA, PUEDE CAMBIAR A PROMOCION O LIQUIDACION.
//					  LA DECISION DEL CAMBIO ES DE UN OBJETO EXTERNO. NO LO DECIDE NI LA ESTRATEGIA NI EL OBJETO QUE TIENE LA ESTRATEGIA.

interface EstadoPrenda {
	Double precioFinal(Integer precioOriginal);
}

class Liquidacion implements EstadoPrenda {
	@Override
	public Double precioFinal(Integer precioOriginal) {
	  return (precioOriginal * 0.50);
	}
}

class Nueva implements EstadoPrenda {
	@Override
	public Double precioFinal(Integer precioOriginal) {
	  return Double.valueOf(precioOriginal);
	}
}

class Promocion implements EstadoPrenda {
	Integer descuento;
  
	public Promocion(Integer descuento){
	  this.descuento = descuento;
	}

	@Override
	public Double precioFinal(Integer precioOriginal) {
	  return Double.valueOf((precioOriginal - this.descuento));
	}
}