/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import entidades.MMetricas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan Carlos
 */
@Local
public interface MMetricasFacadeLocal {

    void create(MMetricas mMetricas);

    void edit(MMetricas mMetricas);

    void remove(MMetricas mMetricas);

    MMetricas find(Object id);

    List<MMetricas> findAll();

    List<MMetricas> findRange(int[] range);

    int count();
    
}
