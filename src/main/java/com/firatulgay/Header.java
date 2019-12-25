package com.firatulgay;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by FiratUlgay on 24.12.2019.
 */
public class Header extends VerticalLayout {

    public Header(){

        setSizeFull();
        setHeight(100,Unit.PIXELS);
        Label label = new Label("'Yaşam Var Mı ?' Katamıza Hoşgeldiniz !");
        label.addStyleName(ValoTheme.LABEL_BOLD);
        label.addStyleName(ValoTheme.LABEL_H2);
        label.addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        addComponent(label);

    }
}
