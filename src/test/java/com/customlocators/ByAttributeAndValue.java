package com.customlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByAttributeAndValue extends By {
    private final String attribute;
    private final String value;

    public ByAttributeAndValue(String attribute, String value){
        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public List<WebElement> findElements(SearchContext webDriver){
        return webDriver.findElements(By.cssSelector(String.format("[%s='%s']", attribute, value)));
    }
}
