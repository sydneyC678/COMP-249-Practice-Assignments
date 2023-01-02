//Assignment 1 2018 Practice For Future Assignments
//Purpose: The purpose of this assignment is to help you review some of the main topics 
//covered in the previous course, including classes, loops, arrays, arrays of objects, static attributes and static methods.

//Part 1: Implement the Book class
package Assignment1_2018;

public class Book
{
    private String title;
    private String name;
    private long ISBN;
    private double price;
    private static int numOfBooks=0;
    

    public Book()
    {
        this.title=null;
        this.name=null;
        this.ISBN=0;
        this.price=0.0;
        numOfBooks++;
    }
    public Book(String t, String n, long isbn, double pr)
    {
        title = t;
        name = n;
        ISBN=isbn;
        price=pr;
        numOfBooks++;
    }
    public Book(Book b)
    {
        this.title = b.title;
        this.name = b.name;
        this.ISBN=b.ISBN;
        this.price = b.price;
        numOfBooks++;
    }
    //Muttaors/Accessors
    public String getTitle()
    {
        return title;
    }
    public void setTitle()
    {
        this.title=title;
    }
    public String getName()
    {
        return name;
    }
    public void setName()
    {
        this.name = name;
    }
    public long getISBN()
    {
        return ISBN;
    }
    public void setISBN()
    {
        this.ISBN=ISBN;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice()
    {
        this.price = price;
    }

    //Display all information of an object
    public String toString()
    {
        return ("Book Title: " + title
        + "\nName of Author: " + name
        +"\nISBN Number: " + ISBN
        + "\nPrice of Book: "+ price + "$");
    }
    //Method to know how many book objects have been created
    public static int findNumberOfCreatedBooks()
    {
        return numOfBooks;
    }
    //Compare two books and their equality 
    public boolean equals(Book otherBook)
    {
        return (this.ISBN==otherBook.ISBN&&this.price==otherBook.price);
    }

}
