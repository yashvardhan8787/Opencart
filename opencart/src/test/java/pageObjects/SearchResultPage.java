package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-search")
    WebElement inputSearchBar;

    @FindBy(name = "category_id")
    WebElement categoryDropdown;

    @FindBy(name = "sub_category")
    WebElement subCategoryCheckbox;

    @FindBy(id = "description")
    WebElement descriptionCheckbox;

    @FindBy(id = "button-search")
    WebElement searchButton;

    @FindBy(id = "input-sort")
    WebElement sortDropdown;

    @FindBy(id = "input-limit")
    WebElement limitDropdown;

    @FindBy(xpath = "//div[@class='product-thumb']")
    List<WebElement> productList;

    @FindBy(xpath = "//div[@class='product-thumb']//h4/a")
    List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='product-thumb']//p[@class='price']")
    List<WebElement> productPrices;

    @FindBy(xpath = "//div[@class='col-sm-6 text-right']")
    WebElement paginationInfo;

    @FindBy(id = "list-view")
    WebElement listViewButton;

    @FindBy(id = "grid-view")
    WebElement gridViewButton;

    @FindBy(id = "compare-total")
    WebElement productCompareLink;

    // Method to enter text in the search bar
    public void enterSearchText(String text) {
        inputSearchBar.clear();
        inputSearchBar.sendKeys(text);
    }

    // Method to select a category from the dropdown
    public void selectCategory(String category) {
        selectDropdownOptionByVisibleText(categoryDropdown, category);
    }

    // Method to toggle the subcategory checkbox
    public void toggleSubCategoryCheckbox(boolean enable) {
        if (subCategoryCheckbox.isEnabled() && subCategoryCheckbox.isSelected() != enable) {
            subCategoryCheckbox.click();
        }
    }

    // Method to toggle the description checkbox
    public void toggleDescriptionCheckbox(boolean enable) {
        if (descriptionCheckbox.isSelected() != enable) {
            descriptionCheckbox.click();
        }
    }

    // Method to click the search button
    public void clickSearchButton() {
        searchButton.click();
    }

    // Method to select a sorting option
    public void selectSortOption(String sortOption) {
        selectDropdownOptionByVisibleText(sortDropdown, sortOption);
    }

    // Method to select a limit option
    public void selectLimitOption(String limitOption) {
        selectDropdownOptionByVisibleText(limitDropdown, limitOption);
    }

    // Method to get the count of products displayed
    public int getProductCount() {
        return productList.size();
    }

    // Method to get product names
    public List<String> getProductNames() {
        return productNames.stream().map(WebElement::getText).toList();
    }

    // Method to get product prices
    public List<String> getProductPrices() {
        return productPrices.stream().map(WebElement::getText).toList();
    }

    // Method to get pagination information
    public String getPaginationInfo() {
        return paginationInfo.getText();
    }

    // Method to switch to list view
    public void switchToListView() {
        listViewButton.click();
    }

    // Method to switch to grid view
    public void switchToGridView() {
        gridViewButton.click();
    }

    // Method to get product compare text
    public String getProductCompareText() {
        return productCompareLink.getText();
    }

    // Helper method to select an option from a dropdown by visible text
    private void selectDropdownOptionByVisibleText(WebElement dropdown, String visibleText) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
}