package view;

import controller.FornitoriController;
import model.ContattoFornitore;
import model.Fornitore;
import model.Prodotto;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private List<?> data;  // I dati che vogliono essere visualizzati nella tabella
    private List<?> data2;
    private String[] columnNames;  // I nomi delle colonne, passati dinamicamente

    // Costruttore che accetta i dati e i nomi delle colonne
    public TableModel(List<?> data, String[] columnNames) {
        this.data = data;
        //this.data2 = data2;
        this.columnNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object row = data.get(rowIndex);  // Ottieni l'oggetto della riga

        if (row instanceof Fornitore) {
            Fornitore fornitore = (Fornitore) row;
            switch (columnIndex) {
                case 0:
                    //System.out.println("Sono stato chiamato");
                    return fornitore.getSelected();
                case 1: return fornitore.getNome();
                case 2: return fornitore.getRappresentante();
                case 3: return fornitore.getContatti().getFirst().getContatti();
                case 4: return fornitore.getContatti().getFirst().getEmail();
                default: return null;
            }
        }

        // Altri casi possono essere aggiunti in base ai dati che passano al modello
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Object row = data.get(rowIndex);
        if (row instanceof Fornitore) {
            Fornitore fornitore = (Fornitore) row;
            switch (columnIndex) {
                case 0:
                    // Gestione del checkbox
                    fornitore.setSelected((Boolean) aValue);
                    isClicked((List<Fornitore>) data);
                    break;
            }
            fireTableCellUpdated(rowIndex, columnIndex); // Puoi aggiungere altri casi se vuoi rendere modificabili altre colonne
        }
         // Notifica alla JTable che il dato è stato aggiornato
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Rendi editabile solo la colonna dei checkbox
        return columnIndex == 0;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public List<?> getData() {return data;}

    public void isClicked(List<Fornitore> data) {
        int counter = 0;
        for (Fornitore fornitore : data) {
            if (fornitore.getSelected()) {
                counter++;
            }
        }
        if (counter != 0) {
            GestioneFornitoriFrame.getModifica().setEnabled(true);
            GestioneFornitoriFrame.getRimuovi().setEnabled(true);
        } else {
            GestioneFornitoriFrame.getModifica().setEnabled(false);
            GestioneFornitoriFrame.getRimuovi().setEnabled(false);
        }
    }


    @Override
    public void fireTableChanged(TableModelEvent e) {

    }

    public static class CheckBoxRenderer extends DefaultTableCellRenderer implements TableCellRenderer {
        private final JCheckBox checkBox = new JCheckBox();

        public CheckBoxRenderer() {
            checkBox.setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            checkBox.setSelected((Boolean) value);
            return checkBox;
        }
    }
}

