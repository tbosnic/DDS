package codigo.src.main.java.guardaropas;

public class PropuestaAgregar extends PropuestaModificacion{

  public PropuestaAgregar(Prenda prenda) {
    super(prenda);
  }

  @Override
  public void deshacer(Guardaropas guardaropas) {
    this.estado = Estado.DESECHA;
    guardaropas.quitarPrenda(this.prenda);
  }

  @Override
  public void ejecutarAceptacion(Guardaropas guardaropas) {
    guardaropas.agregarPrenda(this.prenda);
  }
}
