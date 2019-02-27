package Util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by alina on 27.02.19.
 */
public class LockingNode {
    public int data;
    public LockingNode left;
    public LockingNode right;
    public boolean isLocked;
    public LockingNode parent;
    public int lockedChildren;

    public boolean isLocked() {
        return isLocked;
    }

    public boolean lock() {
        if (!areAncestorsLocked() || lockedChildren == 0) {
            isLocked = true;
            addAncestor();
        }
        return isLocked;
    }

    public boolean unlock() {
        if (isLocked) {
            if (!areAncestorsLocked() || lockedChildren == 0) isLocked = false;
        }
        return isLocked;
    }

    private boolean areAncestorsLocked() {
        LockingNode node = parent;
        while(node.parent != null) {
            if (node.isLocked) return true;
            node = node.parent;
        }
        return false;
    }

    private boolean addAncestor() {
        LockingNode node = parent;
        while(node.parent != null) {
            parent.lockedChildren++;
            node = node.parent;
        }
        return false;
    }

}
