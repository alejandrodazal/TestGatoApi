package com.co.elondono;

import com.co.elondono.Services.GatoService;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        String[] strMenu = {"1. Ver Gatos", "2. Salir"};
        int opcionMenu = -1;
        do {
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos Java", "Menu Principal",JOptionPane.INFORMATION_MESSAGE,
                    null, strMenu, strMenu[0]);

            for (int i = 0; i < strMenu.length ; i++) {
                opcionMenu = opcion.equals(strMenu[i])?i:-1;
            }

            switch(opcionMenu){
                case 0:
                    GatoService.verGatos();
                    break;
            case 1:
                    break;

            }
        }while(opcionMenu != 1);

    }
}
