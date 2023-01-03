package package3;
import package1.Event;
public class SportCompetition extends Event {
    private int numOfActivities;
    enum SeasonType{SUMMER,FALL,WINTER,SPRING};
    private SeasonType season;

    public SportCompetition()
    {
        numOfActivities=0;
        season=null;
    }
    public SportCompetition(int y, int m, int nc, int na, String s)
    {
        super(y,m,nc);
        numOfActivities=na;
        season=SeasonType.valueOf(s);
    }
    public SportCompetition(SportCompetition p)
    {
        setYear(p.getYear());
		setMonth(p.getMonth());
		setNumOfCities(p.getNumOfCities());
		numOfActivities = p.numOfActivities;
		season = p.season;
    }
    public int getNumOfActivities()
    {
        return numOfActivities;
    }
    public void setNumOfActivities(int na)
    {
        numOfActivities=na;
    }
    public SeasonType getSeason()
    {
        return season;
    }
    public void setSeason(String st)
    {
        season = SeasonType.valueOf(st);
    }
    public String toString()
    {
      return "This " + season + " SportCompetition will be held in " + getYear() + ", "+ getMonth() 
				+ " in " + getNumOfCities() + " cities, and has " + numOfActivities + " activities."; 
    }
    public boolean equals(Object x)
    {
        if(x==null||this.getClass()!=x.getClass())
        {
            return false;
        }
        else
        {
            SportCompetition s = (SportCompetition)x;
            return (this.getYear() == s.getYear() &&
            this.getMonth() == s.getMonth() &&
            this.getNumOfCities() == s.getNumOfCities() &&
            this.numOfActivities == s.numOfActivities &&
            this.season.equals(s.season) );
        }
    }
}
