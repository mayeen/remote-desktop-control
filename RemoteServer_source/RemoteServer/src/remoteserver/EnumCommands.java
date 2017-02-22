/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteserver;

/**
 *
 * @author Mayeen
 */
/**
 * Used to represent commands which can be sent by the server
 */
public enum EnumCommands {
    PRESS_MOUSE(-1),
    RELEASE_MOUSE(-2),
    PRESS_KEY(-3),
    RELEASE_KEY(-4),
    MOVE_MOUSE(-5);

    private int abbrev;

    EnumCommands(int abbrev){
        this.abbrev = abbrev;
    }

    public int getAbbrev(){
        return abbrev;
    }
}
