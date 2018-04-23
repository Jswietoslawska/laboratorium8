package laboratorium8;

public abstract class FiguraForemna implements Figura{
	double bok;
	String nazwa;
	Punkt punkt;
	public FiguraForemna(double b, String tekst, Punkt pkt) throws wyjatekUjemny
	{
		if(b<=0)
			throw new wyjatekUjemny();
		bok=b;
		nazwa=tekst;
		punkt=pkt;
	}
}
