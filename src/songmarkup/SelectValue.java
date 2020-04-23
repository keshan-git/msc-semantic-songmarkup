package songmarkup;

/**
 *
 * @author Keshan De Silva
 */
public class SelectValue
{
    private boolean select;
    private String value;

    public SelectValue(boolean select, String value)
    {
        this.select = select;
        this.value = value;
    }

    public SelectValue(String value)
    {
        this.value = value;
    }

    public boolean isSelect()
    {
        return select;
    }

    public void setSelect(boolean select)
    {
        this.select = select;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    } 
}
