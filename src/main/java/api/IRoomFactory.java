package api;

import environment.*;
public interface IRoomFactory extends IFactory {

    public Room createRoom(IWorld context);
    
}