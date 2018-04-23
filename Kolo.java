package laboratorium8;

public class Kolo implements Comparable<Figura>, Figura{
	double bok;
	String nazwa;
	Punkt punkt;
	public Kolo(double b, String tekst, Punkt pkt) throws wyjatekUjemny
	{
		if(b<=0)
			throw new wyjatekUjemny();
		bok=b;
		nazwa=tekst;
		punkt=pkt;
	}

	final double PI=3.14159265359;
	@Override
	public double pole() {
		return bok*bok*PI;
	}

	@Override
	public double obwod() {
		return 2*PI*bok;
	}
	@Override
	public String toString()
	{
		return "Kolo, nazywa sie "+nazwa+". Jego pole: "+pole()+". Jego obwod: "+obwod();
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
	        Kolo temp = (Kolo) obj;
	       if(bok==temp.bok&&punkt.equals(temp.punkt))
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
			 double y2=punkt.getY();
			 double x2=punkt.getX();
			 double r2=bok;
			 double r=temp.bok;
			 double x=temp.punkt.getX();
			 double y=temp.punkt.getY();
			 if(r+r2>=Math.sqrt(Math.pow(x2-x,2)+Math.pow(y2-y, 2)))
			 {
				 return true;
			 }
			 else
				 return false;
		 }
		 if(obj.getClass().getName()=="laboratorium8.Kwadrat")
		 {
			 Kwadrat temp=(Kwadrat) obj;
			 double b2=temp.punkt.getY()+temp.bok;
			 double b1=temp.punkt.getY();
			 double a1=temp.punkt.getX();
			 double a2=temp.punkt.getX()+temp.bok;
			 double r=bok;
			 double x=punkt.getX();
			 double y=punkt.getY();
			 if(x<=a2&&x>=a1&&y>=b1&&y<=b2) //srodek kola wewnatrz kwadratu
			 {
				 return true;
			 }
			 Punkt A=temp.punkt;
			 Punkt B=new Punkt(a2,b1);
			 Punkt C=new Punkt(a2,b2);
			 Punkt D=new Punkt(a1,b2);
			 if(punkt.dlugoscOdcinka(A)<=r||punkt.dlugoscOdcinka(B)<=r||punkt.dlugoscOdcinka(C)<=r||punkt.dlugoscOdcinka(D)<=r)
				 return true;
			 return false;
		 }
		 if(obj.getClass().getName()=="laboratorium8.Prostokat")
		 {
			 Prostokat temp=(Prostokat) obj;
			 double b2=temp.punkt.getY()+temp.bokB;
			 double b1=temp.punkt.getY();
			 double a1=temp.punkt.getX();
			 double a2=temp.punkt.getX()+temp.bokA;
			 double r=bok;
			 double x=punkt.getX();
			 double y=punkt.getY();
			 if(x<=a2&&x>=a1&&y>=b1&&y<=b2) //srodek kola wewnatrz prostokata
			 {
				 return true;
			 }
			 Punkt A=temp.punkt;
			 Punkt B=new Punkt(a2,b1);
			 Punkt C=new Punkt(a2,b2);
			 Punkt D=new Punkt(a1,b2);
			 if(punkt.dlugoscOdcinka(A)<=r||punkt.dlugoscOdcinka(B)<=r||punkt.dlugoscOdcinka(C)<=r||punkt.dlugoscOdcinka(D)<=r)
				 return true;
			 return false;
		 }
		 return false;
	 }
}
