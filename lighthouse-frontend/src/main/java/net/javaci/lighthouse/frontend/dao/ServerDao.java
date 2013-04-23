package net.javaci.lighthouse.frontend.dao;

import net.javaci.lighthouse.frontend.model.Server;

import java.util.List;

/**
 * User: ekocaman
 * Date: 4/22/13
 */
public interface ServerDao {

    public void saveServer(Server server);

    public List<Server> getAllServers();

    public void removeServer(Integer id);
}
