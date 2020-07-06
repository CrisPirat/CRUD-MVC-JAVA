
package Intefaces;

import Modelo.Objeto;
import java.util.List;


public interface CRUD {
    public List list();
    public Objeto show(int id);
    public boolean add(Objeto per);
    public boolean edit(Objeto per);
    public boolean remove(int id);
}
