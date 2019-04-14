package api;

import models.*;
import org.json.JSONObject;

public abstract interface IItemFactory extends IFactory {
    
    public Item createItem(Actor owner, JSONObject options);

}