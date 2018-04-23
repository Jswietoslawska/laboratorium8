package laboratorium8;

public class Prostokat implements Figura, Comparable<Figura>{
	Punkt punkt;
	double bokA;
	double bokB;
	String nazwa;
	@Override
	public double pole() {
		return bokA*bokB;
	}

	@Override
	public double obwod() {
		return 2*bokA+2*bokB;
	}
	public Prostokat(double b1, double b2, String tekst, Punkt pkt)
	{
		try {
		if(b1<=0||b2<=0)
		{
			throw new wyjatekUjemny();
		}
		}
		catch(wyjatekUjemny e)
		{
			e.printStackTrace();
		}
		bokA=b1;
		bokB=b2;
		nazwa=tekst;
		punkt=pkt;
	}
	@Override
	public String toString()
	{
		return "Prostokat, nazywa sie "+nazwa+". Jego pole: "+pole()+". Jego obwod: "+obwod();
	}
	@Override
	public int compareTo(Figura o) {
		if(o.pole()==pole())
			return 0;
		if(o.pole()<pole())
			return 1;
		else 
			return -1;
	}
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Prostokat temp = (Prostokat) obj;
	       if(bokA==temp.bokA&&bokB==temp.bokB&&punkt.equals(temp.punkt))
	    	   	return true;
		return false;
	    }
	 @Override
	 public boolean czyPrzecina(Object obj)
	 {
		 if(this==obj)
			 return false;
		 if(obj==null)
			 return false;
		 if(obj.getClass().getName()=="laboratorium8.Kolo")
		 {
			 Kolo temp=(Kolo) obj;
			 double b2=punkt.getY()+bokB;
			 double b1=punkt.getY();
			 double a1=punkt.getX();
			 double a2=punkt.getX()+bokA;
			 double r=temp.bok;
			 double x=temp.punkt.getX();
			 double y=temp.punkt.getY();
			 if(x<=a2&&x>=a1&&y>=b1&&y<=b2) //srodek kola wewnatrz prostokata
			 {
				 return true;
			 }
			 Punkt A=punkt;
			 Punkt B=new Punkt(a2,b1);
			 Punkt C=new Punkt(a2,b2);
			 Punkt D=new Punkt(a1,b2);
			 if(temp.punkt.dlugoscOdcinka(A)<=r||temp.punkt.dlugoscOdcinka(B)<=r||temp.punkt.dlugoscOdcinka(C)<=r||temp.punkt.dlugoscOdcinka(D)<=r)
				 return true;
			 return false;
		 }
		 if(obj.getClass().getName()=="laboratorium8.Kwadrat")
		 {
			 Kwadrat temp=(Kwadrat) obj;
			 double b2=punkt.getY()+bokB;
			 double b1=punkt.getY();
			 double a1=punkt.getX();
			 double a2=punkt.getX()+bokA;
			 double x1=temp.punkt.getX();
			 double x2=temp.punkt.getX()+temp.bok;
			 double y1=temp.punkt.getY();
			 double y2=temp.punkt.getY()+temp.bok;
			 if(!(x1>a2||y2<b1||y1>b2||x2<a1))
			 {
				 return true;
			 }
			 else
				 return false;
		 }
		 if(obj.getClass().getName()=="laboratorium8.Prostokat")
		 {
			 Prostokat temp=(Prostokat) obj;
			 double b2=punkt.getY()+bokB;
			 double b1=punkt.getY();
			 double a1=punkt.getX();
			 double a2=punkt.getX()+bokA;
			 double x1=temp.punkt.getX();
			 double x2=temp.punkt.getX()+temp.bokA;
			 double y1=temp.punkt.getY();
			 double y2=temp.punkt.getY()+temp.bokB;
			 if(!(x1>a2||y2<b1||y1>b2||x2<a1))
			 {
				 return true;
			 }
			 else
				 return false;
		 }
		 return false;
	 }
}
