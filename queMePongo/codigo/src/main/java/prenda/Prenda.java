package prenda;

public class Prenda {
  private TipoPrenda tipoPrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama;

  public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal, Color colorSecundario, Trama trama){
    this.tipoPrenda = tipoPrenda;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.trama = trama;
  }

  public Categoria categoria(){
    return tipoPrenda.getCategoria();
  }

  public boolean esAptaParaTemperatura(int temperatura){
    return tipoPrenda.esAptaParaTemperatura(temperatura);
  }
}
