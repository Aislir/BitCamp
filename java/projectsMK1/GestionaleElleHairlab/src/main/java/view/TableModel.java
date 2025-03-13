package view;

import model.Fornitore;
import model.Prodotto;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private List<?> data;  // I dati che vogliono essere visualizzati nella tabella
    //private List<?> data2;
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

        if (row instanceof Prodotto) {
            Prodotto prodotto = (Prodotto) row;
            try{
                switch (columnIndex) {
                    case 0:
                        //System.out.println("Sono stato chiamato");
                        return prodotto.getSelected();
                    case 1: return prodotto.getNome();
                    case 2: return prodotto.getCodice();
                    case 3: return prodotto.getTipo().toString();
                    case 4: return prodotto.getContenuto();
                    case 5: return prodotto.getMarca().toString();
                    case 6: return prodotto.getFornitore().getNome();
                    default: return null;
                }
            } catch (NullPointerException e) {
                return null;
            }
        }

        // Altri casi possono essere aggiunti in base ai dati che passano al modello
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Object row = data.get(rowIndex);
        if (row instanceof Prodotto) {
            Prodotto prodotto = (Prodotto) row;
            switch (columnIndex) {
                case 0:
                    // Gestione del checkbox
                    prodotto.setSelected((Boolean) aValue);
                    isClicked(data, rowIndex);
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

    public void isClicked(List<?> data, int rowIndex) {
        Object row = data.get(rowIndex);
        int counter = 0;

        if (row instanceof Prodotto) {
            Prodotto prodotto = (Prodotto) row;
            if (prodotto.getSelected()) {
                counter++;
            }
            if (counter != 0) {
                GestioneProdottiFrame.getModificaProdotto().setEnabled(true);
                GestioneProdottiFrame.getRimuovi().setEnabled(true);
            } else {
                GestioneProdottiFrame.getModificaProdotto().setEnabled(false);
                GestioneProdottiFrame.getRimuovi().setEnabled(false);
            }
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

