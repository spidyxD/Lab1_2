/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Alumno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dh173
 */
public class AlumnosProfTableModel  extends AbstractTableModel{
    List<Alumno> rows;
    int[] cols;

    public  AlumnosProfTableModel (int[] cols, List<Alumno> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col){
        return colNames[cols[col]];
    }


    public int getRowCount() {
        return rows.size();
    }

    public Object getValueAt(int row, int col) {
        Alumno alumno = rows.get(row);
        
        switch (cols[col]){
            case NOMBRE: return alumno.getNombre();
            case CEDULA: return alumno.getCedula();
            case EMAIL: return alumno.getEmail();
            default: return "";
        }
    }    

    public Alumno getRowAt(int row) {
        return rows.get(row);
    }
    
    
    public static final int NOMBRE=0;
    public static final int CEDULA=1;
    public static final int EMAIL=2;
    
    String[] colNames = new String[3];
    private void initColNames(){
        colNames[NOMBRE]= "Nombre";
        colNames[CEDULA]= "Cedula";
        colNames[EMAIL]= "Email";
    }
}
