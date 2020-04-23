package songmarkup;

import com.hp.hpl.jena.ontology.OntResource;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Keshan De Silva
 */
public class SearchResultTableModel extends DefaultTableModel
{
    private ArrayList<OntResource> data = new ArrayList<>();

    public void addOntResource(OntResource resource)
    {
        data.add(resource);
        fireTableDataChanged();
    }
    
    public void clear()
    {
        data.clear();
        fireTableDataChanged();
    }
        
    @Override
    public Object getValueAt(int row, int column)
    {
        return data.get(row);
    }

    @Override
    public int getColumnCount()
    {
        return 1;
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
    public String getColumnName(int column)
    {
        return "Song";
    }

    @Override
    public boolean isCellEditable(int i, int i1)
    {
        return false;
    }
    
    
}
