package codigo.src.main.java.guardaropas;

public class PropuestaQuitar extends PropuestaModificacion{

  public PropuestaQuitar(Prenda prenda) {
    super(prenda);
  }

  @Override
  public void deshacer(Guardaropas guardaropas) {
    this.estado = Estado.DESECHA;
    guardaropas.agregarPrenda(this.prenda);
  }

  @Override
  public void ejecutarAceptacion(Guardaropas guardaropas) {
    guardaropas.quitarPrenda(this.prenda);
  }
}
