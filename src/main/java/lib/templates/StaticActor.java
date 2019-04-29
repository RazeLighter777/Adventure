package lib.templates;

import environment.IWorld;
import lib.dataStructures.SAttack;
import lib.dataStructures.SThrow;
import lib.internalApi.environment.Position;
import lib.internalApi.instance.IInventory;
import lib.internalApi.stats.Stats;
import models.Actor;
import models.Item;
import org.json.JSONObject;

import java.util.Optional;

public abstract  class StaticActor extends Actor {

    public static final long serialVersionUID = 1;

    protected Position p;

    public StaticActor(IWorld w, Position p) {
        super(w);
        this.p = p;
    }

    @Override
    public Position getPosition() {
        return p;
    }

    @Override
    public void reposition(Position n) {
        p = n;
    }

    @Override
    public boolean topple() {
        return false;
    }

    @Override
    public boolean sendDeletionRequest(Item i) {
        return false;
    }

    @Override
    public Optional<Item> pickUp() {
        return Optional.empty();
    }

    @Override
    public double getWeight() {
        return 1;
    }

    @Override
    public double getVolume() {
        return 1;
    }

    @Override
    public double getTemperature() {
        return 65;
    }

    @Override
    public Optional<IInventory> getInventory() {
        return Optional.empty();
    }

    @Override
    public void applyAttack(SAttack attack) {

    }

    @Override
    public boolean activate() {
        return false;
    }

    @Override
    public String observe() {
        return "";
    }

    @Override
    public boolean hit(Actor projectile, SThrow thrower) {
        return false;
    }

    @Override
    public void update() {
    }


    @Override
    public Optional<String> getFactoryAssetId() {
        return Optional.empty();
    }

    @Override
    public void receiveDeletionRequest() {

    }

    @Override
    public Optional<Stats> getStats() {
        return Optional.empty();
    }

    @Override
    public Optional<JSONObject> queryProperty() {
        return Optional.empty();
    }

}
