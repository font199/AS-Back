package serveisComuns.entradaSortida;

/* Imports de la classe */
import java.util.*;
import java.io.*;
import serveisComuns.objectesAuxiliars.*;

/* Capa de Presentaci� */
public class ControlES
{

	public Tuple obteDadesConnexio() throws ErrorLecturaDadesConnexio, ErrorLecturaDadesEntrada
	{
	  		
		Tuple r = new Tuple();
			
		String Driver = "";
		String URL = "";
		String SSLRequired = "";
		String SSLFabrica = "";
		String suportaEsquema = "";
		String Esquema = "";
		String Username = "";
    		String Password="";

		try
		{
			FileInputStream fis = new FileInputStream("dadesconnexio.txt");
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader d = new BufferedReader(new InputStreamReader(dis));

			Driver = d.readLine();
			URL = d.readLine();
			SSLRequired = d.readLine();
			SSLFabrica = d.readLine();
			suportaEsquema = d.readLine();
			Esquema = d.readLine();
			Username = d.readLine();
			Password = d.readLine();
			d.close();
		}
		catch (IOException i) {throw new ErrorLecturaDadesConnexio();}
		
		try
		{
			r.afegir(Driver);
			r.afegir(URL);
			r.afegir(SSLRequired);
			r.afegir(SSLFabrica);
			r.afegir(suportaEsquema);
			r.afegir(Esquema);
			r.afegir(Username);
			r.afegir(Password);

		}
		catch (NullPointerException n) {throw new ErrorLecturaDadesConnexio();} 

		return r;

	}
	
	public Tuple obteDadesEntrada(String dadesTransaccio) throws ErrorLecturaDadesEntrada
	{
		String par;		
		Tuple pars = new Tuple();

		try {
			FileInputStream fis = new FileInputStream(dadesTransaccio);
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader d = new BufferedReader(new InputStreamReader(dis));
			par = d.readLine();
			while (par != null) {
				pars.afegir(par);
				par = d.readLine();
			}	
			d.close();
		}
		catch (IOException i) {throw new ErrorLecturaDadesEntrada();}
		catch (NullPointerException n) {throw new ErrorLecturaDadesEntrada();} 
		return pars;
	}

	
	public void mostrarTuple(Tuple t) throws ErrorLecturaDadesEntrada
	{
		
		
		int mida = t.tamany();
		String s;
		
		for (int i=0; i<mida; i++)
		{
						
			try
			{
				s = t.valorString(i);
				if (s != null) s = s.trim(); 
				System.out.print(s + " ");
			}
			catch (TupleException ig) {throw new ErrorLecturaDadesEntrada();} 
		}
		System.out.println();
		
	}

	public void mostrarConjuntTuples(Vector<?> rs) throws ErrorLecturaDadesEntrada
	{
		
		Tuple t = new Tuple();
		
		int mida = rs.size();

		Object[] as = rs.toArray();
		Arrays.sort(as);
		
		for (int i=0; i<mida; i++)
		{
			t = (Tuple) as[i];
			
				mostrarTuple(t);
		}
		
	}

	public void missatge(String s)
	{
		
		System.out.println(s);
		
	}

}