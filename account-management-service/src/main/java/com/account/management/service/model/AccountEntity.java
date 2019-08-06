package com.account.management.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AM_ACCOUNT_DETAILS")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "account_number")
	private String account_no;
	@Column(name = "amount")
	private int amount;
	@Column(name = "base_curr")
	private String baseCurrency;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "modified_date")
	private Date modifiedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String base_currency) {
		this.baseCurrency = base_currency;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date created_date) {
		this.createdDate = created_date;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modified_date) {
		this.modifiedDate = modified_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_no == null) ? 0 : account_no.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountEntity other = (AccountEntity) obj;
		if (account_no == null) {
			if (other.account_no != null)
				return false;
		} else if (!account_no.equals(other.account_no))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", account_no=" + account_no + ", amount=" + amount + ", baseCurrency="
				+ baseCurrency + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
