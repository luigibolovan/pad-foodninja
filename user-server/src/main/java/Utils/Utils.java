package Utils;

import entities.Entity;
import entities.User;

public class Utils {
    public static String getEntityName(Entity entity) {
        return entity.getMyTableType().toString();
    }


}
