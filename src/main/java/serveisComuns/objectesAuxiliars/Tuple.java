package serveisComuns.objectesAuxiliars;

import java.util.*;

/**
  *   * Classe que representa una fila de dades
  * @author David Ga��n Jim�nez
  */
public class Tuple implements Comparable
{
	private Vector valors;
	private boolean conteTuple;

	
	/**
	  * Metode constructor 
	  * construeix un Tuple buit
	  */
	public Tuple ()
	{
		valors = new Vector (0);
		conteTuple = false;
	}


	Tuple (Tuple r)
	{
		valors = new Vector ();
		
		for (int i=0;i<r.valors.size();i++)
		{
			valors.add(r.valors.elementAt(i));
		}

		conteTuple = r.conteTuple;
	}


	/**
	  * Metode constructor 
	  * construeix un Tuple a partir dels valors
	  */
	public Tuple (String[] v)
	{
		valors = new Vector(v.length);
		
		for (int i=0; i<v.length; i++)
		{
			valors.add (v[i]);
		}

		conteTuple = false;
	}


	public int compareTo(Object tt)
	/* compara dues tuples */
	{
		Tuple t = ((Tuple)tt);
		int n = t.tamany();
		int c = 0;
		int i = 0;
		i=0;
		while (i<n)
		{
			c = ((String)this.valors.elementAt(i)).compareTo((String)t.valors.elementAt(i));
//			System.out.println("&"+(String)t.valors.elementAt(i)+"&"+(String)this.valors.elementAt(i)+"&"+c);
			if (c != 0) { return c;}
			i++;
		}
		return c;
	}

	/**
	  * Metode afegir
	  * afegeix un element al Tuple
	  */
	public void afegir (String v)
	{
		if (v==null) {valors.add(v);} else valors.add (new String (v));
	}


	/**
	  * Metode afegir
	  * afegeix un Tuple al Tuple
	  */
	public void afegir (Tuple r) throws TupleException
	{
		if (r.conteTuple())
		{
			throw new TupleException ("No es pot afegir un Tuple que tambe conte algun Tuple");
		}

		valors.add (new Tuple(r));

		conteTuple = true;
	}


	/**
	  * Metode valorString 
	  * retorna l'element String de la posicio demanada del Tuple 
	  * @return 	retorna el valor String de la posicio demanada del Tuple
	  *				si el valor d'aquesta posicio es un Tuple retorna null
	  */
	public String valorString (int i) throws TupleException
	{
		String res = null;
		
		try
		{
			res = (String)valors.elementAt(i);
		}
		catch (ClassCastException cce)
		{
			throw new TupleException ("El camp "+i+" del Tuple no es un String");
		}
		return res;
	}


public String consulta(int i) {
String res;
try {
res = (String)valors.elementAt(i - 1);
}
catch (ClassCastException cce) {
res = null;
}
return res;
}

	/**
	  * Metode valorTuple
	  * retorna l'element Tuple de la posicio demanada del Tuple 
	  * @return 	retorna el valor Tuple de la posicio demanada del Tuple
	  *				si el valor d'aquesta posicio es un String retorna null
	  */
	public Tuple valorTuple (int i) throws TupleException
	{
		Tuple res = null;

		try
		{
			res = (Tuple)valors.elementAt(i);
		}
		catch (ClassCastException cce)
		{
			throw new TupleException("El camp "+i+" del Tuple no es un Tuple");
		}
		return new Tuple(res);
	}


	/**
	  * Metode tamany
	  * retorna el tamany del Tuple 
	  * @return 	retorna el tamany del Tuple
	  */
	public int tamany ()
	{
		return valors.size();
	}


	/**
	  * Metode conteTuple
	  * retorna si el Tuple conte un altre Tuple a dins o no
	  * @return 	retorna un boolea
	  */
	public boolean conteTuple ()
	{
		return conteTuple;
	}

	/**
	  * Metode toArray
	  * retorna un array d'objectes amb el contingut del Tuple 
	  * @return 	retorna un array d'objectes
	  */
	public Object [] toArray ()
	{
		return valors.toArray();
	}


	protected Vector toVector ()
	{
		return new Vector(valors);
	}
}


