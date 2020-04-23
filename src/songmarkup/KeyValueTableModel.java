package songmarkup;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Keshan De Silva
 */
public class KeyValueTableModel extends DefaultTableModel
{
    private ArrayList<KeyValue> data = new ArrayList<>();
    private boolean editable = false;
    
    public void addKeyValue(KeyValue keyValue)
    {
        data.add(keyValue);
        fireTableDataChanged();
    }
    
    public void clearKeyValues()
    {
        data.clear();
        fireTableDataChanged();
    }
        
    public void setEditable(boolean flag)
    {
        editable = flag;
    }
    
    @Override
    public Object getValueAt(int row, int column)
    {
        if (column == 0)
        {
            return data.get(row).getKey();
        }
        else
        {
            return data.get(row).getValue();
        }
    }

    @Override
    public String getColumnName(int i)
    {
        if (i == 0)
        {
            return "Property Name";
        }
        else
        {
            return "Value";
        }
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
    public boolean isCellEditable(int row, int column)
    {
        if (column == 1)
        {
            return editable;
        }
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int column)
    {
        data.get(row).setValue(value.toString());
    }   

    public ArrayList<KeyValue> getUpdatedKeyValues()
    {
        ArrayList<KeyValue> result = new ArrayList<>();
        for (KeyValue keyValue : data)
        {
            if ((keyValue.getValue() != null) && (!keyValue.getValue().trim().isEmpty()))
            {
                result.add (keyValue);
            }
        }
        
        return result;
    }
}
