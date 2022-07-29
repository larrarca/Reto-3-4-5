/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.reto3;

import Clases.ClsJdbc;
import Vistas.VistaMenu;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author larrc0
 */
public class Reto3 {

    public static void main(String[] args) {
        ClsJdbc jdbc = new ClsJdbc();
        jdbc.CrearConexion();
        
        VistaMenu vistamenu = new VistaMenu();
        vistamenu.setLocationRelativeTo(null);
        vistamenu.setVisible(true);
    }
}
