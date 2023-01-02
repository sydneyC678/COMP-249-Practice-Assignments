package Assignment1;
import java.util.Scanner;

public class BookDriver 
{
    private static final String password = "password";
    private static int maxBooks;
    private static int choice;
    private static Book[] inventory;
    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args)
    {
    Scanner in = new Scanner(System.in);
    String welcome = "Welcome to the Book Tracker System!";
    System.out.println(welcome);

    System.out.print("How many books can your bookstore contain?: ");
    maxBooks = in.nextInt();

    //array that keeps track of created Book objects
    inventory = new Book[maxBooks];
    
    mainMenu();

    //Depending on which choice the user chooses, each choice corresponds to a task

    switch(choice)
    {
        case 1:
            if(PasswordValidity1())
            {
                System.out.print("How many books would you like to enter?: ");
                int numBooks=in.nextInt();
                int numBooksRemainding=maxBooks-Book.findNumberOfCreatedBooks();
                if(numBooksRemainding<numBooks)
                {
                    System.out.println("You have reached the limit, you can only add " + numBooksRemainding + "book(s)");
                    numBooks = numBooksRemainding; //This will add the maximum number of books possible
                }
                //Fill the array and add the new books
                for(int i =0; i<numBooks;i++)
                {
                    System.out.print("Title: ");
                    String t = in.nextLine();
                    System.out.print("Author: ");
                    String a = in.nextLine();
                    long ISBN = ISBNValidity();
                    double pr = PriceValidity();
                    Book new_book = new Book(t,a,ISBN,pr);
                    inventory[Book.findNumberOfCreatedBooks()-1]=new_book; //Storing the book in inventory array and assigning
                    //it an index value
                    System.out.println(t + " added.");
                }
                
            }
            break;
        case 2:
            if(PasswordValidity2())
            {
                
            }
            
        case 3:
        case 4:
        case 5:
    }
   
    }
    public static int mainMenu()
    {
        System.out.print("What do you want to do?"+
        "\n1. Enter new books (password required)"+
        "\n2. Change information of a book (password required)"+
        "\n3. Display all books by a specific author"+
        "\n4. Display all books under a certain a price."+
        "\n5. Quit"+
       "\nPlease enter your choice >");
       
       boolean valid = false;
       choice = in.nextInt();
       while(!valid)
       {
        valid = true;
        if(choice>0&&choice<=5)
        {
            valid =true;
        }
        else
        {
            mainMenu();
        }
       }
       return choice;
    }
    public static boolean PasswordValidity1()
    {   
        int result = 0;
        while(result<4)
        {
            System.out.print("Enter password: ");
            String ps = in.next();
            if(!(ps.equals(password)))
            {
                for(int i=0;i<2;i++)
                {
                    System.out.print("Enter password: ");
                    ps = in.next();
                }
                result++;
                if(result==4)
                {
                    System.out.println("Program detected suspicous activities and will terminate immediately!");
                    System.exit(0);
                }
                mainMenu();
            }
            else
            {
                return true;
            }
         }
       
        return false;
    }
    public static boolean PasswordValidity2()
    {
        
        System.out.print("Enter password: ");
        String ps = in.next();
        if(!(ps.equals(password)))
        {
            for(int i=0;i<2;i++)
            {
                System.out.print("Enter password: ");
                ps = in.next();
            }
            mainMenu();
        } 
        else
        {
            return true;
        }
        return false;
    }
    private static void UpdateBook()
    {
        System.out.print("Which book number would you like to update?: ");
        Scanner in = new Scanner(System.in);
        int index = in.nextInt()-1;
        

    }
    private static long ISBNValidity()
    {
        long ISBN;
        do{
            System.out.print("ISBN: ");
            ISBN = in.nextLong();
            if(ISBN < 1000000000000L
            || ISBN > 9999999999999L) System.out.println("Invalid ISBN: ISBN must be a positive "
                                        + "13 digit integer.");
        } while(ISBN < 1000000000000L
        || ISBN > 9999999999999L);
        return ISBN;

    }
    private static double PriceValidity()
    {
        double price;
	
		do {
			System.out.print("Price: ");
			price = in.nextDouble();
			in.nextLine();
			
			if (price < 0) System.out.println("Invalid Price: Price must be a positive number.");
		} while (price < 0);
		
		return price;
	}
	
    

    


    
}
