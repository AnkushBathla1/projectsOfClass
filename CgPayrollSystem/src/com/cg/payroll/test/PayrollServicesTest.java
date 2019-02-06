package com.cg.payroll.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
import com.cg.payroll.util.PayrollDBUtil;

public class PayrollServicesTest {
public static PayrollServices services;
@BeforeClass
public static void setUpTestEnv() {
	services = new PayrollServicesImpl();	
}
@Before
public void setUpTestData() {
	Associate associate= new Associate(101,78000,"ANKUSH","BATHLA","Training","Manager","DTD","Ankushbathla1@gmail.com",new Salary(35000,56221,2100),new BankDetails(12555,"ICICI","ICIC4545"));
	Associate associate1= new Associate(101,78000,"Vikram","BATHLA","Owner","owner","PYP","Vbathla5@gmail.com",new Salary(15000,6221,200),new BankDetails(2551,"ICICI","ICIC4545"));
    PayrollDBUtil.associates.put(associate.getAssociateId(),associate);
    PayrollDBUtil.associates.put(associate1.getAssociateId(),associate1);
}
@Test
@After
public void tearDownTestData() {
	PayrollDBUtil.associates.clear();
	PayrollDBUtil.ASSOCIATE_ID_COUNTER=100;
}
@AfterClass
public void tearDownTestEnv() {
	services =null;
}
}
