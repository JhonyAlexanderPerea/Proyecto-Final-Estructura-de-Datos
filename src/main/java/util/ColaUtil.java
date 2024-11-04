package util;

public class ColaUtil <T> {

    public NodoUtil<T> nodoPrimero, nodoUltimo;
    public int tamanio;

    /**
     * Agrega un elemento en la Cola
     * @param dato elemento a guardar en la Cola
     */
    public void encolar(T dato) {

        NodoUtil<T> nodo = new NodoUtil<>(dato);

        if(estaVacia()) {
            nodoPrimero = nodoUltimo = nodo;
        }else {
            nodoUltimo.setSiguienteNodo(nodo);
            nodoUltimo = nodo;
        }

        tamanio++;
    }

    /**
     * Retorna y elimina el elemento que est� al incio de la Cola
     * @return Primer elemento de la Cola
     */
    public T desencolar() {

        if(estaVacia()) {
            throw new RuntimeException("La Cola está vacía");
        }

        T dato = nodoPrimero.getValorNodo();
        nodoPrimero = nodoPrimero.getSiguienteNodo();

        if(nodoPrimero==null) {
            nodoUltimo = null;
        }

        tamanio--;
        return dato;
    }

    /**
     * Verifica si la Cola est� vac�a
     * @return true si est� vac�a
     */
    public boolean estaVacia() {
        return nodoPrimero == null;
    }



    /**
     * Borra completamente la Cola
     */
    public void borrarCola() {
        nodoPrimero = nodoUltimo = null;
        tamanio = 0;
    }

    /**
     * @return the primero
     */
    public NodoUtil<T> getPrimero() {
        return nodoPrimero;
    }

    /**
     * @return the ultimo
     */
    public NodoUtil<T> getUltimo() {
        return nodoUltimo;
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamanio;
    }

    /**
     * Verifica si la Cola es id�ntica a la actual
     * @param cola Cola a comparar
     * @return True si son iguales
     */
    public boolean sonIdenticas(ColaUtil<T> cola) {

        ColaUtil<T> clon1 = clone();
        ColaUtil<T> clon2 = cola.clone();

        if(clon1.getTamano() == clon2.getTamano()) {

            while( !clon1.estaVacia() ) {
                if( !clon1.desencolar().equals( clon2.desencolar() ) ) {
                    return false;
                }
            }

        }else {
            return false;
        }

        return  true;
    }

    /**
     * Imprime una cola en consola
     */
    public void imprimir() {
        NodoUtil<T> aux = nodoPrimero;
        while(aux!=null) {
            System.out.print(aux.getValorNodo()+"\t");
            aux = aux.getSiguienteNodo();
        }
        System.out.println();
    }

    @Override
    protected ColaUtil<T> clone() {

        ColaUtil<T> nueva = new ColaUtil<>();
        NodoUtil<T> aux = nodoPrimero;

        while(aux!=null) {
            nueva.encolar( aux.getValorNodo() );
            aux = aux.getSiguienteNodo();
        }

        return nueva;
    }


}
