package package1;
import package2.*;
import package3.*;
import package4.*;
public class Driver {
    public static void main(String[] args)
    {
        Event e1 = new Event(2019,3,10), e2 = new Event(e1);
        Festival f1 = new Festival(2018,6,5,"Film",25.0,1), f2 = new Festival(f1);;
        Culturalfiesta c1 = new Culturalfiesta(2017,5,6,"Arts",30.0,1,3);
        Musicfiesta m1 = new Musicfiesta(2018, 7, 3, "beer", 20.0, 5, 50), m2 = new Musicfiesta(2018, 6, 2, "folk", 15.0, 6, 10);
        SportCompetition s1 = new SportCompetition(2022,12,1,1,"SUMMER");
        Fair fr1 = new Fair(2017, 4, 6, 30, "CAREER"), fr2 = new Fair(2017, 4, 6, 30, "SCIENCE");

        //display all objects' information using the toString() method
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(f1);
		System.out.println(c1);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(s1);
		System.out.println(fr1);

        //Test the equality of some created objects using the equals() method

        if(e1.equals(e2))
        {
            System.out.println("Event e1 and Event e2 are equals");
        }
        else
        {
            System.out.println("Event e1 and e2 are not equal");
        }
        if(c1.equals(m2))
			System.out.println("Culturalfiesta c1 & musicfiesta m1 are equal");
		else
			System.out.println("Culturalfiesta c1 & musicfiesta m1 are not equal");

        //Create an array of 10 Event objects and fill that array with various objects from the 6
        //classes (each class must have at least one entry in that array).
        Event[] eventArray = new Event[10];

        eventArray [0] = e1;
		eventArray [1] = e2;
		eventArray [2] = f1;
		eventArray [3] = f2;
		eventArray [4] = c1;
		eventArray [5] = m1;
		eventArray [6] = m2;
		eventArray [7] = s1;
		eventArray [8] = fr1;
		eventArray [9] = fr2;
		
        //Trace(search) that array to find the object that:
        //(a) Hastheleast/mostnumberofcities
        //(b) Arehappeningonthesameyear(e.g.2018)
        //For both (a) and (b) display all information of the objects along with their location (index) in the array.

        int indexOfLeast = 0, indexOfMost=0;
        boolean [] flag = new boolean [10]; 			// the variable to indicate whether has the same year
        for(int i =1; i<eventArray.length;i++)
        {
            if(eventArray[i].getNumOfCities()<eventArray[indexOfLeast].getNumOfCities())
            indexOfLeast=i;
            if(eventArray[i].getNumOfCities()>eventArray[indexOfMost].getNumOfCities())
            indexOfMost=i;
            if(eventArray[i].getYear()==2018)
            flag[i]=true;
        }
        //display all information of the objects along with their location (index) in the array
		System.out.println("Having the least number of cities:\n"+eventArray[indexOfLeast]
        +"\nwith the location "+indexOfLeast+" in the array.");

        System.out.println("Having the most number of cities:\n"+eventArray[indexOfMost]
        +"\nwith the location "+indexOfMost+" in the array.");

        System.out.println("\nHappening on the same year: 2018");
        for(int i=0; i < eventArray.length-1; i++)
        {	
            if(flag[i])
            System.out.println(eventArray[i]+"\nwith the location "+i+" in the array.");
        }

    }
}
