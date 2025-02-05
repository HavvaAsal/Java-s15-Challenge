package librarysystem.model;

import librarysystem.util.InvoiceStatus;

public class Invoice {
    private static int invoiceCounter = 1;
    private int invoiceId;
    private User user;
    private Book book;
    private double amount;
    private InvoiceStatus status;

    public Invoice(User user, Book book, double amount) {
        this.user = user;
        this.book = book;
        this.amount = amount;
        this.invoiceId = invoiceCounter++;
        this.status = InvoiceStatus.PAID;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public double getAmount() {
        return amount;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void refund() {
        if (status == InvoiceStatus.PAID) {
            status = InvoiceStatus.REFUNDED;
            System.out.println("Refund of $" + amount + " processed for " + user.getName());
        } else {
            System.out.println("Invoice " + invoiceId + " has already been refunded.");
        }
    }

    public void printInvoice() {
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("User: " + user.getName());
        System.out.println("Book: " + book.getTitle());
        System.out.println("Amount: $" + amount);
        System.out.println("Status: " + status);
    }
}