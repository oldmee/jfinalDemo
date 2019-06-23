package demo;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Config;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

/**
 * @author R.oldmee
 * @date 2019/6/23 12:29 PM
 */
public class DemoConfig extends JFinalConfig {
    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class, 8080, true);
    }

    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
        me.setBaseDownloadPath("files");
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/hello", HelloController.class);
    }

    @Override
    public void configEngine(Engine me) {}
    @Override
    public void configPlugin(Plugins me) {
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost:3306/jfinal?useSSL=false", "root", "root");
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);
        arp.addMapping("user", User.class);

    }
    @Override
    public void configInterceptor(Interceptors me) {}
    @Override
    public void configHandler(Handlers me) {}
}
