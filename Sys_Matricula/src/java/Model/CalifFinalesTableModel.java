/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Alumno;
import Entities.Rendimiento_grupo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dh173
 */
public class CalifFinalesTableModel extends AbstractTableModel{
    List<Rendimiento_grupo> rows;
    int[] cols;

    public  CalifFinalesTableModel (int[] cols, List<Rendimiento_grupo> rows){
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
        Rendimiento_grupo nota = rows.get(row);
        
        switch (cols[col]){
            case NOTA: return nota.getCalificacion();
            default: return "";
        }
    }    

    public Rendimiento_grupo getRowAt(int row) {
        return rows.get(row);
    }
    
    
    public static final int NOTA=0;
    
    String[] colNames = new String[4];
    private void initColNames(){
        colNames[NOTA]= "Nota Final";
    }
}
