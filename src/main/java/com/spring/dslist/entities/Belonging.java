package com.spring.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name ="tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPK belongingPK= new BelongingPK();
    private Integer position;

    public Belonging(){

    }

    public Belonging(Game game, GameList gameList, Integer position) {
        belongingPK.setGame(game);
        belongingPK.setGameList(gameList);
        this.position = position;
    }

    public BelongingPK getBelongingPK() {
        return belongingPK;
    }

    public void setBelongingPK(BelongingPK belongingPK) {
        this.belongingPK = belongingPK;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
                return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Belonging other = (Belonging) obj;
        return Objects.equals(belongingPK, other.belongingPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(belongingPK);
    }
}
