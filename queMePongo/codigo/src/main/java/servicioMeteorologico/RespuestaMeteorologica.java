package servicioMeteorologico;

import java.time.LocalDateTime;

public class RespuestaMeteorologica {
  private LocalDateTime expiracion;
  private int temperatura;

  public RespuestaMeteorologica(int temperatura, LocalDateTime expiracion){
    this.temperatura = temperatura;
    this.expiracion = expiracion;
  }

  public boolean expiro() {
    return this.expiracion.isBefore(LocalDateTime.now());
  }

  public int getTemperatura(){
    return temperatura;
  }
}
