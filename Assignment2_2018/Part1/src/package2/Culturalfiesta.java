package package2;

public class Culturalfiesta extends Festival {
    private int numOfLanguages;

    public Culturalfiesta()
    {
        numOfLanguages=0;
    }
    public Culturalfiesta(int yr, int mt, int num, String na, double tp, int dur, int numlan)
    {
        super(yr, mt, num, na, tp, dur);
        numOfLanguages=numlan;
    }
    public Culturalfiesta(Culturalfiesta c)
    {
        year = c.year;
		month = c.month;
		numOfCities = c.numOfCities;
		name = c.name;
		price= c.price;
		duration = c.duration;
		numOfLanguages = c.numOfLanguages;
    }
    public int getNumOfLanguages()
    {
        return numOfLanguages;
    }
    public void setNumOfLanguages(int nl)
    {
        numOfLanguages=nl;
    }
    public String toString()
    {
        return ("This " + getName() + " Culturalfiesta will be held in " + getYear() + ", "+ getMonth() 
        + " in " + getNumOfCities() + " cities, for " + getDuration() 
        + " days, the ticket will cost " + getPrice() + "$, and has " 
        + numOfLanguages + " spoken language.");
    }
    public boolean equals(Object x)
    {
        if(x==null&&this.getClass()!=x.getClass())
        {
            return false;
        }
        else
        {
            Culturalfiesta c = (Culturalfiesta)x;
            return (this.getYear() == c.getYear() &&
            this.getMonth() == c.getMonth() &&
            this.getNumOfCities() == c.getNumOfCities() &&
            this.name.equals(c.name)  &&
            this.price == c.price &&
            this.duration == c.duration &&
            this.numOfLanguages == c.numOfLanguages);
        }
    }
}
