package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.SearchResultPage;
import testBase.BaseTest;

public class TC003_ProductSearchTest extends BaseTest {

    @Test
    public void testSearchFunctionality() {
        logger.info("Starting test for search functionality");

        SearchResultPage searchResultPage = new SearchResultPage(driver);

        // Enter search term
        searchResultPage.enterSearchText("imac");
        logger.info("Entered search term: imac");

        // Click search button
        searchResultPage.clickSearchButton();
        logger.info("Clicked search button");

        // Verify products are displayed
        int productCount = searchResultPage.getProductCount();
        Assert.assertTrue(productCount > 0, "No products found for the search term!");
        logger.info("Search functionality verified with " + productCount + " products found.");
    }
}