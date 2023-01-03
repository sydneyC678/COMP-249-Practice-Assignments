package package2;

public class Musicfiesta extends Festival{
    private int numOfBands;
    
    public Musicfiesta()
    {
        numOfBands=0;
    }
    public Musicfiesta(int yr, int mt, int num, String na, double tp,int dur, int nb)
    {
        super(yr,mt,num,na,tp,dur);
        numOfBands=nb;
    }
    public Musicfiesta(Musicfiesta m)
    {
        year = m.year;
		month = m.month;
		numOfCities = m.numOfCities;
		name = m.name;
		price = m.price;
		duration = m.duration;
		numOfBands = m.numOfBands;
    }
    public int getNumOfBands()
    {
        return numOfBands;
    }
    public void setNumOfBands(int nb)
    {
        numOfBands=nb;
    }
    public String toString()
    {
        return "This " + getName() + " Musicfiesta will be held in " + getYear() + ", "+ getMonth() 
        + " in " + getNumOfCities() + " cities, for " + getDuration() 
        + " days, the ticket will cost " + getPrice() + "$, and has " + numOfBands + " bands."; 
    }
    public boolean equals(Object x)
    {
        if(x==null||this.getClass()!=x.getClass())
        {
            return false;
        }
        else
        {
            Musicfiesta m = (Musicfiesta)x;
            return (this.getYear() == m.getYear() &&
            this.getMonth() == m.getMonth() &&
            this.getNumOfCities() == m.getNumOfCities() &&
            this.name.equals(m.name)  &&
            this.price == m.price &&
            this.duration == m.duration &&
            this.numOfBands==m.numOfBands);
        }
    }
    
}
