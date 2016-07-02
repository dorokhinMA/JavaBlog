package mdorokhin.model;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */

public abstract class BaseEntity {

    protected int id;

    public BaseEntity(Integer id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
