package com.cg.bankingsystem.beans;
import java.util.Date;

public class Customer {
	private String fName,lName,adharNo,panNo,mobileNo;
	private String dob;

	public Customer() {}

	public Customer(String fName, String lName, String adharNo, String panNo, String mobileNo) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.adharNo = adharNo;
		this.panNo = panNo;
		this.mobileNo = mobileNo;
		
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adharNo == null) ? 0 : adharNo.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((panNo == null) ? 0 : panNo.hashCode());
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
		Customer other = (Customer) obj;
		if (adharNo == null) {
			if (other.adharNo != null)
				return false;
		} else if (!adharNo.equals(other.adharNo))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		if (panNo == null) {
			if (other.panNo != null)
				return false;
		} else if (!panNo.equals(other.panNo))
			return false;
		return true;
	}

}
