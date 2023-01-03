package package4;
import package1.Event;
public class Fair extends Event{
    private int numExhibitors;
    enum FairType {CAREER,SCIENCE,TRADE,TRAVEL}
    private FairType fairtype;

    public Fair()
    {
        numExhibitors=0;
        fairtype=null;
    }
    public Fair(int y, int m, int nc,int ne,String ft)
    {
        super(y,m,nc);
        numExhibitors=ne;
        fairtype=FairType.valueOf(ft);
    }
    public Fair(Fair f)
    {
        setYear(f.getYear());
        setMonth(f.getMonth());
        setNumOfCities(f.getNumOfCities());
        numExhibitors=f.numExhibitors;
        fairtype=f.fairtype;
    }
    public int getNumExhibitors()
    {
        return numExhibitors;
    }
    public void setNumExhibitors(int ne)
    {
        numExhibitors=ne;
    }
    public FairType getFairtype()
    {
        return fairtype;
    }
    public void setFairtype(String ft)
    {
        fairtype = FairType.valueOf(ft);
    }
    public String toString()
    {
        return ("This " + fairtype + " Fair will be held in " + getYear() + ", "+ getMonth() 
        + " in " + getNumOfCities() + " cities, and has " + numExhibitors + " exibitors.");
    }
    public boolean equals(Object x)
    {
        if(x==null||this.getClass()!=x.getClass())
        {
            return false;
        }
        else
        {
            Fair f = (Fair)x;
            return (this.getYear() == f.getYear() &&
            this.getMonth() == f.getMonth() &&
            this.getNumOfCities() == f.getNumOfCities() &&
            this.numExhibitors == f.numExhibitors &&
            this.fairtype.equals(f.fairtype));
        }
    }
}
