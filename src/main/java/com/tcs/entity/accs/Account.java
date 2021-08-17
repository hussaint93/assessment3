package com.tcs.entity.accs;

import java.util.Date;

public class Account {
	private String ownerName;
	private Long amount;
	private Date createdDate;
	private String status;
	private String type;
	private String address;

	public Account(String ownerName, Long amount, Date createdDate, String status, String type, String address) {
		super();
		this.ownerName = ownerName;
		this.amount = amount;
		this.createdDate = createdDate;
		this.status = status;
		this.type = type;
		this.address = address;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "[ ownerName=" + ownerName + ", amount=" + amount + ", createdDate=" + createdDate + ", status=" + status
				+ ", type=" + type + ", address=" + address + "]";
	}

}

class SavingsAccount extends Account {
	public SavingsAccount(String ownerName, Long amount, Date createdDate, String status, String type, String address) {
		super(ownerName, amount, createdDate, status, type, address);
	}
}

class CurrentAccount extends Account {

	public CurrentAccount(String ownerName, Long amount, Date createdDate, String status, String type, String address) {
		super(ownerName, amount, createdDate, status, type, address);
	}

}

class DematAccount extends Account {

	public DematAccount(String ownerName, Long amount, Date createdDate, String status, String type, String address) {
		super(ownerName, amount, createdDate, status, type, address);
	}

}
