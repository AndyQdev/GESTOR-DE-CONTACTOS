/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ArbolCliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author CLAUDIA CORTEZ
 * @param <K>
 * @param <V>
 */
public class ArbolBinarioBusqueda<K extends Comparable<K>, V> implements 
        IArbolBusqueda<K, V>{
    
    protected NodoBinario<K, V> raiz;
    
    
    /*RECONSTRUCCION DE UN ARBOL 
    EN BASE A SUS RECORRIDOS INORDEN Y (PRE O POST )SI EL PARAMETO USANDO PREORDEN
    ES VERDADERO ,LOS PARAMETROS CLAVES NOINORDEN Y VALORESNOUNORDEN TENDRA
     EL RECORRIDO EN PREORDEN DEL ARBOL,CASO CONTRARIO SERAN EL POSORDEN
    
    public ArbolBinarioBusqueda(List<K> clavesInOrden, List<V> valoresInOrden,
            List<K> clavesNoInOrden, List<V> valoresNoInOrden,
            boolean usandoPreOrden) {
            
        if (clavesInOrden == null
                || clavesNoInOrden == null
                || valoresInOrden == null
                || valoresNoInOrden == null) {
            throw new IllegalArgumentException("Los parametros no pueden estar null");
        }

        if (clavesInOrden.isEmpty() || clavesNoInOrden.isEmpty()
                || valoresInOrden.isEmpty() || valoresNoInOrden.isEmpty()) {
            throw new IllegalArgumentException("Los parametros no pueden estar vacios");
        }

        if (clavesInOrden.size() != clavesNoInOrden.size()
                || valoresInOrden.size() != valoresNoInOrden.size()
                || clavesInOrden.size() != valoresNoInOrden.size()) {
            throw new IllegalArgumentException("Los parametros no pueden ser listas de diferente tamanos");
        }

        if (usandoPreOrden) {
            this.raiz = reconstruirConPreOrden(clavesInOrden,valoresInOrden,
            clavesNoInOrden,valoresNoInOrden);
        } else {
            this.raiz = reconstruirConPostOrden(clavesInOrden, valoresInOrden,
                    clavesNoInOrden, valoresNoInOrden);
        }
    }

    private NodoBinario<K,V> reconstruirConPreOrden(List<K> clavesInOrden, List<V> valoresInOrden, List<K> clavesEnPreOrden, List<V> valoresEnPreOrden) {

        int posicionDeClavePadreEnPreOrden = 0;
        K clavePadre = clavesEnPreOrden.get(posicionDeClavePadreEnPreOrden);
        //V valorPadre = valoresInOrden.get(posicionDeClavePadreEnPreOrden);
        V valorPadre = valoresEnPreOrden.get(posicionDeClavePadreEnPreOrden);
        int posicionDeClavePadreInOrden = this.posicionDeClave(clavePadre,
                clavesInOrden);
        //Para armar la rama izquierda 

        List<K> clavesInOrdenPorIzquierda = clavesInOrden.subList(0, //n=3
                posicionDeClavePadreInOrden);//subList toma en cuenta valores de 0 hasta n-1
        List<V> valoresInOrdenPorIzquierda = valoresInOrden.subList(0,
                posicionDeClavePadreInOrden);
        List<K> clavesPreOrdenPorIzquierda = clavesInOrden.subList(0, //n=3
                posicionDeClavePadreInOrden);
        List<V> valoresPreOrdePorIzquierda = valoresInOrden.subList(0,
                posicionDeClavePadreInOrden);

        NodoBinario<K, V> hijoIzquierdo = reconstruirConPreOrden(clavesInOrdenPorIzquierda,
                valoresInOrdenPorIzquierda, clavesPreOrdenPorIzquierda,
                valoresPreOrdePorIzquierda);

        //para armar la rma derecha
        List<K> clavesInOrdenPorDerecha = clavesInOrden.subList(posicionDeClavePadreInOrden - 1, //n=3
                clavesInOrden.size());
        List<V> valoresInOrdePorDerecha = valoresInOrden.subList(posicionDeClavePadreInOrden - 1,
                clavesInOrden.size());
        List<K> clavesPreOrdenPorDerecha = clavesEnPreOrden.subList(posicionDeClavePadreInOrden - 1, //n=3
                posicionDeClavePadreInOrden);//subList toma en cuenta valores de 0 hasta n-1
        List<V> valoresPreOrdePorDerecha = valoresEnPreOrden.subList(posicionDeClavePadreInOrden - 1,
                clavesInOrden.size());
        NodoBinario<K, V> hijoDerecho = reconstruirConPreOrden(clavesInOrdenPorDerecha,
                 valoresInOrdePorDerecha, clavesPreOrdenPorDerecha, valoresPreOrdePorDerecha);

        //armando el nodoActual
        NodoBinario<K, V> nodoActual = new NodoBinario<>(clavePadre, valorPadre);
        nodoActual.setHijoIzquierdo(hijoIzquierdo);
        nodoActual.setHijoDerecho(hijoDerecho);

        return nodoActual;
    }
    
    

    private NodoBinario<K,V> reconstruirConPostOrden(List<K> clavesInOrden, List<V> valoresInOrden, List<K> clavesEnPostOrden, List<V> valoresEnPostOrden) {
        if(clavesInOrden.size() == 0){
            return NodoBinario.nodoVacio();
        }
        int posicionDeLaClavePadrePostOrden = clavesEnPostOrden.size() - 1;
        K clavePadre = clavesEnPostOrden.get(posicionDeLaClavePadrePostOrden);
        V valorPadre = valoresEnPostOrden.get(posicionDeLaClavePadrePostOrden);
        int posicionDeLaClaveEnInOrden = posicionDeClave(clavePadre, clavesInOrden);
        
        List<K> clavesEnInOrdenEnIzquierda = clavesInOrden.subList( 0,posicionDeLaClaveEnInOrden );
        List<V> valoresEnInOrdenEnIzquierda = valoresInOrden.subList( 0,posicionDeLaClaveEnInOrden);
        List<K> clavesEnPostOrdenEnIzquierda = clavesEnPostOrden.subList(0, posicionDeLaClaveEnInOrden);
        List<V> valoresEnPostOrdenEnIzquierda = valoresEnPostOrden.subList(0, posicionDeLaClaveEnInOrden);
        
        NodoBinario<K,V>hijoIzquierdo= reconstruirConPostOrden(clavesEnInOrdenEnIzquierda,valoresEnInOrdenEnIzquierda,
                  clavesEnPostOrdenEnIzquierda, valoresEnPostOrdenEnIzquierda);
        //para armar por derecha
        if(posicionDeLaClavePadrePostOrden == 0){
            return NodoBinario.nodoVacio();
        }
        List<K> clavesEnPostOrdenEnDerecha = clavesEnPostOrden.subList( posicionDeLaClaveEnInOrden-1, posicionDeLaClavePadrePostOrden );
        List<V> valoresEnPostOrdenEnDerecha = valoresEnPostOrden.subList(posicionDeLaClaveEnInOrden-1, posicionDeLaClavePadrePostOrden );
        List<K> clavesEnInOrdenEnDerecha = clavesInOrden.subList( posicionDeLaClaveEnInOrden-1, clavesEnPostOrden.size()  );
        List<V> valoresEnInOrdenEnDerecha = valoresInOrden.subList( posicionDeLaClaveEnInOrden-1, clavesEnPostOrden.size() );
        NodoBinario<K,V>hijoDerecho=reconstruirConPostOrden(clavesEnPostOrdenEnDerecha ,valoresEnPostOrdenEnDerecha,
                clavesEnInOrdenEnDerecha,valoresEnInOrdenEnDerecha );
        
        //armar nodoactual
        NodoBinario<K, V> nodoActual = new NodoBinario<>(clavePadre, valorPadre);
        nodoActual.setHijoIzquierdo(hijoIzquierdo);
        nodoActual.setHijoDerecho(hijoDerecho);
        
        return nodoActual;
    }

    private int posicionDeClave(K claveABuscar, List<K> listaDeClaves) {
        for (int i = 0; i < listaDeClaves.size(); i++) {
            K claveActual = listaDeClaves.get(i);
            if (claveABuscar.compareTo(claveActual) == 0) {
                return i;
            }
        }
        return -1;
    }*/
    
    @Override
    public void insertar(K claveAInsertar, V valorAsociado) {
        if(claveAInsertar == null){
            throw new IllegalArgumentException("La clave no puede ser nula");
        }
        
        if(valorAsociado == null){
            throw new IllegalArgumentException("El valor no puede ser nulo");
        }
        
        if(this.esArbolVacio()){
            this.raiz = new NodoBinario<>(claveAInsertar, valorAsociado);
            return;
        }
        
        NodoBinario<K, V> nodoAnterior = NodoBinario.nodoVacio();
        NodoBinario<K, V> nodoActual = this.raiz;
        
        do{
            K claveActual = nodoActual.getClave();
            int comparacion = claveAInsertar.compareTo(claveActual);
            nodoAnterior = nodoActual;
            if(comparacion < 0){
                nodoActual = nodoActual.getHijoIzquierdo();
            }else if(comparacion > 0){
                nodoActual = nodoActual.getHijoDerecho();
            }else{
                nodoActual.setValor(valorAsociado);
                return;
            }          
        }while(!NodoBinario.esNodoVacio(nodoActual));
        
        NodoBinario<K, V> nuevoNodo = new NodoBinario<>(claveAInsertar, valorAsociado);
        if(claveAInsertar.compareTo(nodoAnterior.getClave()) < 0){
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        }else{
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }
    }
    
    /*
    @Override
    public V eliminar(K claveAEliminar) {
        V valorARetornar = this.buscar(claveAEliminar);
        if(valorARetornar == null){
            return null;
        }
        
        this.raiz = eliminar(this.raiz, claveAEliminar);
        
        return valorARetornar;
    }
    
    private NodoBinario<K, V> eliminar(NodoBinario<K, V> nodoActual, K claveAEliminar){
        K claveDelNodoActual = nodoActual.getClave();
        if(claveAEliminar.compareTo(claveDelNodoActual) < 0){
            NodoBinario<K, V> supuestoNuevoHijoIzquierdo = 
                    eliminar(nodoActual.getHijoIzquierdo(), claveAEliminar);
            
            nodoActual.setHijoIzquierdo(supuestoNuevoHijoIzquierdo);
            return nodoActual;
        }
        
        if(claveAEliminar.compareTo(claveDelNodoActual) > 0){
            NodoBinario<K, V> supuestoNuevoHijoDerecho = 
                    eliminar(nodoActual.getHijoDerecho(), claveAEliminar);
            
            nodoActual.setHijoDerecho(supuestoNuevoHijoDerecho);
            return nodoActual;
        }
        
        //caso 1: clave a eliminar es un nodo hoja
        if(nodoActual.esHoja()){
            return NodoBinario.nodoVacio();
        }
        
        //caso2A: clave a eliminar solo tiene hijo izquierdo
        if(!nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()){
            return nodoActual.getHijoIzquierdo();
        }
        
        //caso2B: clave a eliminar solo tiene hijo derecho
        if(!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo()){
            return nodoActual.getHijoDerecho();
        }
        
        //caso3: clave a eliminar tiene ambos hijos
        NodoBinario<K, V> nodoDelSucesor = this.getSucesor(nodoActual.getHijoDerecho());
        NodoBinario<K, V> supuestoNuevoHijoDerecho = 
                eliminar(nodoActual.getHijoDerecho(), nodoDelSucesor.getClave());
        
        nodoActual.setHijoDerecho(supuestoNuevoHijoDerecho);
        nodoActual.setClave(nodoDelSucesor.getClave());
        nodoActual.setValor(nodoDelSucesor.getValor());
        return nodoActual;
    }
    
    protected NodoBinario<K, V> getSucesor(NodoBinario<K, V> nodoAux){
        while(!nodoAux.esVacioHijoIzquierdo()){
            nodoAux = nodoAux.getHijoIzquierdo();
        }
        
        return nodoAux;
    }*/
    
    @Override
    public V eliminar(K claveAEliminar){
        V valorARetornar = this.buscar(claveAEliminar);
        if(valorARetornar == null)
            return null;
        
        NodoBinario<K, V> nodoAnterior, nodoActual;
        nodoAnterior = NodoBinario.nodoVacio();
        nodoActual = this.raiz;
        K claveActual = nodoActual.getClave();
        while(!NodoBinario.esNodoVacio(nodoActual) && !claveActual.equals(claveAEliminar)){
            nodoAnterior = nodoActual;
            if(claveAEliminar.compareTo(claveActual) < 0){
                nodoActual = nodoActual.getHijoIzquierdo();
            }else{
                nodoActual = nodoActual.getHijoDerecho();
            }
            claveActual = nodoActual.getClave();
        }
        
        if(nodoActual.esHoja()){
            eliminarCaso1(nodoAnterior, nodoActual);
        }else{
            //eliminar caso2A: hijo izquierdo distinto de vacio y derecho vacio
            if(!nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()){
                eliminarCaso2A(nodoAnterior, nodoActual);
                //caso 2B: hijo derecho distinto de vacio, hijo izquierdo vacio
            }else if(!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo()){
                eliminarCaso2B(nodoAnterior, nodoActual);
            }else{
                //ambos hijos no vacios
                eliminarCaso3(nodoActual);
            }
        }
        
        return valorARetornar;
    }
    
    private void eliminarCaso1(NodoBinario<K,V> nodoAnterior, NodoBinario<K,V> nodoActual){
        if(NodoBinario.esNodoVacio(nodoAnterior)){
            this.raiz = NodoBinario.nodoVacio();
            return;
        }
        
        K claveActual = nodoActual.getClave();
        K claveAnterior = nodoAnterior.getClave();
        if(claveActual.compareTo(claveAnterior) < 0){
            nodoAnterior.setHijoIzquierdo(NodoBinario.nodoVacio());
        }else{
            nodoAnterior.setHijoDerecho(NodoBinario.nodoVacio());
        }
    }
    
    private void eliminarCaso2A(NodoBinario<K,V> nodoAnterior, NodoBinario<K,V> nodoActual){
        if(NodoBinario.esNodoVacio(nodoAnterior)){
            this.raiz = nodoActual.getHijoIzquierdo();
            return;
        }
        
        NodoBinario<K, V> supuestoNuevoHijo = nodoActual.getHijoIzquierdo();
        K claveActual = nodoActual.getClave();
        K claveAnterior = nodoAnterior.getClave();
        if(claveActual.compareTo(claveAnterior) < 0){
            nodoAnterior.setHijoIzquierdo(supuestoNuevoHijo);
        }else{
            nodoAnterior.setHijoDerecho(supuestoNuevoHijo);
        }
        //nodoAnterior.setHijoIzquierdo(supuestoNuevoHijo);
    }
    
    private void eliminarCaso2B(NodoBinario<K,V> nodoAnterior, NodoBinario<K,V> nodoActual){
        if(NodoBinario.esNodoVacio(nodoAnterior)){
            this.raiz = nodoActual.getHijoDerecho();
            return;
        }
        
        NodoBinario<K, V> supuestoNuevoHijo = nodoActual.getHijoDerecho();
        K claveActual = nodoActual.getClave();
        K claveAnterior = nodoAnterior.getClave();
        if(claveActual.compareTo(claveAnterior) < 0){
            nodoAnterior.setHijoIzquierdo(supuestoNuevoHijo);
        }else{
            nodoAnterior.setHijoDerecho(supuestoNuevoHijo);
        }
        //nodoAnterior.setHijoDerecho(supuestoNuevoHijoDer);
    }
    
    private void eliminarCaso3(NodoBinario<K,V> nodoActual){
        NodoBinario<K, V> nodoAnterior = nodoActual;
        NodoBinario<K, V> nodoAux = nodoActual.getHijoDerecho();
        //NodoBinario<K, V> nodoAnterior = NodoBinario.nodoVacio();
        while(!nodoAux.esVacioHijoIzquierdo()){
            nodoAnterior = nodoAux;
            nodoAux = nodoAux.getHijoIzquierdo();
        }
        
        nodoActual.setClave(nodoAux.getClave());
        nodoActual.setValor(nodoAux.getValor());
        if(nodoAux.esHoja()){
            eliminarCaso1(nodoAnterior, nodoAux);
        }else if(!nodoAux.esVacioHijoIzquierdo() && nodoAux.esVacioHijoDerecho()){
            eliminarCaso2A(nodoAnterior, nodoAux);
        }else{
            eliminarCaso2B(nodoAnterior, nodoAux);
        }
    }

    @Override
    public V buscar(K claveABuscar) {
        if(claveABuscar == null){
            throw new IllegalArgumentException("No se puede buscar claves nulas");
        }
        
        NodoBinario<K, V> nodoActual = this.raiz;
        do{
            K claveDelNodoActual = nodoActual.getClave();
            if(claveABuscar.compareTo(claveDelNodoActual) == 0){
                return nodoActual.getValor();
            }
            if(claveABuscar.compareTo(claveDelNodoActual) < 0){
               nodoActual = nodoActual.getHijoIzquierdo();
            }else{
                nodoActual = nodoActual.getHijoDerecho();
            }
        }while(!NodoBinario.esNodoVacio(nodoActual));
        
        return null;
    }

    @Override
    public boolean contiene(K claveABuscar) {
        if(claveABuscar == null){
            throw new IllegalArgumentException("No se puede buscar claves nulas");
        }
        
        NodoBinario<K, V> nodoActual = this.raiz;
        do{
            K claveDelNodoActual = nodoActual.getClave();
            if(claveABuscar.compareTo(claveDelNodoActual) == 0){
                return true;
            }
            if(claveABuscar.compareTo(claveDelNodoActual) < 0){
               nodoActual = nodoActual.getHijoIzquierdo();
            }else{
                nodoActual = nodoActual.getHijoDerecho();
            }
        }while(!NodoBinario.esNodoVacio(nodoActual));
        
        return false;
    }

    @Override
    public int size() {
        int contador = 0;
        if(!this.esArbolVacio()){
            Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
            pilaDeNodos.push(raiz);
            do{
                NodoBinario<K, V> nodoActual = pilaDeNodos.pop();
                contador++;
                if(!nodoActual.esVacioHijoDerecho()){
                    pilaDeNodos.push(nodoActual.getHijoDerecho());
                }
                
                if(!nodoActual.esVacioHijoIzquierdo()){
                    pilaDeNodos.push(nodoActual.getHijoIzquierdo());
                }
            }while(!pilaDeNodos.isEmpty());
        }
        
        return contador;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
    }
    
    protected int altura(NodoBinario<K, V> nodoActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        
        int alturaIzq = altura(nodoActual.getHijoIzquierdo());
        int alturaDer = altura(nodoActual.getHijoDerecho());
        if(alturaIzq > alturaDer){
            return alturaIzq + 1;
        }else{
            return alturaDer + 1;
        }
    }

    @Override
    public void vaciar() {
        this.raiz = NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(raiz);
    }

    @Override
    public int nivel() {
        return this.altura() - 1;
    }
    
    @Override
    public List<K> recorridoEnInOrden() {
        List<K> recorrido = new ArrayList<>();
        if(!this.esArbolVacio()){
            Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
            meterEnInOrden(pilaDeNodos, this.raiz);
            do{
                NodoBinario<K, V> nodoActual = pilaDeNodos.pop();
                recorrido.add(nodoActual.getClave());
                if(!nodoActual.esVacioHijoDerecho()){
                    meterEnInOrden(pilaDeNodos, nodoActual.getHijoDerecho());
                } 
            }while(!pilaDeNodos.isEmpty());           
        }
        
        return recorrido;
    }
    
    private void meterEnInOrden(Stack<NodoBinario<K, V>> pila, NodoBinario<K, V> nodo){
        while(!NodoBinario.esNodoVacio(nodo)){
            pila.push(nodo);
            if(!nodo.esVacioHijoIzquierdo()){
                nodo = nodo.getHijoIzquierdo();
            }else
                nodo = NodoBinario.nodoVacio();
        }
    }

    @Override
    public List<K> recorridoEnPreOrden() {
        List<K> recorrido = new ArrayList<>();
        if(!this.esArbolVacio()){
            Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
            pilaDeNodos.push(raiz);
            do{
                NodoBinario<K, V> nodoActual = pilaDeNodos.pop();
                recorrido.add(nodoActual.getClave());
                if(!nodoActual.esVacioHijoDerecho()){
                    pilaDeNodos.push(nodoActual.getHijoDerecho());
                }
                
                if(!nodoActual.esVacioHijoIzquierdo()){
                    pilaDeNodos.push(nodoActual.getHijoIzquierdo());
                }
            }while(!pilaDeNodos.isEmpty());
        }
        
        return recorrido;
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        List<K> recorrido = new ArrayList<>();
        if(!this.esArbolVacio()){
            Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
            meterEnPostOrden(pilaDeNodos, this.raiz);
            do{
                NodoBinario<K, V> nodoActual = pilaDeNodos.pop();
                recorrido.add(nodoActual.getClave());
                if(!pilaDeNodos.isEmpty()){
                    NodoBinario<K, V> nodoDelTope = pilaDeNodos.peek();
                    if(nodoDelTope.getHijoIzquierdo() == nodoActual){
                        meterEnPostOrden(pilaDeNodos, nodoDelTope.getHijoDerecho());
                    }
                }
            }while(!pilaDeNodos.isEmpty());
        }
        
        return recorrido;
    }
    
    private void meterEnPostOrden(Stack<NodoBinario<K, V>> pila, NodoBinario<K, V> nodo){
        while(!NodoBinario.esNodoVacio(nodo)){
            pila.push(nodo);
            if(!nodo.esVacioHijoIzquierdo()){
                nodo = nodo.getHijoIzquierdo();
            }else{
                nodo = nodo.getHijoDerecho();
            }         
        }
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new ArrayList<>();
        if(this.esArbolVacio()){
            return recorrido;
        }
        
        Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(raiz);
        do{
            NodoBinario<K, V> nodoActual = colaDeNodos.poll();
            recorrido.add(nodoActual.getClave());
            if(!nodoActual.esVacioHijoIzquierdo()){
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            
            if(!nodoActual.esVacioHijoDerecho()){
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }while(!colaDeNodos.isEmpty());
        
        return recorrido;
    } 
    
    //si un abb a partir de un nivel n cumple avl
    
    
    //------------------------------------------------
    //Mostrar los primos de X clave
    public void mostrarPrimos(K clave){
        if(this.esArbolVacio()){
            System.out.println("El árbol está vacio");
            return;
        }
        
        V valor = this.buscar(clave);
        if(valor == null){
            System.out.println(clave + " No existe en el árbol");
            return;
        }
        
        //List<K> listaDePrimos = new ArrayList<>();
        NodoBinario<K, V> nodoPadre = this.buscarNodo(NodoBinario.nodoVacio(), this.raiz, clave);
        if(!NodoBinario.esNodoVacio(nodoPadre)){
            K claveDelPadre = nodoPadre.getClave();
            NodoBinario<K, V> nodoAbuelo = this.buscarNodo(NodoBinario.nodoVacio(), 
                    this.raiz, claveDelPadre);
            
            if(!NodoBinario.esNodoVacio(nodoAbuelo)){
                //mostrarPrimos(nodoAbuelo, clave, listaDePrimos);
                mostrarPrimos(nodoAbuelo, clave);
            }else{
                System.out.println(clave + " No tiene primos");
            }
        }else{
            System.out.println(clave + " No tiene primos");
        }
    }
    
    private NodoBinario<K, V> buscarNodo(NodoBinario<K,V> nodoAnterior, NodoBinario<K, V> nodoActual, K clave){
        if(NodoBinario.esNodoVacio(nodoActual))
            return NodoBinario.nodoVacio();
        
        NodoBinario<K, V> subArbolIzq = buscarNodo(nodoActual, nodoActual.getHijoIzquierdo(), clave);
        NodoBinario<K, V> subArbolDer = buscarNodo(nodoActual, nodoActual.getHijoDerecho(), clave);
        
        K claveActual = nodoActual.getClave();
        if(clave.compareTo(claveActual) == 0)
            return nodoAnterior;
        
        if(!NodoBinario.esNodoVacio(subArbolIzq))
            return subArbolIzq;
        
        if(!NodoBinario.esNodoVacio(subArbolDer))
            return subArbolDer;
        
        return NodoBinario.nodoVacio();
    }
    
    private void mostrarPrimos(NodoBinario<K,V> nodo, K clave){
        K claveDelNodo = nodo.getClave();
        if(clave.compareTo(claveDelNodo) < 0){
            if(nodo.esVacioHijoDerecho()){
                System.out.println(clave + " NO tiene primos");
                return;
            }
            NodoBinario<K, V> nodoTio = nodo.getHijoDerecho();
            if(!nodoTio.esVacioHijoIzquierdo()){
                NodoBinario<K, V> primoIzq = nodoTio.getHijoIzquierdo();
                //lista.add(primoIzq.getClave()); 
                System.out.println(primoIzq.getClave());
            }
            
            if(!nodoTio.esVacioHijoDerecho()){
                NodoBinario<K, V> primoDer = nodoTio.getHijoDerecho();
                //lista.add(primoDer.getClave());
                System.out.println(primoDer.getClave());
            }
            
        }else{
            if(nodo.esVacioHijoIzquierdo()){
                System.out.println(clave + " NO tiene primos");
                return;
            }
            NodoBinario<K, V> nodoTio = nodo.getHijoIzquierdo();
            if(!nodoTio.esVacioHijoIzquierdo()){
                NodoBinario<K, V> primoIzq = nodoTio.getHijoIzquierdo();
                //lista.add(primoIzq.getClave());
                System.out.println(primoIzq.getClave());
            }
            
            if(!nodoTio.esVacioHijoDerecho()){
                NodoBinario<K, V> primoDer = nodoTio.getHijoDerecho();
                //lista.add(primoDer.getClave());
                System.out.println(primoDer.getClave());
            }
        }
    }
    
    //valores in orden
    public List<V> recorridoInOrdenV(){
        List<V> lista = new ArrayList<>();
        recorridoInOrdenV(this.raiz, lista);
        return lista;
    }
    
    private void recorridoInOrdenV(NodoBinario<K,V> nodoActual, List<V> lista){
        if(NodoBinario.esNodoVacio(nodoActual))
            return;
        
        recorridoInOrdenV(nodoActual.getHijoIzquierdo(), lista);
        lista.add(nodoActual.getValor());
        recorridoInOrdenV(nodoActual.getHijoDerecho(), lista);
    }
    
    public List<V> recorridoEnPostOrdenV(){
        List<V> lista = new ArrayList<>();
        recorridoEnPostOrdenV(this.raiz, lista);
        return lista;
    }
    
    private void recorridoEnPostOrdenV(NodoBinario<K,V> nodoActual, List<V> lista){
        if(NodoBinario.esNodoVacio(nodoActual))
            return;
        
       // lista.add(nodoActual.getValor());
        recorridoEnPostOrdenV(nodoActual.getHijoIzquierdo(), lista);
        recorridoEnPostOrdenV(nodoActual.getHijoDerecho(), lista);
        lista.add(nodoActual.getValor());
    }
    
    public int contarDosHijos(int nivel){
        return contarDosHijos(this.raiz, nivel, 0);
    }
    
    private int contarDosHijos(NodoBinario<K,V> nodoActual, int nivel, int nivelActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return 0;
        }
        
        int subArbolIzq = contarDosHijos(nodoActual.getHijoIzquierdo(), nivel, nivelActual+1);
        int subArbolDer = contarDosHijos(nodoActual.getHijoDerecho(), nivel, nivelActual+1);
        if(nivelActual >= nivel){
            if(!nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()){
                return subArbolIzq + subArbolDer + 1;
            }
            /*}else{
                return subArbolDer + subArbolIzq;
            }*/
        }
        return subArbolDer + subArbolIzq;
    }
    
    public boolean arbolLleno(){
        return arbolLleno(this.raiz);
    }
    
    private boolean arbolLleno(NodoBinario<K,V> nodoActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
            return true;
        }
        
        boolean izq = arbolLleno(nodoActual.getHijoIzquierdo());
        boolean der = arbolLleno(nodoActual.getHijoDerecho());
        if(!nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()){
            return false;
        }
        
        if(nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()){
            return false;
        }
        
        if(izq && der){
            return true;
        }
        
        return false;
    }
    
    public int contarHV(){
  int cant = 0;
  if(esArbolVacio()){
     return cant;
  }

  Stack<NodoBinario<K,V>> pilaDeNodos = new Stack<>();
  meterEnInOrden(pilaDeNodos, this.raiz);
  do{
     NodoBinario<K,V> nodoActual = pilaDeNodos.pop();
     if(nodoActual.esVacioHijoIzquierdo()){
       cant++;
     }

     if(nodoActual.esVacioHijoDerecho()){
       cant++;
     }

     if(!nodoActual.esVacioHijoDerecho()){
       meterEnInOrden(pilaDeNodos, nodoActual.getHijoDerecho());
     }
  }while(!pilaDeNodos.isEmpty());

return cant;
}
   //AYUDA PARA LA INTERFAS 

    
     public List<V> listarClientes() {
        List<V> lista = new ArrayList<>();
        listarClientes(raiz, lista);
        return lista;
    }

    private void listarClientes(NodoBinario nodo, List<V> lista) {
        if (nodo != null) {
            listarClientes(nodo.getHijoIzquierdo(), lista);
            lista.add((V) nodo.getValor());
            //lista.add(nodo.getValor());
            listarClientes(nodo.getHijoDerecho(), lista);
        }
    }
    
    public boolean editarClienteABB(K clave,V newCliente) {
        NodoBinario<K,V> nodo = raiz;
        while (nodo != null) {
            if (clave.equals(nodo.getClave())) {
                nodo.setValor(newCliente);
                return true;
            } else if (clave.compareTo(nodo.getClave()) < 0) {
                nodo = nodo.getHijoIzquierdo();
            } else {
                nodo = nodo.getHijoDerecho();
            }
        }
        return false;
    }
    

    
    public static void main(String[] args) {
        ArbolBinarioBusqueda<Integer, String> arbol = new ArbolBinarioBusqueda();
        arbol.insertar(50, "Rodrigo");
        arbol.insertar(30, "rojo");
        arbol.insertar(90, "azul");
        arbol.insertar(10, "amarillo");
        arbol.insertar(75, "verde");
        arbol.insertar(80, "cafe");
       arbol.insertar(40, "dsasdasd");
        arbol.insertar(95, "asasa");
        arbol.insertar(35, "wweww");
        //System.out.println("lleno: "+arbol.arbolLleno());
        //System.out.println("dos hijos: "+arbol.contarDosHijos(2));
        //System.out.println(arbol.recorridoEnPreOrden());
        //System.out.println("Eliminamos el 50: "+arbol.eliminar(50));
        //System.out.println(arbol.recorridoEnPreOrden());
        //arbol.mostrarPrimos(80);
        /*
        List<Integer> clavesInOrden = arbol.recorridoEnInOrden();
        List<Integer> clavesNoInOrden = arbol.recorridoEnPostOrden();
        List<String> valoresInOrden = arbol.recorridoInOrdenV();
        List<String> valoresNoInOrden = arbol.recorridoEnPostOrdenV();
        System.out.println("ClavesInOrden: "+clavesInOrden);
        System.out.println("ValoresInOrden: "+valoresInOrden);
        System.out.println("clavesNoInOrden: "+clavesNoInOrden);
        System.out.println("valoresNoInOrden: "+valoresNoInOrden);
        
        List<Integer> clavesInOrden = Arrays.asList(10, 30, 50, 75, 80, 90, 95);
        List<Integer> clavesNoInOrden = Arrays.asList(10, 30, 80, 75, 95, 90, 50);
        List<String> valoresInOrden = Arrays.asList("amarillo", "rojo", "Rodrigo", "verde", "cafe", "azul", "asasa");
        List<String> valoresNoInOrden = Arrays.asList("amarillo", "rojo", "cafe", "verde", "asasa", "azul", "Rodrigo");
        boolean usandoPreOrden = false;
        /*
        List<Integer> clavesInOrden = Arrays.asList(10, 30, 50, 75, 80, 90, 95);
        List<Integer> clavesNoInOrden = Arrays.asList(50, 30, 10, 90, 75, 80, 95);
        List<String> valoresInOrden = Arrays.asList("amarillo", "rojo", "Rodrigo", "verde", "cafe", "azul", "asasa");
        List<String> valoresNoInOrden = Arrays.asList("Rodrigo", "rojo", "amarillo", "azul", "verde", "cafe", "asasa");
        boolean usandoPreOrden = true;
        ArbolBinarioBusqueda<Integer, String> arbol = new ArbolBinarioBusqueda<>(clavesInOrden, valoresInOrden,
                    clavesNoInOrden, valoresNoInOrden, usandoPreOrden);*/
        
        
        
    }

}
