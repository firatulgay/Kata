package com.firatulgay;

import com.vaadin.client.debug.internal.Icon;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by FiratUlgay on 24.12.2019.
 */
public class MyButton extends Button {

    Adres adres;


    public MyButton(){

        setIcon(FontAwesome.CIRCLE_O);
        adres = new Adres();
//        addStyleName(ValoTheme.BUTTON_FRIENDLY);

    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }



}
