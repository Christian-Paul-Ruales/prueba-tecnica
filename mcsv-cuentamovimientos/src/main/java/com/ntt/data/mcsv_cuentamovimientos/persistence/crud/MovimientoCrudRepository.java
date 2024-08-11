package com.ntt.data.mcsv_cuentamovimientos.persistence.crud;

import com.ntt.data.mcsv_cuentamovimientos.persistence.entity.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface MovimientoCrudRepository extends CrudRepository<Movimiento, Integer> {
    /**
     * Buscar todos los movimientos de cuenta ordenados desde el ultimo hasta el primero
     * */
    @Query("SELECT m FROM Movimiento m where m.cuentaId.id=?1 order by m.id asc")
    List<Movimiento> findByCuentaIdByOrderByIdAsc(int cuentaId);

    @Query("SELECT m FROM Movimiento m where m.cuentaId.id=?1 and m.fecha >= ?2 and m.fecha <= ?3 order by m.id asc")
    List<Movimiento> findByCuentaIdBetweenToByOrderByIdAsc(int cuentaId, Date inicio, Date fin);
}
