package package1;

public class Event {
    private int year;
    private int month;
    private int numOfCities;

    public Event() //default constructor
    {
        year =0;
        month = 0;
        numOfCities =0;
    }
    public Event(int y, int m, int nc)
    {
        year = y;
        month = m;
        numOfCities =nc;
    }
    public Event(Event e)
    {
        this.year = e.year;
        this.month = e.month;
        this.numOfCities = e.numOfCities;
    }
    public int getYear()
    {
        return year;
    }
    public void setYear(int y)
    {
        year =y;
    }
    public int getMonth()
    {
        return month;
    }
    public void setMonth(int m)
    {
        month = m;
    }
    public int getNumOfCities()
    {
        return numOfCities;
    }
    public void setNumOfCities(int nc)
    {
        numOfCities = nc;
    }
    @Override
    public String toString()
    {
        return "This event will be held in " + getYear() + ", "+ getMonth() 
				+ " in " + getNumOfCities() + " cities." ;
    }
    @Override
    public boolean equals(Object x)
    {
        if(x==null||this.getClass()!=x.getClass())
        {
            return false;
        }
        else
        {
            Event e = (Event)x;
            return (this.year==e.year&&this.month==e.month&&this.numOfCities==e.numOfCities);
        }
    }

}
