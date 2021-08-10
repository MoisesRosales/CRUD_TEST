package Entitys;

/**
 *
 * @author moise
 */
public class ECategoria {
    private int CATEGORY_ID;
    private String CATEGORY_NAME;
    private String DESCRIPTION;
    private String PICTURE;

    public ECategoria() {
    }

    public ECategoria(int CATEGORY_ID, String CATEGORY_NAME, String DESCRIPTION, String PICTURE) {
        this.CATEGORY_ID = CATEGORY_ID;
        this.CATEGORY_NAME = CATEGORY_NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.PICTURE = PICTURE;
    }

    public int getCATEGORY_ID() {
        return CATEGORY_ID;
    }

    public void setCATEGORY_ID(int CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
    }

    public String getCATEGORY_NAME() {
        return CATEGORY_NAME;
    }

    public void setCATEGORY_NAME(String CATEGORY_NAME) {
        this.CATEGORY_NAME = CATEGORY_NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getPICTURE() {
        return PICTURE;
    }

    public void setPICTURE(String PICTURE) {
        this.PICTURE = PICTURE;
    }

    @Override
    public String toString() {
        return "Categoria{" + "CATEGORY_ID=" + CATEGORY_ID + ", CATEGORY_NAME=" + CATEGORY_NAME + ", DESCRIPTION=" + DESCRIPTION + ", PICTURE=" + PICTURE + '}';
    }
    
    
    
}
