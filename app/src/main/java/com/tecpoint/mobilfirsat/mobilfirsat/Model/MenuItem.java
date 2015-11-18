package com.tecpoint.mobilfirsat.mobilfirsat.Model;

/**
 * Created by Halil ibrahim AKSOY on 15.11.2015.
 */
public class MenuItem {

  private   String itemText;
   private String itemIconUrl;

    public MenuItem(String itemText, String itemIconUrl) {
        this.itemText = itemText;
        this.itemIconUrl = itemIconUrl;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public String getItemIconUrl() {
        return itemIconUrl;
    }

    public void setItemIconUrl(String itemIconUrl) {
        this.itemIconUrl = itemIconUrl;
    }
}
