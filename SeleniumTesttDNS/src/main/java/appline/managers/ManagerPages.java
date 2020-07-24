package appline.managers;

import appline.pages.MainPage;
import appline.pages.ProductPage;
import appline.pages.ResultSearchPage;

public class ManagerPages {
    private static ManagerPages managerPages;
    MainPage mainPage;
    ResultSearchPage resultSearchPage;
    ProductPage productPage;



    private ManagerPages() {

    }

    public static ManagerPages getManagerPages() {
        if (managerPages == null) {
            managerPages = new ManagerPages();
        }
        return managerPages;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public ResultSearchPage getResultSearchPage() {
        if (resultSearchPage == null) {
            resultSearchPage = new ResultSearchPage();
        }
        return resultSearchPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }



}
