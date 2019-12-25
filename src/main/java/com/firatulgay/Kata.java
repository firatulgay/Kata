package com.firatulgay;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by FiratUlgay on 24.12.2019.
 */
public class Kata extends VerticalLayout {

    Random random = new Random();

    List<MyButton> btnList = new ArrayList<>();
    List<MyButton> yeniBtnList = new ArrayList<>();
    List<MyButton> oluList = new ArrayList<>();
    List<MyButton> diriList = new ArrayList<>();
    private TextField textFieldSatir;
    private TextField textFieldSutun;
    FormLayout girisLayout;
    int satirSayisi;
    int sutunSayisi;

    public Kata() {

        setSpacing(true);
        setMargin(true);

        buildGirisLayout();
    }

    private void buildGirisLayout() {

        girisLayout = new FormLayout();
        textFieldSatir = new TextField();
        textFieldSatir.setCaption("Satır Sayısı Giriniz");
        textFieldSutun = new TextField();
        textFieldSutun.setCaption("Sütun Sayısı Giriniz");

        Button btnOlustr = new Button();
        btnOlustr.setCaption("OLUŞTUR");

        btnOlustr.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                satirSayisi = Integer.parseInt(textFieldSatir.getValue());
                sutunSayisi = Integer.parseInt(textFieldSatir.getValue());
                buildButtonTable(satirSayisi, sutunSayisi);
                removeComponent(girisLayout);
            }
        });
        girisLayout.addComponent(textFieldSatir);
        girisLayout.addComponent(textFieldSutun);
        girisLayout.addComponent(btnOlustr);
        addComponent(girisLayout);
    }

    private void buildButtonTable(int satirSayisi, int sutunSayisi) {

        for (int i = 0; i < sutunSayisi; i++) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            horizontalLayout.setSpacing(true);
            for (int j = 0; j < satirSayisi; j++) {
                MyButton button = new MyButton();

                setRandomSayi(button);
                button.setDescription(button.getData().toString());

                button.getAdres().setSatir(i);
                button.getAdres().setSutun(j);

                btnList.add(button);

                btnListener(i, j, button);

                horizontalLayout.addComponent(button);
            }
            addComponent(horizontalLayout);
        }
    }

    private void btnListener(final int i, final int j, final MyButton secilenButon) {
        secilenButon.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                diriList.clear();
                yeniBtnList.clear();

                if (secilenButon.getData().equals(0)) {
                    secilenButon.addStyleName(ValoTheme.BUTTON_DANGER);
                    return;

                }
                for (MyButton myButton : btnList) {

                    /**
                     * Sol üst köşe buton
                     */
                    if (secilenButon.getAdres().getSatir() == 0 && secilenButon.getAdres().getSutun() == 0) {
                        if ((myButton.getAdres().getSatir() == i && myButton.getAdres().getSutun() == j + 1)
                                || (myButton.getAdres().getSatir() == i + 1 && myButton.getAdres().getSutun() == j + 1) ||
                                (myButton.getAdres().getSatir() == i + 1 && myButton.getAdres().getSutun() == j)) {
                            yeniBtnList.add(myButton);
                        }
                        /**
                         * Sağ üst köşe buton
                         */
                    } else if (secilenButon.getAdres().getSatir() == 0 && secilenButon.getAdres().getSutun() == sutunSayisi) {
                        if ((myButton.getAdres().getSatir() == 0 && myButton.getAdres().getSutun() == sutunSayisi-1)
                                || (myButton.getAdres().getSatir() == 1 && myButton.getAdres().getSutun() == sutunSayisi-1) ||
                                (myButton.getAdres().getSatir() == 2 && myButton.getAdres().getSutun() == sutunSayisi-1)) {
                            yeniBtnList.add(myButton);
                        }
                    }
                    /**
                     * sol alt köşe buton
                     */
                    else if (secilenButon.getAdres().getSatir() == satirSayisi && secilenButon.getAdres().getSutun() == 0) {
                        if ((myButton.getAdres().getSatir() == satirSayisi && myButton.getAdres().getSutun() == 1)
                                || (myButton.getAdres().getSatir() == satirSayisi-1 && myButton.getAdres().getSutun() == 1) ||
                                (myButton.getAdres().getSatir() == satirSayisi-1 && myButton.getAdres().getSutun() == 0)) {
                            yeniBtnList.add(myButton);
                        }
                    }

                    /**
                     * sağ alt köşe buton
                     */
                    else if (secilenButon.getAdres().getSatir() == satirSayisi && secilenButon.getAdres().getSutun() == sutunSayisi) {
                        if ((myButton.getAdres().getSatir() == satirSayisi && myButton.getAdres().getSutun() == sutunSayisi-1)
                                || (myButton.getAdres().getSatir() == satirSayisi-1 && myButton.getAdres().getSutun() == sutunSayisi-1) ||
                                (myButton.getAdres().getSatir() == satirSayisi-1 && myButton.getAdres().getSutun() == sutunSayisi)) {
                            yeniBtnList.add(myButton);
                        }
                    }
                    /**
                     * Eğer köşe değilse..
                     */
                    else {

                        if (myButton.getAdres().getSatir() == i - 1 && myButton.getAdres().getSutun() == j - 1) {
                            yeniBtnList.add(myButton);

                        } else if (myButton.getAdres().getSatir() == i - 1 && myButton.getAdres().getSutun() == j) {
                            yeniBtnList.add(myButton);

                        } else if (myButton.getAdres().getSatir() == i - 1 && myButton.getAdres().getSutun() == j + 1) {
                            yeniBtnList.add(myButton);

                        } else if (myButton.getAdres().getSatir() == i && myButton.getAdres().getSutun() == j - 1) {
                            yeniBtnList.add(myButton);

                        } else if (myButton.getAdres().getSatir() == i && myButton.getAdres().getSutun() == j + 1) {
                            yeniBtnList.add(myButton);

                        } else if (myButton.getAdres().getSatir() == i && myButton.getAdres().getSutun() == j + 1) {
                            yeniBtnList.add(myButton);

                        } else if (myButton.getAdres().getSatir() == i + 1 && myButton.getAdres().getSutun() == j - 1) {
                            yeniBtnList.add(myButton);

                        } else if (myButton.getAdres().getSatir() == i + 1 && myButton.getAdres().getSutun() == j) {
                            yeniBtnList.add(myButton);

                        } else if (myButton.getAdres().getSatir() == i + 1 && myButton.getAdres().getSutun() == j + 1) {
                            yeniBtnList.add(myButton);

                        }
                    }

                }

                for (MyButton yeniButtonList : yeniBtnList) {
                    System.out.println(yeniButtonList.getData() + " " + yeniButtonList.getCaption());

                    if (yeniButtonList.getData().equals(0)) {
                        oluList.add(yeniButtonList);
                    } else {
                        diriList.add(yeniButtonList);
                    }
                }
                if (diriList.size() < 3) {

                    secilenButon.addStyleName(ValoTheme.BUTTON_DANGER);
                    Notification.show("KILLED!");
                    secilenButon.setData(0);

                } else {
                    secilenButon.addStyleName(ValoTheme.BUTTON_FRIENDLY);
                    Notification.show("LIVE!");
                }
            }
        });
    }

    public void setRandomSayi(MyButton button) {
        int rnd = random.nextInt(2);
        button.setData(rnd);
    }
}