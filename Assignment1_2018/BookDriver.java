package Assignment1_2018;
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
                UpdateBook();
            }
            break;
            
        case 3:
        System.out.print("Author to search: ");
        String author = in.nextLine();
        
        for(int i = 0;i < inventory.length; i++){
            if(inventory[i] != null) {
                if(inventory[i].getName().equals(author)) {
                    System.out.println("\nBook #" + (i + 1) + "\n" + inventory[i]);
                }
            }
        }
        break;
        case 4:
        System.out.print("Price to search: ");
        double price = in.nextDouble();
        in.nextLine();
        
        for(int i = 0;i < inventory.length; i++){
            if(inventory[i] != null) {
                if(inventory[i].getPrice() < price) {
                    System.out.println("\nBook #" + (i + 1) + "\n" + inventory[i]);
                }							
            }
        }
        break;
        case 5:
        System.out.println("QuitingÉ");
        System.exit(0);
        break;
    default:
        System.out.println("Unknown choice, try again.");
        break;
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
        
		if(index >= maxBooks || index <= -1 || inventory[index] == null) {
			System.out.print("\nThat book number doesn't exist. Try again? ('y' or 'yes', anything else bring you back to the main menu): ");
			String response = in.nextLine();
			if(response.equals("yes") || response.equals("y")) {
				UpdateBook();
			}
			return;
		} else {
			UpdateIndividualBook(index);
		}
    }
    private static void UpdateIndividualBook(int index) {
		System.out.println("\nBook #" + (index + 1) + "\n" + inventory[index]);
		
		String prompt = "\nWhat information would you like to change? \n"
				+ "	1. author\n"
				+ "	2. title\n"
				+ "	3. ISBN\n"
				+ "	4. price\n"
				+ "	5. Quit\n"
				+ "Enter your choice > ";
		System.out.print(prompt);
		
		int update_choice = in.nextInt();
		in.nextLine();
		
		switch (update_choice) {
			case 1:
				System.out.print("Enter a new author: ");
				String author = in.nextLine();
				inventory[index].setName(author);

				UpdateIndividualBook(index);
				break;
			case 2:
				System.out.print("Enter a new title: ");
				String title = in.nextLine();
				inventory[index].setTitle(title);
				
				UpdateIndividualBook(index);
				break;
			case 3:
				System.out.print("Enter a new ISBN: ");
				long ISBN = ISBNValidity();
				inventory[index].setISBN(ISBN);
				
				UpdateIndividualBook(index);
				break;
			case 4:
				System.out.print("Enter a new Price: ");
				double price =PriceValidity();
				inventory[index].setPrice(price);
				
				UpdateIndividualBook(index);
				break;
			case 5:
				break;
			default:
				UpdateIndividualBook(index);
				break;
		}	
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
