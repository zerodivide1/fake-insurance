package models;

import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by Sean on 10/25/2014.
 */
@Entity @IdClass(InsuranceRegionId.class)
public class InsuranceRegion extends Model {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @Id
    public long zipBase;

    @Id
    public String gender;

    public double rate0;
    public double rate20;
    public double rate30;
    public double rate40;
    public double rate50;
    public double rate60;
    public double rate70;
}
