package com.firatulgay;

import com.vaadin.ui.VerticalLayout;

/**
 * Created by FiratUlgay on 24.12.2019.
 */
public class General extends VerticalLayout {


     public General(){
         Header header = new Header();
         Kata kata = new Kata();

         addComponent(header);
         addComponent(kata);

     }

}
