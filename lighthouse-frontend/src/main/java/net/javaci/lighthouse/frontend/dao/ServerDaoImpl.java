package net.javaci.lighthouse.frontend.dao;

import net.javaci.lighthouse.frontend.model.Server;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: ekocaman
 * Date: 4/22/13
 */
@Repository("serverDao")
@Transactional
public class ServerDaoImpl implements ServerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveServer(Server server) {
        sessionFactory.getCurrentSession().save(server);
    }

    @Override
    public List<Server> getAllServers() {
        return sessionFactory.getCurrentSession().createQuery("from Server").list();
    }

    @Override
    public void removeServer(Integer id) {
        Server server = (Server) sessionFactory.getCurrentSession().load(Server.class, id);
        if (null != server) {
            sessionFactory.getCurrentSession().delete(server);
        }
    }
}
