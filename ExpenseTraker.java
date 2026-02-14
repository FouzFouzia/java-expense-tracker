package com.expense;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ExpenseTraker {
	    static Scanner sc = new Scanner(System.in);
	    static ArrayList<Expense> expenses = new ArrayList<>();
	    static int expenseCounter = 1;

	    public static void main(String[] args) {

	        while (true) {
	            System.out.println("\n===== EXPENSE TRACKER MENU =====");
	            System.out.println("1. Add Expense");
	            System.out.println("2. View All Expenses");
	            System.out.println("3. Search by Category");
	            System.out.println("4. View Total Expenses");
	            System.out.println("5. Update Expense");
	            System.out.println("6. Delete Expense");
	            System.out.println("7. Exit");

	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1 -> addExpense();
	                case 2 -> viewExpenses();
	                case 3 -> searchByCategory();
	                case 4 -> viewTotal();
	                case 5 -> updateExpense();
	                case 6 -> deleteExpense();
	                case 7 -> {
	                    System.out.println("Exiting Application...");
	                    return;
	                }
	                default -> System.out.println("Invalid Choice!");
	            }
	        }
	    }

	    static void addExpense() {
	        sc.nextLine();
	        System.out.print("Enter Date (dd-mm-yyyy): ");
	        String date = sc.nextLine();
	        System.out.print("Enter Amount: ");
	        double amount = sc.nextDouble();
	        sc.nextLine();
	        System.out.print("Enter Category: ");
	        String category = sc.nextLine();
	        System.out.print("Enter Description: ");
	        String description = sc.nextLine();

	        expenses.add(new Expense(expenseCounter++, date, amount, category, description));
	        System.out.println("Expense Added Successfully!");
	    }

	    static void viewExpenses() {
	        if (expenses.isEmpty()) {
	            System.out.println("No Expenses Recorded!");
	            return;
	        }

	        for (Expense e : expenses) {
	            System.out.println("\n" + e);
	        }
	    }

	    static void searchByCategory() {
	        sc.nextLine();
	        System.out.print("Enter Category: ");
	        String category = sc.nextLine();

	        boolean found = false;
	        for (Expense e : expenses) {
	            if (e.getCategory().equalsIgnoreCase(category)) {
	                System.out.println("\n" + e);
	                found = true;
	            }
	        }

	        if (!found)
	            System.out.println("No Expenses Found in this Category!");
	    }

	    static void viewTotal() {
	        double total = 0;
	        for (Expense e : expenses) {
	            total += e.getAmount();
	        }
	        System.out.println("Total Expenses: ₹" + total);
	    }

	    static void updateExpense() {
	        System.out.print("Enter Expense ID to Update: ");
	        int id = sc.nextInt();

	        for (Expense e : expenses) {
	            if (e.getId() == id) {
	                System.out.print("Enter New Amount: ");
	                double newAmount = sc.nextDouble();
	                sc.nextLine();
	                System.out.print("Enter New Category: ");
	                String newCategory = sc.nextLine();
	                System.out.print("Enter New Description: ");
	                String newDesc = sc.nextLine();

	                e.setAmount(newAmount);
	                e.setCategory(newCategory);
	                e.setDescription(newDesc);

	                System.out.println("Expense Updated Successfully!");
	                return;
	            }
	        }

	        System.out.println("Expense Not Found!");
	    }

	    static void deleteExpense() {
	        System.out.print("Enter Expense ID to Delete: ");
	        int id = sc.nextInt();

	        Iterator<Expense> iterator = expenses.iterator();
	        while (iterator.hasNext()) {
	            Expense e = iterator.next();
	            if (e.getId() == id) {
	                iterator.remove();
	                System.out.println("Expense Deleted Successfully!");
	                return;
	            }
	        }

	        System.out.println("Expense Not Found!");
	    }
	}



