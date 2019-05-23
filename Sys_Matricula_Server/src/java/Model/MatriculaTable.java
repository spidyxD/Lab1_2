/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Alumno;
import Entities.Grupo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dh173
 */
public class MatriculaTable extends AbstractTableModel{
    List<Grupo> rows;
    int[] cols;

    public  MatriculaTable (int[] cols, List<Grupo> rows){
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
        Grupo grupo = rows.get(row);
        
        switch (cols[col]){
            case CURSO: return grupo.getCurso().getNombre();
            case NRC: return grupo.getNrc();
            case CREDITOS: return grupo.getCurso().getCreditos();
            case HORARIO: return grupo.getHorario();
            case PROFESOR : return grupo.getPorfesor().getNombre();
            default: return "";
        }
    }    

    public Grupo getRowAt(int row) {
        return rows.get(row);
    }
    
    
    public static final int CURSO=0;
    public static final int NRC=1;
    public static final int CREDITOS=2;
    public static final int HORARIO=3;
    public static final int PROFESOR=4;
    
    String[] colNames = new String[5];
    private void initColNames(){
        colNames[CURSO]= "Curso";
        colNames[NRC]= "NRC";
        colNames[CREDITOS]= "Creditos";
        colNames[HORARIO]="Horario";
        colNames[PROFESOR]="Profesor";
    }
}
