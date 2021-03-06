/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProcesarBD;
import Vista.vistaConceptosDescuento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ControladorConceptosDescuento implements ActionListener{
    private vistaConceptosDescuento vista;
    private ProcesarBD base;
    public ControladorConceptosDescuento(vistaConceptosDescuento vista1) {
        this.vista=vista1;
        base = new ProcesarBD();
        vista.ButtonAgregar.addActionListener(this);
        vista.ButtonCerrar.addActionListener(this);
        vista.ButtonLimpiar.addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.ButtonAgregar) {
            String Codigo = vista.TexCodigo.getText();
            String Descripcion = vista.TexDescripcion.getText();
            String Tipo = vista.TexTipo.getText();
            String Valor = vista.TexValor.getText();
            base.ingresarConceptosDescuento(Integer.parseInt(Codigo), Descripcion, Tipo, Integer.parseInt(Valor));
            JOptionPane.showMessageDialog(null, "Se ha Agregado un Concepto de Descuento Correctamente");
            vista.TexCodigo.setText("");
            vista.TexValor.setText("");
            vista.TexTipo.setText("");
            vista.TexDescripcion.setText("");
        }
        if (e.getSource() == vista.ButtonLimpiar) {
            vista.TexCodigo.setText("");
            vista.TexValor.setText("");
            vista.TexTipo.setText("");
            vista.TexDescripcion.setText("");
        }
        if (e.getSource() == vista.ButtonCerrar) {
            vista.dispose();
        }
    }
}
