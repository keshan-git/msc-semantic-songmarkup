package songmarkup;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Keshan De Silva
 */
public class SelectValueTableModel extends DefaultTableModel
{
    private ArrayList<SelectValue> data = new ArrayList<>();
    
    public void addSelectValue(SelectValue keyValue)
    {
        data.add(keyValue);
        fireTableDataChanged();
    }
    
    public void clearSelectValue()
    {
        data.clear();
        fireTableDataChanged();
    }
        
    @Override
    public Object getValueAt(int row, int column)
    {
        if (column == 0)
        {
            return data.get(row).isSelect();
        }
        else
        {
            return data.get(row).getValue();
        }
    }

    @Override
    public void setValueAt(Object value, int row, int column)
    {
        if (column == 0)
        {
            data.get(row).setSelect((Boolean)value);
        }
    }
    
    @Override
    public String getColumnName(int i)
    {
        if (i == 1)
        {
            return "Value";
        }
        return "";
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public int getRowCount()
    {
        if (data != null)
        {
            return data.size();
        }
        return 0;
    }

    @Override
    public Class<?> getColumnClass(int row)
    {
        if (row == 0)
        {
            return Boolean.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        if (column == 0)
        {
            return true;
        }
        return false;
    } 

    public boolean isSelected(String value)
    {
        for (SelectValue selectValue : data)
        {
            if (selectValue.getValue().equalsIgnoreCase(value))
            {
                return selectValue.isSelect();
            }
        }
        return false;
    }
}
