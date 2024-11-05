package util;
public class PilaUtil<T> {

    private NodoUtil<T> cima;
    private int tamano;

    /**
     * Verifica si la PilaUtil est� vac�a
     * @return true si est� vac�a
     */
    public boolean estaVacia() {
        return cima==null;
    }

    /**
     * Inserta un elemento en la PilaUtil - push
     * @param dato elemento a guardar en la pila
     */
    public void push(T dato) {

        NodoUtil<T> nodo = new NodoUtil<>(dato);
        nodo.setSiguienteNodo(cima);
        cima = nodo;

        tamano++;
    }

    /**
     * Retorna y elimina el elemento que est� en la cima de la PilaUtil - pop
     * @return Elemento de la cima
     */
    public T pop() {

        if(estaVacia()) {
            throw new RuntimeException("La PilaUtil est� vac�a");
        }

        T dato = cima.getValorNodo();
        cima = cima.getSiguienteNodo();
        tamano--;

        return dato;
    }

    /**
     * Borra completamente la PilaUtil
     */
    public void borrarPila() {
        cima = null;
        tamano = 0;
    }

    /**
     * @return the cima - peek
     */
    public T obtenerCima() {
        return cima.getValorNodo();
    }

    /**
     * @return the cima - peek
     */
    public NodoUtil<T> getCima() {
        return cima;
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * Agrega una PilaUtil nueva
     * @param pilaUtil nueva PilaUtil
     */
    public void agregar(PilaUtil<T> pilaUtil) {

        PilaUtil<T> clon = pilaUtil.clone();
        PilaUtil<T> aux = new PilaUtil<>();

        while(!clon.estaVacia()) {
            aux.push(clon.pop());
        }

        while(!aux.estaVacia()) {
            push(aux.pop());
        }

    }

    /**
     * Imprime una pila en consola
     */
    public void imprimir() {
        NodoUtil<T> aux = cima;
        while(aux!=null) {
            System.out.print(aux.getValorNodo()+"\t");
            aux = aux.getSiguienteNodo();
        }
        System.out.println();
    }



    @Override
    protected PilaUtil<T> clone(){

        PilaUtil<T> pilaUtilFinal = new PilaUtil<>();
        NodoUtil<T> nodoCima = null;

        for (NodoUtil<T> aux = cima; aux!=null; aux = aux.getSiguienteNodo()) {

            NodoUtil<T> nuevo = new NodoUtil<>( aux.getValorNodo() );

            if(pilaUtilFinal.estaVacia()) {
                pilaUtilFinal.cima = nuevo;
                nodoCima = nuevo;
            }else {
                pilaUtilFinal.cima.setSiguienteNodo(nuevo);
                pilaUtilFinal.cima = nuevo;
            }
            pilaUtilFinal.tamano++;

        }

        pilaUtilFinal.cima = nodoCima;

        return pilaUtilFinal;
    }

}