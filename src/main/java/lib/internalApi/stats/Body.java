package lib.internalApi.stats;

import lib.dataStructures.SNutrition;
import models.Actor;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Body implements Serializable {

    public static final long serialVersionUID = 1;

    private ArrayList<Body> childParts;

    private Body parentPart;

    protected boolean killMarked;
    /**
     *
     * @return The blood loss per update.
     */
    public double getBloodLoss() {
        return getChildParts().stream().mapToDouble(n -> n.getBloodLoss()).sum();
    }

    /**
     *
     * @return The text given when the part is gibbed.
     */
    protected abstract String getGibText(String actorName);

    /**
     *
     * @return A description of the part, along with optional state.
     */
    protected abstract String getDescription();

    /**
     *
     * @return Just the name of the part. Should have direction built in.
     */
    public abstract String getPartName();


    protected void attach(ArrayList<Body> parts) {
        parts.forEach(p -> p.parentPart = this);
    }

    protected void attatch(Body b) {
        childParts.add(b);
    }


    public String sever(Actor parentActor) {
        parentPart.childParts.remove(this);
        this.setKillMarked();
        parentPart = null;
        return getGibText(parentActor.getFullName());
    }

    public boolean isKillMarked() {
        return killMarked;
    }

    /**
     *
     * @return Whether the actor will be destroyed if this body is killed.
     */
    public abstract boolean isVital();

    /**
     *
     * @return The weight of the gib.
     */
    public abstract double getWeight();



    /**
     * Sets this body as killed, and kills all child parts.
     */
    protected void setKillMarked() {
        killMarked = true;
        childParts.forEach( p -> p.setKillMarked());
    }

    /**
     *
     * @return all of the body's children.
     */
    public ArrayList<Body> getChildParts() {
        return childParts;
    }

    /**
     *
     * @return The nutrition of the body part.
     */
    public abstract SNutrition getNutrition();
}
