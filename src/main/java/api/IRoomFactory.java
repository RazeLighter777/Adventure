package api;

import environment.*;
import org.json.JSONObject;

public interface IRoomFactory extends IFactory {

    public Room createRoom(IWorld context, JSONObject options);
    
}