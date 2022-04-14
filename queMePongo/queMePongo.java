class Prenda{
    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrincipal;

    Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal){

        //VALIDAR QUE SE PASAN TODOS LOS PARAMETROS, CASO CONTARIO, LANZAR EXCEPCION

        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
    }

    Categoria categoria(){
        return tipoPrenda.getCategoria();
    }
}

public enum Material{
    MATERIALES
}

class Color{
    int rojo, azul, verde;

    Color(int rojo, int azul, int verde){
        this.rojo = rojo;
        this.azul = azul;
        this.verde = verde;
    }
}

abstract class TipoPrenda{
    Categoria categoria;

    TipoPrenda(Categoria categoria){
        this.categoria = categoria;
    }

    Categoria getCategoria(){
        return categoria;
    }

    abstract boolean esCategoriaValida(Categoria categoria);
}

class Zapatos extends TipoPrenda{

    Zapatos(Categoria categoria){
        if(!this.esCategoriaValida(categoria)){

            //LANZAR EXCEPCION

        }
        super(categoria);
    }

    boolean esCategoriaValida(Categoria categoria){
        if (categoria != Categoria.CALZADO){
            return false;
        }
        else{
            return true;
        }
    }
}

class CamisaMangasCortas extends TipoPrenda{

    CamisaMangasCortas(Categoria categoria){
        if(!this.esCategoriaValida(categoria)){

            //LANZAR EXCEPCION

        }
        super(categoria);
    }

    boolean esCategoriaValida(Categoria categoria){
        if (categoria != Categoria.PARTE_SUPERIOR){
            return false;
        }
        else{
            return true;
        }
    }
}

class Pantalon extends TipoPrenda{

    Pantalon(Categoria categoria){
        if(!this.esCategoriaValida(categoria)){

            //LANZAR EXCEPCION

        }
        super(categoria);
    }

    boolean esCategoriaValida(Categoria categoria){
        if (categoria != Categoria.PARTE_INFERIOR){
            return false;
        }
        else{
            return true;
        }
    }
}

public enum Categoria{
    PARTE_SUPERIOR, 
    CALZADO, 
    PARTE_INFERIOR, 
    ACCESORIOS;
}