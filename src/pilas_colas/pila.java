/*
 * procedimiento que cuenta la cantidad de elementos de una pila
    procedimiento que invierta el orden de la pila.
 */
package pilas_colas;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author brayan
 */
public class pila
{
    //atributos clase pila
    private Scanner Teclado;
    private Random Aleatorio;
    public Nodo Raiz;
    public int Can_nodos;
    public int Can;
    public int []vec;
    //get() and set()

    public Nodo getRaiz() {
        return Raiz;
    }

    public void setRaiz(Nodo Raiz) {
        this.Raiz = Raiz;
    }
    
    
    
    //constructor de la clase pila
    public pila()
    {
        Raiz=null;
    }
    //metodo que retorna verdadero si la pila esta vacia de lo contrario retorna falso
    public boolean PILA_VACIA_f()
    {
        if(Raiz==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void APILAR_f(int x)
    {
        Nodo Nuevo;
        Nuevo=new Nodo();
        Nuevo.Inf=x;
        Nuevo.Sgt=Raiz;
        Raiz=Nuevo;
    }
    
    public int DESAPILAR_f()
    {
        int Informacion;
        if(!PILA_VACIA_f())
        {
            Informacion=Raiz.Inf;
            Raiz=Raiz.Sgt;
            return Informacion;
        }
        else
        {
            System.out.println("empty stack");
            return Integer.MAX_VALUE;
        }
    }
    
    public void MOSTRAR_f()
    {
        Nodo Rec=Raiz;
        
        while(Rec!=null)
        {
            System.out.print(Rec.Inf+"\t");
            Rec=Rec.Sgt;
        }
    }
    
    public int CAN_NODOS_f()
    {
        Nodo Rec=Raiz;
        Can_nodos=0;
        
        while(Rec!=null)
        {
            Can_nodos++;
            Rec=Rec.Sgt;
        }
        return Can_nodos;
    }
    
    public void LLENAR_PILA_ALEATORIOS_f()
    {
        int Can;
        Teclado=new Scanner(System.in);
        Aleatorio=new Random();
        System.out.print("insert random number: ");
        Can=Teclado.nextInt();
        
        while(Can>0)
        {
            APILAR_f(Aleatorio.nextInt(100));
            Can--;
        }
    }
    
    public void INVERTIR_PILA_f()
    {
        int i;
        Can=0;
        if(!PILA_VACIA_f())
        {
            //pila nueva invertida
            pila aux=new pila();
            
            Can=CAN_NODOS_f();
            
            vec=new int[Can];
            for(i=0; i<Can; i++)
            {
                vec[i]=DESAPILAR_f();
            }
            
            for(i=0; i<Can; i++)
            {
                aux.APILAR_f(vec[i]);
            }
            //reasigna la raiz la raiz de aux sera la nueva raiz la pila
            Raiz=aux.getRaiz();
          
        }
        else
        {
            System.out.println("empty stack");
        }
    }
    
    
    
 
    public static void main(String[] args)
    {
        pila pila1;
        pila1=new pila();
        pila1.APILAR_f(5);
        pila1.APILAR_f(2);
        pila1.APILAR_f(7);
        pila1.INVERTIR_PILA_f();
        pila1.APILAR_f(15);
        pila1.MOSTRAR_f();
    }
    
    
}
