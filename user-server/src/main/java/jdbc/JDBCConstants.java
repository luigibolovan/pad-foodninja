package jdbc;

import Utils.Utils;
import entities.Entity;

public class JDBCConstants {



    public String insertQuery(Entity entity) {

        return  " insert into " + Utils.getEntityName(entity) + " users (first_name, last_name, date_created, is_admin, num_points)"
                + " values (?, ?, ?, ?, ?)";
    }

//    public String delete(Entity entity,String stringToDelete) {
//           return "delete from " + Utils.getEntityName(entity) + " where "
//    }

    public String findQuery(Entity entity) {
         return null;
    }
}
