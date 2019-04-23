package lib.templates;

import lib.dataStructures.SAttack;
import lib.dataStructures.SNutrition;
import lib.dataStructures.SThrow;
import lib.internalApi.Environment.Position;
import lib.internalApi.Instance.IInventory;
import models.Actor;
import models.Item;
import org.json.JSONObject;

import java.util.Optional;

public abstract class StaticItem extends Item {

    public static final long serialVersionUID = 1;

    @Override
    public boolean stackable() {
        return false;
    }

    @Override
    public double getValue() {
        return 1;
    }

    @Override
    public boolean hurlable() {
        return false;
    }

    @Override
    public int stackQuantity() {
        return 1;
    }

    @Override
    public boolean popStack(int amount) {
        return false;
    }

    @Override
    public boolean pushStack(int items) {
        return false;
    }

    @Override
    public Optional<SNutrition> eat(Actor eater) {
        return Optional.empty();
    }

    @Override
    public boolean hurl(Position target, SThrow tSThrow) {
        return false;
    }

    @Override
    public boolean hurl(Actor target, SThrow tSThrow) {
        return false;
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
        return 0;
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
    public Optional<JSONObject> queryProperty() {
        return Optional.empty();
    }

    @Override
    public Optional<SNutrition> drink(Actor eater) {
        return Optional.empty();
    }

    @Override
    public boolean edible() {
        return false;
    }

    @Override
    public boolean drinkable() {
        return false;
    }
}
