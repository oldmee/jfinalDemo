package demo;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * @author R.oldmee
 * @date 2019/6/23 12:31 PM
 */
public class HelloController extends Controller {
    public void index(String project) {

        // 创建name属性为James,age属性为25的User对象并添加到数据库
        new User().set("name", "James").set("age", 25).save();


        User.DAO.save();

        // 删除id值为25的User
        User.DAO.deleteById(1);

        // 查询id值为25的User将其name属性改为James并更新到数据库
        User.DAO.findById(2).set("name", "Jack").update();

        // 查询id值为25的user, 且仅仅取name与age两个字段的值
        User user = User.DAO.findByIdLoadColumns(2, "name, age");

        // 获取user的name属性
        String userName = user.getStr("name");

        // 获取user的age属性
        Integer userAge = user.getInt("age");

        // 查询所有年龄大于18岁的user
        List<User> users = User.DAO.find("select * from user where age>18");

        // 分页查询年龄大于18的user,当前页号为1,每页10个user
        Page<User> userPage = User.DAO.paginate(1, 10, "select *", "from user where age > ?", 18);

        renderText(project);

    }

}
