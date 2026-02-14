package com.expense;

import java.io.Serializable;

public class Expense implements Serializable {
	
	    private int id;
	    private String date;
	    private double amount;
	    private String category;
	    private String description;

	    public Expense(int id, String date, double amount, String category, String description) {
	        this.id = id;
	        this.date = date;
	        this.amount = amount;
	        this.category = category;
	        this.description = description;
	    }

	    public int getId() { return id; }
	    public String getDate() { return date; }
	    public double getAmount() { return amount; }
	    public String getCategory() { return category; }

	    public void setAmount(double amount) { this.amount = amount; }
	    public void setCategory(String category) { this.category = category; }
	    public void setDescription(String description) { this.description = description; }

	    @Override
	    public String toString() {
	        return "ID: " + id +
	                "\nDate: " + date +
	                "\nAmount: ₹" + amount +
	                "\nCategory: " + category +
	                "\nDescription: " + description;
	    }
	}

	


