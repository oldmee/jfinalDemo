package demo;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author R.oldmee
 * @date 2019/6/23 7:07 PM
 */
public class User extends Model<User> {
        public static final User DAO = new User().dao();
}
