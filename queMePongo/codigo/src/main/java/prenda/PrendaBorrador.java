package codigo.src.main.java.prenda;
import prenda.Prenda;
import prenda.Categoria;
import prenda.Color;
import prenda.Material;
import prenda.TipoPrenda;
import prenda.Trama;

import static java.util.Objects.requireNonNull;

// PATRON BUILDER -> USO UNA CLASE PARA CONFIGURAR LA CLASE FINAL QUE QUIERO CREAR. ME PERMITE HACERLO POR ETAPAS, TENER UNA REPRESENTACION MUTABLE DE UN OBJETO NO MUTABLE,
//                   DELEGAR LAS VALIDACIONES, TENER VALORES DE ATRIBUTOS POR DEFECTO.

public class PrendaBorrador {
  private TipoPrenda tipoPrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama = Trama.LISA;

  public PrendaBorrador setTipoPrenda(TipoPrenda tipoPrenda){
    this.tipoPrenda = tipoPrenda;
    return this;
  }

  public PrendaBorrador setMaterial(Material material){
    this.material = material;
    return this;
  }

  public PrendaBorrador setColorPrincipal(Color color){
    this.colorPrincipal = color;
    return this;
  }

  public PrendaBorrador setColorSecundario(Color color){
    this.colorSecundario = color;
    return this;
  }

  public PrendaBorrador setTrama(Trama trama){
    this.trama = trama;
    return this;
  }

  public Prenda crearPrenda(){

    requireNonNull(tipoPrenda, "Debe especificar el tipo de prenda");
    requireNonNull(material, "Debe especificar el material");
    requireNonNull(colorPrincipal, "Debe especificar el color principal");

    // OTRA MANERA DE HACERLO ES CREAR UNA FUNCION validarParametros(tipoPrenda, material, colorPrincipal) (*)

    return new Prenda(this.tipoPrenda, this.material, this.colorPrincipal, this.colorSecundario, this.trama);
  }
}

// (*) private void validarParametros(TipoPrenda tipoPrenda, Material material, Color colorPrincipal){
//          if(tipoPrenda == null){
//              throw new PrendaInvalidaException("debe especificar el tipo de prenda");
//           }
//          if(material == null){
//              throw new PrendaInvalidaException("debe especificar el material");
//           }
//          if(colorPrincipal == null){
//              throw new PrendaInvalidaException("debe especificar el color principal");
//           }
//      }
//}

// public PrendaInvalidaException extends RuntimeException{
//      public PrendaInvalidaException(String causa){
//          super("La prenda es invalida porque: " + causa);
//      }
// }
