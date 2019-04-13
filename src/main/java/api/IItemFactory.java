package api;

import models.*;

public abstract interface IItemFactory extends IFactory {
    
    public Item createItem(Actor owner);

}