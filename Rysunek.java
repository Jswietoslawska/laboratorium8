package laboratorium8;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.lang.Math.*;
public class Rysunek {
public static void main(String args[])
{
	TreeSet<Figura> figury = new TreeSet<Figura>();
	int decyzja;
	try {
	menu();
	decyzja=wyborUzytkownika();
	if(decyzja<0||decyzja>3)
		throw new wyjatekDecyzja();
	while(decyzja!=0)
	{
		int ilosc=0;
		try {
		System.out.println("Ile figur wprowadzisz?");
		ilosc=(int)pobierzLiczbe();
		}
		catch(InputMismatchException ex){
			System.out.println( "Podales inny znak zamiast liczby!" );
			}
		switch(decyzja)
		{
		case 0:	for(Figura f:figury)
		{
			f.toString();
		}
		break;
		case 1:for(int i=0;i<ilosc;i++)
		{
			double r,x,y;
			System.out.println("Podaj promien");
			try
			{
				r=pobierzLiczbe();
				if(r<=0)
					throw new wyjatekUjemny();
				System.out.println("Podaj wspolrzedna x");
				x=pobierzLiczbe();
				System.out.println("Podaj wspolrzedna y");
				y=pobierzLiczbe();
				Kolo temp = new Kolo(r, "Kolo"+i, new Punkt(x,y));
				if(!figury.isEmpty())
				{
					for(Figura k:figury)
					{
						if(k.compareTo(temp)==0)
						{
							throw new wyjatekIstniejacy();
						}
					}
				}
				figury.add(temp);
			}
			catch(InputMismatchException ex)
			{
				System.out.println( "Podales inny znak zamiast liczby!" );
			}
			catch(wyjatekUjemny e)
			{
				e.printStackTrace();
			}
			catch(wyjatekIstniejacy e)
			{
				e.printStackTrace();
			}
		}
		break;
		case 2:for(int i=0;i<ilosc;i++)
		{
			double r,x,y;
			System.out.println("Podaj bok");
			try
			{
				r=pobierzLiczbe();
				if(r<=0)
					throw new wyjatekUjemny();
				System.out.println("Podaj wspolrzedna x lewego dolnego punktu");
				x=pobierzLiczbe();
				System.out.println("Podaj wspolrzedna y lewego dolnego punktu");
				y=pobierzLiczbe();
				Kwadrat temp = new Kwadrat(r, "Kw"+i, new Punkt(x,y));
				if(!figury.isEmpty())
				{
					for(Figura k:figury)
					{
						if(k.compareTo(temp)==0)
						{
							throw new wyjatekIstniejacy();
						}
					}
				}
				figury.add(temp);
			}
			catch(InputMismatchException ex)
			{
				System.out.println( "Podales inny znak zamiast liczby!" );
			}
			catch(wyjatekUjemny e)
			{
				e.printStackTrace();
			}
			catch(wyjatekIstniejacy e)
			{
				e.printStackTrace();
			}
		}
		break;
		case 3:for(int i=0;i<ilosc;i++)
		{
			double b1,b2,x,y;
			System.out.println("Podaj pierwszy bok");
			try
			{
				b1=pobierzLiczbe();
				if(b1<=0)
					throw new wyjatekUjemny();
				System.out.println("Podaj drugi bok");
				b2=pobierzLiczbe();
				if(b2<=0)
					throw new wyjatekUjemny();
				System.out.println("Podaj wspolrzedna x lewego dolnego punktu");
				x=pobierzLiczbe();
				System.out.println("Podaj wspolrzedna y lewego dolnego punktu");
				y=pobierzLiczbe();
				Prostokat temp = new Prostokat(b1, b2, "Prostokat"+i, new Punkt(x,y));
				if(!figury.isEmpty())
				{
					for(Figura k:figury)
					{
						if(k.compareTo(temp)==0)
						{
							throw new wyjatekIstniejacy();
						}
					}
				}
				figury.add(temp);
			}
			catch(InputMismatchException ex)
			{
				System.out.println( "Podales inny znak zamiast liczby!" );
			}
			catch(wyjatekUjemny e)
			{
				e.printStackTrace();
			}
			catch(wyjatekIstniejacy e)
			{
				e.printStackTrace();
			}
		}
		break;
		}
		menu();
		decyzja=wyborUzytkownika();
		if(decyzja<0||decyzja>3)
			throw new wyjatekDecyzja();
	}
	}
	catch(InputMismatchException ex){
		System.out.println( "Podales inny znak zamiast liczby!" );
		ex.printStackTrace();
	}
	catch(wyjatekDecyzja e)
	{
		e.printStackTrace();
	}
	for(Figura f:figury)
	{
		System.out.println(f);
	}
	HashSet<TreeSet<Figura>> przeciete=new HashSet<TreeSet<Figura>>();
	for(Figura f:figury)
	{
		TreeSet<Figura> temp = new TreeSet<Figura>();
		for(Figura f1:figury)
		{
			if(f.czyPrzecina(f1))
			{
				temp.add(f1);
				temp.add(f);
			}
		}
		int size=0;
		while(size<temp.size())
		{
			size=temp.size();
			ArrayList<Figura> doDodania=new ArrayList<Figura>();
			for(Figura f3:temp)
			{
				for(Figura f2:figury)
				{
					if(f3.czyPrzecina(f2))
					{
						doDodania.add(f2);
					}
				}
			}
			temp.addAll(doDodania);
		}
		przeciete.add(temp);
	}
	HashSet<TreeSet<Figura>> figuryDoUsuniecia=new HashSet<TreeSet<Figura>>();
	for(TreeSet<Figura> F:przeciete)
	{
		if(F.isEmpty())
			figuryDoUsuniecia.add(F);
	}
	przeciete.removeAll(figuryDoUsuniecia);
	System.out.println(" ");
	if(przeciete.isEmpty())
	{
		System.out.println("Brak grup przecinajacych sie figur");
		return;
	}
	for(TreeSet<Figura> F:przeciete)
	{
		System.out.println("Przecinaja sie:");
		Iterator<Figura> it = F.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println(" ");
	}
}
static void menu()
{
	System.out.println("~~~MENU~~~");
	System.out.println("Podaj liczbe, aby wykonac akcje");
	System.out.println("0 - zakoncz podawanie figur");
	System.out.println("1 - dodaj kola");
	System.out.println("2 - dodaj kwadraty");
	System.out.println("3 - dodaj prostokaty");
}
static int wyborUzytkownika()
{
	System.out.print("Twoja decyzja: ");
	Scanner odczyt=new Scanner(System.in);
	int liczba = odczyt.nextInt();
	odczyt.nextLine();
	return liczba;
}
static double pobierzLiczbe()
{
	Scanner odczyt=new Scanner(System.in);
	double liczba = odczyt.nextDouble();
	return liczba;
}
}
