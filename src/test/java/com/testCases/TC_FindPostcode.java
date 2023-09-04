package com.testCases;

import org.testng.annotations.Test;

import com.pageObjects.LLyodsPage;
import com.utilities.GenericUtils;
import com.utilities.XLUtils;


public class TC_FindPostcode extends GenericUtils {
	@Test(priority = 1,dataProvider = "LoginAmazonData", dataProviderClass = XLUtils.class)
	public void test(String Postcode,String BranchCode) throws InterruptedException {
		LLyodsPage llyPg=new LLyodsPage(Basedriver);
		llyPg.branchFinder(Postcode,BranchCode);

	}

	
}