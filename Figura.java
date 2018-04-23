package laboratorium8;

public interface Figura extends Comparable<Figura>{
public double pole();
public double obwod();
@Override
public default int compareTo(Figura o) {
	if(o.pole()==pole())
		return 0;
	if(o.pole()<pole())
		return 1;
	else 
		return -1;
}
@Override
public String toString();
boolean czyPrzecina(Object obj);
}
