/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas_colas;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author brayan
 */
public class cola 
{
    public int Can;
    public int Can_nodos;
    public Nodo Raiz, Ultimo;
    private Scanner Teclado;
    private Random Aleatorio;
    public int []vec;
    
    public cola()
    {
        Raiz=null; 
        Ultimo=null;
    }
    //get() and set()

    public Nodo getRaiz() {
        return Raiz;
    }

    public void setRaiz(Nodo Raiz) {
        this.Raiz = Raiz;
    }
    
    
    public boolean COLA_VACIA_f()
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
    
    public void ENCOLAR_f(int x)
    {
        Nodo Nuevo;
        Nuevo=new Nodo();
        Nuevo.Inf=x;
        Nuevo.Sgt=null;
        
        if(Raiz==null)
        {
            Raiz=Nuevo;
            Ultimo=Nuevo;
        }
        else
        {
            Ultimo.Sgt=Nuevo;
            Ultimo=Nuevo;
        }
    }
    
    public int DESENCOLAR_f()
    {
        int Informacion;
        if(!COLA_VACIA_f())
        {
            Informacion=Raiz.Inf;
            if(Raiz==Ultimo)
            {
                Raiz=null;
                Ultimo=null;
            }
            else
            {
                Raiz=Raiz.Sgt;
            }
            return Informacion;
        }
        else
        {
            System.out.println("cola vacia");
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
    
    public void LLENAR_COLA_ALEATORIOS_f()
    {
        int Can;
        Teclado=new Scanner(System.in);
        Aleatorio=new Random();
        System.out.print("insert random number: ");
        Can=Teclado.nextInt();
        
        while(Can>0)
        {
            ENCOLAR_f(Aleatorio.nextInt(100));
            Can--;
        }
    }
    
    public void INVERTIR_COLA_f()
    {
        int i;
        Can=0;
        if(!COLA_VACIA_f())
        {
            //cola nueva invertida
            cola aux=new cola();
            
            Can=CAN_NODOS_f();
            
            vec=new int[Can];
            for(i=0; i<Can; i++)
            {
                vec[i]=DESENCOLAR_f();
            }
            
            for(i=Can ; i>0; i--)
            {
                aux.ENCOLAR_f(vec[i-1]);
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
        cola cola1;
        cola1=new cola();
        cola1.ENCOLAR_f(5);
        cola1.ENCOLAR_f(8);
        cola1.ENCOLAR_f(15);
        cola1.ENCOLAR_f(3);
        cola1.INVERTIR_COLA_f();
        cola1.MOSTRAR_f();
    } 
}
