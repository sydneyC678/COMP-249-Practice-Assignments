package package2;
import package1.*;
public class Festival extends Event {
    protected int year;       					
	protected int month;				
	protected int numOfCities;	
    protected String name;
    protected double price;
    protected int duration;

    public Festival()
    {
        name = null;
        price = 0.0;
        duration =0;
    }
    public Festival(int yr, int mt, int num, String na, double tp, int dur)
    {
        super(yr,mt,num);
        name=na;
        price=tp;
        duration=dur;
    }
    public Festival(Festival f)
    {
        setYear(f.getYear());
        setMonth(f.getMonth());
        setNumOfCities(f.getNumOfCities());
        name = f.name;
        price = f.price;
        duration = f.duration;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name = n;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double pr)
    {
       price = pr; 
    }
    public int getDuration()
    {
        return duration;
    }
    public void setDuration(int dr)
    {
        duration = dr;
    }
    public String toString()
    {
        return "This festival will be held in " + getYear() + ", "+ getMonth() 
				+ " in " + getNumOfCities() + " cities, for " + getDuration() 
				+ " days, the ticket will cost " + getPrice() + "$."; 
    }
    public boolean equals(Object x)
    {
        if(x==null||this.getClass()!=x.getClass())
        {
            return false;
        }
        else
        {
            Festival f = (Festival)x;
            return (this.getYear() == f.getYear() &&
            this.getMonth() == f.getMonth() &&
            this.getNumOfCities() == f.getNumOfCities() &&
            this.name.equals(f.name) &&
            this.price == f.price &&
            this.duration == f.duration);
        }
    }

}
