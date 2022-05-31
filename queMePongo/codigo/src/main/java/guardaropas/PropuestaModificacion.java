package codigo.src.main.java.guardaropas;
package codigo.src.main.java.prenda;

public abstract class PropuestaModificacion {

  protected Estado estado;
  protected Prenda prenda;

  public PropuestaModificacion(Prenda prenda){
    this.estado = Estado.PENDIENTE;
    this.prenda = prenda;
  }

  public Estado getEstado(){
    return estado;
  }

  public void aceptar(Guardaropas guardaropas){
    this.estado = Estado.ACEPTADA;
    this.ejecutarAceptacion(guardaropas);
  }

  public void rechazar(){
    this.estado = Estado.RECHAZADA;
  }

  public abstract void deshacer(Guardaropas guardaropas);

  public abstract void ejecutarAceptacion(Guardaropas guardaropas);
}
