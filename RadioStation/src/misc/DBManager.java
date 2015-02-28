package misc;

import javax.persistence.EntityManager;

public class DBManager {
    public static EntityManager em = 
            javax.persistence.Persistence.createEntityManagerFactory("RadioStationPU").createEntityManager();
 
}