package org.csc.seleniumtests.puffin_selenium_tests;

import org.junit.experimental.categories.Category;

import utility.Constant;

/**
 * This class contains integration test for Puffin Login Page 
 * @author hstancheva
 *
 */
@Category(IntegrationTest.class)
@SuppressWarnings({"nls"})
public class ChooseReferatIT extends BaseClassForIT{

	@Override
	protected void customInitialization()  {
		//given
		driver.get(Constant.CHOOSE_REFERAT_PAGE);
	}

}
