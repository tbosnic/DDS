package prenda;

public enum TipoPrenda {
  ZAPATOS(Categoria.CALZADO, 25),
  CAMISA_MANGAS_CORTAS(Categoria.PARTE_SUPERIOR, 35),
  PANTALON(Categoria.PARTE_INFERIOR, 20),
  REMERA_MANGAS_LARGAS(Categoria.PARTE_SUPERIOR, 20);

  private Categoria categoria;
  private int temperaturaMaximaOptima;

  private TipoPrenda(Categoria categoria, int temperaturaMaximaOptima){
    this.categoria = categoria;
    this.temperaturaMaximaOptima = temperaturaMaximaOptima;
  }

  public Categoria getCategoria(){
    return categoria;
  }

  public boolean esAptaParaTemperatura(int temperatura){
    return temperaturaMaximaOptima > temperatura;
  }
}
