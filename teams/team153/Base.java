package team153;

import battlecode.common.*;
import static battlecode.common.GameConstants.*;
import java.util.*;

public class Base {

    public NovaPlayer player;
    public RobotController controller;
    public Robot robot;

    public Base(NovaPlayer player) {
        this.player = player;
        robot = player.robot;
        controller = player.controller;
    }

    public Base(RobotController controller) {
        this.controller = controller;
        robot = controller.getRobot();
    }

    public void p(String s) {
        if(false) {
            return;
        }

        if(controller.getRobot().getID() == 109) {
            System.out.println(s);
        }
    }

    class BroadcastMessage {

        static final int LOW_ENERGON = 1;//LOW_ENERGON (has less than 25% energon) //status, sent when pinged
        static final int UNDER_ATTACK = 2;//UNDER_ATTACK (has been attacked in the past 100 turns) (enemy type, enemy energon level) //broadcasted initially, and sent as status when pinged if has been attacked for past 100 turns
        static final int ENEMY_IN_SIGHT = 3;//(can see an enemy) //broadcasted  (how many enemies and enemy types)
        static final int FLUX_IN_SIGHT = 4;// (can see flux) //broadcasted  (parameter is location)
        static final int NEW_UNIT = 5; //NEW_UNIT (type of unit location on map maybe unique id) //broadcasted
        static final int MAP_INFO = 6;//broadcasted
        static final int PING = 7;//broadcasted
        static final int PONG = 8;//broadcasted response to ping
        static final int FOLLOW_REQUEST = 9;
        static final int FIND_BLOCKS = 10;
        static final int MOVE = 11; //MOVE BITCH GET OUT DA WAY
        static final int LOW_ALLIED_UNITS = 12;
        static final int SCOUT_ALLIED_UNIT_RELAY = 13;
        static final int SUPPORT = 14;
    }

    class Status {

        public static final int success = 1, fail = 0;
        public static final int notEnoughEnergon = 2;
        public static final int cantMoveThere = 3, goalBlocked = 4;
        public static final int outOfRange = 10, turnsNotIdle = 11;
    }

    static class Goal {

        public static final int exploringForFlux = 2, goingTowardsFlux = 3, goingDirectlyToFlux = 4, gettingCloseToFlux = 5;
        public static final int supporttingFluxDeposit = 10, collectingFlux = 11;
        public static final int idle = 20;
        public static final int scouting = 30, followingArchon = 31, alliedUnitRelay = 32, fight = 33;
        public static final int findBlock = 40, foundBlock = 41, goingToSteps = 42;

        public static String toString(int goal) {
            switch(goal) {
                case exploringForFlux:
                    return "Exploring for Flux";
                case goingTowardsFlux:
                    return "Going towards Flux";
                case goingDirectlyToFlux:
                    return "Going directly to Flux";
                case gettingCloseToFlux:
                    return "Getting closer to a flux depsoit";
                case supporttingFluxDeposit:
                    return "Supporting Flux Deposit";
                case collectingFlux:
                    return "Collecting Flux";
                case idle:
                    return "Idle";
                case scouting:
                    return "Scouting";
                case followingArchon:
                    return "Following Archon";
                case findBlock:
                    return "Finding Block";
                case foundBlock:
                    return "Found Block";
                case goingToSteps:
                    return "Going to steps";
                case alliedUnitRelay:
                    return "Relaying Allied Unit Locations";
                case fight:
                    return "FIGHT!";

            }
            return "?";
        }
    }
}
