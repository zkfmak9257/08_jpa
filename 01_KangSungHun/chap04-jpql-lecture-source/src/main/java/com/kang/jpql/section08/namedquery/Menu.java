package com.kang.jpql.section08.namedquery;

import jakarta.persistence.*;

@Entity(name="Section08Menu")
@Table(name="tbl_menu")
@NamedQueries({
        @NamedQuery(name = "Section08Menu.selectMenuList",
                query = "SELECT m FROM Section08Menu m"
        )
})
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
    }

    public Menu() {

    }


    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                '}';
    }
}

