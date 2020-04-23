package songmarkup;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntResource;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Keshan De Silva
 */
public class IconTreeCellRendere extends DefaultTreeCellRenderer
{
    public static final String ICON_PATH = "src/resources/";
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                        boolean expanded,boolean leaf, int row, boolean hasFocus)
    {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        JLabel label = (JLabel) this ;
        String nodeText = value.toString();
        
        if (value instanceof DefaultMutableTreeNode)
        {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
            if (node.getUserObject() instanceof OntClass)
            {
                nodeText = ((OntClass)node.getUserObject()).getLocalName();
            }
            else if (node.getUserObject() instanceof OntResource)
            {
                nodeText = ((OntResource)node.getUserObject()).getLocalName();
            }
            else if (node.getUserObject() instanceof OntResource)
            {
                nodeText = ((OntResource)node.getUserObject()).getLocalName();
            }
        }
        
        label.setText(nodeText);
        label.setIcon( new ImageIcon(ICON_PATH + "song.png")); 
        return label;
    }       
}
