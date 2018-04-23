package laboratorium8;

public class Punkt {
double pozycjaX;
double pozycjaY;
public void setWspolrzedne(double x, double y)
{
	pozycjaX=x;
	pozycjaY=y;
}
public double getX()
{
	return pozycjaX;
}
public double getY()
{
	return pozycjaY;
}
public Punkt(double x, double y)
{
	pozycjaX=x;
	pozycjaY=y;
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Punkt temp = (Punkt) obj;
   if(pozycjaX==temp.pozycjaX&&pozycjaY==temp.pozycjaY)
	   	return true;
return false;
}
public double dlugoscOdcinka(Punkt pkt)
{
	return Math.sqrt(Math.pow(pozycjaX-pkt.pozycjaX,2)+Math.pow(pozycjaY-pkt.pozycjaY, 2));
}
}
